<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=request.getContextPath()%>/js/highcharts/highcharts.js"></script>
<script src="<%=request.getContextPath()%>/js/highcharts/exporting.js"></script>
<script
	src="<%=request.getContextPath()%>/js/highcharts/series-label.js"></script>
<script
	src="<%=request.getContextPath()%>/js/highcharts/highcharts-zh_CN.js"></script>
<script src="<%=request.getContextPath()%>/js/highcharts/oldie.js"></script>
<script src="<%=request.getContextPath()%>/js/other/Draggablepoints.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery/jquery-1.9.1.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/layer/layer.js"></script>

<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/layer.css" />
<meta http-equiv="Access-Control-Allow-Origin" content="*">
<title>Insert title here</title>
</head>
<script type="text/javascript">
var value = '';
var chart = null;

//获取麻醉单Bedside数据,并放在value里面
$.ajax({
   type: "GET",
   url: "http://localhost:8080/SPMVC/mazuidanController/getAnalogData.do",
   async: false, 
   success: function(data){
		value = data;
   },
   error: function(){
   		console.log("获取数据错误!!!!!error!");
   }
});

$(function(){
	//给Highcharts设置全局属性
	Highcharts.setOptions({
	    global: {
	      useUTC: false  //是否使用国际时间
			}
	});

	//创建Highcharts
	chart = Highcharts.chart('container', {
	    title: {
	        text: '麻醉单'	//标题
	    },
	    chart:{
	        style: {	//字体css设置
	            fontFamily: '\微软雅黑\, Arial, Helvetica, sans-serif',
	            color: '#333',
	            fontSize: '12px',
	            fontWeight: 'normal',
	            fontStyle: 'normal'
	        },
	        borderRadius: 11,	//边框圆角
	        borderWidth: 0,		//边框宽度
	        type: 'line',	//图表类型
	        height:500,		//图表长度
	        width:900,		//图表宽度
	    },
	    xAxis: [{	//x轴属性设置
	        type: 'datetime',	//轴数据类型
	        opposite: true,		//对面显示
	        reversed: false,	//是否反转
	        labels: {
	            format: '{value:%H:%M}'		//数据显示格式
	        },
	        isX: true,
	        gridLineColor: 'black',		//网格线颜色
	        gridLineWidth: 2,		//网格线宽度
	        max:value.mazuiEndTime,		//起始值
	        minorTickInterval: 'auto',		//次网格线最小间隔
	        minorGridLineColor: 'black',	//次网格线颜色
	        minorGridLineDashStyle:'ShortDash',	//次网格线条样式
	    }],
	    yAxis: [{
	        title: {	//标题
	            text:'mmhg',
	        },
	        max: 280,	//最大值
	        min: 0,		//最小值
	        gridLineColor: 'black',
	        gridLineWidth: 2,
	        minorGridLineColor: 'black',
	        minorTickInterval: 'auto',
	        minorGridLineDashStyle:'ShortDash',
	    },{
	        title: {
	            text:'温度℃',
	        },
	        max: 46,
	        min: 20,
	    },{
	        title: {
	            text: ''
	        },
	        max: 0,
	        min: -999999,
	        labels: {
	            enabled: false
	        }
	    }],
	    legend: {	//图例布局
	        layout: 'vertical',
	        align: 'right',
	        verticalAlign: 'middle'
	    },
	    plotOptions: {	//数据列配置
	        series: {	//通用数据列
	            pointStart: value.mazuiNowTime, // 开始值
	            pointInterval: 5 * 60 * 1000 ,	//间隔
	        },
	    },
	    series: value.data,/*[{
	        data: [37.0, 37.0, 37.2, 37.2, 37.2, 37.0, 37.0, 37.5, 37.5, 37.5, 37.5, 38.0, 38.0, 37.5],
	        name: '体温',
	        draggableY: true,
	        yAxis: 1,
	        color: '#e040fb',
	        marker: {
	            enabled: true,
	            symbol: 'triangle'
	        },
	    },{
	        data: [80, 80, 85, 85, 85, 84, 84, 98, 105, 105, 105, 82, 82, 85],
	        draggableY: true,
	        name: '心率',
	        color: '#b2ff59'
	    },{
	        data: [35, 35, 40, 40, 40, 38, 38, 24, 20, 20, 20, 30, 30, 35],
	        draggableY: true,
	        name: '自主呼吸',
	        color: '#40c4ff'
	    } ]*/
	    tooltip: {	//提示框
	        formatter: function () {
	       			var vlaue= this.y;
	            if(this.series.name == '体温'){
            		vlaue = vlaue.toFixed(1);
	       			setBedsideData(vlaue,this.x,this.colorIndex);
	                return this.series.name+':'+vlaue+'℃';
	            }else{
            		vlaue = vlaue.toFixed(0);
	       			setBedsideData(vlaue,this.x,this.colorIndex);
	                return this.series.name+':'+vlaue;
	            }
	        },
	    },
	    responsive: {
	        rules: [{
	            condition: {
	                maxWidth: 500
	            }
	        }]
	    }
	});


	var i = 10;

	$('#button').click(function () {
		console.log("button");
		if(i%2 == 0){
			chart.series[0].show();
		}else{
			chart.series[0].hide();
		}
		i++;
	});

})

