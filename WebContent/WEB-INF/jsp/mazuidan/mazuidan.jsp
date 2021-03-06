
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
					console.log("??????????????????!!!!!error!");
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
				text : '?????????'
			},
			chart : {
				style : {
					fontFamily : '\????????????\, Arial, Helvetica, sans-serif',
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
					text : '?????????',
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
					pointStart : value.mazuiNowTime, // ?????????
					pointInterval : 5 * 60 * 1000,
				},
			},
			series : value.data,
			tooltip : {
				formatter : function() {
					var vlaue = this.y;
					if (this.series.name == '??????') {
						vlaue = vlaue.toFixed(1);
						setBedsideData(vlaue, this.x, this.colorIndex);
						return this.series.name + ':' + vlaue + '???';
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
			console.log("????????????");
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
			title : '????????????',
			area : [ '550px', '330px' ],
			shadeClose : true,
			closeBtn : true,
			content : '${ctx }/mazuidanController/mazuidanAddEvent.do', //??????
		});
	};

	//(???????????????)
	function addQuestion() {
		var index = layer.open({
			type : 2, //???????????????     
			maxmin : true, //??????????????????????????????
			title : '????????????',
			fixed : true,
			shade : 0.8, //??????
			area : [ '100px', '100px' ], //???????????????
			content : '${ctx }/mazuidanController/mazuidanAddEvent.do', //??????
			end : function() { //???????????????
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
	//layer?????????????????????
	function ifrclose(i) {
		layer.confirm('???????????????????????????????????????????????????', {
			icon : 3,
			btn : [ '??????', '??????' ]
		//??????
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
		?????????????????????
		<button onclick="addEvent()">dfaf1d</button>
	</div>
	<div id="main">
		<div id="basemessage">
			<div>
				<div id="basemessage_left">
					<label>??????:</label> <input type="text" id="name" class="text_type">
					<label>??????:</label><input type="text" id="sex" class="text_type">
					<label>??????:</label><input type="text" id="age" class="text_type">
					<label>??????:</label><input type="text" id="weight" class="text_type">
					<label>??????:</label><input type="text" id="height" class="text_type">
					<label>?????????:</label><input type="text" id="yiliaofei"
						class="text_type" style="width: 70px;"><br> <label>??????:</label><input
						type="text" id="bingshi" class="text_type" style="width: 180px;">
					<label>??????:</label><input type="text" id="chuanghao"
						class="text_type"> <label>?????????:</label><input type="text"
						id="zhuyuanhao" class="text_type" style="width: 195px;"><br>
					<label>NNIS:</label><input type="text" id="NNIS" class="text_type">
					<label>NYHA:</label><input type="text" id="NYHA" class="text_type">
					<label>??????:</label><input type="text" id="blood" class="text_type">
					<label>???????????????:</label><input type="text" class="text_type"
						style="width: 200px;" id="mazuiqianyongyao"><br> <label>????????????:</label><input
						type="text" class="text_type" style="width: 285px;"
						id="shoushutiwei"> <label>ASA:</label><input type="text"
						class="text_type" id="ASA"> <label>??????:</label><input
						type="radio" name="menzhenfangshi" class="radio_type"> <label>??????:</label><input
						type="radio" name="menzhenfangshi" class="radio_type"><br>
					<label>????????????:</label><input type="text" class="text_type"
						style="width: 490px;" id="mazuifangshi">
				</div>
				<div id="basemessage_right">
					<label>????????????:</label><input type="text" class="text_type"
						style="width: 120px;" id="shoushuriqi"> <label
						style="margin-left: 30px;">????????????:</label><input type="text"
						class="text_type" style="width: 120px;" id="shoushujianhao">
					<label style="margin-left: 25px;">???1???/???10???</label><br> <label>????????????:</label>
					<input type="radio" name="shuqianjinshi" class="radio_type">???
					<input type="radio" name="shuqianjinshi" class="radio_type">???
					<label style="margin-left: 30px;">????????????????????????:</label> <input
						type="radio" name="ercishoushu" class="radio_type">??? <input
						type="radio" name="ercishoushu" class="radio_type">??? <label
						style="margin-left: 30px;">??????????????????:</label> <select id="qidaofenji">
						<option>???</option>
						<option>???</option>
						<option>???</option>
						<option>???</option>
						<option>???</option>
						<option>???</option>
					</select><br> <label>???????????????:</label> <input type="radio"
						name="fanliuweixianxing" class="radio_type">??? <input
						type="radio" name="fanliuweixianxing" class="radio_type">???
					<input type="radio" name="fanliuweixianxing" class="radio_type">???
					<label style="margin-left: 140px">POVN:</label> <input type="radio"
						name="POVN" class="radio_type">?????? <input type="radio"
						name="POVN" class="radio_type">?????? <input type="radio"
						name="POVN" class="radio_type">?????? <br> <label>????????????:</label>
					<textarea id="teshuqingkuang"
						style="overflow-y: hidden; resize: none; width: 450px; height: 40px;"></textarea>
				</div>
			</div>
			<div class="clearfix"></div>
			<div>
				<div id="basemessage_button">
					<label>????????????:</label><input type="text" class="text_type"
						style="width: 1015px;" id="shuqianzhenduan"> <br> <label>????????????:</label><input
						type="text" class="text_type" style="width: 1015px;"
						id="nixingshoushu">
				</div>
			</div>
		</div>
		<div class="clearfix"></div>
		<div id="jilu">
			<div id="container" style="height: 500px"></div>
			<div>
				<button id="button" class="autocompare">??????</button>
				<button id="button1" class="autocompare">?????????</button>
				<button id="parameter" class="autocompare" onclick="parameter()">??????</button>
			</div>
		</div>
		<div class="clearfix"></div>
		<div id="biaoji"></div>
		<div id="yongyao">
			<div id="chixuyongyao">????????????</div>
		</div>
		<div id="shuye">
			<div id="shuxueshuye">????????????</div>
			<div>

				<div id="testDiv">???????????????</div>
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
			<div id="mazuizhongshijian">?????????????????????</div>
			<div
				style="float: left; width: 25%; padding-left: 5px; padding-top: 5px;">
				<button>????????????</button>
				<button>??????</button>
				<br>
			</div>
			<div style="float: left; width: 25%"></div>
			<div style="float: left; width: 25%"></div>
			<div style="float: left; width: 25%"></div>
		</div>
		<div id="churuliang">
			<div id="churuliang_left">?????????</div>
			<div id="churuliang_right">
				<label>N.S</label><input type="text" class="text_dtype" id="NS"><label>ml&nbsp;&nbsp;</label>
				<label>G.S</label><input type="text" class="text_dtype" id="GS"><label>ml&nbsp;&nbsp;</label>
				<label>?????????</label><input type="text" class="text_dtype"
					id="jiaotiye"><label>ml&nbsp;</label> <label>?????????</label><input
					type="text" class="text_dtype" id="pinghengye"><label>ml
					&nbsp;&nbsp;</label> <label>?????????</label><input type="text"
					class="text_dtype" id="lengchenye"><label>ml
					&nbsp;&nbsp;</label> <label>????????????</label><input type="text"
					class="text_dtype" id="tansuanqingna"><label>ml
					&nbsp;&nbsp;</label> <label>???????????????</label><input type="text"
					class="text_dtype" id="hongxibaoxuanye"><label>ml
					&nbsp;&nbsp;</label> <label>??????</label><input type="text" class="text_dtype"
					id="xuejiang"><label>ml &nbsp;&nbsp;</label><br> <label>?????????</label><input
					type="text" class="text_dtype" id="ganluchun"><label>ml&nbsp;&nbsp;</label>
				<label>??????</label><input type="text" class="text_dtype"
					style="width: 760px;" id="qita"> <label>?????????</label><input
					type="text" class="text_dtype" id="zongruliang"><label>ml&nbsp;&nbsp;</label><br>
				<label>?????????</label><input type="text" class="text_dtype"
					id="shixueliang"><label>ml&nbsp;&nbsp;</label> <label>?????????</label><input
					type="text" class="text_dtype" id="chuxueliang"><label>ml&nbsp;&nbsp;</label>
				<label>??????</label><input type="text" class="text_dtype"
					id="niaoliang"><label>ml&nbsp;&nbsp;</label> <label>??????</label><input
					type="text" class="text_dtype" style="width: 510px;" id="oher">
				<label>?????????</label><input type="text" class="text_dtype"
					id="zongchuliang"><label>ml&nbsp;&nbsp;</label>
			</div>
		</div>
		<div class="clearfix"></div>
		<div id="zongjie">
			<div style="margin-left: 10px;">
				<label>???????????????:</label> <input type="checkbox"> <label>????????????&nbsp;&nbsp;</label>
				<input type="checkbox"> <label>????????????</label> <select>
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
				</select> <input type="checkbox"><label>??????????????????&nbsp;&nbsp;</label> <input
					type="checkbox"><label>????????????&nbsp;&nbsp;</label> <input
					type="checkbox"><label>????????????&nbsp;&nbsp;</label> <input
					type="checkbox"><label>???????????????&nbsp;&nbsp;</label> <input
					type="checkbox"><label>?????????????????????&nbsp;&nbsp;</label> <input
					type="checkbox"><label>??????(??????)????????????&nbsp;&nbsp;</label> <input
					type="checkbox"><label>TEG</label> <br> <input
					type="checkbox"><label>?????????????????????&nbsp;&nbsp;</label> <input
					type="checkbox"><label>??????????????????&nbsp;&nbsp;</label> <input
					type="checkbox"><label>??????????????????&nbsp;&nbsp;</label> <label>????????????:</label>
				<input type="radio"><label>PCIA&nbsp;&nbsp;</label> <input
					type="radio"><label>PCEA&nbsp;&nbsp;</label> <input
					type="radio"><label>PCNA&nbsp;&nbsp;</label> <input
					type="radio"><label>??????PCA&nbsp;&nbsp;</label> <label>?????????????????????</label><input
					type="text" class="text_type" id="zongchuliang"><label>ml&nbsp;&nbsp;</label>
				<label>????????????</label><input type="text" class="text_type"
					id="zongchuliang"><label>???&nbsp;&nbsp;</label><br> <label>??????????????????:</label>
				<input type="radio"><label>???</label> <input type="radio"><label>???</label>
				<input type="radio"><label>???</label> <label>????????????:</label> <select>
					<option>PACU</option>
					<option>??????</option>
					<option>ICU</option>
				</select> <label>????????????:</label><input type="text" class="text_type"
					style="width: 655px;" id="zongchuliang"><br> <label>????????????:</label><input
					type="text" class="text_type" style="width: 992px;"
					id="zongchuliang"><br> <label>????????????:</label><input
					type="text" class="text_type" style="width: 992px;"
					id="zongchuliang"><br> <label>????????????:</label>
				<textarea id="teshuqingkuang"
					style="overflow-y: hidden; resize: none; width: 987px; height: 2;"></textarea>
			</div>
		</div>
		<div class="clearfix"></div>
		<div id="message">
			<div style="margin-left: 10px;">
				<label>????????????:</label><input type="text" class="text_type"
					style="width: 280px;" id="zongchuliang"> <label>????????????:</label><input
					type="text" class="text_type" style="width: 280px;"
					id="zongchuliang"> <label>????????????:</label><input type="text"
					class="text_type" style="width: 305px;" id="zongchuliang"><br>
				<label>????????????:</label><input type="text" class="text_type"
					style="width: 280px;" id="zongchuliang"> <label>??????????????????:</label><input
					type="text" class="text_type" style="width: 240px;"
					id="zongchuliang"> <label>????????????</label><input type="text"
					class="text_type" style="width: 325px;" id="zongchuliang">
			</div>

		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$("#startTime ").datetimepicker({
			format : "Y - m - d ",
			timepicker : false, //??????????????????
			yearEnd : 2050, //?????????????????? 
			lang : 'ch',
			validateOnBlur : false,
		});
	});
</script>
</html>