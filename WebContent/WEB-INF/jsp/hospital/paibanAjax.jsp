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
<title>${Hospital }</title>
<base href="<%=basePath%>">
<link href="<%=request.getContextPath()%>/assets/css/bootstrap.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/css/bootstrap-table-daping.css"
	rel="stylesheet" />
<script src="<%=request.getContextPath()%>/js/jquery/jquery-1.9.1.js"></script>
<script
	src="<%=request.getContextPath()%>/js/bootstrap/bootstrap-table-daping.js"></script>
<script
	src="<%=request.getContextPath()%>/js/bootstrap/bootstrap-table-daping-zh-CN.js"></script>
</head>
<body style="height: 768px; margin: 0; background-color: #3691da; color: #ffffff">
<%--<body style="height: 768px; margin: 0; background-color: #ffffff; color: #000000">--%>
	<div class=".container-fluid">
		<div
			style="background-color: #3691da; color: #ffffff; height: 768px; width: 100%;">
			<%--style="background-color: #ffffff; color: #000000; height: 768px; width: 100%;">--%>
				<div class="col-md-12 column"
				style="font-size: 300%; width: 100%; margin-top: 30px; margin-bottom: 50px;">
				<span onclick="uppage()">${Hospital }</span>
					<span style="color: black;font-size: 30px">
					<select onchange="setDept()" id="dept">

						 <option   style="margin: 0;" class="form-control input-medium" value="" selected="selected">请选择科室</option>
                        <c:forEach var="d" items="${configDepartmentsList}" >
							<option value="${d.name}"  style="margin: 0;" class="form-control input-medium" >${d.name}</option>
						</c:forEach>
					</select>
				</span>
				<span
					style="margin-left: 2%" onclick="downpage()">手术排班</span> <span
					id="show" style="float: right;"></span>
			</div>
			<div style="width: 100%; font-size: 25px;">
				<table id="table"></table>
				<script type="text/javascript">
				window.onload = function() {
				    var dept=$("#dept option:selected").val();
					 $('#table').bootstrapTable(getData(0,dept));
					 changecolor();
					 $("#page").val(0);
				     setInterval(function() {
						var time = new Date();
						// 程序计时的月从0开始取值后+1
						var m = time.getMonth() + 1;
						var t = time.getFullYear() + "-" + m + "-" + time.getDate() + " "
								+ time.getHours() + ":" + time.getMinutes() + ":"
								+ time.getSeconds();
						$("#show").text(t);
					}, 1000);
				    
				    setInterval(function() {
                        var dept=$("#dept option:selected").val();
				    	 var i= Number($("#page").val());
						 $('#table').bootstrapTable("load",getData(i+1,dept));
						 if($("#count").val()/8 >i+1){
							 $("#page").val(i+1);
						 }else{
							 $("#page").val(0);
						 }	
						 changecolor();
						 }, 15*1000);  
				    
				    setInterval(function() {
				    	  window.location.href="<%=request.getContextPath()%>/commandController/paibanA.do";			 
						 }, 2*60*1000);
				}
				
				</script>
			</div>
			<div class="clearfix"></div>
			<div style="width: 100%; font-size: 50px; margin-top: 30px;">
				<marquee id="pao" behavior=alternate direction=left></marquee>
			</div>
			<div hidden>
				<input id="page" value="${page }"><input id="count" value="">
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">

function uppage(){
    var dept=$("#dept option:selected").val();
	 var i= Number($("#page").val());
	 $('#table').bootstrapTable("load",getData(i-1,dept));
	 if(i<=0){
		 $("#page").val(0);
	 }else{
		 $("#page").val(i-1);
	 }
	 changecolor();
	 }
function downpage(){
    var dept=$("#dept option:selected").val();
	 var i= Number($("#page").val());
	 $('#table').bootstrapTable("load",getData(i+1,dept));
	 if($("#count").val()/8 >i+1){
		 $("#page").val(i+1);
	 }else{
		 $("#page").val(0);
	 }
	 changecolor();
	}


