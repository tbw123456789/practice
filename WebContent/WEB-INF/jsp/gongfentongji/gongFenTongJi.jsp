<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
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
    <script src="${ctx }/js/bootstrap/bootstrap-table-export.js"></script>
    <script src="${ctx }/js/bootstrap_above/tableExport/tableExport.js"></script>
    <script src="${ctx }/js/highcharts/highcharts.js"></script>
    <script src="${ctx }/js/highcharts/exporting.js"></script>
    <script src="${ctx }/layui/layer.all.js"></script>
    <script src="${ctx }/js/highcharts/series-label.js"></script>
    <script src="${ctx }/js/highcharts/highcharts-zh_CN.js"></script>
    <script src="${ctx }/js/highcharts/oldie.js"></script>



    <%--<script src="js/bootstrap_above/tableExport/libs/pdfmake/pdfmake.min.js"></script>--%>
    <%--<script src="js/bootstrap_above/tableExport/libs/pdfmake/vfs_fonts.js"></script>--%>
    <%--<script type="text/javascript" src="js/bootstrap_above/tableExport/libs/FileSaver/FileSaver.min.js"></script>--%>
    <%--<script type="text/javascript" src="js/bootstrap_above/tableExport/libs/jsPDF/jspdf.min.js"></script>--%>
    <%--<script type="text/javascript" src="js/bootstrap_above/tableExport/libs/jsPDF-AutoTable/jspdf.plugin.autotable.js"></script>--%>
    <%--<script type="text/javascript" src="js/bootstrap_above/tableExport/tableExport.js"></script>--%>

</head>
<body style="height: 768px; margin: 0;">
    <table id="tableValue" class="table table-bordered" >
    </table>
