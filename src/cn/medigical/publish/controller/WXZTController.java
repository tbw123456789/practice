package cn.medigical.publish.controller;

import cn.medigical.publish.interfaces.wxzt.nantong.WXZTServiceImpl;
import cn.medigical.publish.utils.PropertyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/wxztController")
public class WXZTController {
	private final static String HospitalName = PropertyUtil.getProperty("Hospital.Name");

	@ResponseBody
	@RequestMapping(value = "wxzt", method = RequestMethod.POST)
	public String process(@RequestBody String requestXml) {
		System.out.println(requestXml);
		String xmlString="";
		try {
			// 获取需要进入的方法的方法名字
			if (("FY").equals(HospitalName)) {

			} else if (("TL").equals(HospitalName)) {
				
			} else if (("NT").equals(HospitalName)) {
				WXZTServiceImpl wxzt=new WXZTServiceImpl();
				xmlString=wxzt.progress(requestXml);
			} else if (("NS").equals(HospitalName)) {

			}else if (("DC").equals(HospitalName)) {

			}else if (("RongChang").equals(HospitalName)){
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xmlString;
	}
}
