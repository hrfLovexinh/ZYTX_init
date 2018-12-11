package com.zytx.init.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zytx.init.domain.ElevatorCoordinate;
import com.zytx.init.domain.ElevatorInfo;
import com.zytx.init.exception.NetWorkException;
import com.zytx.init.mapper.ElevatorMapper;
import com.zytx.init.utils.OkHttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ElevatorService {

    @Autowired
    private ElevatorMapper elevatorMapper;

    public Map findCantConfirmByCoordinate(int rows,int page,int sign) {
        if(sign == 0) {
            sign = 9;
        }
        long total = elevatorMapper.confirmCoordinateByAllCount(sign);
        List<ElevatorCoordinate> items =  elevatorMapper.confirmCoordinateByAll((page - 1) * rows,page * rows,sign);
        Map<String, Object> result = new HashMap<>();
        result.put("total", total);
        result.put("rows", items);
        return result;
    }

    public void updateCoordinate() {
        /*//将百度返回字段设为null
        elevatorMapper.setPreciseIsNull();*/
        //long count = elevatorMapper.updateCoordinateCount();
        List<ElevatorInfo> items = null;
        //for(int i = 1; i <= Math.floor(count/500) + 1; i ++) {
        while(true) {
            items = elevatorMapper.updateCoordinate(0,500);
            if(items == null || items.size() == 0) {
                break;
            }
            for (ElevatorInfo item : items) {
                getCoordinateBybd(item);
            }
        }
    }

    public void getCoordinateBybd(ElevatorInfo item) {
        try{
            String url = "http://api.map.baidu.com/geocoder/v2/?output=json&ak=c7fvr8IyDuF0Y1qibqzrjBeMRhqzQe2k&city=成都&address="+item.getAddress();
            Map<String,String> queries = new HashMap<String,String>();
            String string = OkHttpUtil.get(url,queries);
            JSONObject statusObiect = JSON.parseObject(string);
            Integer status = statusObiect.getInteger("status");
            item.setPrecise("0");
            if(status.equals(0)){
                JSONObject jsonObject = JSON.parseObject(string).getJSONObject("result").getJSONObject("location");
                JSONObject result = JSON.parseObject(string).getJSONObject("result");
                item.setMap_X(jsonObject.getString("lng"));
                item.setMap_Y(jsonObject.getString("lat"));
                item.setPrecise(result.getString("precise"));
            }else{
                item.setMap_X("0.000000");
                item.setMap_Y("0.000000");
                item.setPrecise("0");

            }
            elevatorMapper.updateCoordinateInsert(item.getMap_X(),item.getMap_Y(),item.getPrecise(),item.getId());
        }catch(Exception e) {
			/*e.printStackTrace();
			item.setMap_X("0.000000");
			item.setMap_Y("0.000000");
			item.setPrecise("0");
			ElevaltorInfo.updateAll(ElevaltorInfo.class, "map_X=?,map_Y=?,precise=?", new Object[]{item.getMap_X(),item.getMap_Y(),item.getPrecise()}, "id=?", new Object[]{item.getId()});*/
            //System.out.println("启用自调");
            if(isConnect()) {
                getCoordinateBybd(item);
            } else {
                System.out.println("延时10s");
                try
                {
                    Thread.currentThread().sleep(10000);//毫秒
                }
                catch(Exception ex){
                    System.out.println("线程睡眠异常");
                }
                if(isConnect()) {
                    getCoordinateBybd(item);
                } else {
                    //Exception exception = new NetWorkException("gbg");
                    throw new NetWorkException("网络不畅通！请联系管理员检查网络！");
                }
            }

        }
    }

    public void confirmCoordinateByAll() {
        //long count = elevatorMapper.confirmCoordinateByAllCount(1);
        //System.out.println(count);
        List<ElevatorCoordinate> items = null;
        //for(int i = 1; i <= Math.floor(count/500) + 1; i ++) {
        while(true) {
            //查询出三个坐标误差都小于200m的电梯数据
            items = elevatorMapper.confirmCoordinateByAll(0,500,1);
            if(items == null || items.size() == 0) {
                break;
            }
            for (ElevatorCoordinate item : items) {
                //三个坐标误差都小于200m的以96933坐标为准
                elevatorMapper.updateConfirmCoordinate(item.getPmap_X(),item.getPmap_Y(),1,item.getId());
            }
        }
    }

    public void confirmCoordinateBypddistance() {
        //long count = elevatorMapper.confirmCoordinateByAllCount(2);
        List<ElevatorCoordinate> items = null;
        //for(int i = 1; i <= Math.floor(count/500) + 1; i ++) {
        while(true) {
            //查询出96933坐标与粘贴库坐标误差小于250m的电梯
            items = elevatorMapper.confirmCoordinateByAll(0,500,2);
            if(items == null || items.size() == 0) {
                break;
            }
            for (ElevatorCoordinate item : items) {
                //96933坐标与粘贴库坐标误差小于250m的以96933坐标为准
                elevatorMapper.updateConfirmCoordinate(item.getPmap_X(),item.getPmap_Y(),2,item.getId());
            }
        }
    }

    public void confirmCoordinateByepdistance() {
        //long count = elevatorMapper.confirmCoordinateByAllCount(3);
        List<ElevatorCoordinate> items = null;
        //for(int i = 1; i <= Math.floor(count/500) + 1; i ++) {
        while(true) {
            //查询出96933坐标与电梯库坐标误差小于250m的电梯
            items = elevatorMapper.confirmCoordinateByAll(0,500,3);
            if(items == null || items.size() == 0) {
                break;
            }
            for (ElevatorCoordinate item : items) {
                //96933坐标与电梯库坐标误差小于250m的以96933坐标为准
                elevatorMapper.updateConfirmCoordinate(item.getPmap_X(),item.getPmap_Y(),3,item.getId());
            }
        }
    }

    public void confirmCoordinateByeddistance() {
        //long count = elevatorMapper.confirmCoordinateByAllCount(4);
        List<ElevatorCoordinate> items = null;
        //for(int i = 1; i <= Math.floor(count/500) + 1; i ++) {
        while(true) {
            //查询出电梯库坐标与粘贴库坐标误差小于500m的电梯
            items = elevatorMapper.confirmCoordinateByAll(0,500,4);
            if(items == null || items.size() == 0) {
                break;
            }
            for (ElevatorCoordinate item : items) {
                //电梯库坐标与粘贴库坐标误差小于500m的以粘贴库坐标为准
                elevatorMapper.updateConfirmCoordinate(item.getDmap_X(),item.getDmap_Y(),4,item.getId());
            }
        }
    }

    public void confirmCoordinateByepdistance1() {
        //long count = elevatorMapper.confirmCoordinateByAllCount(5);
        List<ElevatorCoordinate> items = null;
        //for(int i = 1; i <= Math.floor(count/500) + 1; i ++) {
        while(true) {
            //查询出96933坐标与电梯库坐标误差小于1000m的电梯
            items = elevatorMapper.confirmCoordinateByAll(0,500,5);
            if(items == null || items.size() == 0) {
                break;
            }
            for (ElevatorCoordinate item : items) {
                //96933坐标与电梯库坐标误差小于1000m的以96933坐标为准
                elevatorMapper.updateConfirmCoordinate(item.getPmap_X(),item.getPmap_Y(),5,item.getId());
            }
        }
    }

    public void confirmCoordinateByeddistance1() {
        //long count = elevatorMapper.confirmCoordinateByAllCount(6);
        List<ElevatorCoordinate> items = null;
        //for(int i = 1; i <= Math.floor(count/500) + 1; i ++) {
        while(true) {
            //查询出电梯库坐标与粘贴库坐标误差小于1000m的电梯
            items = elevatorMapper.confirmCoordinateByAll(0,500,6);
            if(items == null || items.size() == 0) {
                break;
            }
            for (ElevatorCoordinate item : items) {
                //电梯库坐标与粘贴库坐标误差小于1000m的以粘贴库坐标为准
                elevatorMapper.updateConfirmCoordinate(item.getDmap_X(),item.getDmap_Y(),6,item.getId());
            }
        }
    }

    public void confirmCoordinateBybd() {
        //long count = elevatorMapper.confirmCoordinateBybdCount();
        List<ElevatorInfo> items = null;
        //for(int i = 1; i <= Math.floor(count/500) + 1; i ++) {
        while(true) {
            items = elevatorMapper.confirmCoordinateBybd(0,500);
            if(items == null || items.size() == 0) {
                break;
            }
            for (ElevatorInfo item : items) {
                //if(parseAddressByCoordinate(item.getMap_X(),item.getMap_Y())) {
                    elevatorMapper.updateConfirmCoordinateBybd(7,item.getId());
                //}

            }
        }
    }

    //检验坐标有效性
    public boolean parseAddressByCoordinate(String map_X,String map_Y) {
        try{
            String url = "http://api.map.baidu.com/geocoder?location=" + map_Y + "," + map_X + "&coord_type=gcj02&output=json&src=webapp.baidu.openAPIdemo";
            Map<String,String> queries = new HashMap<String,String>();
            String string = OkHttpUtil.get(url,queries);
            JSONObject statusObiect = JSON.parseObject(string);
            String status = statusObiect.getString("status");
            if("OK".equals(status)) {
                JSONObject resultObject = statusObiect.getJSONObject("result");
                JSONObject addressObject = resultObject.getJSONObject("addressComponent");
                String city = addressObject.getString("city");
                String province = addressObject.getString("province");
                String formatted_address = resultObject.getString("formatted_address");
                System.out.println(formatted_address);
                if("四川省".equals(province) && "成都市".equals(city)) {
                    return true;
                } else {
                    return false;
                }
            }else {
                return false;
            }
        }catch(Exception e) {
            //e.printStackTrace();
            //System.out.println("开启自调");
            if(isConnect()) {
                return parseAddressByCoordinate(map_X,map_Y);
            } else {
                System.out.println("延时10s");
                try
                {
                    Thread.currentThread().sleep(10000);//毫秒
                }
                catch(Exception ex){
                    System.out.println("线程睡眠异常");
                }
                if(isConnect()) {
                    return parseAddressByCoordinate(map_X,map_Y);
                } else {
                    //Exception exception = new NetWorkException("gbg");
                    throw new NetWorkException("网络不畅通！请联系管理员检查网络！");
                }
            }
        }

	   /* if(status.equals(0)){
	        JSONObject jsonObject = JSON.parseObject(string).getJSONObject("result").getJSONObject("location");
	        JSONObject result = JSON.parseObject(string).getJSONObject("result");
	        item.setMap_X(jsonObject.getString("lng"));
	        item.setMap_Y(jsonObject.getString("lat"));
	        item.setPrecise(result.getString("precise"));
	    }else{
	        item.setPrecise("0");

	    }*/
    }

    public void personConfirmCoordinate(String map_X, String map_Y,String registNumber) {
        //更新电梯库坐标
        elevatorMapper.personConfirmCoordinate(map_X,map_Y,8,registNumber,1);
        //更新粘贴库坐标
        elevatorMapper.personConfirmCoordinate(map_X,map_Y,8,registNumber,2);
        //更新96933坐标
        elevatorMapper.personConfirmCoordinate(map_X,map_Y,8,registNumber,3);
    }

    public void cheeckCoordinate(int sign) {
        long count = elevatorMapper.cheeckCoordinateCount(sign);
        List<ElevatorInfo> items = null;
        for(int i = 1; i <= Math.floor(count/500) + 1; i ++) {
            items = elevatorMapper.cheeckCoordinate((i - 1)*500,i*500,sign);
            for (ElevatorInfo item : items) {
                if(!parseAddressByCoordinate(item.getMap_X(),item.getMap_Y())) {
                    elevatorMapper.cheeckCoordinateUpdate(item.getId(),sign);
                }

            }
        }
    }

    public void initCoordinate() {
        //将百度返回字段设为null
        elevatorMapper.setPreciseIsNull();
    }

    public void updateCoordinateNoRewrite() {
        //long count = elevatorMapper.updateCoordinateNoRewriteCount();
        List<ElevatorInfo> items = null;
        //for(int i = 1; i <= Math.floor(count/500) + 1; i ++) {
        while(true) {
            items = elevatorMapper.updateCoordinateNoRewrite(0,500);
            if(items == null || items.size() == 0) {
                break;
            }
            for (ElevatorInfo item : items) {
                getCoordinateBybd(item);
            }
        }
    }

    //判断网络是否联通
    public boolean isConnect(){
        boolean connect = false;
        Runtime runtime = Runtime.getRuntime();
        Process process;
        try {
            process = runtime.exec("ping " + "www.baidu.com");
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            StringBuffer sb = new StringBuffer();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            System.out.println("返回值为:"+sb);
            is.close();
            isr.close();
            br.close();

            if (null != sb && !sb.toString().equals("")) {
                String logString = "";
                if (sb.toString().indexOf("TTL") > 0) {
                    // 网络畅通
                    connect = true;
                } else {
                    // 网络不畅通
                    connect = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connect;
    }
}
