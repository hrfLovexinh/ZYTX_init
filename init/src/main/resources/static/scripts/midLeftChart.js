$(function(){
	
    // 基于准备好的dom，初始化echarts实例
	
	
	jQuery.post('/tcweb/elevator/cseletjEcharts', function(data){   
        data = eval(data);//POST方法必加，ajax方法自动处理了 
        var leftValueData = data.tjEcharts;          
        draw(leftValueData);
	   }, 'json');
});
    //value数据
 /*   var leftValueData = [
        {name: '通力电梯有限公司成都分公司',value:8704},
        {name: '奥的斯机电成都分公司', value:8300},
        {name: '日立(中国)四川分公司', value:8020},
        {name: '蒂森电梯成都分公司',value:7986},
        {name: '迅达(中国)成都分公司',value:7785},
        {name: '奥的斯电梯(中国)成都分公司', value:7530},
        {name: '上海三菱四川分公司', value:7422},
        {name: '四川至上安装工程有限责任公司', value:7399},
        {name: '四川景泰祥楼宇设备有限公司',value:7352},
        {name: '四川安信捷实业有限公司', value:6984},
        {name: '四川中意环泰电梯有限公司', value:6578},
        {name: '四川铂莱电梯工程有限公司', value:6003},
        {name: '成都安迅达机电设备有限公司',value:5698},
        {name: '永大电梯四川分公司',value:5555},
        {name: '成都吉高电梯工程有限公司', value:5100},
        {name: '四川众雁电梯有限公司', value:4988},
        {name: '富士电梯有限公司', value:4651},
        {name: '成都九信电梯有限公司',value:4366},
        {name: '四川中安电梯有限公司',value:4066},
        {name: '四川富士达电梯有限公司', value:3999},
    ]; */
    // y轴坐标数组
