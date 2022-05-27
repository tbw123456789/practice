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
<link href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css"
	rel="stylesheet">
<script src="<%=request.getContextPath()%>/js/jquery/jquery.min.js"></script>
<script type="text/javascript">
function stringify(json, space) {
	if (typeof (space) == 'undefined') {
		return JSON.stringify(json);
	} else {
		return JSON.stringify(json, undefined, 2);
	}
}
</script>
</head>

<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column"
				style="height: 10%; font-size: 200%; background-color: #F3FAFF">
				<div class="col-md-2 column">
					<span class="glyphicon glyphicon-floppy-save" onclick="save()">保存</span>
				</div>
				<script type="text/javascript">
				function save(){
				    obj = document.getElementsByName("pbpz");
				    var PaiBanTable=new Object();
				    check_val = [];
				    for(k in obj){
				        if(obj[k].checked){
				            check_val.push(true);
				       	}else{
				       	 check_val.push(false);
				       	}
				    }
				   if(check_val[0]){
					  PaiBanTable.shijian=true;
				   }else{
					  PaiBanTable.shijian=false;
				   }
 				   if(check_val[1]){
 				 	 PaiBanTable.shoushujian=true;
				   }else{
				 	  PaiBanTable.shoushujian=false;
				   } 
 				   if(check_val[2]){
 				 	 PaiBanTable.huangtai=true;
				   }else{
				 	  PaiBanTable.huangtai=false;
				   } 
 				   if(check_val[3]){
 					  PaiBanTable.xingming=true;
				   }else{
					  PaiBanTable.xingming=false;
				  } 
 				  if(check_val[4]){
 					 PaiBanTable.xingbie=true;
				  }else{
					  PaiBanTable.xingbie=false;
				  } 
				  if(check_val[5]){
					  PaiBanTable.nianling=true;
				  }else{
					  PaiBanTable.nianling=false;
				  }
				  if(check_val[6]){
					  PaiBanTable.bingshi=true;
				  }else{
					  PaiBanTable.bingshi=false;
				  } 
				  if(check_val[7]){
					  PaiBanTable.shoushuneirong=true;
				  }else{
					  PaiBanTable.shoushuneirong=false;
				  } 
				  if(check_val[8]){
					  PaiBanTable.shoushuzhe=true;
				  }else{
					  PaiBanTable.shoushuzhe=false;
				  } 
				  if(check_val[9]){
					  PaiBanTable.mazuizhe=true;
				  }else{
					  PaiBanTable.mazuizhe=false;
				  } 
				 /*  if(check_val[10]){
					  PaiBanTable.hushi=true;
				  }else{
					  PaiBanTable.hushi=false;
				  }  */
				  if(check_val[11]){
					  PaiBanTable.mazuifangfa=true;
				  }else{
					  PaiBanTable.mazuifangfa=false;
				  } 
				  PaiBanTable.notice=$("#notice").val();
				    var json=stringify(PaiBanTable);
				    var json1=encodeURIComponent(json);
				    var url="<%=request.getContextPath()%>/commandController/paibanUp.do?data=";
					window.location.href = url + json1;
					}
				</script>
				<div class="col-md-10 column"></div>
			</div>
		</div>
		<div class="row clearfix">
			<div>
				<table class="table table-striped">
					<tbody>
						<tr>
							<td style="height: 40px;"><input type="checkbox" name="pbpz"
								value="shijian"
								<c:if test="${paiban.shijian eq true }">checked=true</c:if>
								class="pbpz">时间</td>
							<td><input type="checkbox" name="pbpz" value="shoushujian"
								<c:if test="${paiban.shoushujian eq true }">checked=true</c:if>
								class="pbpz">手术间</td>
							<td><input type="checkbox" name="pbpz" value="zhuangtai"
								<c:if test="${paiban.huangtai eq true }">checked=true</c:if>
								class="pbpz">状态</td>
						</tr>
						<tr>
							<td style="height: 40px;"><input type="checkbox"
								<c:if test="${paiban.xingming eq true }">checked=true</c:if>
								value="xingming" name="pbpz" class="pbpz">姓名</td>
							<td><input type="checkbox" name="pbpz" value="xingbie"
								<c:if test="${paiban.xingbie eq true }">checked=true</c:if>
								class="pbpz">性别</td>
							<td><input type="checkbox" name="pbpz" value="nianling"
								<c:if test="${paiban.nianling eq true }">checked=true</c:if>
								class="pbpz">年龄</td>
						</tr>
						<tr>
							<td style="height: 40px;"><input type="checkbox"
								value="bingshi" name="pbpz"
								<c:if test="${paiban.bingshi eq true }">checked=true</c:if>
								class="pbpz">病室</td>
							<td><input type="checkbox" name="pbpz"
								value="shoushumingcheng" class="pbpz"
								<c:if test="${paiban.shoushuneirong eq true }">checked=true</c:if>>手术名称</td>
							<td><input type="checkbox" name="pbpz" value="zhudouyisheng"
								class="pbpz"
								<c:if test="${paiban.shoushuzhe eq true }">checked=true</c:if>>主刀医生</td>
						</tr>
						<tr>
							<td style="height: 40px;"><input type="checkbox" name="pbpz"
								value="mazuiyishi"
								<c:if test="${paiban.mazuizhe eq true }">checked=true</c:if>
								class="pbpz">麻醉医师</td>
							<%-- <td><input type="checkbox" name="pbpz" value="hushi" class="pbpz" <c:if test="${paiban.hushi eq true }">checked=true</c:if> >护士</td> --%>
							<%--<td><input type="checkbox" name="pbpz" value="mazuileixing"--%>
								<%--class="pbpz"--%>
								<%--<c:if test="${paiban.mazuifangfa eq true }">checked=true</c:if>>麻醉类型</td>--%>
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
									style="overflow-y: hidden; resize: none; width: 100%; height: 100%;">${paiban.notice }</textarea></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>