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
    <title>麻醉经过</title>
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
        <div class="form-inline print_div">
            <td class="title" colspan="10">
                <span style="padding-bottom:10px">贺州广济医院</span><br />
                <span style="font-size: 20px;">麻醉主要经过记录单</span>
           
       </div>
    </table>

   
            <div class="printbody body" >

               
                    <div class="form-inline print_div">
                        <label >姓名:</label>
                        <label id="brxm"  class="hrlabel" style="width:150px;text-align: center">${patientLink.patient.brxm}
                            <hr  style="border:0.1px solid #000;margin:0px;"/>
                        </label>
                        <label >性别:</label>
                        <label id="xb"  class="hrlabel" style="width:50px;text-align: center">${patientLink.patient.xb}
                            <hr  style="border:0.1px solid #000;margin:0px;"/>
                        </label>
                        <label >科室:</label>
                        <label id="ksmc"  class="hrlabel" style="width:150px;text-align: center">${patientLink.patient.ksmc}
                            <hr  style="border:0.1px solid #000;margin:0px;"/>
                        </label>
                        <label >床号:</label>
                        <label id="zych"  class="hrlabel" style="width:60px;text-align: center">${patientLink.patient.zych}
                            <hr  style="border:0.1px solid #000;margin:0px;"/>
                        </label>
                        <label >住院号:</label>
                        <label id="zyh"  class="hrlabel" style="width:80px;text-align: center">${patientLink.patient.zyh}
                            <hr  style="border:0.1px solid #000;margin:0px;"/>
                        </label>
                        
                          
                        
                   </div>

                    <div class="form-inline print_div">
                        <label>1.全麻：诱导平顺:</label>
                        <input type="checkbox" readonly="" value="是" id="qm_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.qm_y eq 'true'}"> checked="checked"</c:if>>
                        <label>是</label>
                        <label>/</label>
                        <input type="checkbox" readonly="" value="否" id="qm_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.qm_n eq 'true'}"> checked="checked"</c:if>>
                        <label>否</label>
                        <label>反流误吸:</label>
                        <input type="checkbox" readonly="" value="是" id="flwx_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.flwx_y eq 'true'}"> checked="checked"</c:if>>
                        <label>是</label>
                        <label>/</label>
                        <input type="checkbox" readonly="" value="否" id="flwx_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.flwx_n eq 'true'}"> checked="checked"</c:if>>
                        <label>否</label>
                        <label>呼吸道梗阻:</label>
                        <input type="checkbox" readonly="" value="是" id="hxgdzs_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.hxgdzs_y eq 'true'}"> checked="checked"</c:if>>
                        <label>是</label>
                        <label>/</label>
                        <input type="checkbox" readonly="" value="否" id="hxgdzs_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.hxgdzs_n eq 'true'}"> checked="checked"</c:if>>
                        <label>否</label>

                       
                   </div>
                <div class="form-inline print_div">
                    <label style="width: 50px"></label>
                    <label>喉/支气管痉挛:</label>
                    <input type="checkbox" readonly="" value="有" id="hzqg_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.hzqg_y eq 'true'}"> checked="checked"</c:if>>
                    <label>有</label>
                    <label>/</label>
                    <input type="checkbox" readonly="" value="无" id="hzqg_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.hzqg_n eq 'true'}"> checked="checked"</c:if>>
                    <label>无</label>
                    <label>气管拔管:</label>
                    <input type="checkbox" readonly="" value="是" id="qgbg_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.qgbg_y eq 'true'}"> checked="checked"</c:if>>
                    <label>是</label>
                    <label>/</label>
                    <input type="checkbox" readonly="" value="否" id="qgbg_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.qgbg_n eq 'true'}"> checked="checked"</c:if>>
                    <label>否</label>
                    <label>气管拔管后呼吸正常:</label>
                    <input type="checkbox" readonly="" value="是" id="qghx_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.qghx_y eq 'true'}"> checked="checked"</c:if>>
                    <label>是</label>
                    <label>/</label>
                    <input type="checkbox" readonly="" value="否" id="qghx_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.qghx_n eq 'true'}"> checked="checked"</c:if>>
                    <label>否</label>
                </div>

              
                    <div class="form-inline print_div">
                        <label>2.椎管内麻醉：常规消毒铺巾，穿刺顺利:</label>
                        <input type="checkbox" readonly="" value="有" id="zgnz_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.zgnz_y eq 'true'}"> checked="checked"</c:if>>
                        <label>有</label>
                        <label>/</label>
                        <input type="checkbox" readonly="" value="无" id="zgnz_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.zgnz_y eq 'true'}"> checked="checked"</c:if>>
                        <label>无</label>
                        <label>突破感:</label>
                        <input type="checkbox" readonly="" value="有" id="tpg_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.tpg_y eq 'true'}"> checked="checked"</c:if>>
                        <label>有</label>
                        <label>/</label>
                        <input type="checkbox" readonly="" value="无" id="tpg_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.tpg_n eq 'true'}"> checked="checked"</c:if>>
                        <label>无</label>
                        <label>阻力消退:</label>
                        <input type="checkbox" readonly="" value="有" id="zlxt_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.zlxt_y eq 'true'}"> checked="checked"</c:if>>
                        <label>有</label>
                        <label>/</label>
                        <input type="checkbox" readonly="" value="无" id="zlxt_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.zlxt_n eq 'true'}"> checked="checked"</c:if>>
                        <label>无</label>

                   </div>
                <div class="form-inline print_div">
                    <label style="width: 50px"></label>
                    <label>出血:</label>
                    <input type="checkbox" readonly="" value="有" id="cx_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.cx_y eq 'true'}"> checked="checked"</c:if>>
                    <label>有</label>
                    <label>/</label>
                    <input type="checkbox" readonly="" value="无" id="cx_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.cx_n eq 'true'}"> checked="checked"</c:if>>
                    <label>无</label>
                    <label>穿刺/置管时易感:</label>
                    <input type="checkbox" readonly="" value="有" id="chuac_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.chuac_y eq 'true'}"> checked="checked"</c:if>>
                    <label>有</label>
                    <label>/</label>
                    <input type="checkbox" readonly="" value="无" id="chuac_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.chuac_n eq 'true'}"> checked="checked"</c:if>>
                    <label>无</label>
                    <label>负压:</label>
                    <input type="checkbox" readonly="" value="有" id="fy_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.fy_y eq 'true'}"> checked="checked"</c:if>>
                    <label>有</label>
                    <label>/</label>
                    <input type="checkbox" readonly="" value="无" id="fy_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.fy_n eq 'true'}"> checked="checked"</c:if>>
                    <label>无</label>
                </div>
                    <div class="form-inline print_div">
                        <label style="width: 50px"></label>
                        <label>硬膜外针/导管回抽脑脊液或血液:</label>
                        <input type="checkbox" readonly="" value="有" id="ym_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.ym_y eq 'true'}"> checked="checked"</c:if>>
                        <label>有</label>
                        <label>/</label>
                        <input type="checkbox" readonly="" value="无" id="ym_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.ym_n eq 'true'}"> checked="checked"</c:if>>
                        <label>无</label>
                        <label>全脊麻:</label>
                        <input type="checkbox" readonly="" value="有" id="qjm_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.qjm_y eq 'true'}"> checked="checked"</c:if>>
                        <label>有</label>
                        <label>/</label>
                        <input type="checkbox" readonly="" value="无" id="qjm_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.qjm_n eq 'true'}"> checked="checked"</c:if>>
                        <label>无</label>
                   </div>
                    <div class="form-inline print_div">
                        <label style="width: 50px"></label>
                        <label>术前阻滞平面:</label>
                        <label id="zzhipm"  class="hrlabel" style="width:150px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.zzhipm}
                            <hr  style="border:0.1px solid #000;margin:0px;"/>
                        </label>

                        <label>术毕阻滞平面:</label>
                        <label id="sbzzhipm"  class="hrlabel" style="width:150px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.sbzzhipm}
                            <hr  style="border:0.1px solid #000;margin:0px;"/>
                        </label>

                        <label>麻醉效果:</label>
                        <input type="checkbox" readonly="" value="完善" id="mzxg_ws" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.mzxg_ws eq 'true'}"> checked="checked"</c:if>>
                        <label>完善</label>
                        <label>/</label>
                        <input type="checkbox" readonly="" value="不完善" id="mzxg_nws" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.mzxg_nws eq 'true'}"> checked="checked"</c:if>>
                        <label>不完善</label>
                        <label>/</label>
                        <input type="checkbox" readonly="" value="失败" id="mzxg_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.mzxg_n eq 'true'}"> checked="checked"</c:if>>
                        <label>失败</label>
                        
                   </div>
                    <div class="form-inline print_div">
                        <label style="width: 50px"></label>
                        <label>辅助应用镇静/镇痛药:</label>
                        <input type="checkbox" readonly="" value="是" id="zt_y1" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.zt_y1 eq 'true'}"> checked="checked"</c:if>>
                        <label>是</label>
                        <label>/</label>
                        <input type="checkbox" readonly="" value="否" id="zt_n1" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.zt_n1 eq 'true'}"> checked="checked"</c:if>>
                        <label>否</label>
                        <label>改全麻（</label>
                        <input type="checkbox" readonly="" value="是" id="ztqm_y1" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.ztqm_y1 eq 'true'}"> checked="checked"</c:if>>
                        <label>是</label>
                        <label>/</label>
                        <input type="checkbox" readonly="" value="否" id="ztqm_n1" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.ztqm_n1 eq 'true'}"> checked="checked"</c:if>>
                        <label>否</label>
                        <label>） 顺利;</label>
                             
                       
                   </div>
                    <div class="form-inline print_div">
                        <label>3.神经阻滞：常规消毒铺巾，操作顺利:</label>

                        <input type="checkbox" readonly="" value="是" id="shjzz_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.shjzz_y eq 'true'}"> checked="checked"</c:if>>
                        <label>是</label>
                        <label>/</label>
                        <input type="checkbox" readonly="" value="否" id="shjzz_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.shjzz_n eq 'true'}"> checked="checked"</c:if>>
                        <label>否</label>
                        <label>局麻醉药毒性反应:</label>
                        <input type="checkbox" readonly="" value="有" id="jbmz_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.jbmz_y eq 'true'}"> checked="checked"</c:if>>
                        <label>有</label>
                        <label>/</label>
                        <input type="checkbox" readonly="" value="无" id="jbmz_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.jbmz_n eq 'true'}"> checked="checked"</c:if>>
                        <label>无</label>

                       
                   </div>
                <div class="form-inline print_div">
                    <label style="width: 50px"></label>
                    <label>组织后声嘶/呼吸困难:</label>
                    <input type="checkbox" readonly="" value="有" id="zuzhiss_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.zuzhiss_y eq 'true'}"> checked="checked"</c:if>>
                    <label>有</label>
                    <label>/</label>
                    <input type="checkbox" readonly="" value="无" id="zuzhiss_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.zuzhiss_n eq 'true'}"> checked="checked"</c:if>>
                    <label>无</label>
                    <label>麻醉效果:</label>
                    <input type="checkbox" readonly="" value="完善" id="mzxiaog_ws" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.mzxiaog_ws eq 'true'}"> checked="checked"</c:if>>
                    <label>完善</label>
                    <label>/</label>
                    <input type="checkbox" readonly="" value="不完善" id="mzxiaog_nws" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.mzxiaog_nws eq 'true'}"> checked="checked"</c:if>>
                    <label>不完善</label>
                    <label>/</label>
                    <input type="checkbox" readonly="" value="失败" id="mzxiaog_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.mzxiaog_n eq 'true'}"> checked="checked"</c:if>>
                    <label>失败</label>

                </div>
                    <div class="form-inline print_div">
                        <label style="width: 50px"></label>
                                    <label>辅助应用镇静/镇痛药:</label>
                               <input type="checkbox" readonly="" value="是" id="zt_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.zt_y eq 'true'}"> checked="checked"</c:if>>
                                    <label>是</label>
                                  <label>/</label>

                                    <input type="checkbox" readonly="" value="否" id="zt_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.zt_n eq 'true'}"> checked="checked"</c:if>>
                                    <label>否</label>
                                 <label>改全麻（</label>
                               <input type="checkbox" readonly="" value="是" id="ztqm_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.ztqm_y eq 'true'}"> checked="checked"</c:if>>
                                    <label>是</label>
                                 <label>/</label>
                                <input type="checkbox" readonly="" value="否" id="ztqm_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.ztqm_n eq 'true'}"> checked="checked"</c:if>>
                                    <label>否</label>
                                <label>） 顺利;</label>

                   </div>
                    <div class="form-inline print_div">
                                    <label>4.</label>
                              <label id="jmText"  class="hrlabel" style="width:105px;">
                                  <hr  style="border:0.1px solid #000;margin:0px;"/>
                              </label>

                                 <label>静脉穿刺置管手术：常规消毒铺巾，穿刺顺利:</label>
                                <input type="checkbox" readonly="" value="是" id="jm_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.jm_y eq 'true'}"> checked="checked"</c:if>>
                                    <label>是</label>
                                <label>/</label>
                              <input type="checkbox" readonly="" value="否" id="jm_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.jm_n eq 'true'}"> checked="checked"</c:if>>
                                    <label>否</label>

                   </div>
                <div class="form-inline print_div">
                    <label style="width: 50px"></label>
                    <label>进针:</label>
                    <label id="jzText"  class="hrlabel" style="width:45px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.jzText}
                        <hr  style="border:0.1px solid #000;margin:0px;"/>
                    </label>

                    <label>cm  回抽见血，置入</label>
                    <label id="zrText"  class="hrlabel" style="width:45px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.zrText}
                        <hr  style="border:0.1px solid #000;margin:0px;"/>
                    </label>

                    <label>F导管:</label>
                    <label id="dgText"  class="hrlabel" style="width:45px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.dgText}
                        <hr  style="border:0.1px solid #000;margin:0px;"/>
                    </label>

                    <label>cm,置入顺利:</label>
                    <input type="checkbox" readonly="" value="是" id="zrsl_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.zrsl_y eq 'true'}"> checked="checked"</c:if>>
                    <label>是</label>
                    <label>/</label>
                    <input type="checkbox" readonly="" value="否" id="zrsl_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.zrsl_n eq 'true'}"> checked="checked"</c:if>>
                    <label>否</label>
                </div>

                    <div class="form-inline print_div">
                        <label style="width: 50px"></label>
                                    <label>回血通畅:</label>
                               <input type="checkbox" readonly="" value="是" id="hxtc_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.hxtc_y eq 'true'}"> checked="checked"</c:if>>
                                    <label>是</label>
                                <label>/</label>
                                <input type="checkbox" readonly="" value="否" id="hxtc_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.hxtc_n eq 'true'}"> checked="checked"</c:if>>
                                    <label>否</label>
                                <label>误穿动脉:</label>
                                <input type="checkbox" readonly="" value="有" id="wcdm_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.wcdm_y eq 'true'}"> checked="checked"</c:if>>
                                    <label>有</label>
                                <label>/</label>
                                <input type="checkbox" readonly="" value="无" id="wcdm_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.wcdm_n eq 'true'}"> checked="checked"</c:if>>
                                    <label>无</label>
                                <label>穿刺过程中病人不适:</label>
                                <input type="checkbox" readonly="" value="有" id="brbs_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.brbs_y eq 'true'}"> checked="checked"</c:if>>
                                    <label>有</label>
                               <label>/</label>
                                <input type="checkbox" readonly="" value="无" id="sbrbs_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.sbrbs_n eq 'true'}"> checked="checked"</c:if>>
                                    <label>无</label>
                   </div>
                    <div class="form-inline print_div">
                                    <label>5.</label>
                                <label id="dmciText"  class="hrlabel" style="width:105px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.dmciText}
                                    <hr  style="border:0.1px solid #000;margin:0px;"/>
                                </label>

                                 <label>动脉穿刺置管手术：穿刺前allen试验:</label>
                                <input type="checkbox" readonly="" value="阴性" id="dmci_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.dmci_y eq 'true'}"> checked="checked"</c:if>>
                                    <label>阴性</label>
                                <label>/</label>
                                <input type="checkbox" readonly="" value="阳性" id="dmci_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.dmci_n eq 'true'}"> checked="checked"</c:if>>
                                    <label>阳性</label>
                                <label>常规消毒铺巾，穿刺顺利:</label>
                               <input type="checkbox" readonly="" value="是" id="sl_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.sl_y eq 'true'}"> checked="checked"</c:if>>
                                    <label>是</label>
                                <label>/</label>
                                <input type="checkbox" readonly="" value="否" id="sl_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.sl_n eq 'true'}"> checked="checked"</c:if>>
                                    <label>否</label>

                   </div>
                    <div class="form-inline print_div">
                    <label>6.麻醉过程：生命特征平稳:</label>
                      <input type="checkbox" readonly="" value="是" id="smtz_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.smtz_y eq 'true'}"> checked="checked"</c:if>>
                                    <label>是</label>
                        <label>/</label>
                                <input type="checkbox" readonly="" value="否" id="smtz_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.smtz_n eq 'true'}"> checked="checked"</c:if>>
                                    <label>否</label>
                                  <label>术中严重高/低血压:</label>
                                <input type="checkbox" readonly="" value="有" id="xy_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.xy_y eq 'true'}"> checked="checked"</c:if>>
                                    <label>有</label>
                                <label>/</label>
                               <input type="checkbox" readonly="" value="无" id="xy_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.xy_n eq 'true'}"> checked="checked"</c:if>>
                                    <label>无</label>
                        <label>严重低氧血症:</label>
                        <input type="checkbox" readonly="" value="有" id="dyz_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.dyz_y eq 'true'}"> checked="checked"</c:if>>
                        <label>有</label>
                        <label>/</label>
                        <input type="checkbox" readonly="" value="无" id="dyz_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.dyz_n eq 'true'}"> checked="checked"</c:if>>
                        <label>无</label>

                   </div>
                <div class="form-inline print_div">
                    <label style="width: 50px"></label>

                    <label>高碳酸血症:</label>
                    <input type="checkbox" readonly="" value="有" id="gtsxz_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.gtsxz_y eq 'true'}"> checked="checked"</c:if>>
                    <label>有</label>
                    <label>/</label>
                    <input type="checkbox" readonly="" value="无" id="gtsxz_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.gtsxz_n eq 'true'}"> checked="checked"</c:if>>
                    <label>无</label>
                    <label>术中病人躁动:</label>
                    <input type="checkbox" readonly="" value="有" id="szzd_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.szzd_y eq 'true'}"> checked="checked"</c:if>>
                    <label>有</label>
                    <label>/</label>
                    <input type="checkbox" readonly="" value="无" id="szzd_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.szzd_n eq 'true'}"> checked="checked"</c:if>>
                    <label>无</label>
                    <label>术中大出血:</label>
                    <input type="checkbox" readonly="" value="有" id="szcx_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.szcx_y eq 'true'}"> checked="checked"</c:if>>
                    <label>有</label>
                    <label>/</label>
                    <input type="checkbox" readonly="" value="无" id="szcx_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.szcx_n eq 'true'}"> checked="checked"</c:if>>
                    <label>无</label>
                </div>
                    <div class="form-inline print_div">
                        <label style="width: 50px"></label>
                                 <label>药物/血制品过敏:</label>
                                <input type="checkbox" readonly="" value="有" id="ywgm_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.ywgm_y eq 'true'}"> checked="checked"</c:if>>
                                    <label>有</label>
                                 <label>/</label>
                                 <input type="checkbox" readonly="" value="无" id="ywgm_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.ywgm_n eq 'true'}"> checked="checked"</c:if>>
                                    <label>无</label>
                                 <label id="ywxzp"  class="hrlabel" style="width:545px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.ywxzp}
                                     <hr  style="border:0.1px solid #000;margin:0px;"/>
                                 </label>


                   </div>

                    <div class="form-inline print_div">
                                    <label>7.病人术毕情况：生命特征稳定:</label>
                                    <input type="checkbox" readonly="" value="是" id="qk_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.qk_y eq 'true'}"> checked="checked"</c:if>>
                                    <label>是</label>
                                 <label>/</label>
                                 <input type="checkbox" readonly="" value="否" id="qk_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.qk_n eq 'true'}"> checked="checked"</c:if>>
                                    <label>否</label>
                                <label>;</label>
                                <input type="checkbox" readonly="" value="送至病房" id="qk_szbf" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.qk_szbf eq 'true'}"> checked="checked"</c:if>>
                                    <label>送至病房</label>
                                 <label>/</label>
                                <input type="checkbox" readonly="" value="PACU" id="qk_pacu" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.qk_pacu eq 'true'}"> checked="checked"</c:if>>
                                    <label>PACU</label>
                                 <label>/</label>
                                <input type="checkbox" readonly="" value="ICU时" id="qk_icu" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.qk_icu eq 'true'}"> checked="checked"</c:if>>
                                    <label>ICU时</label>
                                 <label>;</label>
                                <label>BP:</label>
                               <label id="bptext"  class="hrlabel" style="width:55px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.bptext}
                                   <hr  style="border:0.1px solid #000;margin:0px;"/>
                               </label>

                                     <label>mmHg</label>
                               <label>P:</label>
                                <label id="ptext"  class="hrlabel" style="width:40px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.ptext}
                                    <hr  style="border:0.1px solid #000;margin:0px;"/>
                                </label>

                                 <label>次/分</label>


                   </div>
                <div class="form-inline print_div">
                    <label style="width: 50px"></label>
                    <label>R:</label>
                    <label id="rtext"  class="hrlabel" style="width:40px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.rtext}
                        <hr  style="border:0.1px solid #000;margin:0px;"/>
                    </label>

                    <label>次/分</label>
                    <label>Sp02:</label>
                    <label id="spo2text"  class="hrlabel" style="width:40px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.spo2text}
                        <hr  style="border:0.1px solid #000;margin:0px;"/>
                    </label>

                    <label>%(</label>
                    <input type="checkbox" readonly="" value="吸氧" id="szqx" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.sp_xy eq 'true'}"> checked="checked"</c:if>>
                    <label>吸氧</label>
                    <label>/</label>
                    <input type="checkbox" readonly="" value="空气" id="szmh" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.sp_kq eq 'true'}"> checked="checked"</c:if>>
                    <label>空气</label>
                    <label>),T:</label>
                    <label id="twt"  class="hrlabel" style="width:40px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.ttext}
                        <hr  style="border:0.1px solid #000;margin:0px;"/>
                    </label>

                    <label>℃</label>
                </div>
                <div class="form-inline print_div">
                    <label style="width: 50px"></label>

                             <label>病人完全清醒:</label>
                             <input type="checkbox" readonly="" value="是" id="qx_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.qx_y eq 'true'}"> checked="checked"</c:if>>
                                <label>是</label>
                            <label>/</label>
                             <input type="checkbox" readonly="" value="否" id="qx_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.qx_n eq 'true'}"> checked="checked"</c:if>>
                                <label>否</label>
                             <label>清醒时间:</label>
                             <label id="qxsj"  class="hrlabel" style="width:140px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.qxsj}
                                 <hr  style="border:0.1px solid #000;margin:0px;"/>
                             </label>

                            <label>肌力恢复:</label>
                             <input type="checkbox" readonly="" value="正常" id="jl_y" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.jl_y eq 'true'}"> checked="checked"</c:if>>
                                <label>正常</label>
                            <label>/</label>
                            <input type="checkbox" readonly="" value="异常" id="jl_n" <c:if test="${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.jl_n eq 'true'}"> checked="checked"</c:if>>
                                <label>异常</label>

                   </div>

                    <div class="form-inline print_div">
                                    <label>8.术后镇痛：0.9%NaCl 100ml+舒芬太尼</label>
                               <label id="shzt_c"  class="hrlabel" style="width:45px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.shzt_c}
                                   <hr  style="border:0.1px solid #000;margin:0px;"/>
                               </label>

                               <label>ug + 胃复安</label>
                                <label id="shzt_d"  class="hrlabel" style="width:40px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.shzt_d}
                                    <hr  style="border:0.1px solid #000;margin:0px;"/>
                                </label>

                                    <label>mg + 氧比洛芬脂</label>

                                    <label id="shzt_e"  class="hrlabel" style="width:40px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.shzt_e}
                                        <hr  style="border:0.1px solid #000;margin:0px;"/>
                                    </label>
                        <label>mg</label>

                   </div>
                <div class="form-inline print_div">
                    <label style="width: 50px"></label>
                    <label>+ 罗哌卡因</label>
                    <label id="shzt_f"  class="hrlabel" style="width:40px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.shzt_f}
                        <hr  style="border:0.1px solid #000;margin:0px;"/>
                    </label>

                    <label>mg +咪达唑呛</label>
                    <label id="shzt_g"  class="hrlabel" style="width:40px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.shzt_g}
                        <hr  style="border:0.1px solid #000;margin:0px;"/>
                    </label>
                    <label>mg</label>
                </div>
                    <div class="form-inline print_div">
                                    <label>9.特殊情况（必要时在病程记录上详细记录抢救经过）:</label>
                       
                   </div>
                    <div class="form-inline print_div">
                         <label id="tsqkText"  class="hrlabel" style="width:1000px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.tsqkText}
                             <hr  style="border:0.1px solid #000;margin:0px;"/>
                         </label>

                   </div>

                    <div class="form-inline print_div">

                                    <label>麻醉医师签名:</label>
                                <label id="mzysqm"  class="hrlabel" style="width:200px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.mzysqm}
                                    <hr  style="border:0.1px solid #000;margin:0px;"/>
                                </label>
                                    <label>护送者签名:</label>
                                    <label id="hszqm"  class="hrlabel" style="width:200px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.hszqm}
                                        <hr  style="border:0.1px solid #000;margin:0px;"/>
                                    </label>
                                    <label>日期:</label>
                                    <label id="rq"  class="hrlabel" style="width:200px;">${patientLink.tableForHeZhouGuangJiEY.shuHouFangShi.rq}
                                        <hr  style="border:0.1px solid #000;margin:0px;"/>
                                    </label>

                   </div>
                   
            </div>
  

</div>

</body>
<script type="text/javascript">
</script>
</html>