package cn.medigical.publish.interfaces.his;


import org.apache.log4j.Logger;

import cn.medigical.publish.interfaces.his.HisPLZYY.HisLinkPLZYY;
import cn.medigical.publish.interfaces.his.hisPLXYY.HisLinkPLXYY;
import cn.medigical.publish.utils.PropertyUtil;

public class GetHisDataRunning implements Runnable{
	private static Logger logger = Logger.getLogger("UdpRunning");
	private String Name = PropertyUtil.getProperty("Hospital.Name");
	@Override
	public void run() {
		synchronized (this) {
			try {
				for (;;) {
					
	//				 LisWjyyData.getInstance().getLisDataFromHis("201804016", "5c7c9535ed512231418850e4");
	//				LisDataNantong2.getInstance().getLisFromHis("1605190086", "", "", "");
					
					 Thread.sleep(1000*30);
					if (Name.equals("PLXYY")) {
						logger.info("PLXYY获取数据ing");
						HisLinkPLXYY.getInstance().getOperationFromHis();
						HisLinkPLXYY.getInstance().getAccountFromHis();
						HisLinkPLXYY.getInstance().getDepartmentFromHis();
					}
					if (Name.equals("PLZYY")) {
						logger.info("PLZYY获取数据ing");
						HisLinkPLZYY.getInstance().getOperationFromHis();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
