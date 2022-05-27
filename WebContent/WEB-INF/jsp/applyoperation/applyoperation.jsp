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
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>手术申请</title>
    <base href="<%=basePath%>">
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
    <style type="text/css">
        .parent{
            width: 99%;
        }
        .table th, .table td {
            text-align: center;
            vertical-align: middle!important;
        }

         #d1{
             width: 400px;
             height: 300px;
             z-index: 2;
             position: fixed;
             top: 50%;
             left: 50%;
             margin-left: -200px;
             margin-top: -150px;
             overflow: hidden;
             display: none;
             background-color: white;
         }
        #d2{
            position: fixed;
            left: 0;
            top:0;
            width: 100%;
            height: 100%;
            background-color: grey;
            z-index: 1;
            opacity: 0.8;
            display: none;
        }
        #number{
            display: block;
            width: 90%;
            height: 30px;
            margin: 40px auto;


            outline: none;
            padding-left: 5px;
        }
        #number:focus{
            border: solid 1px #248CD6;
            border-radius: 5px;
            box-shadow: 0 0 8px #248CD6;
        }
        .submit{
            display: flex;
            width: 90%;
            height: 40px;
            margin: 20px auto;
        }
        .cancel,.confirm{
            flex: 1;
            margin: 42px;

            background-color: #248CD6 ;
            transition: all 0.2s;
            border: solid 1px #a6e1ec;
            border-radius: 5px;
            width: 30%;

        }
        .cancel:hover,.confirm:hover{
            background-color: #248CD6;
            color: white;
            width: 30%;
            text-align: center;
        }
        .top{
            width: 90%;
            height: 20px;
            margin: 2px auto;
        }
        .top a{
            float: right;
            margin-right: 2px;
            text-decoration: none;
            color: #3A3C3D;
            opacity: 0.5;
        }
        .top a:hover{
            opacity: 1;
        }

    </style>
</head>
<body class="container">
<fieldset class="layui-elem-field layui-field-title text-center">
    <legend>手术申请</legend>
