$(function(){
	
	jQuery.post('/tcweb/elevator/cseletjEllipseEcharts', function(data){ 
        data = eval(data);//POST方法必加，ajax方法自动处理了 
        var ellipseValueData = data.tjEllipseEcharts;            
        drawEllipse(ellipseValueData);
	   }, 'json'); 
}); 

function drawEllipse(ellipseValueData){
// 基于准备好的dom，初始化echarts实例
        var ellipseChart = echarts.init(document.getElementById('ellipse'));
        //电梯使用数量
        var ellipseData = [3695];
        //电梯安全员
  //      var ellipsePeople = '安全员';
        
        for (var i = 0; i < ellipseValueData.length; i++) {
        	ellipseData[0] =ellipseValueData[i].companyTotal;
        }
        // 指定图表的配置项和数据
        var ellipseOption = {
            title: [{
                text: '电梯使用单位',
                textStyle:{
                    color:'#dfd915'
                }
            }
      /*      ,{
                text: "电梯安全员：" + ellipsePeople,
                x: 'left',
                y: 'bottom',
                textStyle:{
                    fontSize: 14,
                    fontWeight: 'normal',
                    color:'#fff'
                }
            } */
      ],
            grid: {
                left: '3%',
                right: '4%',
                bottom: '15%',
                containLabel: true
            },
            xAxis : [
                {
                    type : 'category',
                    axisLine: {
                        show:false
                    },
                    axisTick: {
                        show:false
                    },
                    axisLabel: {
                        show: true,
                        inside : true,
                        nameLocation:'start',
                        textStyle: {
                            color: '#fff'
                        }
                    }
                }
            ],
            yAxis : [
                {
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
                }
            ],
            series : [
                {
                    type:'bar',
                    barWidth: '100%',
                    data:ellipseData,//电梯使用数量
                    itemStyle: {
                        normal: {
                            color: new echarts.graphic.LinearGradient(0, 0, 1, 0, [{
                                offset: 0,
                                color: '#477efb'
                            }, {
                                offset: 1,
                                color: '#01339f'
                            },]),
                            opacity: 1,
                            barBorderRadius:[10, 10, 10, 10]
                        }
                    },
                    label:{ 
                        normal:{ 
                            show: true, 
                            position: 'top',//insideRight
                            formatter:function(params){
                                return params.value + '家';
                            },
                            textStyle: {
                                color:'#32d21f',
                                fontSize: 18
                                    
                            }
                        } 
                    }
                }
            ]
        };

        // 使用刚指定的配置项和数据显示图表。
        ellipseChart.setOption(ellipseOption);

        window.onresize = function(){
            ellipseChart.resize();
        };
}