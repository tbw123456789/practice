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
    <title>术后随访</title>
    <base href="<%=basePath%>">
    <link href="${ctx }/css/form/print.css" type="text/css" rel="stylesheet">
    <link href="${ctx }/css/form/bootsdivap.min.css" rel="stylesheet">
    <link href="${ctx }/css/form/font-awesome.min.css" rel="stylesheet">
    <link href="${ctx }/css/form/materialdesignicons.min.css" rel="stylesheet">
    <link href="${ctx }/css/form/material-design-iconic-font.min.css" rel="stylesheet">
    <link href="${ctx }/css/form/typicons.min.css" rel="stylesheet">
    <link href="${ctx }/css/form/ionicons.min.css" rel="stylesheet">
    <link href="${ctx }/css/form/htmleaf-demo.css" rel="stylesheet">
    <link href="${ctx }/css/form/pretty.min.css" rel="stylesheet">
    <link href="${ctx }/css/bootsdivap.min.css" rel="stylesheet">
    <link href="${ctx }/css/bootsdivap-table.css" rel="stylesheet"/>
    <link href="${ctx }/css/bootsdivap-datetimepicker.min.css"
          rel="stylesheet"/>

    <!--图标样式-->
    <link href="${ctx }/css/bootsdivap.min.css" rel="stylesheet">
    <link href="${ctx }/css/bootsdivap-datetimepicker.min.css" rel="stylesheet">

    <script src="${ctx }/js/jquery/jquery.min.js"></script>
    <script src="${ctx }/js/jquery/jquery.datetimepicker.js"></script>
    <script src="${ctx }/js/bootsdivap-datetimepicker/moment-with-locales.min.js"></script>
    <script src="${ctx }/js/bootsdivap-datetimepicker/bootsdivap-datetimepicker.min.js"></script>

    <link href="${ctx }/css/toast.style.css" rel="stylesheet">
    <script src="${ctx }/js/jquery/toast/toast.script.js"></script>

    <script src="${ctx }/js/bootsdivap/bootsdivap-table.js"></script>
    <script src="${ctx }/js/bootsdivap/bootsdivap.min.js"></script>
    <script src="${ctx }/js/bootsdivap/bootsdivap-table-zh-CN.js"></script>
    <script src="${ctx }/js/highcharts/highcharts.js"></script>
    <script src="${ctx }/js/highcharts/exporting.js"></script>
    <script src="${ctx }/js/highcharts/series-label.js"></script>
    <script src="${ctx }/js/highcharts/highcharts-zh_CN.js"></script>
    <script src="${ctx }/js/highcharts/oldie.js"></script>