$('#button1').click(function () {
	chart.series[0].series.show();
});

//麻醉单值发生变化时保存数据库
function setBedsideData(intval,time,colorIndex){
	var time = (time-value.mazuiNowTime) / 300000;
	var ider = value.data[colorIndex].data[time];
	
	if(intval == ider){
		console.log("没事没事");
	}else{
		var url = "http://localhost:8080/SPMVC/mazuidanController/setBedsideData/"+ intval + "/" + time + "/" + colorIndex + ".do";
		console.log(url);
		$.ajax({
		   type: "GET",
		   url: url,
		   async: false, 
		   success: function(data){
		   		console.log(data);
		   		value.data[colorIndex].data[time] = intval;
		   		console.log("success!");
		   },
		   error: function(){
		   		console.log("error!");
		   }
		});
	}
	
};

//打开参数页面
function parameter(){
	layer.open({  
		   type: 2, 
		   area: ['550px', '330px'],
		   shadeClose: true,
		   closeBtn: true,
		   content: 'http://localhost:8080/SPMVC/mazuidanController/parameter.do'
		}); 
};

//根据参数页面值发生改变而改变图表
function update(id,time,data){
	var dataId = (Date.parse(time)-value.mazuiNowTime) / 300000;
	chart.get(id).data[dataId].update(data);
}

//每五秒钟获取一次数据,并画出来
var time = value.mazuiNowTime + value.data[0].data.length * 300000;
var getBedsideRegularly=self.setInterval("clock("+ time +")",5000);
function clock(time)
{
	var operationId = 1;
	time = value.mazuiNowTime + value.data[0].data.length * 300000;
	if(time == value.mazuiEndTime){
		getBedsideRegularly=window.clearInterval(getBedsideRegularly)
	}
	
	$.ajax({
		   type: "GET",
		   url: "http://localhost:8080/SPMVC/mazuidanController/getBedsideRegularly/"+ time + "/" + operationId + ".do",
		   async: false, 
		   success: function(data){
			    var bedsideList = data.data;
		   		bedsideList.forEach(function (bedside) {
			   		chart.get(bedside.code).addPoint(bedside.intVal);
		   		});
		   },
		   error: function(){
		   		console.log("error!");
		   }
		});
}
</script>
<body>
	<div id="container" style="height: 500px"></div>
	<div>
		<button id="button" class="autocompare">显示</button>
		<button id="button1" class="autocompare">添加点</button>
		<button id="parameter" class="autocompare" onclick="parameter()">参数</button>
	</div>
</body>
</html>