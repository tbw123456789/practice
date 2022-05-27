<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${ctx }/js/jquery/jquery.min.js"></script>
<style type="text/css">
.operation {
	width: 18%;
	height: 200px;
	float: left;
	border: 2px solid black;
	margin: 0px 20px 10px 0;
}

.oper {
	margin: 20px;
}

.shuoshujian {
	font-size: 15px;
	color: #22c1ff";
}
</style>
<script type="text/javascript">
	function reloadDate() {
		var url="<%=request.getContextPath()%>/ZhurengongzuozhanController/ZhurengongzuozhanAjax.do";
		$.ajax({
			   type: "GET",
			   url: url,
			   async: false, 
			   success: function(data){
				   $(".operation").remove();  
				   var html="";
				   for(var i=0;i<data.data.length;i++){
					   var bingshi=data.data[i].pbssjh;
					   var shuzhangya=data.data[i].shuzhangya;
					   var shousuoya=data.data[i].shousuoya;
					   var xinglv=data.data[i].xinglv;
					   var xueyang=data.data[i].xueyang;
					   var yishengxingming=data.data[i].docname;
					   var hushixingming=data.data[i].nurname;
					   var pid=data.data[i].pid;
					   html= html+"<div class='operation'  ondblclick='sdf('"+pid+"')'>	<div class='oper'>"+
						"<div class='shuoshujian'>"+bingshi+"号手术间</div><div>无创舒张压:"+shuzhangya+"mmHg</div><div>无创收缩压:"+shousuoya+"mmHg</div>"+
						"<div>心率:"+xinglv+"bpm</div><div>血氧:"+xueyang+"</div><div>医生名字:"+yishengxingming+"</div><div>护士名字:"+hushixingming+"</div></div></div>"
				   }
				   $("body").append(html);
			   },
			   error: function(){
			   		console.log("获取数据错误!!!!!error!");
			   }
			});
	}
	setInterval(function() {
		reloadDate();
	}, 60 * 1000);
	
	function sdf(dd){
		//getMZD.button(dd);
		JSWorkStation.NavigateToAnesRecordOnWorkStation(dd);
	}
</script>
</head>
<body>
	<c:forEach var="op" items="${operations }">
		<div class="operation" ondblclick="sdf('${op.pid}')">
			<div class="oper">
				<div class="shuoshujian">${op.pbssjh }号手术间</div>
				<div>无创舒张压:${op.shuzhangya }mmHg</div>
				<div>无创收缩压:${op.shousuoya }mmHg</div>
				<div>心率:${op.xinglv }bpm</div>
				<div>血氧:${op.xueyang }</div>
				<div>医生名字:${op.docname }</div>
				<div>护士名字:${op.nurname }</div>
			</div>
		</div>
	</c:forEach>
</body>
</html>