<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../../common/common_css.jsp"%>
<script src="<%=request.getContextPath()%>/js/jquery/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery/jquery-1.9.1.js"></script>
<script src="<%=request.getContextPath()%>/js/layer/layer.js"></script>
<script type="text/javascript">

function updata(id,time,data){
	parent.update(id,time,data);
}
</script>
</head>


<body>
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<div class="table-responsive"
					style="margin: 0px -20px 0px -20px; width: 550px">
					<table id="sample-table-1"
						class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<c:forEach items="${mazuiTime }" var="time">
									<th>${time}</th>
								</c:forEach>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${bedsideList}" var="bedsides">
								<tr>
									<td style="width: 150px;">${bedsides[0].name}</td>
									<c:forEach items="${bedsides}" var="bedside">
										<td><input type="text" value="${bedside.intVal}"
											style="width: 40px;"
											onmouseout="updata('${bedside.code}','${bedside.time}',${bedside.intVal})"></td>
									</c:forEach>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>



</body>
</html>