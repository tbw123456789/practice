<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>术前访视</title>
    <base href="<%=basePath%>">
    <link href="${ctx }/css/form/print.css" type="text/css" rel="stylesheet">
    <link href="${ctx }/css/form/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx }/css/form/font-awesome.min.css" rel="stylesheet">
    <link href="${ctx }/css/form/materialdesignicons.min.css" rel="stylesheet">
    <link href="${ctx }/css/form/material-design-iconic-font.min.css" rel="stylesheet">
    <link href="${ctx }/css/form/typicons.min.css" rel="stylesheet">
    <link href="${ctx }/css/form/ionicons.min.css" rel="stylesheet">
    <link href="${ctx }/css/form/htmleaf-demo.css" rel="stylesheet">
    <link href="${ctx }/css/form/pretty.min.css" rel="stylesheet">
    <link href="${ctx }/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx }/css/bootstrap-table.css" rel="stylesheet"/>
    <link href="${ctx }/css/bootstrap-datetimepicker.min.css"
          rel="stylesheet"/>

    <!--图标样式-->
    <link href="${ctx }/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx }/css/bootstrap-datetimepicker.min.css" rel="stylesheet">

    <script src="${ctx }/js/jquery/jquery.min.js"></script>
    <script src="${ctx }/js/jquery/jquery.datetimepicker.js"></script>
    <script src="${ctx }/js/bootstrap-datetimepicker/moment-with-locales.min.js"></script>
    <script src="${ctx }/js/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>

    <link href="${ctx }/css/toast.style.css" rel="stylesheet">
    <script src="${ctx }/js/jquery/toast/toast.script.js"></script>

    <script src="${ctx }/js/bootstrap/bootstrap-table.js"></script>
    <script src="${ctx }/js/bootstrap/bootstrap.min.js"></script>
    <script src="${ctx }/js/bootstrap/bootstrap-table-zh-CN.js"></script>
    <script src="${ctx }/js/highcharts/highcharts.js"></script>
    <script src="${ctx }/js/highcharts/exporting.js"></script>
    <script src="${ctx }/js/highcharts/series-label.js"></script>
    <script src="${ctx }/js/highcharts/highcharts-zh_CN.js"></script>
    <script src="${ctx }/js/highcharts/oldie.js"></script>