</fieldset>
<form id="defaultForm"  >
    <table class="table table-striped table-bordered">
        <tbody>
        <tr>
            <td class="text-center">
                <label for="name"  style="margin: 0; color: red;">姓名:</label>
            </td>
            <td >
                <div class="text-left">
                    <input id="name" name="name"  value="${patientLink.patient.brxm}" style="margin: 0;" class="form-control input-medium" type="text">
                </div>
            </td>
            <td ><label for="hospitalid" style="margin: 0;">住院号:</label></td>
            <td >
                <div class="text-left">
                    <input id="hospitalid" name="hospitalid"  value="${patientLink.patient.zyh}" style="margin: 0;" class="form-control input-medium" type="text">
                </div>
            </td>
            <td ><label style="margin: 0;">性别:</label></td>
            <td >
                <div class="text-left">

                    <input id="sexb" name="sex" class="form-control input-medium" type="radio" value="男"  <c:if test="${patientLink.patient.xb eq '男'}"> checked="checked"</c:if> /> 男
                    <input id="sexg" name="sex" class="form-control input-medium" type="radio" value="女" <c:if test="${patientLink.patient.xb eq '女'}"> checked="checked" </c:if> />女
                </div>
            </td>
        </tr>
        <tr>
            <td ><label for="height" style="margin: 0;">身高:</label></td>
            <td >
                <div class="text-left">
                    <input id="height" name="height" style="margin: 0;"  value="${patientLink.patient.sg}" class="form-control input-medium" type="text">
                </div>
            </td>
            <td ><label for="weight" style="margin: 0;">体重:</label></td>
            <td >
                <div class="text-left">
                    <input id="weight" name="weight"  value="${patientLink.patient.tz}"  style="margin: 0;" class="form-control input-medium" type="text">
                </div>
            </td>
            <td ><label style="margin: 0;">血型:</label></td>
            <td >
                <div class="text-left">
                    <input id="bloda1" name="blod" class="form-control input-medium" type="radio" value="A RH+" <c:if test="${patientLink.patient.xx=='A RH+'}" > checked="checked"</c:if> /> A RH+
                    <input id="bloda2" name="blod" class="form-control input-medium" type="radio" value="A RH-" <c:if test="${patientLink.patient.xx=='A RH-'}" > checked="checked"</c:if> /> A RH-
                    <input id="blodb1" name="blod" class="form-control input-medium" type="radio" value="B RH+" <c:if test="${patientLink.patient.xx=='B RH+'}" > checked="checked"</c:if> /> B RH+
                    <input id="blodb2" name="blod" class="form-control input-medium" type="radio" value="B RH-" <c:if test="${patientLink.patient.xx=='B RH-'}" > checked="checked"</c:if> /> B RH-
                </div>
                <div class="text-left">
                    <input id="blodab1" name="blod" class="form-control input-medium" type="radio" value="AB RH+" <c:if test="${patientLink.patient.xx=='AB RH+'}" > checked="checked"</c:if> /> AB RH+
                    <input id="blodab2" name="blod" class="form-control input-medium" type="radio" value="AB RH-" <c:if test="${patientLink.patient.xx=='AB RH-'}" > checked="checked"</c:if> /> AB RH-
                    <input id="blodo1" name="blod" class="form-control input-medium" type="radio" value="O RH+" <c:if test="${patientLink.patient.xx=='O RH+'}" > checked="checked"</c:if> /> O RH+
                    <input id="blodo2" name="blod" class="form-control input-medium" type="radio" value="O RH-" <c:if test="${patientLink.patient.xx=='O RH-'}" > checked="checked"</c:if> /> O RH-
                </div>
            </td>
        </tr>
        <tr>
            <td ><label for="dept"  style="margin: 0;">住院科室:</label></td>
            <td >
                <div class="text-left">
                    <select  id="dept" name="dept" onchange="setAccounts()" >
                        <option   style="margin: 0;" class="form-control input-medium"></option>
                        <c:forEach var="d" items="${configDepartmentsList}" >
                            <option value="${d.name}"  style="margin: 0;" class="form-control input-medium" <c:if test="${d.name==patientLink.patient.ksmc}" > selected="selected"</c:if>>${d.name}</option>
                        </c:forEach>
                    </select>
                    <%--<input id="dept" name="dept"  value="${patientLink.patient.ksmc}"    style="margin: 0;" class="form-control input-medium" type="text">--%>
                </div>
            </td>
            <td ><label for="bednum" style="margin: 0;">病床号:</label></td>
            <td >
                <div class="text-left">
                    <input id="bednum" name="bednum"  value="${patientLink.patient.zych}"  style="margin: 0;" class="form-control input-medium" type="text">
                </div>
            </td>
            <td ><label for="age" style="margin: 0;">年龄:</label></td>
            <td >
                <div class="text-left">
                    <input id="age" name="age"  value="${patientLink.patient.nl}"   style="margin: 0;" class="form-control input-medium" type="text">
                </div>
            </td>
        </tr>
        <tr>
            <td ><label for="applyid"  style="margin: 0;">申请单号:</label></td>
            <td >
                <div class="text-left">
                    <input id="applyid" name="applyid"   value="${patientLink.application.sssqdh}"  style="margin: 0;" class="form-control input-medium" type="password" readonly="true">
                </div>
            </td>
            <td ><label style="margin: 0;">切口类型:</label></td>
            <td  colspan="4">
                <div class="text-left">
                    <input id="incision1" name="incision" class="form-control input-medium" type="radio" value="Ⅰ" <c:if test="${patientLink.application.qklx=='Ⅰ'}" > checked="checked" </c:if> / > Ⅰ类切口
                    <input id="incision2" name="incision" class="form-control input-medium" type="radio" value="Ⅱ" <c:if test="${patientLink.application.qklx=='Ⅱ'}" > checked="checked"</c:if> /> Ⅱ类切口
                    <input id="incision3" name="incision" class="form-control input-medium" type="radio" value="Ⅲ" <c:if test="${patientLink.application.qklx=='Ⅲ'}" > checked="checked"</c:if> /> Ⅲ类切口
                    <input id="incision4" name="incision" class="form-control input-medium" type="radio" value="Ⅳ" <c:if test="${patientLink.application.qklx=='Ⅳ'}" > checked="checked"</c:if> /> Ⅳ类切口
                    <%--<input id="incision5" name="incision" class="form-control input-medium" type="radio" value="类型五" <c:if test="${patientLink.application.qklx=='类型五'}" > checked="checked"</c:if> /> 类型五--%>
                    <%--<input id="incision6" name="incision" class="form-control input-medium" type="radio" value="类型六" <c:if test="${patientLink.application.qklx=='类型六'}" > checked="checked"</c:if> /> 类型六--%>
                </div>
            </td>
        </tr>
        <tr>
            <td ><label   style="margin: 0;">手术体位:</label></td>
            <td  colspan="5">
                <div class="text-left">
                    <select id="sstw" name="sstw">
                        <option value=""></option>
                        <option value="平卧位">平卧位</option>
                        <option value="截石位">截石位</option>
                        <option value="侧卧位">侧卧位</option>
                        <option value="俯卧位">俯卧位</option>
                    </select>
                    <%--<input id="allergy" name="allergy"  value="${patientLink.patient.gms}"  style="margin: 0;" class="parent form-control" type="text">--%>
                </div>
            </td>
        </tr>
        <tr>
            <td ><label for="preoperative"  style="margin: 0;">术前诊断:</label></td>
            <td  colspan="5">
                <div class="text-left">
                    <input id="preoperative" name="preoperative"  value="${patientLink.application.sqzd1}" style="margin: 0;" class="parent form-control" type="text">
                </div>
            </td>
        </tr>
        <tr>
            <td ><label for="preoperative"  style="margin: 0;">特殊感染:</label></td>
            <td  colspan="5">
                <div class="align-self-center mx-auto bg-white text-primary">
                    <input id="hiv" name="hiv" class="form-control" type="checkbox" <c:if test="${patientLink.application.hiv=='true'}" > checked="checked" </c:if>/> HIV
                    <input id="hbv" name="hbv" class="form-control" type="checkbox" <c:if test="${patientLink.application.hbv=='true'}" > checked="checked" </c:if>/> HBV
                    <input id="hcv" name="hcv" class="form-control" type="checkbox" <c:if test="${patientLink.application.hcv=='true'}" > checked="checked" </c:if>/> HCV
                    <input id="syphilis" name="syphilis" class="form-control" type="checkbox" <c:if test="${patientLink.application.md=='true'}" > checked="checked" </c:if>/> 梅毒
                    <input id="hbsag" name="hbsag" class="form-control" type="checkbox" <c:if test="${patientLink.application.hbsag=='teue'}" > checked="checked" </c:if>/> HbsAg
                    <input id="gasgangrene" name="gasgangrene" class="form-control" type="checkbox" <c:if test="${patientLink.application.qxxh=='true'}" > checked="checked" </c:if>/> 气性坏疽
                    <input id="bacillus" name="bacillus" class="form-control" type="checkbox" <c:if test="${patientLink.application.lngj=='true'}" > checked="checked" </c:if>/> 绿农杆菌
                    <input id="infect" name="infect" class="form-control" type="checkbox" <c:if test="${patientLink.application.rdtgr=='true'}" > checked="checked" </c:if>/> 阮毒体感染
                    <input id="frozen" name="frozen" class="form-control" type="checkbox" <c:if test="${patientLink.application.tsgr=='true'}" > checked="checked" </c:if>/> 无
                    <%--<input id="paraffin" name="paraffin" class="form-control" type="checkbox" <c:if test="${patientLink.application.slbl=='true'}" > checked="checked" </c:if>/> 石蜡病理--%>
                    <%--<input id="intra" name="intra" class="form-control" type="checkbox" <c:if test="${patientLink.application.szcb=='true'}" > checked="checked" </c:if>/> 术中C臂--%>
                </div>
            </td>
        </tr>
        <tr>
            <td ><label for="pseudo"  style="margin: 0;color: red;">拟施手术:</label></td>
            <td  colspan="5">
                <div class="text-left">
                    <input id="pseudo" name="pseudo" value="${patientLink.application.nsssmc}" style="margin: 0;" class="parent form-control" type="text">
                </div>
            </td>
        </tr>
        <tr>
            <td ><label  style="margin: 0;">手术等级:</label></td>
            <td  colspan="3">
                <div class="text-left">
                    <input id="asa1" name="asa" class="form-control input-medium" type="radio" value="I" <c:if test="${patientLink.patient.ssdj=='I'}" > checked="checked" </c:if>/> 一级
                    <input id="asa2" name="asa" class="form-control input-medium" type="radio" value="II" <c:if test="${patientLink.patient.ssdj=='II'}" > checked="checked" </c:if>/> 二级
                    <input id="asa3" name="asa" class="form-control input-medium" type="radio" value="III" <c:if test="${patientLink.patient.ssdj=='III'}" > checked="checked" </c:if>/> 三级
                    <input id="asa4" name="asa" class="form-control input-medium" type="radio" value="IV" <c:if test="${patientLink.patient.ssdj=='IV'}" > checked="checked" </c:if>/> 四级
                   </div>
            </td>
            <td>
                <div class="text-left">
                    <label   style="margin: 0;">术前抗生素:</label>
                </div>
            </td>
            <td>
                <div class="text-left">
                    <input id="kss" name="kss" value="${patientLink.application.kss}"  style="margin: 0;" class="form-control input-medium" type="text">
                </div>
            </td>
        </tr>
        <tr>
            <td ><label   style="margin: 0;">主刀:</label></td>
            <td >
                <div class="text-left">

                    <select  id="mainknife" name="mainknife"  >
                        <option   style="margin: 0;" class="form-control input-medium"></option>
                        <c:forEach var="a" items="${accounts}" >
                            <option value="${a.trueName}"  style="margin: 0;" class="form-control input-medium" <c:if test="${a.id==patientLink.application.ssysxm}" > selected="selected"</c:if>>${a.trueName}</option>
                        </c:forEach>
                    </select>
                    <%--<input id="mainknife" name="mainknife"  style="margin: 0;" class="form-control input-medium" type="text">--%>
                </div>
            </td>
            <td ><label  style="margin: 0;">助手1:</label></td>
            <td >
                <div class="text-left">
                    <select  id="assitant1" name="assitant1">
                        <option   style="margin: 0;" class="form-control input-medium"></option>
                        <c:forEach var="a" items="${accounts}">
                            <%-- <c:choose>
                             <c:when test="${a.id==patientLink.application.zlysbh1}">
                                 <option value="${a.trueName}"  style="margin: 0;" class="form-control input-medium" selected="selected">${a.trueName}</option>
                             </c:when>
                             <c:otherwise>--%>
                            <option value="${a.trueName}"  style="margin: 0;" class="form-control input-medium" <c:if test="${a.id==patientLink.application.zlysbh1}" > selected="selected"</c:if> >${a.trueName}</option>
                            <%-- </c:otherwise>
                             </c:choose>--%>
                        </c:forEach>
                    </select>
                    <%--<input id="assitant1" name="assitant1" style="margin: 0;" class="form-control input-medium" type="text">--%>
                </div>
            </td>
            <td ><label  style="margin: 0;">助手2:</label></td>
            <td >
                <div class="text-left">

                    <select  id="assitant2" name="assitant2" >
                        <option   style="margin: 0;" class="form-control input-medium"></option>
                        <c:forEach var="a" items="${accounts}">
                            <option value="${a.trueName}"  style="margin: 0;" class="form-control input-medium" <c:if test="${a.id==patientLink.application.zlysbh2}" > selected="selected"</c:if>>${a.trueName}</option>
                        </c:forEach>
                    </select>
                    <%-- <input id="assitant2" name="assitant2" style="margin: 0;" class="form-control input-medium" type="text">--%>
                </div>
            </td>
        </tr>
        <tr>
            <td ><label   style="margin: 0;">助手3:</label></td>
            <td >
                <div class="text-left">
                    <select  id="assitant3" name="assitant3">
                        <option   style="margin: 0;" class="form-control input-medium"></option>
                        <c:forEach var="a" items="${accounts}">
                            <option value="${a.trueName}"  style="margin: 0;" class="form-control input-medium" <c:if test="${a.id==patientLink.application.zlysbh3}" > selected="selected"</c:if>>${a.trueName}</option>
                        </c:forEach>
                    </select>
                    <%--<input id="assitant3" name="assitant3"  style="margin: 0;" class="form-control input-medium" type="text">--%>
                </div>
            </td>
            <td ><label style="margin: 0;">申请医生:</label></td>
            <td >
                <div class="text-left">
                    <select  id="applydoctor" name="applydoctor">
                        <option   style="margin: 0;" class="form-control input-medium"></option>
                        <c:forEach var="a" items="${accounts}">
                            <option value="${a.trueName}"  style="margin: 0;" class="form-control input-medium" <c:if test="${a.id==patientLink.application.sqysbh}" > selected="selected"</c:if> >${a.trueName}</option>
                        </c:forEach>
                    </select>
                    <%--<input id="applydoctor" name="applydoctor" style="margin: 0;" class="form-control input-medium" type="text">--%>
                </div>
            </td>
            <td ><label for="applydept" style="margin: 0;">申请科室:</label></td>
            <td >
                <div class="text-left">
                    <input id="applydept" name="applydept" value="${patientLink.application.sqksmc}" style="margin: 0;" width="220" class="form-control input-medium" type="text">
                </div>
            </td>
        </tr>
        <tr>
            <td ><label for="anesthetic"  style="margin: 0;">麻醉方法:</label></td>
            <td >
                <div class="text-left">
                    <input id="anesthetic" value="${patientLink.application.mzfs}" name="anesthetic"  style="margin: 0;" class="form-control input-medium" type="text">
                </div>
            </td>
            <td ><label  style="margin: 0;">转运方式:</label></td>
            <td >
                <div class="text-left">
                    <select id="zyfs" name="zyfs">
                        <option value=""></option>
                        <option value="轮椅">轮椅</option>
                        <option value="推床">推床</option>
                        <option value="步行">步行</option>
                    </select>
                    <%--<input id="anesthetictype" value="${patientLink.application.mzlb}" name="anesthetictype" style="margin: 0;" class="form-control input-medium" type="text">--%>
                </div>
            </td>
            <td ><label style="margin: 0;color: red;">预约时间:</label></td>
            <td >
                <div class="input-group date form-inline" id="appointmentdate" style="margin: 0;">
                    <input id="appointment" name="appointment" value="${sqsj}" type='text'  style="margin: 0;" class="form-control input-medium" />
                    <span class="input-group-addon">
                <span class="glyphicon glyphicon-calendar"></span>
                </span>
                </div>
            </td>
        </tr>
        <tr>
            <td><label style="margin: 0;" for="bz">备注</label></td>
            <td  colspan="5">
                <div class="text-left">
                    <input id="bz" name="bz" value="${patientLink.schedule.bznr}" style="margin: 0;" class="parent form-control" type="text">
                </div>
            </td>
        </tr>
        <tr>
            <td  colspan="6">
                <div class="text-left form-inline">
                    <label style="width: 15px;height:10px; margin:0; background-color: red;"></label>
                    <label style="margin: 0;">为必填</label>
                </div>
            </td>
        </tr>
        </tbody>
    </table>
    <div class="form-group text-center">
        <button name="submit" id="submitd" class="btn btn-default" type="button"  onclick="chickMe()" >提交</button>
        <button style="margin-left: 30px;" name="revise" id="revise" class="btn btn-default" type="button">修改</button>
        <button style="margin-left: 30px;" name="btn_reset" id="btn_reset" class="btn btn-default" type="button">重置</button>
        <button style="margin-left: 30px;" name="unsubmit" id="unsubmit" class="btn btn-default" type="button">撤销</button>
        <button style="margin-left: 30px;" name="search" id="search" class="btn btn-default" type="button">查询</button>

    </div>
    <div class="text-center">
        <div id="d2"></div>
        <div id="d1">
            <div class="top" id="top">
                <div>提示！</div>
                <a href="javascript:void(0)" onclick="cancel()" >&#935;</a>
            </div>
            <input type="text" class="number" id="number" readonly >
            <div class="submit">
                <label class="cancel" id="cancel"  style="width: 50px;height:30px;text-align: center "> 取消</label>
                <label class="confirm"  id="submit" style="width: 50px;height:30px;text-align: center ">确定</label>
            </div>
        </div>
    </div>
    <div class="form-group text-center " style="height: 50px">
       <span  >科室名称：

            <select  id="deptc" name="deptc"  >
                <option   style="margin: 0;" class="form-control input-medium"></option>
                <c:forEach var="d" items="${configDepartmentsList}" >
                    <option value="${d.name}"  style="margin: 0;" class="form-control input-medium" <c:if test="${d.name==patientLink.patient.ksmc}" > selected="selected"</c:if>>${d.name}</option>
                </c:forEach>
            </select>
            <%--<input id="dept" name="dept"  value="${patientLink.patient.ksmc}"    style="margin: 0;" class="form-control input-medium" type="text">--%>

        <button style="margin-left: 30px;" name="search2" id="search2" class="btn btn-default" type="button">查询</button>

    </span>
    </div>

