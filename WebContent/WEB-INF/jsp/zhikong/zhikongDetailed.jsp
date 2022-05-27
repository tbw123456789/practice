<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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
<script src="${ctx }/js/jquery/jquery-1.9.1.js"></script>
<script src="${ctx }/js/bootstrap/bootstrap-table.js"></script>
<script src="${ctx }/js/bootstrap/bootstrap.min.js"></script>
<script src="${ctx }/js/bootstrap/bootstrap-table-zh-CN.js"></script>
</head>
<body>
	<div style="height: 90px;; line-height: 90px; text-align: center;">
		<span id="starttime" style="font-size: 40px;">${starttime }</span> <span
			style="font-size: 40px;">-</span> <span id="endtime"
			style="font-size: 40px;">${endtime }</span> <span id="docname"
			style="font-size: 40px;">${docname }</span>
		<button style="width: 130px;" onclick="fanhui()">返回</button>
	</div>
	<script type="text/javascript">
	function fanhui(){
		var starttime=$("#starttime").text();
		var endtime=$("#endtime").text();
		var docname=$("#docname").text();
		var json={"starttime":starttime,"endtime":endtime,"name":docname};
		var json1=JSON.stringify(json);
	    var json2=encodeURIComponent(json1);
		var url="<%=request.getContextPath()%>/ZhikongController/zhikong.do?data="+json2;
		window.location.href = url;
	}
	</script>
	<table class="table table-hover table-condensed ">
		<thead>
			<tr>
				<th>手术间</th>
				<th>手术日期</th>
				<th>姓名</th>
				<th>科室</th>
				<th>性别</th>
				<th>年龄</th>
				<th>住院号</th>
				<th>临床诊断</th>
				<th>手术名称</th>
				<th>手术医生</th>
				<th>麻醉方式</th>
				<th>麻醉时间</th>
				<th>麻醉医生</th>
				<th>复苏医生</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="p" items="${patientLink }">
				<tr style="height: 28px;" ondblclick="gotomazuidan('${p.id}')">
					<td>${p.schedule.pbssjh}</td>
					<td>${p.application.yysssjString}</td>
					<td>${p.patient.brxm}</td>
					<td>${p.patient.ksmc}</td>
					<td>${p.patient.xb}</td>
					<td>${p.patient.nl}</td>
					<td>${p.patient.zyh}</td>
					<td>临床诊断</td>
					<td>${p.anesthesiaRecord.ysss1}</td>
					<td>${p.application.ssysxm}</td>
					<td>${p.anesthesiaRecord.mzff}</td>
					<td>${p.status.mazuiStartTimeString}</td>
					<td>${p.schedule.mzysbh1Name}</td>
					<td>${p.pacu.pacuDoctor}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<table>
		<c:forEach var="p" items="${keshi }">
			<tr>
				<td>${p.ksmc }</td>
				<td>${p.num }</td>
			</tr>
		</c:forEach>
	</table>
	<script type="text/javascript">
	function gotomazuidan(id){
		//QualityStatistics.button(id);
		JSZhiKongZhiBiao.NavigateToAnesRecord(id);
	};
	</script>
</body>
</html>