</head>
<body >
<div class="a4_AfterOperation" >
    <table class="printtitle">
        <tr>
            <td class="title" colspan="10">
                <span style="padding-bottom:10px">贺州广济医院</span><br />
                <span style="font-size: 20px;">麻醉术前访视记录单</span>
            </td>
        </tr>
    </table>
    <div class="printbody body" >
        <div class="form-inline print_div">
            <label class="lab"  >住院号:</label>
            <label class="lab"  id="zyh" style="width: 80px; text-align: center"  value="${patientLink.patient.zyh}" class="hrlabel" >
                ${patientLink.patient.zyh}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
            <label class="lab"  >床位:</label>
            <label class="lab"  id="zych" class="hrlabel" style="width: 50px; text-align: center">
                ${patientLink.patient.zych}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
            <label class="lab"  >姓名:</label>
            <label class="lab"  id="brxm" class="hrlabel" style="width: 150px; text-align: center" >
                ${patientLink.patient.brxm}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
            <label class="lab"  >性别:</label>
            <label class="lab"  id="xb" class="hrlabel" style="width: 50px; text-align: center" >
                ${patientLink.patient.xb}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
            <label class="lab"  >年龄:</label>
            <label class="lab"  id="nl" class="hrlabel" style="width: 50px; text-align: center" >
                ${patientLink.patient.nl}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
            <label class="lab"  >体重:</label>
            <label class="lab"  id="tz" class="hrlabel" style="width: 50px; text-align: center" >
                ${patientLink.patient.tz}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
            <label class="lab"  >kg</label>
            <label class="lab"  >身高:</label>
            <label class="lab"  id="sg" class="hrlabel" style="width: 50px; text-align: center" >
                ${patientLink.patient.sg}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
            <label class="lab"  >cm</label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >简要病史:</label>
            <label class="lab"  id="jybs" class="hrlabel" style="width: 680px; " >
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.jybs}
                <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
        </div>
        <div class="form-inline print_div">
            <label class="lab"   >并存疾病:高血压:</label>
            <input type="checkbox"  value="是" id="gxy_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.gxy_y eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >是</label>
            <input type="checkbox"  value="否" id="gxy_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.gxy_n eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" style="width: 20px; " >否</label>
            <label class="lab" >冠心病:</label>
            <input type="checkbox"  value="是" id="gxb_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.gxb_y eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >是</label>
            <input type="checkbox"  value="否" id="gxb_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.gxb_n eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" style="width: 20px; ">否</label>
            <label class="lab" >糖尿病:</label>
            <input type="checkbox"  value="是" id="tnb_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.tnb_y eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >是</label>
            <input type="checkbox"  value="否" id="tnb_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.tnb_n eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" style="width: 20px; ">否</label>
            <label class="lab" >哮喘:</label>
            <input type="checkbox"  value="是" id="xc_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.xc_y eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >是</label>
            <input type="checkbox"  value="否" id="xc_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.xc_n eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" style="width: 20px; ">否</label>
            <label class="lab" >慢性阻塞性肺炎:</label>
            <input type="checkbox"  value="是" id="mxfy_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.mxzsxfy_y eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >是</label>
            <input type="checkbox"  value="否" id="mxfy_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.mxzsxfy_n eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >否</label>
        </div>
        <div class="form-inline print_div">
            <label class="lab"  style="width: 55px;"></label>
            <label class="lab" >脑栓塞:</label>
            <input type="checkbox"  value="是" id="nsh_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.nxs_y eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >是</label>
            <input type="checkbox"  value="否" id="nsh_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.nxs_n eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" style="width: 20px; ">否</label>
            <label class="lab" >脑出血:</label>
            <input type="checkbox"  value="是" id="ncx_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.ncx_y eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >是</label>
            <input type="checkbox"  value="否" id="ncx_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.ncx_n eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" style="width: 20px; ">否</label>
            <label class="lab" >癫痫:</label>
            <input type="checkbox"  value="是" id="dx_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.dx_y eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >是</label>
            <input type="checkbox"  value="否" id="dx_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.dx_n eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" style="width: 20px; ">否</label>
            <label class="lab" >药物过敏史:</label>
            <input type="checkbox"  value="是" id="ywgms_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.ywgms_y eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >是</label>
            <input type="checkbox"  value="否" id="ywgms_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.ywgms_n eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >否</label>
            <label class="lab"  id="ywsText" class="hrlabel" style="width: 180px; " >
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.ywsText}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
        </div>
        <div class="form-inline print_div">
            <label class="lab"  style="width: 55px;"></label>
            <label class="lab" >药物成瘾:</label>
            <input type="checkbox"  value="是" id="ywcy_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.ywcy_y eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >是</label>
            <input type="checkbox"  value="否" id="ywcy_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.ywcy_n eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" style="width: 20px; ">否</label>
            <label class="lab" >其他</label>
            <label class="lab"  id="jbsqt" class="hrlabel" style="width: 180px; " >
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.jbsqt}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
            <label class="lab" >既往麻醉史:</label>
            <input type="checkbox"  value="是" id="mzs_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.mzs_y eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >是</label>
            <input type="checkbox"  value="否" id="mzs_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.mzs_n eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >否</label>
            <label class="lab"  id="mzsText" class="hrlabel" style="width: 180px; " >
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.mzsText}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
        </div>
        <div class="form-inline print_div">
            <label class="lab"  style="width: 55px;"></label>
            <label class="lab" >既往手术史:</label>
            <input type="checkbox"  value="是" id="sss_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.sss_y eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >是</label>
            <input type="checkbox"  value="否" id="sss_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.sss_n eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >否</label>
            <label class="lab"  id="sssText" class="hrlabel" style="width: 180px; " >
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.sssText}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
            <label class="lab" >特殊用药史:</label>
            <input type="checkbox"  value="是" id="yys_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.yys_y eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >是</label>
            <input type="checkbox"  value="否" id="yys_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.yys_n eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >否</label>
            <label class="lab"  id="yysText" class="hrlabel" style="width: 180px; " >
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.yysText}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
        </div>
        <div class="form-inline print_div">
            <div style="text-align: center;">
                <label class="lab" >一般情况检查</label>
            </div>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >BP:</label>
            <label class="lab"  id="bp1" class="hrlabel" style="width: 50px;text-align: center ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.bp1}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
            <label class="lab" >/</label>
            <label class="lab"  id="bp2" class="hrlabel" style="width: 50px;text-align: center ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.bp2}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
            <label class="lab" >mmHg</label>
            <label class="lab" >P:</label>
            <label class="lab"  id="mp" class="hrlabel" style="width: 50px;text-align: center ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.mb}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
            <label class="lab" >次/分</label>
            <label class="lab" >R:</label>
            <label class="lab"  id="hx" class="hrlabel" style="width: 50px;text-align: center ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.hx}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
            <label class="lab" >次/分</label>
            <label class="lab" >T:</label>
            <label class="lab"  id="twt" class="hrlabel" style="width: 50px;text-align: center ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.twt}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
            <label class="lab" style="width: 20px; ">℃</label>
            <label class="lab" >神志:</label>
            <input type="checkbox"  value="清醒" id="szqx" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.szqx eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >清醒</label>
            <input type="checkbox"  value="模糊" id="szmh" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.szhs eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >模糊</label>
            <input type="checkbox"  value="昏迷" id="szhm" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.szhm eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >昏迷</label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >呼吸困难:</label>
            <input type="checkbox"  value="有" id="hxkn_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.hxkn_y eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >有</label>
            <label class="lab" >/</label>
            <input type="checkbox"  value="无" id="hxkn_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.hxkn_n eq 'true'}"> checked="checked"</c:if>>
            <label class="lab"  style="width: 50px; ">无</label>
            <label class="lab" >紫绀:</label>
            <input type="checkbox"  value="有" id="zg_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.zg_y eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >有</label>
            <label class="lab" >/</label>
            <input type="checkbox"  value="无" id="zg_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.zg_n eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >无</label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >开口度:</label>
            <input type="checkbox"  value="正常" id="kkd_zc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.kkd_zc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >正常</label>
            <label class="lab" >/</label>
            <input type="checkbox"  value="异常" id="kkd_yc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.kkd_yc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab"  style="width: 50px; ">异常</label>
            <label class="lab" >牙齿松动、假牙:</label>
            <input type="checkbox"  value="有" id="jyy" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.jyy eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >有</label>
            <label class="lab" >/</label>
            <input type="checkbox"  value="无" id="jyw" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.jyw eq 'true'}"> checked="checked"</c:if>>
            <label class="lab"  style="width: 50px; ">无</label>
            <label class="lab" >头颈活动度:</label>
            <input type="checkbox"  value="正常" id="tjhdzc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.tjhdzc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >正常</label>
            <label class="lab" >/</label>
            <input type="checkbox"  value="异常" id="tjhdsx" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.tjhdsx eq 'true'}"> checked="checked"</c:if>>
            <label class="lab"  style="width: 50px; "> 异常</label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >甲颏间距:</label>
            <label class="lab"  id="jhjj" class="hrlabel" style="width: 50px; text-align: center">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.jhjj}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
            <label class="lab" style="width: 50px; ">cm</label>
            <label class="lab" >马氏气道分级:</label>
            <label class="lab"  id="fj" class="hrlabel" class="hrlabel" style="width: 50px; text-align: center">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.fj}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
            <label class="lab" style="width: 50px; ">级</label>
            <label class="lab" >困难气道:</label>
            <input type="checkbox"  value="有" id="qdwkn" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.qdwkn eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >有</label>
            <label class="lab" >/</label>
            <input type="checkbox"  value="无" id="cgkn" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.cgkn eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >无</label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >心脏检查:</label>
            <input type="checkbox"  value="正常" id="xzzc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.xzzc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >正常</label>
            <label class="lab" >/</label>
            <input type="checkbox"  value="异常" id="xzyc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.xzyc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >异常</label>
            <label class="lab"  id="xzjc" class="hrlabel" class="hrlabel" style="width: 450px; ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.xzjc}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >肺部检查:</label>
            <input type="checkbox"  value="正常" id="fbzc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.fbzc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >正常</label>
            <label class="lab" >/</label>
            <input type="checkbox"  value="异常" id="fbyc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.fbyc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >异常</label>
            <label class="lab"  id="fbjc" class="hrlabel" class="hrlabel" style="width: 450px; ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.fbjc}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >脊椎畸形:</label>
            <input type="checkbox"  value="有" id="jzjx" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.jzjx eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >有</label>
            <label class="lab" >/</label>
            <input type="checkbox"  value="无" id="jzjxyw" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.jzjxyw eq 'true'}"> checked="checked"</c:if>>
            <label class="lab"  style="width: 50px; ">无</label>
            <label class="lab" >椎间隙:</label>
            <input type="checkbox"  value="是" id="zhjx_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.zhjx_y eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >是</label>
            <label class="lab" >/</label>
            <input type="checkbox"  value="否清楚" id="zhjx_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.zhjx_n eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" style="width: 50px; ">否清楚</label>
            <label class="lab" >穿刺点局部红、肿、压痛:</label>
            <input type="checkbox"  value="有" id="ccd_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.ccd_y eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >有</label>
            <label class="lab" >/</label>
            <input type="checkbox"  value="无" id="ccd_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.ccd_n eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >无</label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >双下肢运动/感觉:</label>
            <input type="checkbox"  value="正常" id="ztzc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.ztzc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >正常</label>
            <label class="lab" >/</label>
            <input type="checkbox"  value="异常" id="ztyc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.ztyc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >异常</label>
            <label class="lab"  id="zttext" class="hrlabel" style="width: 500px; ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.zttext}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >其他:</label>
            <label class="lab"  id="sxzqt" class="hrlabel" style="width: 700px; ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.sxzqt}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
        </div>
        <div class="form-inline print_div">
            <div>
                <label class="lab" style="width: 1000px;text-align: center ">与麻醉相关的辅助检查结果</label>
            </div>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >血常规:</label>
            <input type="checkbox"  value="正常" id="xcgzc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.xcgzc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >正常</label>
            <label class="lab" >/</label>
            <input type="checkbox"  value="异常" id="xcgyc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.xcgyc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >异常</label>
            <label class="lab"  id="xcgtext" class="hrlabel" style="width: 450px; ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.xcgtext}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >尿常规:</label>
            <input type="checkbox"  value="正常" id="ncgzc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.ncgzc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >正常</label>
            <label class="lab" >/</label>
            <input type="checkbox"  value="异常" id="ncgyc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.ncgyc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >异常</label>
            <label class="lab"  id="xcg" class="hrlabel" style="width: 450px; ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.xcg}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >心脏：胸片:</label>
            <input type="checkbox"  value="正常" id="xpzc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.xpzc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >正常</label>
            <label class="lab" >/</label>
            <input type="checkbox"  value="异常" id="xpyc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.xpyc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >异常</label>
            <label class="lab"  id="xpText" class="hrlabel" style="width: 450px; ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.xpText}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >超声心动图:</label>
            <input type="checkbox"  value="正常" id="csdtzc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.csdtzc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >正常</label>
            <label class="lab" >/</label>
            <input type="checkbox"  value="异常" id="csdtyc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.csdtyc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >异常</label>
            <label class="lab"  id="chsxdt" class="hrlabel" style="width: 450px; ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.chsxdt}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >ECG:</label>
            <input type="checkbox"  value="正常" id="ecgzc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.ecgzc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >正常</label>
            <label class="lab" >/</label>
            <input type="checkbox"  value="异常" id="ecgyc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.ecgyc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >异常</label>
            <label class="lab"  id="ecg" class="hrlabel" style="width: 450px; ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.ecg}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >肺脏：胸片:</label>
            <input type="checkbox"  value="正常" id="gzxpzc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.gzxpzc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >正常</label>
            <label class="lab" >/</label>
            <input type="checkbox"  value="异常" id="gzxpyc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.gzxpyc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >异常</label>
            <label class="lab"  id="gzxpText" class="hrlabel" style="width: 200px; ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.gzxpText}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
            <label class="lab" >肺功能:</label>
            <input type="checkbox"  value="正常" id="fgnzc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.fgnzc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >正常</label>
            <label class="lab" >/</label>
            <input type="checkbox"  value="异常" id="fgnyc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.fgnyc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >异常</label>
            <label class="lab"  id="fgntext" class="hrlabel" style="width: 200px; ">
                <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.fgntext eq 'true'}"> checked="checked"</c:if>
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >血气分析:</label>
            <input type="checkbox"  value="正常" id="xqfxzc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.xqfxzc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >正常</label>
            <label class="lab" >/</label>
            <input type="checkbox"  value="异常" id="xqfxyc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.xqfxyc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >异常</label>
            <label class="lab"  id="xueqifx" class="hrlabel" style="width: 450px; ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.xueqifx}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >肝脏：肝功能:</label>
            <input type="checkbox"  value="正常" id="ggnzc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.ggnzc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >正常</label>
            <label class="lab" >/</label>
            <input type="checkbox"  value="异常" id="ggnyc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.ggnyc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >异常</label>
            <label class="lab"  id="ggn" class="hrlabel" style="width: 450px; ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.ggn}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >肾脏：肾功能:</label>
            <input type="checkbox"  value="正常" id="sgnzc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.sgnzc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >正常</label>
            <label class="lab" >/</label>
            <input type="checkbox"  value="异常" id="sgnyc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.sgnyc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >异常</label>
            <label class="lab"  id="sgntext" class="hrlabel" style="width: 450px; ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.sgntext}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >凝血功能:</label>
            <input type="checkbox"  value="正常" id="nxgnzc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.nxgnzc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >正常</label>
            <label class="lab" >/</label>
            <input type="checkbox"  value="异常" id="nxgnyc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.nxgnyc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >异常</label>
            <label class="lab"  id="nxgn" class="hrlabel" style="width: 200px; ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.nxgn}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
            <label class="lab" >电解质:</label>
            <input type="checkbox"  value="正常" id="djzzc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.djzzc eq 'true'}"> checked="checked"</c:if> >
            <label class="lab" >正常</label>
            <label class="lab" >/</label>
            <input type="checkbox"  value="异常" id="djzyc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.djzyc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >异常</label>
            <label class="lab"  id="djz" class="hrlabel " style="width: 200px; ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.djz}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >其他:</label>
            <label class="lab"  id="qt" class="hrlabel" style="width: 600px; ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.qt}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >术前诊断:</label>
            <label class="lab"  id="sqzd" class="hrlabel" style="width: 650px; ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.sqzd}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >拟行手术:</label>
            <label class="lab"  id="nsss1" class="hrlabel" style="width: 650px; ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.nsss1}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
        </div>
        <div class="form-inline print_div">
            <div>
                <label class="lab" >麻醉风险评估结论:</label>
            </div>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >1.心功能:</label>
            <input type="checkbox"  value="1" id="xgn1" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.xgn1 eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >1</label>
            <input type="checkbox"  value="2" id="xgn2" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.xgn2 eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >2</label>
            <input type="checkbox"  value="3" id="xgn3" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.xgn3 eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >3</label>
            <input type="checkbox"  value="4" id="xgn4" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.xgn4 eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >4</label>
            <label class="lab" style="width: 150px; ">级</label>
            <label class="lab" >ASA:</label>
            <input type="checkbox"  value="I" id="asa1" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.asa1 eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >I</label>
            <input type="checkbox"  value="II" id="asa2" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.asa2 eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >II</label>
            <input type="checkbox"  value="III" id="asa3" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.asa3 eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >III</label>
            <input type="checkbox"  value="IV" id="asa4" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.asa4 eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >IV</label>
            <input type="checkbox"  value="V" id="asa5" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.asa5 eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >V</label>
            <input type="checkbox"  value="VI" id="asa6" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.asa6 eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >VI</label>
            <input type="checkbox"  value="E" id="asae" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.asae eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >E</label>
        </div>
        <div class="form-inline print_div">
            <div>
                <label class="lab" >2.手术麻醉风险类别:</label>
            </div>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >一类</label>
            <input type="checkbox"  value="：风险较小；" id="fx1" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.fx1 eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >:风险较小;</label>
            <label class="lab" >二类</label>
            <input type="checkbox"  value="：有一定的风险；" id="fx2" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.fx2 eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >:有一定的风险;</label>
            <label class="lab" >三类</label>
            <input type="checkbox"  value="：风险较大" id="fx3" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.fx3 eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >:风险较大</label>
            <label class="lab" >四类</label>
            <input type="checkbox"  value="：风险很大；" id="fx4" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.fx4 eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >:风险很大;</label>
            <label class="lab" >五类</label>
            <input type="checkbox"  value="：病情危重、濒临死亡、异常危险" id="fx5" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.fx5 eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >:病情危重、濒临死亡、异常危险</label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >3.根据病人情况，</label>
            <input type="checkbox"  value="有" id="qk_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.qk_y eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >有</label>
            <label class="lab" >/</label>
            <input type="checkbox"  value="无" id="qk_w" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.qk_w eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" style="width: 50px; ">无</label>
            <label class="lab" >麻醉适应症，可否按期进行手术麻醉：</label>
            <input type="checkbox"  value="按期" id="aq" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.aq eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >按期</label>
            <input type="checkbox"  value="延期" id="yq" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.yq eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >延期</label>
            <input type="checkbox"  value="麻醉" id="mz" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.mz eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >麻醉</label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >4.延期手术麻醉原因:</label>
            <label class="lab"  id="yqyy" class="hrlabel" style="width: 600px; ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.yqyy}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >5.术前麻醉医嘱:</label>
            <label class="lab"  id="mzyz" class="hrlabel" style="width: 600px; ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.mzyz}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>

        </div>
        <div class="form-inline print_div">
            <label class="lab" >6.麻醉科麻醉前会诊/讨论意见:</label>
            <label class="lab"  id="tlyj" class="hrlabel" style="width: 550px; ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.tlyj}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >拟施行麻醉方式:</label>
            <input type="checkbox"  value="全麻" id="qm" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.qm eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >全麻</label>
            <input type="checkbox"  value="气管插管" id="qm_qg" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.qm_qg eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >气管插管</label>
            <input type="checkbox"  value="硬膜外" id="ymw" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.ymw eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >硬膜外</label>
            <input type="checkbox"  value="腰硬联合麻醉" id="yylhmz" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.yylhmz eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >腰硬联合麻醉</label>
            <label class="lab" >（穿刺点:</label>
            <label class="lab"  id="ccd" class="hrlabel" style="width: 40px; ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.ccd}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
            <label class="lab" >）</label>
            <input type="checkbox"  value="颈丛" id="jc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.jc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >颈丛</label>
            <input type="checkbox"  value="臂丛" id="bc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.bc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >臂丛</label>
            <input type="checkbox"  value="神经阻滞" id="sjzz" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.sjzz eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >神经阻滞</label>
            <input type="checkbox"  value="监护麻醉" id="jbmz" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.jbmz eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >监护麻醉</label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >拟选用麻醉药:</label>
            <input type="checkbox"  value="丙泊酚" id="bbf" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.bbf eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >丙泊酚</label>
            <input type="checkbox"  value="依托咪酯" id="ytmz" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.ytmz eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >依托咪酯</label>
            <input type="checkbox"  value="咪达唑仑" id="mdzl" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.mdzl eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >咪达唑仑</label>
            <input type="checkbox"  value="瑞芬太尼" id="rftn" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.rftn eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >瑞芬太尼</label>
            <input type="checkbox"  value="舒芬太尼" id="sftn" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.sftn eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >舒芬太尼</label>
            <input type="checkbox"  value="芬太尼" id="ftn" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.ftn eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >芬太尼</label>
            <input type="checkbox"  value="顺阿曲库胺" id="saqka" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.saqka eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >顺阿曲库胺</label>
            <input type="checkbox"  value="罗溴库胺" id="lxka" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.lxka eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >罗溴库胺</label>
            <input type="checkbox"  value="七氟烷" id="wkxa" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.wkxa eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >七氟烷</label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" style="width: 80px; " ></label>
            <input type="checkbox"  value="利多卡因" id="ldky" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.ldky eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >利多卡因</label>
            <input type="checkbox"  value="罗哌卡因" id="lpky" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.lpky eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >罗哌卡因</label>
            <input type="checkbox"  value="左旋布比卡因" id="zxky" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.zxky eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >左旋布比卡因</label>
            <input type="checkbox"  value="布比卡因" id="bbky" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.bbky eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >布比卡因</label>
            <label class="lab" >其他药物:</label>
            <label class="lab"  id="qtyw" class="hrlabel" style="width: 50px; >
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.qtyw}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >拟监测项目:</label>
            <input type="checkbox"  value="NIBP" id="nibp" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.nibp eq 'true'}"> checked="checked"</c:if>>
            <label class="lab"  style="width: 30px; ">NIBP</label>
            <input type="checkbox"  value="ECG" id="ecg2" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.ecg2 eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" style="width: 30px; " >ECG</label>
            <input type="checkbox"  value="Spo2" id="spo2" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.spo2 eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" style="width: 30px; ">Spo2</label>
            <input type="checkbox"  value="PetCO2" id="petco2" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.petco2 eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" style="width: 30px; ">PetCO2</label>
            <input type="checkbox"  value="尿量" id="niaoliang" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.niaoliang eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" style="width: 30px; " >尿量</label>
            <input type="checkbox"  value="体温" id="tw" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.tw eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" style="width: 30px; ">体温</label>
            <input type="checkbox"  value="IBP" id="ibp" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.ibp eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" style="width: 30px; " >IBP</label>
            <input type="checkbox"  value="CVP" id="cvo" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.cvo eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >CVP</label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" style="width: 70px; "></label>
            <input type="checkbox"  value="血气分析" id="xqfxnjc" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.xqfxnjc eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >血气分析</label>
            <input type="checkbox"  value="电解质" id="djz2" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.djz2 eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >电解质</label>
            <input type="checkbox"  value="血糖" id="xt1" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.xt1 eq 'true'}"> checked="checked"</c:if>>
            <label class="lab" >血糖</label>
            <label class="lab" >其他:</label>
            <label class="lab"  id="njcqt" class="hrlabel" style="width: 230px; ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.njcqt}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >拟准备特殊急救药品及设备:</label>
            <label class="lab"  id="jjyp1" class="hrlabel" style="width: 430px; ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.jjyp1}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
        </div>
        <div class="form-inline print_div">
            <label class="lab" >麻醉医师签名:</label>
            <label class="lab"  id="mzys" class="hrlabel" style="width: 230px; ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.mzys}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
            <label class="lab" >日期:</label>
            <label class="lab"  id="datetime" class="hrlabel" style="width: 230px; ">
                ${patientLink.tableForHeZhouGuangJiEY.shuQianFangShi.datetime}
               <hr style="border:0.2px solid #000;margin:0px;"/>
            </label>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
</script>
</html>