</body>
<script type="text/javascript">
    test();
    function test(){
        $.ajax({
            type : "GET",
            url:"<%=request.getContextPath()%>/gongFenTongjiController/gongFenTongJiName.do",
            dataType : "JSON",
            success : function(result) {
                // console.info("进来了");
                // console.info(result);
                var data = [];
                var item = {field:'date',title:'日期',align : 'center'};
                data.push(item);
                var item = {field:'zongfen',title:'总分',align : 'center'};
                data.push(item);
                for (var i = 0 ; i < result.length ; i++ ){
                    var value = result[i];
                    var item = {field:value["code"],title:value["name"],align : 'center'};
                    data.push(item);
                }
                var item = {field:'ycdmccjjc',title:'有创动脉穿刺及监测',align : 'center'};
                data.push(item);
                var item = {field:'zxjmccjjc',title:'中心静脉穿刺及监测',align : 'center'};
                data.push(item);
                var item = {field:'mzsdjc',title:'麻醉深度监测',align : 'center'};
                data.push(item);
                var item = {field:'xljc',title:'血凝监测',align : 'center'};
                data.push(item);
                var item = {field:'szcs',title:'术中超声',align : 'center'};
                data.push(item);
                var item = {field:'szxqfx',title:'术中血气分析',align : 'center'};
                data.push(item);
                var item = {field:'fsxqfx',title:'复苏血气分析',align : 'center'};
                data.push(item);
                var item = {field:'shzt',title:'术后镇痛',align : 'center'};
                data.push(item);
                var item = {field:'qsmzjcxs',title:'手术间麻醉监测分',align : 'center'};
                data.push(item);
                var item = {field:'fsysjcf',title:'复苏间麻醉监测分',align : 'center'};
                data.push(item);
                console.info(data);
                $('#tableValue').bootstrapTable('destroy');
                $('#tableValue').bootstrapTable(
                    {
                        url : '<%=request.getContextPath()%>/gongFenTongjiController/index.do', //请求后台的URL（*）
                        method : 'post', //请求方式（*）
                        contentType: "application/x-www-form-urlencoded",
                        cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                        pagination : false, //是否显示分页（*）
                        sortable : true, //是否启用排序
                        sortOrder : "desc", //排序方式
                        // queryParams : function (params) {
                        //     //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                        //     var temp = {
                        //         startDate : startDate,
                        //         endDate : endDate,
                        //         rows: params.limit,   //页面大小
                        //         page: params.offset   //页码
                        //     };
                        //     return temp;
                        // },
                        sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*）
                        pageNumber : 1, //初始化加载第一页，默认第一页
                        pageSize : 10, //每页的记录行数（*）
                        pageList : [ 10, 25, 50, 100 ], //可供选择的每页的行数（*）
                        showExport : true, //是否显示导出
                        uniqueId : "id", //每一行的唯一标识，一般为主键列
                        exportDataType: 'all',
                        exportTypes:['excel'],  //导出文件类型
                        columns: data,
                        paginationDetailHAlign:"right",
                        buttonsAlign:"right",  //按钮位置
                        dataType:'json',
                        striped: true,                              //是否显示行间隔色
                        showColumns:true,
                        minimumCountColumns:2,

                    });
            },
            error : function () {
                alert("请检查网络");
            }
        });
    }
    <%--getDate();--%>
    <%--function getDate( ){--%>
    <%--console.info("你好");--%>
    <%--$.ajax({--%>
    <%--type : "POST",--%>
    <%--url : "${ctx}/gongFenTongjiController/gongFenTongJiName.do",--%>
    <%--data : "",--%>
    <%--success : function (result) {--%>
    <%--console.info("nihao ");--%>
    <%--console.info(result);--%>
    <%--var data = [];--%>
    <%--// for (var i = 0 ; i < result.length ; i++ ){--%>
    <%--//     var value = result[i];--%>
    <%--//     var item = {field:value["id"],title:value["name"],align : 'center'};--%>
    <%--//     data.push(item);--%>
    <%--// }--%>
    <%--var item = {field:'anesthesia_doctor',title:'姓名',align : 'center'};--%>
    <%--data.push(item);--%>
    <%--var item = {field:'operation_room',title:'手术间',align : 'center'};--%>
    <%--data.push(item);--%>

    <%--// $('#item_table').bootstrapTable('destroy');--%>
    <%--&lt;%&ndash;$('#item_table').bootstrapTable(&ndash;%&gt;--%>
    <%--&lt;%&ndash;{&ndash;%&gt;--%>
    <%--&lt;%&ndash;url : '${ctx}/drugAndEquipment/getCount.shtml', //请求后台的URL（*）&ndash;%&gt;--%>
    <%--&lt;%&ndash;method : 'post', //请求方式（*）&ndash;%&gt;--%>
    <%--&lt;%&ndash;contentType: "application/x-www-form-urlencoded",&ndash;%&gt;--%>
    <%--&lt;%&ndash;cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）&ndash;%&gt;--%>
    <%--&lt;%&ndash;pagination : true, //是否显示分页（*）&ndash;%&gt;--%>
    <%--&lt;%&ndash;sortable : true, //是否启用排序&ndash;%&gt;--%>
    <%--&lt;%&ndash;sortOrder : "desc", //排序方式&ndash;%&gt;--%>
    <%--&lt;%&ndash;queryParams : function (params) {&ndash;%&gt;--%>
    <%--&lt;%&ndash;//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的&ndash;%&gt;--%>
    <%--&lt;%&ndash;var temp = {&ndash;%&gt;--%>
    <%--&lt;%&ndash;startDate : startDate,&ndash;%&gt;--%>
    <%--&lt;%&ndash;endDate : endDate,&ndash;%&gt;--%>
    <%--&lt;%&ndash;rows: params.limit,   //页面大小&ndash;%&gt;--%>
    <%--&lt;%&ndash;page: params.offset   //页码&ndash;%&gt;--%>
    <%--&lt;%&ndash;};&ndash;%&gt;--%>
    <%--&lt;%&ndash;return temp;&ndash;%&gt;--%>
    <%--&lt;%&ndash;},&ndash;%&gt;--%>
    <%--&lt;%&ndash;sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*）&ndash;%&gt;--%>
    <%--&lt;%&ndash;pageNumber : 1, //初始化加载第一页，默认第一页&ndash;%&gt;--%>
    <%--&lt;%&ndash;pageSize : 10, //每页的记录行数（*）&ndash;%&gt;--%>
    <%--&lt;%&ndash;pageList : [ 10, 25, 50, 100 ], //可供选择的每页的行数（*）&ndash;%&gt;--%>
    <%--&lt;%&ndash;showExport : true, //是否显示导出&ndash;%&gt;--%>
    <%--&lt;%&ndash;uniqueId : "id", //每一行的唯一标识，一般为主键列&ndash;%&gt;--%>
    <%--&lt;%&ndash;exportDataType: 'all',&ndash;%&gt;--%>
    <%--&lt;%&ndash;exportTypes:[ 'excel'],  //导出文件类型&ndash;%&gt;--%>
    <%--&lt;%&ndash;columns: data,&ndash;%&gt;--%>
    <%--&lt;%&ndash;paginationDetailHAlign:"right",&ndash;%&gt;--%>
    <%--&lt;%&ndash;buttonsAlign:"right",  //按钮位置&ndash;%&gt;--%>
    <%--&lt;%&ndash;dataType:'json',&ndash;%&gt;--%>
    <%--&lt;%&ndash;striped: true,                              //是否显示行间隔色&ndash;%&gt;--%>
    <%--&lt;%&ndash;showColumns:true,&ndash;%&gt;--%>
    <%--&lt;%&ndash;minimumCountColumns:2,&ndash;%&gt;--%>

    <%--&lt;%&ndash;});&ndash;%&gt;--%>
    <%--}--%>
    <%--})--%>
    <%--}--%>
</script>

</html>