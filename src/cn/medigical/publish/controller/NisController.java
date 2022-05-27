package cn.medigical.publish.controller;

import cn.medigical.publish.interfaces.wxzt.nantong.WXZTServiceImpl;
import cn.medigical.publish.service.impl.CDTYNisServiceImpl;
import cn.medigical.publish.utils.PropertyUtil;

import java.io.UnsupportedEncodingException;

import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/nisController")
public class NisController {

	private final static String HospitalName = PropertyUtil.getProperty("Hospital.Name");
	@ResponseBody
	@RequestMapping(value = "/process", method = RequestMethod.POST)
	public String process(@RequestBody String requestXml) {
		try {
			requestXml = new String(requestXml.getBytes("ISO-8859-1"),"utf-8");//
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("+++++++++++++================="+requestXml);
		System.out.println(requestXml);
		String xmlString="我们";
		try {
			// 获取需要进入的方法的方法名字
			if (("FY").equals(HospitalName)) {

			} else if (("TL").equals(HospitalName)) {

			}else if (("TY").equals(HospitalName)) {
				CDTYNisServiceImpl nis=new CDTYNisServiceImpl();
				xmlString=nis.progress(requestXml);
			}else if (("GXLT").equals(HospitalName)) {

			}else if (("NT").equals(HospitalName)) {
				WXZTServiceImpl wxzt=new WXZTServiceImpl();
				xmlString=wxzt.progress(requestXml);
			} else if (("NS").equals(HospitalName)) {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xmlString;
	}
	
}
