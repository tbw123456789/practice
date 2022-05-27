<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>质控信息统计</title>
<base href="<%=basePath%>">
<link href="${ctx }/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx }/css/bootstrap-table.css" rel="stylesheet" />
<link href="${ctx }/layui/css/layer.css" rel="stylesheet" />
<link href="${ctx }/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet" />
<script src="${ctx }/js/jquery/jquery.min.js"></script>
<script src="${ctx }/js/bootstrap/bootstrap-table.js"></script>
<script src="${ctx }/js/bootstrap/bootstrap.min.js"></script>
<script src="${ctx }/js/bootstrap/bootstrap-table-zh-CN.js"></script>
<script src="${ctx }/js/highcharts/highcharts.js"></script>
<script src="${ctx }/js/highcharts/exporting.js"></script>
<script src="${ctx }/layui/layer.all.js"></script>
<script src="${ctx }/js/highcharts/series-label.js"></script>
<script src="${ctx }/js/highcharts/highcharts-zh_CN.js"></script>
<script src="${ctx }/js/highcharts/oldie.js"></script>


<style type="text/css">
.biaotou {
	background-color: #3687e2;
	color: #ffffff;
	font-size: 14px;
	height: 36px;
}

.query {
	margin-left: 10px;
	height: 26px;
	width: 58px;
	color: #ffffff;
	background-color: #3687e2;
	float: left;
	text-align: center;
}

