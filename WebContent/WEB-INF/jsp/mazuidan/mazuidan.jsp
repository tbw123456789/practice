
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%-- <%@ include file="../../../common/common_css.jsp"%>
<%@ include file="../../../common/common_js.jsp"%> --%>
<link rel="stylesheet" href="${ctx }/css/layer.css" />
<link rel="stylesheet" href="${ctx }/css/jquery.datetimepicker.css" />
<script src="${ctx }/js/highcharts/highcharts.js"></script>
<script src="${ctx }/js/highcharts/exporting.js"></script>
<script src="${ctx }/js/highcharts/series-label.js"></script>
<script src="${ctx }/js/highcharts/highcharts-zh_CN.js"></script>
<script src="${ctx }/js/highcharts/oldie.js"></script>
<script src="${ctx }/js/other/Draggablepoints.js"></script>
<script src="${ctx }/js/jquery/jquery-1.9.1.js"></script>
<script src="${ctx }/js/jquery/jquery.min.js"></script>
<script src="${ctx }/js/layer/layer.js"></script>
<script src="${ctx }/js/jquery/jquery.datetimepicker.js"></script>
<script src="${ctx }/js/jquery/jquery.dataTables.js"></script>
<script src="${ctx }/js/jquery/jquery.dataTables.bootstrap.js"></script>
<script src="${ctx }/js/jquery/jquery.js"></script>


<script type="text/javascript">
	function stringify(json, space) {
		if (typeof (space) == 'undefined') {
			return JSON.stringify(json);
		} else {
			return JSON.stringify(json, undefined, 2);
		}
	}
</script>
<style type="text/css">
#title {
	width: 100%;
	text-align: center;
	height: 60px;
	font-size: 40px;
}

#main {
	margin: auto;
	width: 1090px;
	border: 1px solid black;
}

#basemessage {
	/* padding: 10px;
	 */
	width: 100%;
	height: 155px;
	background-color: white;
	border-bottom: 1px solid black;
}

#jilu {
	width: 100%;
	height: 500px;
	background-color: white;
	border-bottom: 1px solid black;
}

#yongyao {
	width: 100%;
	height: 100px;
	background-color: white;
	border-bottom: 1px solid black;
}

#shuye {
	width: 100%;
	height: 100px;
	background-color: white;
	border-bottom: 1px solid black;
}

#shijian {
	width: 100%;
	height: 150px;
	background-color: white;
	border-bottom: 1px solid black;
}

#churuliang {
	width: 100%;
	height: 80px;
	background-color: white;
	border-bottom: 1px solid black;
}

#churuliang_left {
	float: left;
	height: 80px;
	width: 20px;
	display: -webkit-flex;
	align-items: center;
	padding-left: 2px;
	border-right: 1px solid black;
}

#biaoji {
	width: 100%;
	height: 30px;
	background-color: white;
	border-bottom: 1px solid black;
}

#chixuyongyao {
	float: left;
	height: 100px;
	width: 20px;
	display: -webkit-flex;
	align-items: center;
	padding-left: 2px;
	border-right: 1px solid black;
}

#shuxueshuye {
	float: left;
	height: 100px;
	width: 20px;
	display: -webkit-flex;
	align-items: center;
	padding-left: 2px;
	border-right: 1px solid black;
}

#mazuizhongshijian {
	float: left;
	width: 20px;
	height: 150px;
	padding-left: 2px;
	display: -webkit-flex;
	align-items: center;
	border-right: 1px solid black;
}

#churuliang_right {
	padding-top: 3px;
	float: left;
	padding-left: 5px;
}

#zongjie {
	width: 100%;
	padding-top: 10px;
	height: 190px;
	background-color: white;
	border-bottom: 1px solid black;
}

#message {
	padding-top: 5px;
	width: 100%;
	height: 50px;
	background-color: white;
}

.radio_type {
	width: 15px;
	padding-top: 5px;
	margin-left: 2px;
	line-height: 5px;
}

#basemessage_left {
	float: left;
	padding-left: 5px;
}

#basemessage_right {
	float: left;
	border-left: 1px solid black;
	padding-left: 5px;
}

#basemessage_button {
	padding-left: 5px;
}

input.text_type {
	width: 45px;
	height: 20px;
	margin-right: 5px;
	border: none;
	border-bottom: 1px solid black;
}