function getData(pageNum,dept) {
	var i = pageNum;
    var json={"pageNum":i};
    var json1=JSON.stringify(json);
    var json2=encodeURIComponent(json1);
    var url1 = "<%=request.getContextPath()%>/commandController/paibanAjax.do?data="+ json2+"&&dept="+dept;
		var columnss = new Array();
		var datas = new Array();
		$.ajax({
			type : "GET",
			url : url1,
			dataType : "json",
			async : false,
			success : function(data) {
				$("#pao").text(data.paiBanTable.notice);
				$("#page").val(data.page);
				$("#count").val(data.count);
				if (data.paiBanTable.shijian) {
					var ss = {
						field : 'shijian',
						title : '时间'
					};
					columnss.push(ss);
				}
				if (data.paiBanTable.xingming) {
					ss = {
						field : 'xingming',
						title : '姓名'
					};
					columnss.push(ss);
				}
				if (data.paiBanTable.bingshi) {
					ss = {
						field : 'bingshi',
						title : '病室'
					};
					columnss.push(ss);
				}
				if (data.paiBanTable.nianling) {
					ss = {
						field : 'nianling',
						title : '年龄'
					};
					columnss.push(ss);
				}
				if (data.paiBanTable.xingbie) {
					ss = {
						field : 'xingbie',
						title : '性别'
					};
					columnss.push(ss);
				}
				if (data.paiBanTable.shoushuneirong) {
					ss = {
						field : 'shoushuneirong',
						title : '手术名称'
					};
					columnss.push(ss);
				}
				if (data.paiBanTable.shoushujian) {
					ss = {
						field : 'shoushujian',
						title : '手术间'
					};
					columnss.push(ss);
				}
				if (data.paiBanTable.huangtai) {
					ss = {
						field : 'huangtai',
						title : '状态'
					};
					columnss.push(ss);
				}
				if (data.paiBanTable.mazuifangfa) {
					ss = {
						field : 'mazuifangfa',
						title : '麻醉方式'
					};
					columnss.push(ss);
				}
				if (data.paiBanTable.shoushuzhe) {
					ss = {
						field : 'shoushuzhe',
						title : '主刀医生'
					};
					columnss.push(ss);
				}
				if (data.paiBanTable.mazuizhe) {
					ss = {
						field : 'mazuizhe',
						title : '麻醉医师'
					};
					columnss.push(ss);
				}
				
				if (data.paiBanTable.hushi) {
					ss = {
						field : 'xhhs',
						title : '巡回护士 '
					};
					columnss.push(ss);
						
				}
				if (data.paiBanTable.hushi) {
					ss = {
						field : 'xshs',
						title : '洗手护士 '
					};
					columnss.push(ss);
						
				}
				for ( var i in data.data) {
					var da = new Object();
					if (data.paiBanTable.shijian) {
						da.shijian = data.data[i].planTime;
					}
					if (data.paiBanTable.shoushujian) {
						da.shoushujian = data.data[i].openRoom;
					}
					if (data.paiBanTable.xingming) {
						da.xingming = data.data[i].bename;
					}
					if (data.paiBanTable.xingbie) {
						da.xingbie = data.data[i].sex;
					}
					if (data.paiBanTable.bingshi) {
						da.bingshi = data.data[i].bingshi;
					}
					if (data.paiBanTable.nianling) {
						da.nianling = data.data[i].strAge;
					}

					if (data.paiBanTable.shoushuneirong) {
						da.shoushuneirong = data.data[i].shoushuName1;
					}
					if (data.paiBanTable.shoushuzhe) {
						da.shoushuzhe = data.data[i].operDoctor1;
					}
					if (data.paiBanTable.mazuifangfa) {
						da.mazuifangfa = data.data[i].mazuiMethod;
					}

					if (data.paiBanTable.mazuizhe) {
						da.mazuizhe = data.data[i].mazuiDoc1;
					}
					if (data.paiBanTable.huangtai) {
						da.huangtai = data.data[i].flag;
					}

					if (data.paiBanTable.mazuitype) {
						da.mazuitype = data.data[i].mazuiMethod;
					}
					if (data.paiBanTable.hushi) {
						da.xhhs = data.data[i].xhhs;
						
					}
					if (data.paiBanTable.hushi) {
						da.xshs = data.data[i].xshs;
						
					}
					datas[i] = da;

				}

			}
		});
		var opt = {
			columns : columnss,
			data : datas,
		};

		return opt;
	}
function changecolor(){
	 $("td").each(function(i){
	    	/* if($(this).text()=="手术中"){
	    		this.style.color=["red"]
	    	} */
	    	if($(this).text()=="手 术 前"){
	    		this.style.color=["red"]
	    	}
	    	/* if($(this).text()=="出手术间"){
	    		this.style.color=["#000000"]
	    	} */
	    	/* if($(this).text()=="手术结束"){
	    		this.style.color=["#00FF00"]
	    	} */
	    });
}
	function setDept() {
		var dept=$("#dept option:selected").val();
        var i= Number($("#page").val());
        $('#table').bootstrapTable("load",getData(i-1,dept));
        if(i<=0){
            $("#page").val(0);
        }else{
            $("#page").val(i-1);
        }
        changecolor();
	}
