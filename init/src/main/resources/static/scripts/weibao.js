$(function(){
	
	jQuery.post('/tcweb/elevator/cseletjWeibaoEcharts', function(data){ 
        data = eval(data);//POST方法必加，ajax方法自动处理了 
        var weibaoValueData = data.tjWeibaoEcharts;            
        drawWeibao(weibaoValueData);
	   }, 'json'); 
}); 

function drawWeibao(weibaoValueData){
// 基于准备好的dom，初始化echarts实例
var weibao = echarts.init(document.getElementById('footer-left-bar'));

//初始化数据
 var barData1 = [258];
 var barData2 = [360];


//根据查询结果，动态赋值
for (var i = 0; i < weibaoValueData.length; i++) {
	 if(i == 0)
	 barData1[0] = weibaoValueData[i].companyTotal;
	 if(i == 1)
	 barData2[0] =	weibaoValueData[i].companyTotal; 
	 if(i == 2)
     $('#sweibaoNum').html(weibaoValueData[i].companyTotal);
	 if(i == 3){
	    if(Number(weibaoValueData[i].companyTotal/weibaoValueData[i-1].companyTotal).toFixed(2) == Infinity)
		   $('#dpeibi').html("");
	    else
	       $('#dpeibi').html(Number(weibaoValueData[i].companyTotal/weibaoValueData[i-1].companyTotal).toFixed(2)+'台');	
	       $('#dtzs').html(weibaoValueData[i].companyTotal);	 
	 }
	 if(i == 4){
	   $('#tydt').html(weibaoValueData[i].companyTotal);	 
	 }
	 if(i == 5){
	   $('#smdt').html(weibaoValueData[i].companyTotal);
	   $('#zydt').html(weibaoValueData[3].companyTotal-weibaoValueData[4].companyTotal-weibaoValueData[i].companyTotal);
	 }
	 
}

// 指定图表的配置项和数据
var optionbar = {
        title : {
            // 是否显示
            show: true,
            // 主标题文本，'\n'指定换行
            text: '电梯维保单位及维保人员',
            textStyle: {
                // 颜色
                color: '#dfd915'
                // 水平对齐方式，可选为：'left' | 'right' | 'center'
            }
        },
       tooltip: {
            trigger: 'item',  
            formatter: "{a} : {c}"  
       },
       grid: {
           left: '3%',
           right: '4%',
           bottom: '16%',
           containLabel: true
       },
       legend: {
           data: ['长沙在保维保单位', '登记维保单位'],
           orient: 'horizontal',
           x:'left',
           y: 'bottom',
           textStyle: {
               color: '#fff',
               fontSize:12
           }
       },
       xAxis: {
           type: 'value',
           axisLine: {
               show: false
           },
           axisTick: {
               show: false
           },
           axisLabel: {
               show: false,
               textStyle: {
                   color: '#fff'
               }
           },
           splitLine: {
                lineStyle: {
                    color: "#333"
                }
            }
       },
       yAxis: {
           type: 'category'
       },
       series: [
           {
               name: '长沙在保维保单位',
               type: 'bar',
               data: barData2,
               barGap:0,
               barWidth : 30,
               itemStyle:{
                   normal:{
                       color:'#e76624'
                   }
               },
               label:{ 
                   normal:{ 
                       show: true, 
                       position: 'insideRight',
                       textStyle: {
                           color:'#fff'
                       }
                   } 
               }
           },
           {
               name: '登记维保单位',
               type: 'bar',
               data: barData1,
               barGap:0,
               barWidth : 30,
               itemStyle:{
                   normal:{
                       color:'#4685c8'
                   }
               },
               label:{ 
                   normal:{ 
                       show: true, 
                       position: 'insideRight',
                       textStyle: {
                           color:'#fff'
                       }
                   } 
               }
           },
       ]
   };

   // 使用刚指定的配置项和数据显示图表。
   weibao.setOption(optionbar);

  //根据窗口的大小变动图表 --- 重点
   window.onresize = function(){
    weibao.resize();
};
}