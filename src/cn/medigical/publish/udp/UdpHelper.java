package cn.medigical.publish.udp;

import cn.medigical.publish.service.impl.*;
import cn.medigical.publish.utils.PropertyUtil;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpHelper {
	public UdpHelper() {
	}

	private static Logger logger = Logger.getLogger("UdpHelper");
	private final static int PORT = Integer.parseInt(PropertyUtil.getProperty("UdpConfig.PORT"));
	private final static String Name = PropertyUtil.getProperty("Hospital.Name");

	public static void sendMsg(String msg) {
		try (DatagramSocket socket = new DatagramSocket(0)) {
			InetAddress host = InetAddress.getByName(UdpConfig.ADDRESS);
			DatagramPacket request = new DatagramPacket(msg.getBytes(), msg.getBytes().length, host, UdpConfig.PORT);
			socket.send(request);
			logger.info("UDP send success!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void sendMsgs(String msg, String ip) {
		try (DatagramSocket socket = new DatagramSocket(0)) {
			// InetAddress host=InetAddress.getByName(UdpConfig.ADDRESS);
			InetAddress host = InetAddress.getByName(ip);
			DatagramPacket request = new DatagramPacket(msg.getBytes(), msg.getBytes().length, host, UdpConfig.PORT);
			socket.send(request);
			logger.info("UDP send success!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String result = "";

	public static void ReceiveMsg() {
		// 传入0表示让操作系统分配一个端口号
		try (DatagramSocket socket = new DatagramSocket(PORT)) {
			// socket.setSoTimeout(1000);
			// 为接受的数据包创建空间
			DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
			while (true) {
				socket.receive(response);
				result = new String(response.getData(), 0, response.getLength(), "UTF-8");
				try {
					logger.info("Udp recive xml is " + result);
					if (Name.equals("PLZYY")) {
						new ClientPLZYYListenerServiceImpl().clientInteraction(result);
					}
					if (Name.equals("PLXYY")) {
						new ClientPLXYYListenerServiceImpl().clientInteraction(result);
					}
					if(Name.equals("NT")){
						new ClientNTListenerServiceImpl().clientInteraction(result);
					}
					if(Name.equals("TL")){
						new ClientTLListenerServiceImpl().clientInteraction(result);
					}
					if(Name.equals("WJZYY")){
						new ClientWJZYYListenerServiceImpl().clientInteraction(result);
					}
					if(Name.equals("DC")){
//						new ClientDCListenerServiceImpl().clientInteraction(result);
					}
					if(Name.equals("GXDL")){
						new ClientDLXRMYYListenerServiceImpl().clientInteraction(result);
					}
					if(Name.equals("CQRC")){
						new ClientRCListenerServiceImpl().clientInteraction(result);
					}
					if(Name.equals("ZJPA")){
						new ClientZJPAListenerServiceImpl().clientInteraction(result);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