.clear {
	clear: both;
}
</style>
<script type="text/javascript">
	$(function() {
		$.fn.datetimepicker.dates['zh'] = {    
                days:       ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六","星期日"],    
                daysShort:  ["日", "一", "二", "三", "四", "五", "六","日"],    
                daysMin:    ["日", "一", "二", "三", "四", "五", "六","日"],    
                months:     ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月","十二月"],    
                monthsShort:  ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"],    
                meridiem:    ["上午", "下午"],    
                //suffix:      ["st", "nd", "rd", "th"],    
                today:       "今天"    
        }; 
		$('#starttime').datetimepicker({
			 format:"yyyy-mm",
			 minView: "month",
			 language:"zh"
			});
		$('#endtime').datetimepicker({
			format:"yyyy-mm",
			minView: "month",
			language:"zh"
		});
	});
	function query(na){
		var starttime=$("#starttime").val();
		var endtime=$("#endtime").val();
		var docname= $("#docname").val();
		var json={"starttime":starttime,"endtime":endtime,"name":na,"docname":docname};
		var json1=JSON.stringify(json);
	    var json2=encodeURIComponent(json1);
	    var url1 = "<%=request.getContextPath()%>/ZhikongController/zhikongAjax.do?data="+json2;
		 $.ajax({
			type : "GET",
			url : url1,
			async : false,
			success : function(data) {
				var chart = Highcharts.chart('container', {
					chart : {
						type : 'column'
					},
					title : {
						text : data.data.data.title
					},
					subtitle : {
						text : data.data.data.subtitle
					},
					xAxis : {
						categories : data.data.data.categories,
						crosshair : true
					},
					yAxis : {
						min : 0,
						title : {
							text : '单位(位)'
						}
					},
					plotOptions : {
						column : {
							borderWidth : 0
						}
					},
					exporting:{
						enabled:false
					},
					series : [ {
						name : '手术例数',
						data : data.data.SeriesDate,
					} ],
					credits : {
						text : '',
						href : ''
					},
					legend : {
						enabled : false
					},
				});
			}
		});
	}
	
	function querytime(){
		var starttime=$("#starttime").val();
		var endtime=$("#endtime").val();
		var name= $("#docname").val();
		var json={"starttime":starttime,"endtime":endtime,"name":name};
		var json1=JSON.stringify(json);
	    var json2=encodeURIComponent(json1);
	    window.location.href="<%=request.getContextPath()%>/ZhikongController/zhikong.do?data="+json2;
	}
	function downpage(){
		var page=Number($("#page").val());
		page=page+1
		$('#huizong').bootstrapTable("load", getDate(page));
		$('#shijiandate').bootstrapTable("load", getDate1(page));
		
	}
	function topage(page){
		$('#huizong').bootstrapTable("load", getDate(page));
		$('#shijiandate').bootstrapTable("load", getDate1(page));
	}
	function uppage(){
		var page=Number($("#page").val());
		page=page-1;
		$('#huizong').bootstrapTable("load", getDate(page));
		$('#shijiandate').bootstrapTable("load", getDate1(page));
		 
	}
	function getDate(page){
		var starttime=$("#starttime").val();
		var endtime=$("#endtime").val();
		var na= $("#docname").val();
		var json={"starttime":starttime,"endtime":endtime,"name":na,"page":page};
		var json1=JSON.stringify(json);
	    var json2=encodeURIComponent(json1);
	    var url1 = "<%=request.getContextPath()%>/ZhikongController/zhikongA.do?data="+ json2;
	    var columnss = new Array();
		var datas = new Array();
	    $.ajax({
			type : "GET",
			url : url1,
			async : false,
			success : function(data) {
				var ss = {
					field : 'name',
					title : '质控指标'
				};
				columnss.push(ss);
				var ss = {
					field : 'num',
					title : '汇总',
					width : '45'
				};
				columnss.push(ss);
				for ( var i in data.data.zhikong1) {
					var da = new Object();
					da.name = data.data.zhikong1[i].name;
					da.num = data.data.zhikong1[i].num;
					datas[i] = da;
				}
				var opt = {
					columns : columnss,
					data : datas,
				};
			}
		});
		var opt = {
	            columns: columnss,
	            data: datas,
	        };
	    return opt;
	}
	function getDate1(page){
		var starttime=$("#starttime").val();
		var endtime=$("#endtime").val();
		var na = $("#docname").val();
		var json={"starttime":starttime,"endtime":endtime,"name":na,"page":page};
		var json1=JSON.stringify(json);
	    var json2=encodeURIComponent(json1);
	    var url1 = "<%=request.getContextPath()%>/ZhikongController/zhikongA.do?data="+ json2;
		var columnss = new Array();
		var datas = new Array();
		$.ajax({
			type : "GET",
			url : url1,
			async : false,
			success : function(data) {
				$("#page").val(data.data.page);
		        $("#count").val(data.count);
				for ( var i in data.data.datetime) {
					var ss = {
						field : data.data.datetime[i].na,
						title : data.data.datetime[i].name
					};
					columnss.push(ss);
				}
				 for ( var i in data.data.zhikong2) {
					var da = new Object();
					da.A = data.data.zhikong2[i][0];
					da.B = data.data.zhikong2[i][1];
					da.C = data.data.zhikong2[i][2];
					da.D = data.data.zhikong2[i][3];
					da.E = data.data.zhikong2[i][4];
					da.F = data.data.zhikong2[i][5];
					da.G = data.data.zhikong2[i][6];
					da.H = data.data.zhikong2[i][7];
					da.I = data.data.zhikong2[i][8];
					da.J = data.data.zhikong2[i][9];
					da.K = data.data.zhikong2[i][10];
					da.L = data.data.zhikong2[i][11];
					datas[i] = da;
				} 
			}
		});
		var opt = {
			columns : columnss,
			data : datas,
		};
		return opt;
	}
	function aaa(){
		//alert("aaaa");
		query('PatientLinkCount');
		$('#huizong').bootstrapTable(getDate(0));
		$('#shijiandate').bootstrapTable(getDate1(0));
	}
	
	
</script>
<script type="text/javascript">

