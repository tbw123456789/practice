package cn.medigical.publish.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongodb.client.MongoDatabase;

import cn.medigical.publish.pojo.Bedside;
import cn.medigical.publish.pojo.daPing.Operation1;
import cn.medigical.publish.pojo.highcharts.Highcharts;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.utils.AjaxMsg;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("mazuidanController")
public class MazuidanController {
	MongoDatabase mongoDataBase = null;
	private AjaxMsg ajax = AjaxMsg.newInstance();
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	SimpleDateFormat sdfMM = new SimpleDateFormat("mm");
	SimpleDateFormat sdfHM = new SimpleDateFormat("HH:mm");
	SimpleDateFormat sdfYMDH = new SimpleDateFormat("yyyy-MM-dd HH:");
	SimpleDateFormat sdfYMD = new SimpleDateFormat("yyyy-MM-dd");

	// 跳转页面到麻醉单
	@RequestMapping(value = "getMazuidanJsp", method = RequestMethod.GET)
	public String getMazuidanJsp(Model model, HttpServletRequest request) {

		return "mazuidan/highcharts";
	}

	@ResponseBody
	@RequestMapping(value = "queryByOperationId/{pDBid}", method = RequestMethod.GET)
	public Object queryByOperationId(Model model, HttpServletRequest request, @PathVariable("pDBid") String pDBid) throws Exception {

		/*
		 * List<String> strings= op1.queryByList(mongoDataBase, "bedside",
		 * "pDBid", pDBid); List<Bedside> bedsideList = new ArrayList<>();
		 * if(strings != null && strings.size()>0){ for(String
		 * Bedsides:strings){ JSONObject jsonObj = new JSONObject(Bedsides);
		 * JSONObject personObject = jsonObj.getJSONObject("_id"); //JSONObject
		 * idObject = personObject.getJSONObject("$oid");
		 * 
		 * Bedsides = Bedsides.replace("_", "");
		 * 
		 * Bedside bedside = (Bedside) JsonUtilTool.json2Object(Bedsides,
		 * Bedside.class); bedsideList.add(bedside); System.out.println("1"); }
		 * } int[] value = new int[]{11,2,3};
		 * 
		 * ajax.addData("strings", value); if(bedsideList.size()>0){
		 * ajax.addData("bedside", bedsideList); }
		 */

		return ajax;
	}

	// 测试数据
	@CrossOrigin(origins = "*", maxAge = 3600)
	@ResponseBody
	@RequestMapping(value = "getAnalogData", method = RequestMethod.GET)
	public Object getAnalogData(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setHeader("Access-Control-Allow-Origin", "*");
		ajax.clear();
		PatientLink operation = new PatientLink();
		Date nowDate = new Date();
		int nowTime = Integer.valueOf(sdfMM.format(nowDate));
		if (nowTime % 5 != 0 && nowTime < 60) {
			nowTime = nowTime - nowTime % 5;
		}
		String stime = sdfYMDH.format(nowDate) + nowTime;
		nowDate = simpleDateFormat.parse(stime);
		Date endDate = new Date(nowDate.getTime() + 14400000);

		List<Bedside> bedsideList = new ArrayList<>();
		List<Bedside> bedsideList2 = new ArrayList<>();
		List<Bedside> bedsideList3 = new ArrayList<>();
		List<Bedside> bedsideList4 = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			Bedside bedside = new Bedside();
			bedside.setIntVal(new Random().nextInt(100) + 50);
			bedside.setId("param_BP" + i);
			bedside.setCode("param_BP");
			bedside.setName("血压");
			bedside.setUnitCode("unit_bp");
			bedsideList.add(bedside);
		}
		for (int i = 0; i < 30; i++) {
			Bedside bedside = new Bedside();
			bedside.setIntVal(new Random().nextInt(50) + 60);
			bedside.setId("param_resp" + i);
			bedside.setCode("param_resp");
			bedside.setName("呼吸");
			bedside.setUnitCode("unit_resp");
			bedsideList2.add(bedside);
		}
		for (int i = 0; i < 30; i++) {
			Bedside bedside = new Bedside();
			bedside.setIntVal(new Random().nextInt(50) + 60);
			bedside.setId("param_HR" + i);
			bedside.setCode("param_HR");
			bedside.setName("心率");
			bedside.setUnitCode("unit_ya");
			bedsideList3.add(bedside);
		}
		for (int i = 0; i < 30; i++) {
			Bedside bedside = new Bedside();
			bedside.setIntVal(new Random().nextInt(3) + 36);
			bedside.setId("param_BT" + i);
			bedside.setCode("param_BT");
			bedside.setName("体温");
			bedside.setUnitCode("unit_c");
			bedsideList4.add(bedside);
		}
		List<Highcharts> highchartList = new ArrayList<>();
		Highcharts highcharts = new Highcharts(bedsideList, operation);
		Highcharts highcharts2 = new Highcharts(bedsideList2, operation);
		Highcharts highcharts3 = new Highcharts(bedsideList3, operation);
		Highcharts highcharts4 = new Highcharts(bedsideList4, operation);
		highchartList.add(highcharts);
		highchartList.add(highcharts2);
		highchartList.add(highcharts3);
		highchartList.add(highcharts4);

