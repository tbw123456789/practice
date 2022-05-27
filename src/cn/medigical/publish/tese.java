package cn.medigical.publish;

import cn.medigical.publish.dao.impl.PatientLinkDao;
import cn.medigical.publish.utils.SpringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class tese {
	
	public static void main(String[]asd){
		String a=null;
		String b="责任医生";
		if(a.contains(b)){
			System.out.println("能小保大");
		}else {
			System.out.println("不能小保大");
		}
		//PatientLinkDao patientLinkDao = SpringUtils.getBean(PatientLinkDao.class);
		System.out.println();

	}
	
	
	
//	public static String agoday(Date date,int n) {
//		int a=7;
//		int b=5;
//		Float ss=(float) (a/b);
//		System.out.println(ss);
//		return three_days_ago;
//	}

}