function zhikongDetailed(type) {
	var starttime=$("#starttime").val();
	var endtime=$("#endtime").val();
	var name=$("#docname").val();
	var type=type;
	var json={"starttime":starttime,"endtime":endtime,"type":type,"name":name};
	var json1=JSON.stringify(json);
    var json2=encodeURIComponent(json1);
	var url="<%=request.getContextPath()%>/ZhikongController/zhikongDetailed.do?data="+json2;
	window.location.href = url;
	
	
};
<%-- function getname(){
	var name=$("#docname").val();
	var json={"name":na};
	var json1=JSON.stringify(json);
    var json2=encodeURIComponent(json1);
    var url1 = "<%=request.getContextPath()%>/ZhikongController/DocName.do?data="+ json2;
		$.ajax({
			type : "GET",
			url : url1,
			async : false,
			success : function(data) {

			}
		})
	} --%>
</script>
</head>
<body onload="aaa()">
	<!-- 上 -->
	<div>
		<div style="margin: 10px 5px 0px 30px;">
			<div style="float: left;" hidden="hidden">
				时间查询:<input type="text" value="${starttime }" id="starttime"
					value="2018-1" style="width: 80px;" />--<input type="text"
					value="${endtime }" style="width: 80px;" id="endtime"
					value="2018-12" /> 麻醉医生:<input type="text" value="${docname }"
					style="width: 100px;" id="docname" />
			</div>
			<!-- <button class="query" onclick="querytime()">查询</button> -->
			<%--<span style="float: right;">--%>
				<%--<button class="query" style="width: 130px;" id="zhikongmessage">导出质控统计信息</button>--%>
				<%--<button class="query" id="gongzuoliang" style="width: 120px;">导出工作量信息</button>--%>
			<%--</span>--%>
			<%--<script type="text/javascript">--%>
                <%--$("#zhikongmessage").click(function() {--%>
                    <%--var starttime = $("#starttime").val();--%>
                    <%--var endtime = $("#endtime").val();--%>
                    <%--var name = $("#docname").val();--%>
                    <%--var json={"starttime":starttime,"endtime":endtime,"name":name};--%>
                    <%--var json1=JSON.stringify(json);--%>
                    <%--var json2=encodeURIComponent(json1);--%>
                    <%--const request = new XMLHttpRequest();--%>
                    <%--const url="<%=request.getContextPath()%>/ZhikongController/zhiKongExcel.do?data="+json2;--%>
                    <%--request.open("get",url);--%>
                    <%--request.send();--%>
                    <%--request.onreadystatechange=function () {--%>
                        <%--if(this.readyState==44&&this.status==200){--%>
                            <%--console.log(request.responseText);--%>
                        <%--}--%>
                    <%--};--%>
                <%--});--%>
                <%--$("#gongzuoliang").click(function() {--%>
                    <%--var starttime = $("#starttime").val();--%>
                    <%--var endtime = $("#endtime").val();--%>
                    <%--var name = $("#docname").val();--%>
                    <%--var json={"starttime":starttime,"endtime":endtime,"name":name};--%>
                    <%--var json1=JSON.stringify(json);--%>
                    <%--var json2=encodeURIComponent(json1);--%>
                    <%--//window.location.href="<%=request.getContextPath()%>/ZhikongController/workExcel.do?data="+json2;--%>
                    <%--const request = new XMLHttpRequest();--%>
                    <%--const url="<%=request.getContextPath()%>/ZhikongController/workExcel.do?data="+json2--%>
                    <%--request.open("get",url)--%>
                    <%--request.send();--%>
                    <%--request.onreadystatechange=function () {--%>
                        <%--if(this.readyState==44&&this.status==200){--%>
                            <%--console.log(request.responseText);--%>
                        <%--}--%>
                    <%--}--%>
                <%--});--%>
				<%--// $("#zhikongmessage").click(function() {--%>
				<%--// 	var starttime = $("#starttime").val();--%>
				<%--// 	var endtime = $("#endtime").val();--%>
				<%--// 	var name = $("#docname").val();--%>
				<%--// 	QualityStatistics.zhiKongExcel(starttime, endtime, name);--%>
				<%--// });--%>
				<%--// $("#gongzuoliang").click(function() {--%>
				<%--// 	var starttime = $("#starttime").val();--%>
				<%--// 	var endtime = $("#endtime").val();--%>
				<%--// 	var name = $("#docname").val();--%>
				<%--// 	QualityStatistics.workExcel(starttime, endtime, name);--%>
				<%--// });--%>
			<%--</script>--%>
		</div>
	</div>
	<div class="clear"></div>
	<!-- 中 -->
	<div style="margin-top: 7px; margin-left: 10px; height: 310px;">
		<div
			style="width: 30%; float: left; height: 300px; margin-left: 20px; margin-top: 20px;">
			<table class="table" style="margin-bottom: 0px;">
				<tr class="biaotou">
					<th style="width: 210px;">质控指标</th>
					<th>数值</th>
					<th>操作</th>
				</tr>
			</table>
			<div style="overflow-y: auto; height: 270px;">
				<table class="table table-hover table-condensed ">
					<tbody>
						<c:forEach var="zk" items="${zhikong }">
							<tr style="height: 28px;" onclick="query('${zk.na}')">
								<td>${zk.name }</td>
								<td>${zk.per }%</td>
								<td><button class="query"
										onclick="zhikongDetailed('${zk.na}')" style="width: 60px;">详情</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div style="width: 60%; float: left; margin-left: 30px;">
			<div id="container" style="min-width: 60%; height: 310px"></div>
		</div>
	</div>
	<!-- 下 -->
	<div style="margin-top: 28px; margin-left: 10px; height: 485px;">
		<div style="float: left; width: 25%; margin-left: 20px;">
			<table class="table table-hover table-condensed " id="huizong">
			</table>
		</div>
		<div style="width: 72%; float: left;">
			<table class="table-condensed " id="shijiandate"></table>
		</div>
	</div>
	<br />
	<div style="margin-left: 500px;">
		<div class="btn-group" role="group" aria-label="First group">
			<button type="button" onclick="uppage()" class="btn btn-default">上一页</button>
			<button type="button" onclick="topage(0)" class="btn btn-default">1</button>
			<button type="button" onclick="topage(1)" class="btn btn-default">2</button>
			<button type="button" onclick="topage(2)" class="btn btn-default">3</button>
			<button type="button" onclick="topage(3)" class="btn btn-default">4</button>
			<button type="button" onclick="topage(4)" class="btn btn-default">5</button>
			<button type="button" onclick="topage(5)" class="btn btn-default">6</button>
			<button type="button" onclick="topage(6)" class="btn btn-default">7</button>
			<button type="button" onclick="topage(7)" class="btn btn-default">8</button>
			<button type="button" onclick="topage(8)" class="btn btn-default">9</button>
			<button type="button" onclick="downpage()" class="btn btn-default">下一页</button>
		</div>
		<!-- 	<span onclick="uppage()">上一页</span> <span onclick="topage(0)">1</span> <span onclick="topage(1)">2</span> <span onclick="topage(2)">3</span> <span onclick="topage(3)">4</span> <span onclick="topage(4)">5</span> <span onclick="topage(5)">6</span><span onclick="topage(6)">7</span><span onclick="topage(7)">8</span> <span onclick="topage(8)">9</span><span onclick="downpage()">下一页</span>
	 -->
	</div>
	<div class="btn-toolbar" role="toolbar"
		aria-label="Toolbar with button groups"></div>
	<div hidden=hidden>
		<input id="page" value="0"> <input id="count" value="0">
	</div>
	<div style="height: 80px;"></div>
</body>
<script src="${ctx }/js/layer/layer.js"></script>
<script
	src="${ctx }/js/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>
<script
	src="${ctx }/js/bootstrap-datetimepicker/bootstrap-datetimepicker.fr.js"></script>
<!-- <script type="text/javascript">
layer.user('from',function(){
});
</script> -->
</html>