input.text_dtype {
	width: 50px;
	height: 20px;
	margin-right: 5px;
	border: none;
	border-bottom: 1px dashed black;
}
</style>
<script type="text/javascript">
	var value = '';
	var chart = null;
	$
			.ajax({
				type : "GET",
				url : "http://172.16.16.46:8080/SPMVC/mazuidanController/getAnalogData.do",
				async : false,
				success : function(data) {
					value = data;
				},
				error : function() {
					console.log("获取数据错误!!!!!error!");
				}
			});
	$(function() {
		Highcharts.setOptions({
			global : {
				useUTC : false
			// true
			}
		});
		chart = Highcharts.chart('container', {
			title : {
				text : '麻醉单'
			},
			chart : {
				style : {
					fontFamily : '\微软雅黑\, Arial, Helvetica, sans-serif',
					color : '#333',
					fontSize : '12px',
					fontWeight : 'normal',
					fontStyle : 'normal'
				},
				borderRadius : 11,
				borderWidth : 0,
				inverted : false,
				type : 'line',
				height : 500,
				width : 900,
			},
			xAxis : [ {
				type : 'datetime',
				opposite : true,
				reversed : false,
				labels : {
					format : '{value:%H:%M}'
				},
				index : 0,
				isX : true,
				gridLineColor : 'black',
				gridLineWidth : 2,
				max : value.mazuiEndTime,
				minorTickInterval : 'auto',
				minorGridLineColor : 'black',
				minorGridLineDashStyle : 'ShortDash',
			} ],
			yAxis : [ {
				title : {
					text : 'mmhg',
				},
				max : 280,
				min : 0,
				minorGridLineColor : 'black',
				minorTickInterval : 'auto',
				minorGridLineDashStyle : 'ShortDash',
				gridLineColor : 'black',
				gridLineWidth : 2,
			}, {
				title : {
					text : '温度℃',
				},
				max : 46,
				min : 20,
			}, {
				title : {
					text : ''
				},
				max : 0,
				min : -999999,
				labels : {
					enabled : false
				}
			} ],
			legend : {
				layout : 'vertical',
				align : 'right',
				verticalAlign : 'middle'
			},
			plotOptions : {
				series : {
					pointStart : value.mazuiNowTime, // 开始值
					pointInterval : 5 * 60 * 1000,
				},
			},
			series : value.data,
			tooltip : {
				formatter : function() {
					var vlaue = this.y;
					if (this.series.name == '体温') {
						vlaue = vlaue.toFixed(1);
						setBedsideData(vlaue, this.x, this.colorIndex);
						return this.series.name + ':' + vlaue + '℃';
					} else {
						vlaue = vlaue.toFixed(0);
						setBedsideData(vlaue, this.x, this.colorIndex);
						return this.series.name + ':' + vlaue;
					}
				},
			},
			responsive : {
				rules : [ {
					condition : {
						maxWidth : 500
					}
				} ]
			}
		});
		var i = 10;
		$('#button').click(function() {
			console.log("button");
			if (i % 2 == 0) {
				chart.series[0].show();
			} else {
				chart.series[0].hide();
			}
			i++;
		});
	})

	$('#button1').click(function() {
		chart.series[0].series.show();
	});

	function setBedsideData(intval, time, colorIndex) {
		var time = (time - value.mazuiNowTime) / 300000;
		var ider = value.data[colorIndex].data[time];

		if (intval == ider) {
			console.log("没事没事");
		} else {
			var url = "http://172.16.16.46:8080/SPMVC/mazuidanController/setBedsideData/"
					+ intval + "/" + time + "/" + colorIndex + ".do";
			console.log(url);
			$.ajax({
				type : "GET",
				url : url,
				async : false,
				success : function(data) {
					console.log(data);
					value.data[colorIndex].data[time] = intval;
					console.log("success!");
				},
				error : function() {
					console.log("error!");
				}
			});
		}
	};
	function parameter() {
		layer
				.open({
					type : 2,
					fixed : true,
					offset : [ '50px', '100px' ],
					area : [ '550px', '330px' ],
					shadeClose : true,
					closeBtn : true,
					content : 'http://172.16.16.46:8080/SPMVC/mazuidanController/parameter.do'
				});
	};

	function update(id, time, data) {
		var ser = chart.get(id);
		var dataId = (time - value.mazuiNowTime) / 300000;
		ser.data[dataId].update(data);
	}

	var time = value.mazuiNowTime + value.data[0].data.length * 300000;
	var getBedsideRegularly = self.setInterval("clock(" + time + ")", 5000);
	function clock(time) {
		var operationId = 1;
		time = value.mazuiNowTime + value.data[0].data.length * 300000;
		if (time == value.mazuiEndTime) {
			getBedsideRegularly = window.clearInterval(getBedsideRegularly)
		}
		$
				.ajax({
					type : "GET",
					url : "http://172.16.16.46:8080/SPMVC/mazuidanController/getBedsideRegularly/"
							+ time + "/" + operationId + ".do",
					async : false,
					success : function(data) {
						var bedsideList = data.data;
						bedsideList.forEach(function(bedside) {
							chart.get(bedside.code).addPoint(bedside.intVal);
						});
					},
					error : function() {
						console.log("error!");
					}
				});
	}

	function addEvent() {
		layer.open({
			closeBtn : 0,
			type : 1,
			// fixed:true,
			title : '新增公告',
			area : [ '550px', '330px' ],
			shadeClose : true,
			closeBtn : true,
			content : '${ctx }/mazuidanController/mazuidanAddEvent.do', //目标
		});
	};

	//(打开弹出层)
	function addQuestion() {
		var index = layer.open({
			type : 2, //弹出层类型     
			maxmin : true, //开启最大化最小化按钮
			title : '新增公告',
			fixed : true,
			shade : 0.8, //遮罩
			area : [ '100px', '100px' ], //弹出层大小
			content : '${ctx }/mazuidanController/mazuidanAddEvent.do', //目标
			end : function() { //结束时方法
				location.reload();
			},
			cancel : function(index, layero) {
				if (ifrclose(index)) {
					layer.close(index)
				}
				return false;
			}
		});
	}
	//layer弹出层关闭方法
	function ifrclose(i) {
		layer.confirm('确认要关闭吗？未保存的数据将丢失！', {
			icon : 3,
			btn : [ '确认', '取消' ]
		//按钮
		}, function(index, layero) {
			layer.close(index);
			layer.close(i);

		}, function(index, layero) {
			layer.close(index);
		});
	}
