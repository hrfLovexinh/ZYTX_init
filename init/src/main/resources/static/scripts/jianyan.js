$(function(){
    // 基于准备好的dom，初始化echarts实例
        var elevatorTest = echarts.init(document.getElementById('elevator-test'));

        // 指定图表的配置项和数据
        var optionTest = {
                title : {
                    text: '电梯检验',
                    x:'left',
                    textStyle: {
                        // 颜色
                        color: '#d8d210'
                    }
                },
                tooltip : {  
                    trigger: 'item',  
                    formatter: "{a} <br/>{b} : {c}"  
                },
                legend: {
                    orient: 'horizontal',
                    left: 'center',
                    bottom: 0,
                    data: ['已检验','检验中'],
                    textStyle: {
                        color: '#fff',
                        fontSize:12
                    }
                },
                color:['#74b34a','#ffc620'],
                series : [
                    {
                        name: '电梯检验状态',
                        type: 'pie',
                        radius : '60%',
                        center: ['50%', '50%'],
                        data:[
                            {value:335, name:'已检验'},
                            {value:66, name:'检验中'},
                        ],
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            },
                            //控制箭头显示
                            normal : {
                                label : {
                                show : false
                                },
                                labelLine : {
                                show : false
                                }
                            }
                        },
                        label:{            //饼图图形上的文本标签
                            normal:{
                                show:true,
                                position:'inner', //标签的位置
                                textStyle : {
                                    fontWeight : 300 ,
                                    fontSize : 12    //文字的字体大小
                                },
                                formatter:'{d}%'
                            }
                        }
                    }
                ]
            };

        // 使用刚指定的配置项和数据显示图表。
        elevatorTest.setOption(optionTest);

        //根据窗口的大小变动图表 --- 重点
        window.onresize = function(){
            elevatorTest.resize();
        }
    })