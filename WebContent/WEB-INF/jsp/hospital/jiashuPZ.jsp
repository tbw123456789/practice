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
<title>Insert title here</title>
<base href="<%=basePath%>">
<script src="<%=request.getContextPath()%>/js/jquery/jquery.min.js"></script>
<link href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript">
function stringify(json, space) {
	if (typeof (space) == 'undefined') {
		return JSON.stringify(json);
	} else {
		return JSON.stringify(json, undefined, 2);
	}
}</script>
</head>

<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column"
				style="height: 10%; font-size: 200%; background-color: #F3FAFF">
				<div class="col-md-2 column">
					<span class="glyphicon glyphicon-floppy-save" onclick="save()">保存</span>
				</div>
				<div class="col-md-10 column"></div>
				<script type="text/javascript">
				function save() {
				    obj = document.getElementsByName("jspz");
				    var JiaShu = new Object();
				    check_val = [];
				    for (k in obj) {
				        if (obj[k].checked) {
				            check_val.push(true);
				        } else {
				            check_val.push(false);
				        }
				    }
				    if (check_val[0]) {
				        JiaShu.shoushujian = true;
				    } else {
				        JiaShu.shoushujian = false;
				    }
				    if (check_val[1]) {
				        JiaShu.zhuantai = true;
				    } else {
				        JiaShu.zhuantai = false;
				    }
				    if (check_val[2]) {
				        JiaShu.keshi = true;
				    } else {
				        JiaShu.keshi = false;
				    }
				    if (check_val[3]) {
				        JiaShu.bingren = true;
				    } else {
				        JiaShu.bingren = false;
				    }
				    if (check_val[4]) {
				        JiaShu.shoushumingcheng = true;
				    } else {
				        JiaShu.shoushumingcheng = false;
				    }
				    if (check_val[5]) {
				        JiaShu.zhudaoyisheng = true;
				    } else {
				        JiaShu.zhudaoyisheng = false;
				    }
				    if (check_val[6]) {
				        JiaShu.mazuiyisheng = true;
				    } else {
				        JiaShu.mazuiyisheng = false;
				    }
				    JiaShu.notice = $("#notice").val();
				    var json=stringify(JiaShu);
				    var json1=encodeURIComponent(json);
				    var url = "<%=request.getContextPath()%>/commandController/jiashuUp.do?data=";
					window.location.href = url + json1;
					}
				</script>
			</div>

		</div>
		<div class="row clearfix">
			<div>
				<table class="table table-striped">
					<tbody>
						<tr>
							<td style="height: 40px;"><input type="checkbox" name="jspz"
								class="jspz"
								<c:if test="${jiashu.shoushujian eq true }">checked=true</c:if>>手术间</td>
							<td><input type="checkbox" name="jspz" class="jspz"
								<c:if test="${jiashu.zhuantai eq true }">checked=true</c:if>>状态</td>
							<td><input type="checkbox" name="jspz" class="jspz"
								<c:if test="${jiashu.keshi eq true }">checked=true</c:if>>病室</td>
						</tr>
						<tr>
							<td style="height: 40px;"><input type="checkbox" name="jspz"
								class="jspz"
								<c:if test="${jiashu.bingren eq true }">checked=true</c:if>>病人</td>
							<td><input type="checkbox" name="pbpz" value="xingbie"
								<c:if test="${jiashu.xingbie eq true }">checked=true</c:if>>性别</td>
							<td><input type="checkbox" name="pbpz" value="nianling"
								<c:if test="${jiashu.nianling eq true }">checked=true</c:if>>年龄</td>
							<td><input type="checkbox" name="jspz" class="jspz"
								<c:if test="${jiashu.shoushumingcheng eq true }">checked=true</c:if>>手术名称</td>
							<td><input type="checkbox" name="jspz" class="jspz"
								<c:if test="${jiashu.zhudaoyisheng eq true }">checked=true</c:if>>主刀医生</td>
						</tr>
						<tr>
							<td style="height: 40px;"><input type="checkbox" name="jspz"
								class="jspz"
								<c:if test="${jiashu.mazuiyisheng eq true }">checked=true</c:if>>麻醉医师</td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td style="height: 40px;"></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td style="height: 40px;"></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td colspan="3">公告内容:</td>
						</tr>
						<tr>
							<td colspan="3"><textarea id="notice"
									style="overflow-y: hidden; resize: none; width: 100%; height: 100%;">${jiashu.notice }</textarea></td>
						</tr>
					</tbody>
				</table>


			</div>
		</div>

	</div>
</body>
</html>