</script>
</head>
<body>
	<div id="title">
		重庆妇幼保健院
		<button onclick="addEvent()">dfaf1d</button>
	</div>
	<div id="main">
		<div id="basemessage">
			<div>
				<div id="basemessage_left">
					<label>姓名:</label> <input type="text" id="name" class="text_type">
					<label>性别:</label><input type="text" id="sex" class="text_type">
					<label>年龄:</label><input type="text" id="age" class="text_type">
					<label>体重:</label><input type="text" id="weight" class="text_type">
					<label>身高:</label><input type="text" id="height" class="text_type">
					<label>医疗费:</label><input type="text" id="yiliaofei"
						class="text_type" style="width: 70px;"><br> <label>病室:</label><input
						type="text" id="bingshi" class="text_type" style="width: 180px;">
					<label>床号:</label><input type="text" id="chuanghao"
						class="text_type"> <label>住院号:</label><input type="text"
						id="zhuyuanhao" class="text_type" style="width: 195px;"><br>
					<label>NNIS:</label><input type="text" id="NNIS" class="text_type">
					<label>NYHA:</label><input type="text" id="NYHA" class="text_type">
					<label>血型:</label><input type="text" id="blood" class="text_type">
					<label>麻醉前用药:</label><input type="text" class="text_type"
						style="width: 200px;" id="mazuiqianyongyao"><br> <label>手术体位:</label><input
						type="text" class="text_type" style="width: 285px;"
						id="shoushutiwei"> <label>ASA:</label><input type="text"
						class="text_type" id="ASA"> <label>择期:</label><input
						type="radio" name="menzhenfangshi" class="radio_type"> <label>急诊:</label><input
						type="radio" name="menzhenfangshi" class="radio_type"><br>
					<label>麻醉方式:</label><input type="text" class="text_type"
						style="width: 490px;" id="mazuifangshi">
				</div>
				<div id="basemessage_right">
					<label>手术日期:</label><input type="text" class="text_type"
						style="width: 120px;" id="shoushuriqi"> <label
						style="margin-left: 30px;">手术间号:</label><input type="text"
						class="text_type" style="width: 120px;" id="shoushujianhao">
					<label style="margin-left: 25px;">第1页/第10页</label><br> <label>术前禁食:</label>
					<input type="radio" name="shuqianjinshi" class="radio_type">是
					<input type="radio" name="shuqianjinshi" class="radio_type">否
					<label style="margin-left: 30px;">非计划性二次手术:</label> <input
						type="radio" name="ercishoushu" class="radio_type">是 <input
						type="radio" name="ercishoushu" class="radio_type">否 <label
						style="margin-left: 30px;">困难气道分级:</label> <select id="qidaofenji">
						<option>Ⅰ</option>
						<option>Ⅱ</option>
						<option>Ⅲ</option>
						<option>Ⅳ</option>
						<option>Ⅴ</option>
						<option>Ⅵ</option>
					</select><br> <label>反流危险性:</label> <input type="radio"
						name="fanliuweixianxing" class="radio_type">高 <input
						type="radio" name="fanliuweixianxing" class="radio_type">中
					<input type="radio" name="fanliuweixianxing" class="radio_type">低
					<label style="margin-left: 140px">POVN:</label> <input type="radio"
						name="POVN" class="radio_type">高危 <input type="radio"
						name="POVN" class="radio_type">中危 <input type="radio"
						name="POVN" class="radio_type">低危 <br> <label>特殊情况:</label>
					<textarea id="teshuqingkuang"
						style="overflow-y: hidden; resize: none; width: 450px; height: 40px;"></textarea>
				</div>
			</div>
			<div class="clearfix"></div>
			<div>
				<div id="basemessage_button">
					<label>术前诊断:</label><input type="text" class="text_type"
						style="width: 1015px;" id="shuqianzhenduan"> <br> <label>拟行手术:</label><input
						type="text" class="text_type" style="width: 1015px;"
						id="nixingshoushu">
				</div>
			</div>
		</div>
		<div class="clearfix"></div>
		<div id="jilu">
			<div id="container" style="height: 500px"></div>
			<div>
				<button id="button" class="autocompare">显示</button>
				<button id="button1" class="autocompare">添加点</button>
				<button id="parameter" class="autocompare" onclick="parameter()">参数</button>
			</div>
		</div>
		<div class="clearfix"></div>
		<div id="biaoji"></div>
		<div id="yongyao">
			<div id="chixuyongyao">持续用药</div>
		</div>
		<div id="shuye">
			<div id="shuxueshuye">输血输液</div>
			<div>

				<div id="testDiv">放在我上面</div>
				<script type="text/javascript">
					$('#testDiv').mousemove(
							function(e) {
								var xx = e.originalEvent.x
										|| e.originalEvent.layerX || 0;
								var yy = e.originalEvent.y
										|| e.originalEvent.layerY || 0;
								$(this).text(xx + '---' + yy);
							});
				</script>
			</div>
		</div>
		<div id="shijian">
			<div id="mazuizhongshijian">手术中麻醉事件</div>
			<div
				style="float: left; width: 25%; padding-left: 5px; padding-top: 5px;">
				<button>单次用药</button>
				<button>事件</button>
				<br>
			</div>
			<div style="float: left; width: 25%"></div>
			<div style="float: left; width: 25%"></div>
			<div style="float: left; width: 25%"></div>
		</div>
		<div id="churuliang">
			<div id="churuliang_left">出入量</div>
			<div id="churuliang_right">
				<label>N.S</label><input type="text" class="text_dtype" id="NS"><label>ml&nbsp;&nbsp;</label>
				<label>G.S</label><input type="text" class="text_dtype" id="GS"><label>ml&nbsp;&nbsp;</label>
				<label>胶体液</label><input type="text" class="text_dtype"
					id="jiaotiye"><label>ml&nbsp;</label> <label>平衡液</label><input
					type="text" class="text_dtype" id="pinghengye"><label>ml
					&nbsp;&nbsp;</label> <label>冷沉淀</label><input type="text"
					class="text_dtype" id="lengchenye"><label>ml
					&nbsp;&nbsp;</label> <label>碳酸氢钠</label><input type="text"
					class="text_dtype" id="tansuanqingna"><label>ml
					&nbsp;&nbsp;</label> <label>红细胞悬液</label><input type="text"
					class="text_dtype" id="hongxibaoxuanye"><label>ml
					&nbsp;&nbsp;</label> <label>血浆</label><input type="text" class="text_dtype"
					id="xuejiang"><label>ml &nbsp;&nbsp;</label><br> <label>甘露醇</label><input
					type="text" class="text_dtype" id="ganluchun"><label>ml&nbsp;&nbsp;</label>
				<label>其他</label><input type="text" class="text_dtype"
					style="width: 760px;" id="qita"> <label>总入量</label><input
					type="text" class="text_dtype" id="zongruliang"><label>ml&nbsp;&nbsp;</label><br>
				<label>失血量</label><input type="text" class="text_dtype"
					id="shixueliang"><label>ml&nbsp;&nbsp;</label> <label>出血量</label><input
					type="text" class="text_dtype" id="chuxueliang"><label>ml&nbsp;&nbsp;</label>
				<label>尿量</label><input type="text" class="text_dtype"
					id="niaoliang"><label>ml&nbsp;&nbsp;</label> <label>其他</label><input
					type="text" class="text_dtype" style="width: 510px;" id="oher">
				<label>总出量</label><input type="text" class="text_dtype"
					id="zongchuliang"><label>ml&nbsp;&nbsp;</label>
			</div>
		</div>
		<div class="clearfix"></div>
		<div id="zongjie">
			<div style="margin-left: 10px;">
				<label>监测与治疗:</label> <input type="checkbox"> <label>动脉穿刺&nbsp;&nbsp;</label>
				<input type="checkbox"> <label>血气分析</label> <select>
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
					<option>6</option>
					<option>7</option>
					<option>8</option>
					<option>9</option>
					<option>10</option>
				</select> <input type="checkbox"><label>中心静脉穿刺&nbsp;&nbsp;</label> <input
					type="checkbox"><label>漂浮导管&nbsp;&nbsp;</label> <input
					type="checkbox"><label>超声引导&nbsp;&nbsp;</label> <input
					type="checkbox"><label>神经刺激仪&nbsp;&nbsp;</label> <input
					type="checkbox"><label>使用输注工作站&nbsp;&nbsp;</label> <input
					type="checkbox"><label>血液(液体)加温治疗&nbsp;&nbsp;</label> <input
					type="checkbox"><label>TEG</label> <br> <input
					type="checkbox"><label>控制性降压治疗&nbsp;&nbsp;</label> <input
					type="checkbox"><label>肢体气压治疗&nbsp;&nbsp;</label> <input
					type="checkbox"><label>血液回输治疗&nbsp;&nbsp;</label> <label>术后镇痛:</label>
				<input type="radio"><label>PCIA&nbsp;&nbsp;</label> <input
					type="radio"><label>PCEA&nbsp;&nbsp;</label> <input
					type="radio"><label>PCNA&nbsp;&nbsp;</label> <input
					type="radio"><label>未用PCA&nbsp;&nbsp;</label> <label>自体血回收治疗</label><input
					type="text" class="text_type" id="zongchuliang"><label>ml&nbsp;&nbsp;</label>
				<label>苏醒评分</label><input type="text" class="text_type"
					id="zongchuliang"><label>分&nbsp;&nbsp;</label><br> <label>麻醉效果评定:</label>
				<input type="radio"><label>Ⅰ</label> <input type="radio"><label>Ⅱ</label>
				<input type="radio"><label>Ⅲ</label> <label>病人去向:</label> <select>
					<option>PACU</option>
					<option>病房</option>
					<option>ICU</option>
				</select> <label>其他检验:</label><input type="text" class="text_type"
					style="width: 655px;" id="zongchuliang"><br> <label>术后诊断:</label><input
					type="text" class="text_type" style="width: 992px;"
					id="zongchuliang"><br> <label>已施手术:</label><input
					type="text" class="text_type" style="width: 992px;"
					id="zongchuliang"><br> <label>术中总结:</label>
				<textarea id="teshuqingkuang"
					style="overflow-y: hidden; resize: none; width: 987px; height: 2;"></textarea>
			</div>
		</div>
		<div class="clearfix"></div>
		<div id="message">
			<div style="margin-left: 10px;">
				<label>手术医生:</label><input type="text" class="text_type"
					style="width: 280px;" id="zongchuliang"> <label>洗手护士:</label><input
					type="text" class="text_type" style="width: 280px;"
					id="zongchuliang"> <label>巡回护士:</label><input type="text"
					class="text_type" style="width: 305px;" id="zongchuliang"><br>
				<label>麻醉医师:</label><input type="text" class="text_type"
					style="width: 280px;" id="zongchuliang"> <label>接班麻醉医师:</label><input
					type="text" class="text_type" style="width: 240px;"
					id="zongchuliang"> <label>接班时间</label><input type="text"
					class="text_type" style="width: 325px;" id="zongchuliang">
			</div>

		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$("#startTime ").datetimepicker({
			format : "Y - m - d ",
			timepicker : false, //关闭时间选项
			yearEnd : 2050, //设置最大年份 
			lang : 'ch',
			validateOnBlur : false,
		});
	});
</script>
</html>