</form>
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
    <tbody id="trs">



    </tbody>
</table>
</body>
<script type="text/javascript">
    function chickMe() {
        var zyh = $("#hospitalid").val();
        if(zyh==null || zyh=="" || zyh=='undefined'){
            alert("住院号不能为空！");
            return;
        }
        var str="";

        $.ajax({
            type: "post",
            url: "<%=request.getContextPath()%>/ApplyOperationController/searchOperApply.do",
            data: {
                "zyh": zyh
            },

            success : function(result,status) {
                if (result.success)
                {

                    $("#number").css("color","green");
                    $("#number").val(result.tishi);
                    var d2=document.getElementById("d2");
                    d2.style.display="block";
                    var d1=document.getElementById("d1");
                    d1.style.display="block";
                }else{

                    $("#number").css("color","red");
                    $("#number").val(result.tishi);
                    var d2=document.getElementById("d2");
                    d2.style.display="block";
                    var d1=document.getElementById("d1");
                    d1.style.display="block";
                }
            }


        })




    }
    $("#cancel").click(function(){
        $("#d1").hide();
        $("#d2").hide();
    });
    $("#confirm").click(function(){
        console.log("您点击了确定");
    });
    function cancel() {
        var d2=document.getElementById("d2");
        d2.style.display="none";
        var d1=document.getElementById("d1");
        d1.style.display="none";


    }
    $(function () {
        $('#appointmentdate').datetimepicker({
            format: 'yyyy-mm-dd hh:ii',
            language: 'zh-CN',
            todayBtn: 'linked',
            startDate:new Date(),
            minuteStep:1,
            pickerPosition:'top-right'
        });
    });
    function setAccounts() {
        var ksmc= $("#dept option:selected").val()

        $.ajax({
            type: "post",
            url: "<%=request.getContextPath()%>/ApplyOperationController/change.do",
            data: {
                "ksmc": ksmc
            },
            success: function (result, status) {
                if (result.success) {

                    for(var i=0;i<result.accounts.length;i++){
                        var $option=$("<option  style=\"margin: 0;\" class=\"form-control input-medium\" value='"+result.accounts[i].trueName+"'>"+result.accounts[i].trueName+"</option>");
                        $("#applydoctor").append($option);
                    }

                    for(var i=0;i<result.accounts.length;i++){
                        $("#assitant1").append( "<option  style=\"margin: 0;\" class=\"form-control input-medium\" value='"+result.accounts[i].trueName+"'>"+result.accounts[i].trueName+"</option>");

                    }
                    for(var i=0;i<result.accounts.length;i++){
                        $("#assitant2").append( "<option  style=\"margin: 0;\" class=\"form-control input-medium\" value='"+result.accounts[i].trueName+"'>"+result.accounts[i].trueName+"</option>");

                    }
                    for(var i=0;i<result.accounts.length;i++){
                        $("#assitant3").append( "<option  style=\"margin: 0;\" class=\"form-control input-medium\" value='"+result.accounts[i].trueName+"'>"+result.accounts[i].trueName+"</option>");

                    }
                    for(var i=0;i<result.accounts.length;i++){
                        $("#mainknife").append( "<option  style=\"margin: 0;\" class=\"form-control input-medium\" value='"+result.accounts[i].trueName+"'>"+result.accounts[i].trueName+"</option>");

                    }

                }else{
                    $.Toast("提示", "所选择的科室没有医师！", "warning", {
                        has_icon:false,
                        has_close_btn:true,
                        fullscreen:false,
                        timeout:1000,
                        sticky:false,
                        has_progress:true,
                        rtl:false
                    });
                }
            }
        });
    };
    $("#revise").click(function (event) {
        var name = $("#name").val();
        if(name==null || name=="" || name=='undefined'){
            alert("姓名不能为空！");
            return;
        }
        var pseudo = $("#pseudo").val();
        if(pseudo==null || pseudo=="" || pseudo=='undefined'){
            alert("拟施手术不能为空！");
            return;
        }
        var appointment = $('#appointment').val();
        if(appointment==null || appointment=="" || appointment=='undefined'){
            alert("预约时间不能为空！");
            return;
        }
        $.ajax({
            type : "post",
            url : "<%=request.getContextPath()%>/ApplyOperationController/revise.do",
            data : {
                "name" : name,
                "age":$("#age").val(),
                "height":$("#height").val(),
                "weight":$("#weight").val(),
                "sex":$('input[name="sex"]:checked').val(),
                "blod":$('input[name="blod"]:checked').val(),//血型
                "dept":$("#dept").val(),
                "bednum":$("#bednum").val(),
                "hospitalid":$("#hospitalid").val(),
                "applyid":$("#applyid").val(),
                "incision":$('input[name="incision"]:checked').val(),//切口类型

                "preoperative":$("#preoperative").val(),
                "hiv":$("#hiv").is(":checked"),
                "hbv":$("#hbv").is(":checked"),
                "hcv":$("#hcv").is(":checked"),
                "syphilis":$("#syphilis").is(":checked"),
                "hbsag":$("#hbsag").is(":checked"),
                "gasgangrene":$("#gasgangrene").is(":checked"),
                "bacillus":$("#bacillus").is(":checked"),
                "infect":$("#infect").is(":checked"),
                "frozen":$("#frozen").is(":checked"),


                "pseudo":pseudo,
                "asa":$('input[name="asa"]:checked').val(),//手术等级
                "mainknife":$("#mainknife").val(),
                "assitant1":$("#assitant1").val(),
                "assitant2":$("#assitant2").val(),
                "assitant3":$("#assitant3").val(),
                "applydoctor":$("#applydoctor").val(),
                "appointment":appointment,
                "anesthetic":$("#anesthetic").val(),
                "kss":$("#kss").val(),
                "applydept":$("#applydept").val(),
                "sstw":$("#sstw").val(),
                "zyfs":$("#zyfs").val(),
                "bz":$("#bz").val(),
            },
            success : function(result,status) {
                if(result.success){
                    $.Toast("提示", "修改成功！", "success", {
                        has_icon:false,
                        has_close_btn:true,
                        fullscreen:false,
                        timeout:1000,
                        sticky:false,
                        has_progress:true,
                        rtl:false
                    });
                }else{
                    $.Toast("提示", "修改失败！", "warning", {
                        has_icon:false,
                        has_close_btn:true,
                        fullscreen:false,
                        timeout:1000,
                        sticky:false,
                        has_progress:true,
                        rtl:false
                    });
                }
            },
            error : function(e) {
                alert("请检查网络！");
            }
        });
    })
    $("#btn_reset").click(function(event) {
        $("#name").val("");
        $("#age").val("");
        $("#height").val("");
        $("#weight").val("");
        $("#sex").attr("checked",false);
        $("#blod").attr("checked",false);
        $("#dept").val("");
        $("#bednum").val("");
        $("#hospitalid").val("");
        $("#incision").attr("checked",false);

        $("#preoperative").val("");
        $("#hiv").attr("checked",false);
        $("#hbv").attr("checked",false);
        $("#hcv").attr("checked",false);
        $("#syphilis").attr("checked",false);
        $("#hbsag").attr("checked",false);
        $("#gasgangrene").attr("checked",false);
        $("#bacillus").attr("checked",false);
        $("#infect").attr("checked",false);
        $("#frozen").attr("checked",false);


        $("#pseudo").attr("checked",false);
        $("#asa").attr("checked",false);
        $("#mainknife").val("");
        $("#assitant1").val("");
        $("#assitant2").val("");
        $("#assitant3").val("");
        $("#applydoctor").val("");
        $("#anesthetic").val("");
        $("#kss").val("");
        $("#applydept").val("");
        $("#sstw").val("");
        $("#zyfs").val("");
        $("#bz").val("");

        <%--var applid=$("#applyid").val();--%>
        <%--var url ="<%=request.getContextPath()%>/ApplyOperationController/resetOperApply.do?hisid="+applid;--%>
        <%--window.location.href=url;--%>

    });

    $("#submit").click(function(event) {
   // function summitClick() {

        var d2=document.getElementById("d2");
        d2.style.display="none";
        var d1=document.getElementById("d1");
        d1.style.display="none";
        var name = $("#name").val();
        if(name==null || name=="" || name=='undefined'){
            alert("姓名不能为空！");
            return;
        }
        var pseudo = $("#pseudo").val();
        if(pseudo==null || pseudo=="" || pseudo=='undefined'){
            alert("拟施手术不能为空！");
            return;
        }
        var appointment = $('#appointment').val();
        if(appointment==null || appointment=="" || appointment=='undefined'){
            alert("预约时间不能为空！");
            return;
        }
        $.ajax({
            type : "post",
            url : "<%=request.getContextPath()%>/ApplyOperationController/submitOperApply.do",
            data : {
                "name" : name,
                "age":$("#age").val(),
                "height":$("#height").val(),
                "weight":$("#weight").val(),
                "sex":$('input[name="sex"]:checked').val(),
                "blod":$('input[name="blod"]:checked').val(),
                "dept":$("#dept").val(),
                "bednum":$("#bednum").val(),
                "hospitalid":$("#hospitalid").val(),
                "applyid":$("#applyid").val(),
                "incision":$('input[name="incision"]:checked').val(),

                "preoperative":$("#preoperative").val(),
                "hiv":$("#hiv").is(":checked"),
                "hbv":$("#hbv").is(":checked"),
                "hcv":$("#hcv").is(":checked"),
                "syphilis":$("#syphilis").is(":checked"),
                "hbsag":$("#hbsag").is(":checked"),
                "gasgangrene":$("#gasgangrene").is(":checked"),
                "bacillus":$("#bacillus").is(":checked"),
                "infect":$("#infect").is(":checked"),
                "frozen":$("#frozen").is(":checked"),

                "pseudo":pseudo,
                "asa":$('input[name="asa"]:checked').val(),
                "mainknife":$("#mainknife").val(),
                "assitant1":$("#assitant1").val(),
                "assitant2":$("#assitant2").val(),
                "assitant3":$("#assitant3").val(),
                "applydoctor":$("#applydoctor").val(),
                "appointment":appointment,
                "anesthetic":$("#anesthetic").val(),
                "kss":$("#kss").val(),
                "applydept":$("#applydept").val(),
                "sstw":$("#sstw").val(),
                "zyfs":$("#zyfs").val(),
                "bz":$("#bz").val()
            },
            success : function(result,status) {
                if(result.success){
                    $.Toast("提示", "申请成功！", "success", {
                        has_icon:false,
                        has_close_btn:true,
                        fullscreen:false,
                        timeout:1000,
                        sticky:false,
                        has_progress:true,
                        rtl:false
                    });
                }else{
                    $.Toast("提示", "提交失败！", "warning", {
                        has_icon:false,
                        has_close_btn:true,
                        fullscreen:false,
                        timeout:1000,
                        sticky:false,
                        has_progress:true,
                        rtl:false
                    });
                }
            },
            error : function(e) {
                alert("请检查网络！");
            }

        });
    });
    $("#unsubmit").click(function(event) {
        $.ajax({
            type : "post",
            url : "<%=request.getContextPath()%>/ApplyOperationController/unSubmitOperApply.do",
            data : {
                "applyid":$("#applyid").val()
            },
            success : function(result,status) {
                if(result.success){
                    $.Toast("提示", "撤销成功！", "success", {
                        has_icon:false,
                        has_close_btn:true,
                        fullscreen:false,
                        timeout:1000,
                        sticky:false,
                        has_progress:true,
                        rtl:false
                    });
                }else{
                    $.Toast("提示", "撤销失败！", "warning", {
                        has_icon:false,
                        has_close_btn:true,
                        fullscreen:false,
                        timeout:1000,
                        sticky:false,
                        has_progress:true,
                        rtl:false
                    });
                }
            },
            error : function(e) {
                alert("请检查网络！");
            }

        });
    });
    $("#search").click(function(event) {
        $.ajax({
            type : "post",
            url : "<%=request.getContextPath()%>/ApplyOperationController/search.do",
            data : {
                "brxm":$("#name").val(),

            },
            success : function(result,status) {
                if(result.success){

                    $("#trs").empty();
                    var str="";

                    for(var i=0;i<result.patientLinks.length;i++){
                        str += "<tr >" +
                            "<td>"+result.patientLinks[i].pbssjh+"</td>"+
                            "<td>"+result.patientLinks[i].nameN+"</td>"+
                            "<td>"+result.patientLinks[i].xb+"</td>"+
                            "<td>"+result.patientLinks[i].nln+"</td>"+
                            "<td>"+result.patientLinks[i].ksmc+"</td>"+
                            "<td>"+result.patientLinks[i].zyh+"</td>"+
                            "<td>"+result.patientLinks[i].sqzd+"</td>"+
                            "<td>"+result.patientLinks[i].nss+"</td>"+
                            "<td>"+result.patientLinks[i].ssys+"</td>"+
                            "<td>"+result.patientLinks[i].sssqrq+"</td>"+
                            "<td>"+result.patientLinks[i].zt+"</td>"+
                            "<td ><button style=\"margin-left: 30px;\"  class=\"btn btn-default\" type=\"button\" onclick='getIdClick(\""+result.patientLinks[i].id+"\")'>撤销</button></td>"+
                            "</tr>";
                    }
                    $("#trs").append(str);

                    console.log(str);
                }else{
                    $.Toast("提示", "查询失败！", "warning", {
                        has_icon:false,
                        has_close_btn:true,
                        fullscreen:false,
                        timeout:1000,
                        sticky:false,
                        has_progress:true,
                        rtl:false
                    });
                }
            },
            error : function(e) {
                alert("请检查网络！");
            }

        });
    });
    $("#search2").click(function(event) {
        var ksmc= $("#deptc option:selected").val()
        $.ajax({
            type : "post",
            url : "<%=request.getContextPath()%>/ApplyOperationController/search2.do",
            data : {
                "ksmc":ksmc
            },
            success : function(result,status) {
                if(result.success){

                    $("#trs").empty();
                    var str="";

                    for(var i=0;i<result.patientLinks.length;i++){
                        str += "<tr >" +
                            "<td>"+result.patientLinks[i].pbssjh+"</td>"+
                            "<td>"+result.patientLinks[i].nameN+"</td>"+
                            "<td>"+result.patientLinks[i].xb+"</td>"+
                            "<td>"+result.patientLinks[i].nln+"</td>"+
                            "<td>"+result.patientLinks[i].ksmc+"</td>"+
                            "<td>"+result.patientLinks[i].zyh+"</td>"+
                            "<td>"+result.patientLinks[i].sqzd+"</td>"+
                            "<td>"+result.patientLinks[i].nss+"</td>"+
                            "<td>"+result.patientLinks[i].ssys+"</td>"+
                            "<td>"+result.patientLinks[i].sssqrq+"</td>"+
                            "<td>"+result.patientLinks[i].zt+"</td>"+
                            "<td ><button style=\"margin-left: 30px;\"  class=\"btn btn-default\" type=\"button\" onclick='getIdClick(\""+result.patientLinks[i].id+"\")'>撤销</button></td>"+
                            "</tr>";
                    }
                    $("#trs").append(str);

                    console.log(str);
                }else{
                    $.Toast("提示", "查询失败！", "warning", {
                        has_icon:false,
                        has_close_btn:true,
                        fullscreen:false,
                        timeout:1000,
                        sticky:false,
                        has_progress:true,
                        rtl:false
                    });
                }
            },
            error : function(e) {
                alert("请检查网络！");
            }

        });
    });
    function getIdClick(id) {

        $.ajax({
            type : "post",
            url : "<%=request.getContextPath()%>/ApplyOperationController/unSubmitOperApply.do",
            data : {
                "applyid":id,
            },
            success : function(result,status) {
                if(result.success){
                    $.Toast("提示", "撤销成功！", "success", {
                        has_icon:false,
                        has_close_btn:true,
                        fullscreen:false,
                        timeout:1000,
                        sticky:false,
                        has_progress:true,
                        rtl:false
                    });
                }else{
                    $.Toast("提示", "撤销失败！", "warning", {
                        has_icon:false,
                        has_close_btn:true,
                        fullscreen:false,
                        timeout:1000,
                        sticky:false,
                        has_progress:true,
                        rtl:false
                    });
                }
            },
            error : function(e) {
                alert("请检查网络！");
            }

        });
    }
</script>
</html>