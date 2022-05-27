<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%@ include file="../../common/common_css.jsp"%>
<%@ include file="../../common/common_js.jsp"%>
<title>XXXX</title>


</head>
<body class="no-skin">
	<!-- header -->
	<div class="main-container" id="main-container">
		<div class="clearfix"></div>
		<script type="text/javascript">
			try{ace.settings.check('main-container' , 'fixed')}catch(e){}
		</script>
		<jsp:include page="../../common/left.jsp"></jsp:include>
		<div class="main-content">
			<iframe name="mainFrame" id="mainFrame" frameborder="0"
				scrolling="no"
				src="<%=request.getContextPath() %>/commandController/paibanA.do"
				onload="setIframeHeight(this)" style="width: 100%"></iframe>
		</div>
	</div>

	<script>
	function setIframeHeight(iframe) {
		if (iframe) {
			var iframeWin = iframe.contentWindow
					|| iframe.contentDocument.parentWindow;
			if (iframeWin.document.body) {
				iframe.height = iframeWin.document.documentElement.scrollHeight
						|| iframeWin.document.body.scrollHeight;
			}
		}
	};

	window.onresize=function(){  
		setIframeHeight(document.getElementById('mainFrame'));
	}
	</script>
</body>
</html>