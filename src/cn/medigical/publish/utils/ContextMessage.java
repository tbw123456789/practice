package cn.medigical.publish.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.medigical.publish.pojo.zhikong.ZhikongMessage;

public class ContextMessage {
	
	
	public static ContextMessage ContextMessage;
	public static ContextMessage getIntent(){
		if(ContextMessage==null){
			ContextMessage=	new ContextMessage();
		}
		return ContextMessage;
	}
	
	
	public static Map<String,String> zhikongDB =new HashMap<String, String>();
	public static Map<String,String> zhikongzhibiao =new HashMap<String, String>();
	public static List<ZhikongMessage> zhikong = new ArrayList<ZhikongMessage>();
	public static String[] color={"#CD0205","#9C0264","#040263","#0B399B","#046665","#359807","#63CF00","#FDFE03","#FC9A05","#FC6605","#FC3204","#FC0000"};
}
