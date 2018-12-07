$(function(){
        //tab切换
        // $(".footer-right-span  span").hover(function(){ 
        //     var num=$(this).index();
        //     $(".footer-right-span  span").removeClass("spanBg").eq(num).addClass("spanBg");
        //     $(".footer-right-bar").hide().eq(num).show();  
        // });
        //解决tab切换echarts显示问题
        // $("#tab-one").css('width',$("#tab-one").width());
        // $("#tab-two").css('width',$("#tab-one").width());
        // $("#tab-three").css('width',$("#tab-one").width());
        // $("#tab-one").css('height',$("#tab-one").height());
        // $("#tab-two").css('height',$("#tab-one").height());
        // $("#tab-three").css('height',$("#tab-one").height());
	
	jQuery.post('/tcweb/elevator/cseletjTabChartsEcharts', function(data){ 
        data = eval(data);//POST方法必加，ajax方法自动处理了 
        var tabChartsValueData = data.tjTabChartsEcharts;            
        drawTabCharts(tabChartsValueData);
	   }, 'json'); 
}); 


function drawTabCharts(tabChartsValueData){        
        // 基于准备好的dom，初始化echarts实例
        var chartOne = echarts.init(document.getElementById('tab-one'));

        // 各个tab的X轴数据
        var Xone = ['高新区','宁乡县','望城区','岳麓区','开福区','雨花区','芙蓉区','天心区','浏阳市'];
        
        //各个tab的电梯数量data
        var dtslOne = [50, 0, 0, 0, 0, 0, 0,0,0];

        //各个tab的电梯预警data
        var dtyjOne = [0, 0, 0, 0, 0, 0, 0,0,0];

        //根据查询结果，动态赋值
        for (var i = 0; i < tabChartsValueData.length; i++) {
    	     var area = tabChartsValueData[i].companyName;
             var etotal = tabChartsValueData[i].etotal;   
             if(area == "高新区"){
            	 dtslOne[0] = etotal;
             }
                   	 
        } 

        // 指定图表的配置项和数据
        var optionOne = {
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'shadow'
                    }
                },
                legend: {
                    data: ['电梯数量', '电梯预警',],
                    align: 'left',
                    orient:'vertical',
                    right: 10,
                    textStyle: {
                        color: "#fff"
                    },
                    itemWidth: 15,
                    itemHeight: 15
                    // itemGap: 35
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '6%',
                    containLabel: true
                },
                xAxis: [{
                    type: 'category',
                    data: Xone,
                    axisLine: {
                        show: true,
                        symbol:['none','arrow'],
                        symbolSize:[5,5],
                        lineStyle: {
                            color: "#fff",
                            width: 1,
                            type: "solid"
                        }
                    },
                    axisTick: {
                        show: false
                    },
                    axisLabel: {
                        interval:0,
                        show: true,
                        textStyle: {
                            color: "#76ffb2"
                        }
                    }
                }],
                yAxis: [{
                    type: 'value',
                    axisLabel: {
                        // formatter: '{value} %'
                    },
                    axisTick: {
                        show: false
                    },
                    axisLine: {
                        symbol:['none','arrow'],
                        symbolSize:[5,5],
                        show: true,
                        lineStyle: {
                            color: "#fff",
                            width: 1,
                            type: "solid"
                        }
                    },
                    splitLine: {
                        lineStyle: {
                            color: "#333"
                        }
                    }
                }],
                series: [{
                    name: '电梯数量',
                    type: 'bar',
                    data: dtslOne,
                    barWidth: 10, //柱子宽度
                    barGap: 0, //柱子之间间距
                    itemStyle: {
                        normal: {
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                offset: 0,
                                color: '#00d699'
                            }, {
                                offset: 1,
                                color: '#007d57'
                            }]),
                            opacity: 1,
                            barBorderRadius:[10, 10, 0, 0]
                        }
                    }
                }, {
                    name: '电梯预警',
                    type: 'bar',
                    data: dtyjOne,
                    barWidth: 10,
                    barGap: 0,
                    itemStyle: {
                        normal: {
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                offset: 0,
                                color: '#f2b72b'
                            }, {
                                offset: 1,
                                color: '#f4810c'
                            }]),
                            opacity: 1,
                            barBorderRadius:[10, 10, 0, 0]
                        }
                    }
                },]
            }; 

        // 使用刚指定的配置项和数据显示图表。
        chartOne.setOption(optionOne);


        //根据窗口的大小变动图表 --- 重点
        window.onresize = function(){
            chartOne.resize();
            chartTwo.resize();
            chartThree.resize();
        };
}

