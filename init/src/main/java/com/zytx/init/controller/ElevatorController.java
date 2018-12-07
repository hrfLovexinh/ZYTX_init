package com.zytx.init.controller;


import com.fasterxml.jackson.annotation.JsonView;
import com.zytx.init.domain.ElevatorCoordinate;
import com.zytx.init.domain.ElevatorInfo;
import com.zytx.init.service.ElevatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ElevatorController {

    @Autowired
    private ElevatorService elevatorService;

    //初始化
    @RequestMapping("/elevator/initCoordinate")
    public String initCoordinate() {
        try {
            elevatorService.initCoordinate();
            return "初始化完成,请继续执行下面操作！";
        } catch (Exception e) {
            e.printStackTrace();
            return "操作出现异常,请与管理员联系检查问题!";
        }
    }

    //根据电梯地址更新坐标
    @RequestMapping("/elevator/updateCoordinate")
    public String updateCoordinate() {
        try {
            elevatorService.updateCoordinate();
            return "更新成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "可能在更新过程中出现问题,请与管理员联系检查问题!";
        }

    }

    //检验坐标有效性
    @RequestMapping("/elevator/cheeckCoordinate")
    public String cheeckCoordinate(int sign) {
        try {
            elevatorService.cheeckCoordinate(sign);
            return "检验完成";
        } catch (Exception e) {
            e.printStackTrace();
            return "可能在更新过程中出现问题,请与管理员联系检查问题!";
        }
    }

    //1.三个坐标误差都小于200m的以96933坐标为准
    @RequestMapping("/elevator/confirmCoordinateByAll")
    public String confirmCoordinateByAll() {
        try {
            elevatorService.confirmCoordinateByAll();
            return "更新成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "可能在更新过程中出现问题,请与管理员联系检查问题!";
        }
    }

    //2.96933坐标与粘贴库坐标误差小于250m的以96933坐标为准
    @RequestMapping("/elevator/confirmCoordinateBypddistance")
    public String confirmCoordinateBypddistance() {
        try {
            elevatorService.confirmCoordinateBypddistance();
            return "更新成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "可能在更新过程中出现问题,请与管理员联系检查问题!";
        }
    }

    //3.96933坐标与电梯库坐标误差小于250m的以96933坐标为准
    @RequestMapping("/elevator/confirmCoordinateByepdistance")
    public String confirmCoordinateByepdistance() {
        try {
            elevatorService.confirmCoordinateByepdistance();
            return "更新成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "可能在更新过程中出现问题,请与管理员联系检查问题!";
        }
    }

    //4.电梯库坐标与粘贴库坐标误差小于500m的以粘贴库为准
    @RequestMapping("/elevator/confirmCoordinateByeddistance")
    public String confirmCoordinateByeddistance() {
        try {
            elevatorService.confirmCoordinateByeddistance();
            return "更新成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "可能在更新过程中出现问题,请与管理员联系检查问题!";
        }
    }

    //5.96933坐标与电梯库坐标误差小于1000m的以96933坐标为准
    @RequestMapping("/elevator/confirmCoordinateByepdistance1")
    public String confirmCoordinateByepdistance1() {
        try {
            elevatorService.confirmCoordinateByepdistance1();
            return "更新成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "可能在更新过程中出现问题,请与管理员联系检查问题!";
        }
    }

    //6.电梯库坐标与粘贴库坐标误差小于1000m的以粘贴库为准
    @RequestMapping("/elevator/confirmCoordinateByeddistance1")
    public String confirmCoordinateByeddistance1() {
        try {
            elevatorService.confirmCoordinateByeddistance1();
            return "更新成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "可能在更新过程中出现问题,请与管理员联系检查问题!";
        }
    }

    //7.根据百度定位的坐标为准
    @RequestMapping("/elevator/confirmCoordinateBybd")
    public String confirmCoordinateBybd() {
        try {
            elevatorService.confirmCoordinateBybd();
            return "更新成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "可能在更新过程中出现问题,请与管理员联系检查问题!";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/elevator/findCantConfirmByCoordinate")
    public Map findCantConfirmByCoordinate(int rows, int page,int sign) {
        return elevatorService.findCantConfirmByCoordinate(rows,page,sign);
    }

    //人工定位坐标
    @RequestMapping("/elevator/personConfirmCoordinate")
    public String personConfirmCoordinate(String map_X,String map_Y,String registNumber) {
        System.out.println("更新编号为" + registNumber +"的坐标：" +"(" + map_X + "," + map_Y + ")");
        try {
            elevatorService.personConfirmCoordinate(map_X,map_Y,registNumber);
            return "更新成功！";
        } catch (Exception e) {
            e.printStackTrace();
            return "更新异常，请尽快与管理员联系！";
        }

    }

    //对坐标无效的电梯生成坐标
    @RequestMapping("/elevator/updateCoordinateNoRewrite")
    public String updateCoordinateNoRewrite() {
        try {
            elevatorService.updateCoordinateNoRewrite();
            return "更新成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "可能在更新过程中出现问题,请与管理员联系检查问题!";
        }
    }

}