function draw(leftValueData){   
	    var midLeftChart = echarts.init(document.getElementById('midLeftChart'));
	    //颜色数组
	    var myColor = ['rgba(53, 119, 73,0.5)', 'rgba(53, 119, 73,0.8)'];
	    
	  

	    var	ydataValue = new Array();
        var YLeftData = [];
      
          for (var i = 0; i < leftValueData.length; i++) {
          //      YLeftData.push(leftValueData[i].name);  
                YLeftData.push(leftValueData[i].companyName);
                ydataValue.push(leftValueData[i].etotal);
            }
          var endPercent = (14 / YLeftData.length) * 100; 
     
    // 指定图表的配置项和数据
    var midLeftOption = {
        title : {
            // 是否显示
            show: true,
            // 主标题文本，'\n'指定换行
            text: '全市各维保企业所属电梯数量',
            left: '2%',
            textStyle: {
                // 颜色
                color: '#dfd915'
                // 水平对齐方式，可选为：'left' | 'right' | 'center'
            }
        },
        tooltip: {
            trigger: 'item',  
            formatter: "{b} : {c}"  
       },
       dataZoom: [
           {
               start: 0,//默认为0  
               end: endPercent,
               type: 'slider',
               show: true,
               handleSize: 0,//滑动条的 左右2个滑动条的大小  
               yAxisIndex: [0],
               width: 8,
               left: '98%',
               filterMode:'empty',
               borderColor: "rgba(0,0,0,0)",
               handleColor: 'rgba(0,0,0,0)',//h滑动图标的颜色  
               handleStyle: {
                   borderColor: "rgba(0,0,0,0)",
                   borderWidth: "0",
                   shadowBlur: 0,
                   background: "rgba(0,0,0,0)",
                   shadowColor: "rgba(0,0,0,0)"
               },
               fillerColor: new echarts.graphic.LinearGradient(1, 0, 0, 0, [{
                   //给颜色设置渐变色 前面4个参数，给第一个设置1，第四个设置0 ，就是水平渐变  
                   //给第一个设置0，第四个设置1，就是垂直渐变  
                   offset: 0,
                   color: 'rgba(53, 119, 73,0.5)'
               }, {
                   offset: 1,
                   color: 'rgba(53, 119, 73,0.8)'
               }]),
               backgroundColor: 'rgba(0,0,0,0)',//两边未选中的滑动条区域的颜色  
               showDataShadow: false,//是否显示数据阴影 默认auto  
               showDetail: false//即拖拽时候是否显示详细数值信息 默认true
           },
           //下面这个属性是里面拖动  
           {
               type: 'inside',
               yAxisIndex: [0],
               start: 0,//默认为1  
               end: endPercent,
               zoomLock: true
           },
       ],
        xAxis: {
            type: 'value',
            axisLine: {
                show: false
            },
            axisTick: {
                show: false
            },
            splitLine:{//改设置不显示坐标区域内的轴分割线
                show:false
            },
            axisLabel: {
                show: false,
                textStyle: {
                    color: '#fff'
                }
            }
        },
        yAxis: {
            type: 'category',
            data:YLeftData,
            axisLine: {
                show:false
            },
            axisTick: {
                show:false
            },
            inverse:true,//反向坐标轴
            zlevel:10,
            axisLabel: {
                    show: true,
                    inside : true,
                    nameLocation:'start',
                    textStyle: {
                        color: '#fff'
                    },
                    formatter: function (params) {
                        var newParamsName=""; // 最终拼接成的字符串
                        var paramsNameNumber=params.length; // 实际标签的个数
                        var provideNumber=20; // 每行能显示的字的个数
                        var rowNumber=Math.ceil(paramsNameNumber / provideNumber); // 换行的话，需要显示几行，向上取整
                        /**
                                         * 判断标签的个数是否大于规定的个数， 如果大于，则进行换行处理 如果不大于，即等于或小于，就返回原标签
                                         */
                        // 条件等同于rowNumber>1
                        if (paramsNameNumber > provideNumber) {
                            /** 循环每一行,p表示行 */
                            for (var p=0;
                            p < rowNumber;
                            p++) {
                                var tempStr=""; // 表示每一次截取的字符串
                                var start=p * provideNumber; // 开始截取的位置
                                var end=start+provideNumber; // 结束截取的位置
                                // 此处特殊处理最后一行的索引值
                                if (p==rowNumber - 1) {
                                    // 最后一次不换行
                                    tempStr=params.substring(start, paramsNameNumber);
                                }
                                else {
                                    // 每一次拼接字符串并换行
                                    tempStr=params.substring(start, end)+"\n";
                                }
                                newParamsName+=tempStr; // 最终拼成的字符串
                            }
                        }
                        else {
                            // 将旧标签的值赋给新标签
                            newParamsName=params;
                        } //将最终的字符串返回
                        return newParamsName
                    }
                }
        },
        series: [{
                name: '手机品牌',
                type: 'bar',
                barCategoryGap:'0%',//条间距
                data: ydataValue,
                barMinHeight:260,
                //设置柱子的宽度
                // barWidth : 30,
                //配置样式
                itemStyle: {   
                    //通常情况下：
                    normal:{  
                        // barBorderRadius: 30,
                        color: function(params) { 
                            var num = myColor.length;
                            return myColor[params.dataIndex % num]
                        }
                    },
                    //鼠标悬停时：
                    emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                },
                label:{ 
                    normal:{ 
                        show: true, 
                        position: 'right',//insideRight
                        formatter:function(params){
                            return params.value;  
                	   // return params.etotal;
                        },
                        textStyle: {
                            color:'#dfd915'
                                
                        }
                    } 
                }
            }],
    //控制边距　
            grid: {
                left: '3%',
                right: '3%',
                bottom: '3%',
                top: '8%',
                containLabel: true
            }
        };

    // 使用刚指定的配置项和数据显示图表。
    midLeftChart.setOption(midLeftOption);  

    //根据窗口的大小变动图表 --- 重点
    window.onresize = function(){
        midLeftChart.resize();
    }; 
}
