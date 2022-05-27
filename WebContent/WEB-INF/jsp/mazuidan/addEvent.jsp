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

							</tr>
						</thead>
						<tbody>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>