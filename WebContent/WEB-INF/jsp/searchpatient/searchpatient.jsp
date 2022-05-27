<%--
  Created by IntelliJ IDEA.
  User: pxq
  Date: 2020/3/16
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>病人查询</title>
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
</head>
<body>
<div style="height: 50px;; line-height: 50px; text-align: center;">
     <%--<button style="width: 130px;" onclick="fanhui()">返回</button>--%>
 <label class="form-inline">病人姓名:
    <input id="brxm" name="brxm"  type="text"/></label>
    <button style="width: 130px;" onclick="searchBrxm()">查询</button>
    </span>

</div>
<table class="table table-hover table-condensed table-bordered ">
    <thead>
    <tr>
        <th>手术间</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>科室</th>
        <th>住院号</th>
        <th>术前诊断</th>
        <th>手术名称</th>
        <th>手术医生</th>
        <th>手术申请日期</th>
        <th>状态</th>
        <th>操作</th>

    </tr>
    </thead>
    <tbody>

    <c:forEach var="p" items="${patientLinks }">
        <tr style="height: 28px;" ondblclick="gotomazuidan('${p.id}')">
            <td>${p.schedule.pbssjh}</td>
            <td>${p.patient.brxm}</td>
            <td>${p.patient.xb}</td>
            <td>${p.patient.nl}</td>
            <td>${p.patient.ksmc}</td>
            <td>${p.patient.zyh}</td>
            <td>${p.application.sqzd1}</td>
            <td>${p.application.nsssmc}</td>
            <td>${p.application.ssysxm}</td>
            <td>${p.application.sssqsj}</td>
            <td>${p.application.detailstatus}</td>
            <td onclick="chexiao('${p.id}')">撤销</td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
<script src="${ctx }/js/layer/layer.js"></script>
<script
        src="${ctx }/js/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>
<script
        src="${ctx }/js/bootstrap-datetimepicker/bootstrap-datetimepicker.fr.js"></script>
<script type="text/javascript">
    function searchBrxm() {
        var  brxmt=$("#brxm").val();
        if(brxmt==""){
            alert("病人姓名不能为空");
            return;
        }
        var url="<%=request.getContextPath()%>/SearchNameController/search.do?brxm="+brxmt;
        window.location.href = url;
        /*$.ajax({
            type : "post",

            data : {
                "brxm" : brxmt,
            },
            dataType:"json",
            async : false,
            success : function(result) {
                alert("传过来集合的大小"+result);
                if(result.success()){
                    alert("传过来集合的大小"+result);
                }
            }
        })*/
    }
</script>
</html>
