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
<title>${Hospital }</title>
<base href="<%=basePath%>">
<link href="<%=request.getContextPath()%>/assets/css/bootstrap.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/css/bootstrap-table-dapingNT.css"
	rel="stylesheet" />
<script src="<%=request.getContextPath()%>/js/jquery/jquery-1.9.1.js"></script>
<script
	src="<%=request.getContextPath()%>/js/bootstrap/bootstrap-table-daping.js"></script>
<script
	src="<%=request.getContextPath()%>/js/bootstrap/bootstrap-table-daping-zh-CN.js"></script>

<style type="text/css">
th {
	height: 100px;
}
</style>
</head>
<%--<body style="height: 768px; margin: 0; background-color: #ffffff; color: #000000">--%>
<body style="height: 768px; margin: 0; background-color: #3691da; color: #ffffff">
	<div class="container">
		<div style="background-color: #3691da; color: #ffffff; height: 768px; width: 100%;">
		<%--<div style="background-color: #ffffff; color: #000000; height: 768px; width: 100%;">--%>
			<div class="col-md-12 column"
				style="font-size: 60px; width: 100%; margin-top: 30px; margin-bottom: 50px;">
				<span onclick="uppage()">${Hospital }</span> <span
					style="margin-left: 2%" onclick="downpage()">家属公告</span> <span
					id="show" style="float: right;"></span>
			</div>
			<div style="width: 100%; font-size: 25px;">
				<table id="table"></table>
				<script type="text/javascript">
				window.onload = function() {
					 $('#table').bootstrapTable(getData(0)); 
					 changecolor();
					 $("#page").val(0);
				     setInterval(function() {
						var time = new Date();
						// 程序计时的月从0开始取值后+1
						var m = time.getMonth() + 1;
						var t = time.getFullYear() + "-" + m + "-" + time.getDate() + " "
								+ time.getHours() + ":" + time.getMinutes() + ":"
								+ time.getSeconds();
						$("#show").text(t);
					}, 1000);
				    
				    setInterval(function() {
				    	 var i= Number($("#page").val());
						 $('#table').bootstrapTable("load",getData(i+1)); 
						 if($("#count").val()/8 >i+1){
							 $("#page").val(i+1);
						 }else{
							 $("#page").val(0);
						 }		
						 changecolor();
						 }, 15*1000);  
				    setInterval(function() {
				    	  window.location.href="<%=request.getContextPath()%>/commandController/jiashuA.do";			 
						 }, 2*1000*60);  
				}
				</script>
			</div>
			<div class="clearfix"></div>
			<div style="width: 100%; font-size: 41px; margin-top: 30px;">
				<marquee id="pao" behavior=alternate direction=left></marquee>
			</div>
		</div>
		<div hidden=hidden>
			<input id="page" value="${page }"><input id="count" value="">
		</div>
	</div>
</body>
<script type="text/javascript">

function uppage(){
	 var i= Number($("#page").val());
	 $('#table').bootstrapTable("load",getData(i-1)); 
	 if(i<=0){
		 $("#page").val(0);
	 }else{
		 $("#page").val(i-1);
	 }
	 changecolor();
}
function downpage(){
	 var i= Number($("#page").val());
	 $('#table').bootstrapTable("load",getData(i+1)); 
	 if($("#count").val()/8 >i+1){
		 $("#page").val(i+1);
	 }else{
		 $("#page").val(0);
	 }
	 changecolor();
	}

function full() {
	var docElm = document.documentElement;
	//W3C  
	if (docElm.requestFullscreen) {
		docElm.requestFullscreen();
	}
	//FireFox  
	else if (docElm.mozRequestFullScreen) {
		docElm.mozRequestFullScreen();
	}
	//Chrome等  
	else if (docElm.webkitRequestFullScreen) {
		docElm.webkitRequestFullScreen();
	}
	//IE11
	else if (elem.msRequestFullscreen) {
		elem.msRequestFullscreen();
	}
}


function getData(pageNum) {
	var i = pageNum;
    var json={"pageNum":i};
    var json1=JSON.stringify(json);
    var json2=encodeURIComponent(json1);
    var url1 = "<%=request.getContextPath()%>/commandController/jiashuAjax.do?data="+ json2;
		var columnss = new Array();
		var datas = new Array();
		$.ajax({
			type : "GET",
			url : url1,
			dataType : "json",
			async : false,
			success : function(data) {
				$("#pao").text(data.jiashu.notice);
				$("#page").val(data.page);
				$("#count").val(data.count);
                if (data.jiashu.shoushujian) {
                    var ss = {
                        field : 'shoushujian',
                        title : '手术间'
                    };
                    columnss.push(ss);
                }
				if (data.jiashu.bingren) {
					ss = {
						field : 'bingren',
						title : '病人',
						height: '100%'
					};
					columnss.push(ss);
				}
				if (data.jiashu.keshi) {
					ss = {
						field : 'keshi',
						title : '科室'
						
					};
					columnss.push(ss);
				}
				if (data.jiashu.shoushumingcheng) {
					ss = {
						field : 'shoushumingcheng',
						title : '手术名称'
					};
					columnss.push(ss);
				}
				if (data.jiashu.nianling) {
					ss = {
						field : 'nianling',
						title : '年龄'
					};
					columnss.push(ss);
				}
				if (data.jiashu.xingbie) {
					ss = {
						field : 'xingbie',
						title : '性别'
					};
					columnss.push(ss);
				}
				if (data.jiashu.zhuantai) {
					ss = {
						field : 'zhuantai',
						title : '状态'
					};
					columnss.push(ss);
				}
				if (data.jiashu.zhudaoyisheng) {
					ss = {
						field : 'zhudaoyisheng',
						title : '主刀医生'
					};
					columnss.push(ss);
				}
				if (data.jiashu.mazuiyisheng) {
					ss = {
						field : 'mazuiyisheng',
						title : '麻醉医师'
					};
					columnss.push(ss);
				}
				for ( var i in data.data) {
					var da = new Object();
					if (data.jiashu.shoushujian) {
						da.shoushujian = data.data[i].openRoom;
					}
					if (data.jiashu.zhuantai) {
						da.zhuantai = data.data[i].flag;
					}
					if (data.jiashu.mazuiyisheng) {
						da.mazuiyisheng = data.data[i].mazuiDoc1;
					}
					if (data.jiashu.nianling) {
						da.nianling = data.data[i].strAge;
					}
					if (data.jiashu.xingbie) {
						da.xingbie = data.data[i].sex;
					}
					if (data.jiashu.keshi) {
						da.keshi = data.data[i].bingshi;
					}
					if (data.jiashu.bingren) {
						da.bingren = data.data[i].bename;
					}
					if (data.jiashu.shoushumingcheng) {
						da.shoushumingcheng = data.data[i].shoushuName1;
					}
					if (data.jiashu.zhudaoyisheng) {
						da.zhudaoyisheng = data.data[i].operDoctor1;
					}
					if (data.jiashu.mazuiyisheng) {
						da.mazuiyisheng = data.data[i].mazuiDoc1;
					}
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
	
function changecolor(){
	 $("td").each(function(i){
	    	if($(this).text()=="手 术 前"){
	    		this.style.color=["red"]
	    	}
	    });
}
</script>

</html>