		ajax.addMap(highchartList);
		ajax.addHashMap("mazuiNowTime", nowDate);
		ajax.addHashMap("mazuiEndTime", endDate);
		return ajax;
	}

	// 拖动值反馈
	@ResponseBody
	@RequestMapping(value = "setBedsideData/{intval}/{time}/{colorIndex}", method = RequestMethod.GET)
	public Object setBedsideData(Model model, HttpServletRequest request, @PathVariable("intval") String intval, @PathVariable("time") int time, @PathVariable("colorIndex") int colorIndex) throws Exception {
		String sss = "在第" + colorIndex + "组里的第" + time + "行里的值" + intval;
		ajax.addHashMap("传进来的值", sss);

		return ajax;
	}

	// 参数页面跳转
	@RequestMapping(value = "parameter", method = RequestMethod.GET)
	public String parameter(Model model, HttpServletRequest request) throws Exception {
		Date nowDate = new Date();
		List<String> timeStrList = new ArrayList<>();
		List<Date> dates = new ArrayList<>();

		int nowTime = Integer.valueOf(sdfMM.format(nowDate));
		if (nowTime % 5 != 0 && nowTime < 60) {
			nowTime = nowTime - nowTime % 5;
		}
		String stime = sdfYMDH.format(nowDate) + nowTime;
		nowDate = simpleDateFormat.parse(stime);
		timeStrList.add("");
		for (int i = 0; i < 48; i++) {
			Date date = new Date(nowDate.getTime() + i * 5 * 60 * 1000);
			dates.add(date);
			timeStrList.add(sdfHM.format(date));
		}

		List<List<Bedside>> bedsideList = new ArrayList<>();

		List<Bedside> bedsideList1 = new ArrayList<>();
		List<Bedside> bedsideList2 = new ArrayList<>();
		List<Bedside> bedsideList3 = new ArrayList<>();
		List<Bedside> bedsideList4 = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			Bedside bedside = new Bedside();
			bedside.setIntVal(new Random().nextInt(100) + 50);
			bedside.setId(String.valueOf(i));
			bedside.setCode("param_BP");
			bedside.setName("血压");
			bedside.setTime(dates.get(i));
			bedside.setUnitCode("unit_bp");
			bedsideList1.add(bedside);
		}
		for (int i = 0; i < 30; i++) {
			Bedside bedside = new Bedside();
			bedside.setIntVal(new Random().nextInt(50) + 60);
			bedside.setId(String.valueOf(i));
			bedside.setCode("param_resp");
			bedside.setName("呼吸");
			bedside.setTime(dates.get(i));
			bedside.setUnitCode("unit_resp");
			bedsideList2.add(bedside);
		}
		for (int i = 0; i < 30; i++) {
			Bedside bedside = new Bedside();
			bedside.setIntVal(new Random().nextInt(50) + 60);
			bedside.setId(String.valueOf(i));
			bedside.setCode("param_HR");
			bedside.setName("心率");
			bedside.setTime(dates.get(i));
			bedside.setUnitCode("unit_ya");
			bedsideList3.add(bedside);
		}
		for (int i = 0; i < 30; i++) {
			Bedside bedside = new Bedside();
			bedside.setIntVal(new Random().nextInt(3) + 36);
			bedside.setId(String.valueOf(i));
			bedside.setCode("param_BT");
			bedside.setName("体温");
			bedside.setTime(dates.get(i));
			bedside.setUnitCode("unit_c");
			bedsideList4.add(bedside);
		}
		bedsideList.add(bedsideList1);
		bedsideList.add(bedsideList2);
		bedsideList.add(bedsideList3);
		bedsideList.add(bedsideList4);

		model.addAttribute("bedsideList", bedsideList);
		model.addAttribute("mazuiTime", timeStrList);
		return "mazuidan/parameter";
	}

	// 模拟定时更新bedside的值
	@ResponseBody
	@RequestMapping(value = "getBedsideRegularly/{time}/{operationId}", method = RequestMethod.GET)
	public Object getBedsideRegularly(Model model, HttpServletRequest request, @PathVariable("time") Long time, @PathVariable("operationId") String operationId) throws Exception {
		System.out.println(simpleDateFormat.format(new Date(time)));

		ajax.clear();
		List<Bedside> bedsideList = new ArrayList<>();

		Bedside bedside = new Bedside();
		bedside.setCode("param_BT");
		bedside.setIntVal(new Random().nextInt(3) + 36);
		Bedside bedside1 = new Bedside();
		bedside1.setCode("param_HR");
		bedside1.setIntVal(new Random().nextInt(50) + 60);
		Bedside bedside2 = new Bedside();
		bedside2.setCode("param_resp");
		bedside2.setIntVal(new Random().nextInt(50) + 60);
		Bedside bedside3 = new Bedside();
		bedside3.setCode("param_BP");
		bedside3.setIntVal(new Random().nextInt(100) + 50);

		bedsideList.add(bedside);
		bedsideList.add(bedside1);
		bedsideList.add(bedside2);
		bedsideList.add(bedside3);

		ajax.addMap(bedsideList);

		return ajax;
	}

	@RequestMapping(value = "mazuidan", method = RequestMethod.GET)
	public String mazuidan(Model m, HttpServletRequest request) {

		return "mazuidan/mazuidan";
	}

	@RequestMapping(value = "mazuidanAddEvent", method = RequestMethod.GET)
	public String mazuidanAddEvent(Model m, HttpServletRequest request) {

		return "mazuidan/addEvent";
	}
}
