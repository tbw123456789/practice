package cn.medigical.publish.udp;

import cn.medigical.publish.utils.PropertyUtil;


public class UdpConfig {
	public static String ADDRESS= PropertyUtil.getProperty("UdpConfig.ADDRESS");
	public static int PORT=Integer.parseInt(PropertyUtil.getProperty("UdpConfig.PORT"));
}