</head>
<body >
<div class="a4_AfterOperation" >
    <table class="printtitle">
        <div class="form-inline print_div">
            <td class="title" colspan="10">
                <span style="padding-bottom:10px">贺州广济医院</span><br />
                <span style="font-size: 20px;">麻醉术后随访记录单</span>

        </div>
    </table>
   
            <div class="printbody body" >

                <div class="form-inline print_div">
                    <label >姓名:</label>
                    <label id="brxm"  class="hrlabel" class="hrlabel"  class="hrlabel"  style="width  :150px;text-align: center">${patientLink.patient.brxm}
                        <hr  style="border:0.1px solid #000;margin:0px;"/>
                    </label>
                    <label >性别:</label>
                    <label id="xb"  class="hrlabel" class="hrlabel"  style="width :50px;text-align: center">${patientLink.patient.xb}
                        <hr  style="border:0.1px solid #000;margin:0px;"/>
                    </label>
                    <label >科室:</label>
                    <label id="ksmc"  class="hrlabel" class="hrlabel"  style="width :150px;text-align: center">${patientLink.patient.ksmc}
                        <hr  style="border:0.1px solid #000;margin:0px;"/>
                    </label>
                    <label >床号:</label>
                    <label id="zych"  class="hrlabel" class="hrlabel"  style="width :60px;text-align: center">${patientLink.patient.zych}
                        <hr  style="border:0.1px solid #000;margin:0px;"/>
                    </label>
                    <label >住院号:</label>
                    <label id="zyh"  class="hrlabel" class="hrlabel"  style="width :80px;text-align: center">${patientLink.patient.zyh}
                        <hr  style="border:0.1px solid #000;margin:0px;"/>
                    </label>



                </div>

                  <div class="form-inline print_div">
                                    <label>生命特征平稳:</label>
                               <input type="checkbox" readonly="" value="是" id="smtzpw_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.smtzpw_y eq 'divue'}"> checked="checked"</c:if>>
                                    <label>是</label>
                                <label>/</label>
                                <input type="checkbox" readonly="" value="否" id="smtzpw_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.smtzpw_n eq 'divue'}"> checked="checked"</c:if>>
                                    <label>否</label>
                                <label>神志:</label>
                                <input type="checkbox" readonly="" value="清醒" id="sz_qx" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.sz_qx eq 'divue'}"> checked="checked"</c:if>>
                                    <label>清醒</label>
                                <label>/</label>
                                <input type="checkbox" readonly="" value="嗜睡" id="sz_ss" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.sz_ss eq 'divue'}"> checked="checked"</c:if>>
                                    <label>嗜睡</label>
                                 <label>/</label>
                                <input type="checkbox" readonly="" value="昏迷" id="sz_hm" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.sz_hm eq 'divue'}"> checked="checked"</c:if>>
                                    <label>昏迷</label>
                                 <label>/</label>
                                <input type="checkbox" readonly="" value="模糊" id="sz_mh" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.sz_mh eq 'divue'}"> checked="checked"</c:if>>
                                    <label>模糊</label>
                                <label>PCA效果:</label>
                                <input type="checkbox" readonly="" value="满意" id="pca_my" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.pca_my eq 'divue'}"> checked="checked"</c:if>>
                                    <label>满意</label>
                                <label>/</label>
                                <input type="checkbox" readonly="" value="不满意" id="pca_bmy" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.pca_bmy eq 'divue'}"> checked="checked"</c:if>>
                                    <label>不满意</label>
                      
                     </div>
                  <div class="form-inline print_div">
                         <label>特殊主诉:</label>
                               <label id="tszs" class="hrlabel"  style="width :650px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.tszs}
                                   <hr  style="border:0.1px solid #000;margin:0px;"/>
                               </label>
                                   
                                
                    </div>
                  <div class="form-inline print_div">
                         <label>心肺检查:</label>
                               <input type="checkbox" readonly="" value="正常" id="xfjc_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.xfjc_y eq 'divue'}"> checked="checked"</c:if>>
                                    <label>正常</label>
                                 <label>/</label>
                                <input type="checkbox" readonly="" value="异常" id="xfjc_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.xfjc_n eq 'divue'}"> checked="checked"</c:if>>
                                    <label>异常</label>
                                <label id="xfjctext" class="hrlabel"  style="width :500px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.xfjctext}
                                    <hr  style="border:0.1px solid #000;margin:0px;"/>
                                </label>

                                
                    </div>
                  <div class="form-inline print_div">
                            <label>呼吸系统：声嘶/咽痛:</label>
                                 <input type="checkbox" readonly="" value="有" id="hxxt_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.hxxt_y eq 'divue'}"> checked="checked"</c:if>>
                                    <label>有</label>
                                  <label>/</label>
                                <input type="checkbox" readonly="" value="无" id="hxxt_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.hxxt_n eq 'divue'}"> checked="checked"</c:if>>
                                    <label>无</label>
                                <label>肺部感染:</label>
                               <input type="checkbox" readonly="" value="有" id="tpg_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.fbgr_y eq 'divue'}"> checked="checked"</c:if>>
                                    <label>有</label>
                                <label>/</label>
                                <input type="checkbox" readonly="" value="无" id="fbgr_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.fbgr_n eq 'divue'}"> checked="checked"</c:if>>
                                    <label>无</label>
                                <label>呼吸困难:</label>
                                <input type="checkbox" readonly="" value="有" id="hxkn_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.hxkn_y eq 'divue'}"> checked="checked"</c:if>>
                                    <label>有</label>
                                 <label>/</label>
                                <input type="checkbox" readonly="" value="无" id="hxkn_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.hxkn_n eq 'divue'}"> checked="checked"</c:if>>
                                    <label>无</label>
                                <label>低血氧血症:</label>
                                 <input type="checkbox" readonly="" value="有" id="dyxz_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.dyxz_y eq 'divue'}"> checked="checked"</c:if>>
                                    <label>有</label>
                                <label>/</label>
                                <input type="checkbox" readonly="" value="无" id="dyxz_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.dyxz_n eq 'divue'}"> checked="checked"</c:if>>
                                    <label>无</label>


                    </div>
                  <div class="form-inline print_div">
                      <label>呼吸衰竭:</label>
                      <input type="checkbox" readonly="" value="有" id="hxsj_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.hxsj_y eq 'divue'}"> checked="checked"</c:if>>
                      <label>有</label>
                      <label>/</label>
                      <input type="checkbox" readonly="" value="无" id="hxsj_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.hxsj_n eq 'divue'}"> checked="checked"</c:if>>
                      <label>无</label>
                         <label>循环系统：严重高/低血压:</label>
                               <input type="checkbox" readonly="" value="有" id="gxy_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.gxy_y eq 'divue'}"> checked="checked"</c:if>>
                                    <label>有</label>
                                 <label>/</label>
                                <input type="checkbox" readonly="" value="无" id="gxy_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.gxy_n eq 'divue'}"> checked="checked"</c:if>>
                                    <label>无</label>
                                <label>严重心率失常:</label>
                                <input type="checkbox" readonly="" value="有" id="yzxl_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.yzxl_y eq 'divue'}"> checked="checked"</c:if>>
                                    <label>有</label>
                                 <label>/</label>
                                <input type="checkbox" readonly="" value="无" id="yzxl_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.yzxl_n eq 'divue'}"> checked="checked"</c:if>>
                                    <label>无</label>
                                 <label>心绞痛:</label>
                                <input type="checkbox" readonly="" value="有" id="xjt_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.xjt_y eq 'divue'}"> checked="checked"</c:if>>
                                    <label>有</label>
                                <label>/</label>
                                <input type="checkbox" readonly="" value="无" id="xjt_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.xjt_n eq 'divue'}"> checked="checked"</c:if>>
                                    <label>无</label>


                    </div>
                  <div class="form-inline print_div">
                      <label>心力衰竭:</label>
                      <input type="checkbox" readonly="" value="有" id="xlsj_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.xlsj_y eq 'divue'}"> checked="checked"</c:if>>
                      <label>有</label>
                      <label>/</label>
                      <input type="checkbox" readonly="" value="无" id="xlsj_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.xlsj_n eq 'divue'}"> checked="checked"</c:if>>
                      <label>无</label>
                         <label>神经系统：认知功能障碍:</label>
                                <input type="checkbox" readonly="" value="有" id="rzgn_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.rzgn_y eq 'divue'}"> checked="checked"</c:if>>
                                    <label>有</label>
                                 <label>/</label>
                                <input type="checkbox" readonly="" value="无" id="rzgn_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.rzgn_n eq 'divue'}"> checked="checked"</c:if>>
                                    <label>无</label>
                                <label>术中知晓:</label>
                                <input type="checkbox" readonly="" value="有" id="szzx_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.szzx_y eq 'divue'}"> checked="checked"</c:if>>
                                    <label>有</label>
                                 <label>/</label>
                                <input type="checkbox" readonly="" value="无" id="szzx_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.szzx_n eq 'divue'}"> checked="checked"</c:if>>
                                    <label>无</label>
                                <label>肢体感觉/活动:</label>
                                <input type="checkbox" readonly="" value="正常" id="ztgj_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.ztgj_y eq 'divue'}"> checked="checked"</c:if>>
                                    <label>正常</label>
                                 <label>/</label>
                                <input type="checkbox" readonly="" value="异常" id="ztgj_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.ztgj_n eq 'divue'}"> checked="checked"</c:if>>
                                    <label>异常</label>


                    </div>
                  <div class="form-inline print_div">
                      <label>脊柱穿刺点疼痛/红肿:</label>
                      <input type="checkbox" readonly="" value="有" id="jz_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.jz_y eq 'divue'}"> checked="checked"</c:if>>
                      <label>有</label>
                      <label>/</label>
                      <input type="checkbox" readonly="" value="无" id="jz_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.jz_n eq 'divue'}"> checked="checked"</c:if>>
                      <label>无</label>
                     <label>其他：恶心呕吐:</label>
                               <input type="checkbox" readonly="" value="有" id="exot_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.exot_y eq 'divue'}"> checked="checked"</c:if>>
                                    <label>有</label>
                                <label>/</label>
                               <input type="checkbox" readonly="" value="无" id="exot_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.exot_n eq 'divue'}"> checked="checked"</c:if>>
                                    <label>无</label>
                                 <label>尿潴留:</label>
                                 <input type="checkbox" readonly="" value="有" id="nzl_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.nzl_y eq 'divue'}"> checked="checked"</c:if>>
                                    <label>有</label>
                                <label>/</label>
                                <input type="checkbox" readonly="" value="无" id="nzl_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.nzl_n eq 'divue'}"> checked="checked"</c:if>>
                                    <label>无</label>

                    </div>
                  <div class="form-inline print_div">
                            <label>病人对麻醉满意:</label>
                                <input type="checkbox" readonly="" value="是" id="mzmy_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.mzmy_y eq 'divue'}"> checked="checked"</c:if>>
                                    <label>是</label>
                               <label>/</label>
                               <input type="checkbox" readonly="" value="否" id="mzmy_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.mzmy_n eq 'divue'}"> checked="checked"</c:if>>
                                    <label>否</label>
                                 <label>投诉意见</label>
                                <label id="mzmyText" class="hrlabel"  style="width :460px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.mzmyText}
                                    <hr  style="border:0.1px solid #000;margin:0px;"/>
                                </label>


                    </div>
                  <div class="form-inline print_div">

                                    <label>麻醉后访视结论：</label>

                       
                    </div>
                  <div class="form-inline print_div">
                                    <label>1、麻醉相关并发症:</label>
                                <input type="checkbox" readonly="" value="有" id="bfz_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.bfz_y eq 'divue'}"> checked="checked"</c:if>>
                                    <label>有</label>
                                 <label>/</label>
                               <input type="checkbox" readonly="" value="无" id="bfz_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.bfz_n eq 'divue'}"> checked="checked"</c:if>>
                                    <label>无</label>
                                 <label id="bfzText" class="hrlabel"  style="width :460px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.bfzText}
                                     <hr  style="border:0.1px solid #000;margin:0px;"/>
                                 </label>


                    </div>
                  <div class="form-inline print_div">
                         <label id="bfzText2" class="hrlabel"  style="width :700px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.bfzText2}
                             <hr  style="border:0.1px solid #000;margin:0px;"/>
                         </label>

                    </div>
                  <div class="form-inline print_div">
                         <label id="bfzText3" class="hrlabel"  style="width :700px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.bfzText3}
                             <hr  style="border:0.1px solid #000;margin:0px;"/>
                         </label>


                    </div>
                  <div class="form-inline print_div">
                                    <label>2、医嘱/处理意见:</label>
                                <input type="checkbox" readonly="" value="有" id="yj_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.yj_y eq 'divue'}"> checked="checked"</c:if>>
                                    <label>有</label>
                               <label>/</label>
                                <input type="checkbox" readonly="" value="无" id="yj_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.yj_n eq 'divue'}"> checked="checked"</c:if>>
                                    <label>无</label>
                               <label id="yjText" class="hrlabel"  style="width :460px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.yjText}
                                   <hr  style="border:0.1px solid #000;margin:0px;"/>
                               </label>

                    </div>
                  <div class="form-inline print_div">
                        <label id="yjText2" class="hrlabel"  style="width :700px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.yjText2}
                            <hr  style="border:0.1px solid #000;margin:0px;"/>
                        </label>

                    </div>
                  <div class="form-inline print_div">
                        <label id="yjText3" class="hrlabel"  style="width :700px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.yjText3}
                            <hr  style="border:0.1px solid #000;margin:0px;"/>
                        </label>

                    </div>

                  <div class="form-inline print_div">
                     <label>麻醉医师签名:</label>
                                <label id="mzysqm2" class="hrlabel"  style="width :300px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.mzysqm2}
                                    <hr  style="border:0.1px solid #000;margin:0px;"/>
                                </label>

                                <label>日期:</label>
                               <label id="rq2" class="hrlabel"  style="width :300px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.rq2}
                                   <hr  style="border:0.1px solid #000;margin:0px;"/>
                               </label>


                </div>
     
    <div class="form-inline print_div">
        <span style="font-size:18px;">注：麻醉术前（后）访视记录单在规定时间完成后存放于病历</span>
    </div>
            </div>
</div>

</body>
<script type="text/javascript">
</script>
</html>