function getData2(pageNum,dept) {
    var i = pageNum;
    var json={"pageNum":i};
    var json1=JSON.stringify(json);
    var json2=encodeURIComponent(json1);
    var url1 = "<%=request.getContextPath()%>/commandController/paibanDeptAjax.do?data="+ json2+"&&dept="+dept;
    var columnss = new Array();
    var datas = new Array();
    $.ajax({
        type : "GET",
        url : url1,
        dataType : "json",
        async : false,
        success : function(data) {
            $("#pao").text(data.paiBanTable.notice);
            $("#page").val(data.page);
            $("#count").val(data.count);
            alert(data.count);
            alert("接收成功"+data.data[0].bename);
            if (data.paiBanTable.shijian) {
                var ss = {
                    field : 'shijian',
                    title : '时间'
                };
                columnss.push(ss);
            }
            if (data.paiBanTable.xingming) {
                ss = {
                    field : 'xingming',
                    title : '姓名'
                };
                columnss.push(ss);
            }
            if (data.paiBanTable.bingshi) {
                ss = {
                    field : 'bingshi',
                    title : '病室'
                };
                columnss.push(ss);
            }
            if (data.paiBanTable.nianling) {
                ss = {
                    field : 'nianling',
                    title : '年龄'
                };
                columnss.push(ss);
            }
            if (data.paiBanTable.xingbie) {
                ss = {
                    field : 'xingbie',
                    title : '性别'
                };
                columnss.push(ss);
            }
            if (data.paiBanTable.shoushuneirong) {
                ss = {
                    field : 'shoushuneirong',
                    title : '手术名称'
                };
                columnss.push(ss);
            }
            if (data.paiBanTable.shoushujian) {
                ss = {
                    field : 'shoushujian',
                    title : '手术间'
                };
                columnss.push(ss);
            }
            if (data.paiBanTable.huangtai) {
                ss = {
                    field : 'huangtai',
                    title : '状态'
                };
                columnss.push(ss);
            }
            if (data.paiBanTable.mazuifangfa) {
                ss = {
                    field : 'mazuifangfa',
                    title : '麻醉方式'
                };
                columnss.push(ss);
            }
            if (data.paiBanTable.shoushuzhe) {
                ss = {
                    field : 'shoushuzhe',
                    title : '主刀医生'
                };
                columnss.push(ss);
            }
            if (data.paiBanTable.mazuizhe) {
                ss = {
                    field : 'mazuizhe',
                    title : '麻醉医师'
                };
                columnss.push(ss);
            }

            if (data.paiBanTable.hushi) {
                ss = {
                    field : 'xhhs',
                    title : '巡回护士 '
                };
                columnss.push(ss);

            }
            if (data.paiBanTable.hushi) {
                ss = {
                    field : 'xshs',
                    title : '洗手护士 '
                };
                columnss.push(ss);

            }
            alert(data.count);
            for ( var i in data.data) {
                var da = new Object();
                if (data.paiBanTable.shijian) {
                    da.shijian = data.data[i].planTime;
                }
                if (data.paiBanTable.shoushujian) {
                    da.shoushujian = data.data[i].openRoom;
                }
                if (data.paiBanTable.xingming) {
                    da.xingming = data.data[i].bename;
                }
                if (data.paiBanTable.xingbie) {
                    da.xingbie = data.data[i].sex;
                }
                if (data.paiBanTable.bingshi) {
                    da.bingshi = data.data[i].bingshi;
                }
                if (data.paiBanTable.nianling) {
                    da.nianling = data.data[i].strAge;
                }

                if (data.paiBanTable.shoushuneirong) {
                    da.shoushuneirong = data.data[i].shoushuName1;
                }
                if (data.paiBanTable.shoushuzhe) {
                    da.shoushuzhe = data.data[i].operDoctor1;
                }
                if (data.paiBanTable.mazuifangfa) {
                    da.mazuifangfa = data.data[i].mazuiMethod;
                }

                if (data.paiBanTable.mazuizhe) {
                    da.mazuizhe = data.data[i].mazuiDoc1;
                }
                if (data.paiBanTable.huangtai) {
                    da.huangtai = data.data[i].flag;
                }

                if (data.paiBanTable.mazuitype) {
                    da.mazuitype = data.data[i].mazuiMethod;
                }
                if (data.paiBanTable.hushi) {
                    da.xhhs = data.data[i].xhhs;

                }
                if (data.paiBanTable.hushi) {
                    da.xshs = data.data[i].xshs;

                }
                datas[i] = da;

            }

        }
    });
    var opt = {
        columns : columnss,
        data : datas,
    };

    return opt;
}
</script>
</html>