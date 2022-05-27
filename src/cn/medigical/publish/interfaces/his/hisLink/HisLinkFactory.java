package cn.medigical.publish.interfaces.his.hisLink;

import cn.medigical.publish.interfaces.his.hisTongliang.HisLinkTongLiang;
import cn.medigical.publish.utils.PropertyUtil;

/**
 * Created by 博创医疗 on 2010/5/20. Copyright by 博创医疗
 */
public class HisLinkFactory {
	private static HisLinkFactory instance = null;
	private HisLink hisLink;
	private String Name = PropertyUtil.getProperty("Hospital.Name");

	private HisLinkFactory() {
		if (Name.equals("TL")) {
			hisLink = new HisLinkTongLiang();
		}
	}

	public static HisLinkFactory getInstance() {
		if (instance == null) {

			instance = new HisLinkFactory();
		}
		return instance;
	}

	public HisLink getHisLink() {
		return hisLink;
	}
}
