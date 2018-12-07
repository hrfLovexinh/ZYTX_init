$(function(){
	
    // 基于准备好的dom，初始化echarts实例
  
	jQuery.post('/tcweb/elevator/cseletjMrEcharts', function(data){ 
        data = eval(data);//POST方法必加，ajax方法自动处理了 
        var rightValueData = data.tjMrEcharts;            
        drawRight(rightValueData);
	   }, 'json'); 
}); 

function drawRight(rightValueData){ 
	    var midRightChart = echarts.init(document.getElementById('midRightChart'));
       //颜色数组
        var midRightChartColor = ['rgba(5, 97, 196,0.5)', 'rgba(5, 97, 196,0.8)',];
        //value数据
    /*    var rightValueData = [
            {name: '成都金房物业服务有限公司',value:1282,},
            {name: '四川嘉宝住宅管理分公司', value:1158,},
            {name: '保利物业管理有限公司成都分公司', value:1102,},
            {name: '成都地铁有限责任公司',value:1095,},
            {name: '华润置地物业服务有限公司',value:1050,},
            {name: '成都龙湖物业服务有限公司', value:1002,},
            {name: '成都万科物业服务有限公司', value:997,},
            {name: '成都蜀信物业服务有限公司', value:984,},
            {name: '深圳市彩生活物业管理成都分公司',value:956,},
            {name: '四川华玮物业管理有限公司', value:935,},
            {name: '中房集团成都物业有限公司', value:915,},
            {name: '成都中海物业管理有限公司', value:890,},
            {name: '家利物业管理成都分公司',value:883,},
            {name: '成都合力物业服务有限公司',value:864,},
            {name: '成都合能物业管理有限公司', value:832,},
            {name: '四川悦华置地物业管理有限公司', value:805,},
            {name: '长城物业集团股份成都分公司', value:798,},
            {name: '成都亿新物业管理有限公司',value:765,},
            {name: '成都仁和春天物业管理公司',value:755,},
            {name: '成都家园经营管理有限公司', value:740,},
        ]; */
        // y轴数据(根据value数组得到相应name)
        var	ydataValue = new Array();
        var YRightData = [];
        
        for (var i = 0; i < rightValueData.length; i++) {
        	      YRightData.push(rightValueData[i].companyName);
                  ydataValue.push(rightValueData[i].etotal);
              }
       
        var endPercent = (14 / YRightData.length) * 100;
        // 指定图表的配置项和数据
        var midRightOption = {
            title : {
		    	// 是否显示
		    	show: true,
                text: '全市电梯使用单位所属电梯数量',
                left: '2%',
                textStyle: {
		        	// 颜色
                    color: '#dfd915'
                }
            },
            tooltip: {
                trigger: 'item',  
                formatter: "{b} : {c}"  
           },
           dataZoom: [//给x轴设置滚动条  
                      {  
                          start:0,//默认为0  
                          end: endPercent,  
                          type: 'slider',  
                          show: true,   
                          handleSize: 0,//滑动条的 左右2个滑动条的大小  
                          yAxisIndex: [0],
                          width: 8, 
                          left: '2%', 
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
                              color: 'rgba(5, 97, 196,0.5)'
                          }, {  
                              offset: 1,  
                              color: 'rgba(5, 97, 196,0.8)'  
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
                          zoomLock:true
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
                inverse:true,
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
                data:YRightData,
                axisLine: {
                    show:false
                },
                axisTick: {
                    show:false
                },
                position:'right',
                inverse:true,//反向坐标轴
                zlevel:10,
                axisLabel: {
                        show: true,
                        inside : true,
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
                            return newParamsName;
                        }
                    }
            },
            series: [{
                    name: '全市电梯使用单位所属电梯数量',
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
                                var num = midRightChartColor.length;
                                return midRightChartColor[params.dataIndex % num];
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
                            position: 'left',
                            formatter:function(params){
                                return params.value;
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
        midRightChart.setOption(midRightOption);

        //根据窗口的大小变动图表 --- 重点
        window.onresize = function(){
            midRightChart.resize();
        };
    }