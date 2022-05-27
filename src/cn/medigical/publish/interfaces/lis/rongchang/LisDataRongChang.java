package cn.medigical.publish.interfaces.lis.rongchang;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.lang.reflect.Field;
import java.sql.*;
import java.text.DecimalFormat;

import org.apache.log4j.Logger;

import cn.medigical.publish.dao.impl.PatientLinkDao;
import cn.medigical.publish.dao.impl.PatientLisDataDao;
import cn.medigical.publish.pojo.lis.JianYan;
import cn.medigical.publish.pojo.patient.PatientLisData;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.utils.SpringUtils;

public class LisDataRongChang {

	protected Logger logger;
	String dbIP;
	String driverName;
	String url;
	String username;
	String password;
	public Map<String, String> SMALLITEMCODE_ENNAME;
	public Map<String, String> SMALLITEMCODE_PROPERTY;
	private static LisDataRongChang instance;
	PatientLinkDao patientLinkDao = SpringUtils.getBean(PatientLinkDao.class);
	PatientLisDataDao patientLisDataDao = SpringUtils.getBean(PatientLisDataDao.class);

	public LisDataRongChang() {
		this.logger = Logger.getLogger("LisDataTengChong");

		this.dbIP = "192.168.169.247";
		this.driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		this.url = "jdbc:sqlserver://192.168.169.247:1433;databaseName=healthone";
		this.username = "sa";
		this.password = "xxk_123";

		this.SMALLITEMCODE_ENNAME = new HashMap();

		this.SMALLITEMCODE_ENNAME.put("RBC", "");
		this.SMALLITEMCODE_ENNAME.put("HGB", "");
		this.SMALLITEMCODE_ENNAME.put("HCT", "");
		this.SMALLITEMCODE_ENNAME.put("PLT", "");
		this.SMALLITEMCODE_ENNAME.put("WBC", "");

		this.SMALLITEMCODE_ENNAME.put("ABO", "");
		this.SMALLITEMCODE_ENNAME.put("RH", "");

		this.SMALLITEMCODE_ENNAME.put("PRO", "PRO");
		this.SMALLITEMCODE_ENNAME.put("GLU", "GLU");
		this.SMALLITEMCODE_ENNAME.put("KET", "KET");
		this.SMALLITEMCODE_ENNAME.put("BLD", "BU");

		this.SMALLITEMCODE_ENNAME.put("K", "K");
		this.SMALLITEMCODE_ENNAME.put("NA", "NA");
		this.SMALLITEMCODE_ENNAME.put("CA", "CA");
		this.SMALLITEMCODE_ENNAME.put("MG", "MG");
		this.SMALLITEMCODE_ENNAME.put("P", "P");

		this.SMALLITEMCODE_ENNAME.put("TP", "TP");
		this.SMALLITEMCODE_ENNAME.put("ALB", "ALB");
		this.SMALLITEMCODE_ENNAME.put("GLB", "GLO");
		this.SMALLITEMCODE_ENNAME.put("ALT", "ALT");
		this.SMALLITEMCODE_ENNAME.put("AST", "AST");

		this.SMALLITEMCODE_ENNAME.put("UREA", "UREA");
		this.SMALLITEMCODE_ENNAME.put("CREA", "CREA");
		this.SMALLITEMCODE_ENNAME.put("UA", "UA");

		this.SMALLITEMCODE_ENNAME.put("GLU", "GLU");
		this.SMALLITEMCODE_ENNAME.put("HbA1C", "HBAIC");

		this.SMALLITEMCODE_ENNAME.put("PT", "PT");
		this.SMALLITEMCODE_ENNAME.put("PT-INR", "PT-INR");
		this.SMALLITEMCODE_ENNAME.put("APTT", "APTT");
		this.SMALLITEMCODE_ENNAME.put("TT", "TT");
		this.SMALLITEMCODE_ENNAME.put("FIB", "Fbg");
		this.SMALLITEMCODE_ENNAME.put("D-Dimer", "DD");

		this.SMALLITEMCODE_PROPERTY = new HashMap();

		this.SMALLITEMCODE_PROPERTY.put("RBC", "rbc");
		this.SMALLITEMCODE_PROPERTY.put("HGB", "hb");
		this.SMALLITEMCODE_PROPERTY.put("HCT", "hct");
		this.SMALLITEMCODE_PROPERTY.put("PLT", "plt");
		this.SMALLITEMCODE_PROPERTY.put("WBC", "wbc");

		this.SMALLITEMCODE_PROPERTY.put("ABO", "bloodType");
		this.SMALLITEMCODE_PROPERTY.put("RH", "bloodType");

		this.SMALLITEMCODE_PROPERTY.put("PRO", "niaoChangGui");
		this.SMALLITEMCODE_PROPERTY.put("GLU", "niaoChangGui");
		this.SMALLITEMCODE_PROPERTY.put("KET", "niaoChangGui");
		this.SMALLITEMCODE_PROPERTY.put("BLD", "niaoChangGui");

		this.SMALLITEMCODE_PROPERTY.put("K", "dianJieZhi");
		this.SMALLITEMCODE_PROPERTY.put("NA", "dianJieZhi");
		this.SMALLITEMCODE_PROPERTY.put("CA", "dianJieZhi");
		this.SMALLITEMCODE_PROPERTY.put("MG", "dianJieZhi");
		this.SMALLITEMCODE_PROPERTY.put("P", "dianJieZhi");

		this.SMALLITEMCODE_PROPERTY.put("TP", "ganGongNeng");
		this.SMALLITEMCODE_PROPERTY.put("ALB", "ganGongNeng");
		this.SMALLITEMCODE_PROPERTY.put("GLB", "ganGongNeng");
		this.SMALLITEMCODE_PROPERTY.put("ALT", "ganGongNeng");
		this.SMALLITEMCODE_PROPERTY.put("AST", "ganGongNeng");

		this.SMALLITEMCODE_PROPERTY.put("UREA", "shenGongNeng");
		this.SMALLITEMCODE_PROPERTY.put("CREA", "shenGongNeng");
		this.SMALLITEMCODE_PROPERTY.put("UA", "shenGongNeng");

		this.SMALLITEMCODE_PROPERTY.put("GLU", "xueTang");
		this.SMALLITEMCODE_PROPERTY.put("HbA1C", "tangHuaXueHong");

		this.SMALLITEMCODE_PROPERTY.put("PT", "ningXueGongNeng");
		this.SMALLITEMCODE_PROPERTY.put("PT-INR", "ningXueGongNeng");
		this.SMALLITEMCODE_PROPERTY.put("APTT", "ningXueGongNeng");
		this.SMALLITEMCODE_PROPERTY.put("TT", "ningXueGongNeng");
		this.SMALLITEMCODE_PROPERTY.put("FIB", "ningXueGongNeng");
		this.SMALLITEMCODE_PROPERTY.put("D-Dimer", "ningXueGongNeng");
	}

	public static LisDataRongChang getInstance() {
		if (instance == null) {
			instance = new LisDataRongChang();
		}
		return instance;
	}

	public void getLisFromHis(String PatientId, String zyh, String zycs) {
		JianYan jy;
		String cxlx;
		jy = getListDataFromHis(zyh, zycs);
		System.out.println(jy);
		PatientLisData patientLisData = patientLisDataDao.getPatientLisData8PatientId(PatientId);
		if (patientLisData == null) {
			patientLisData = new PatientLisData();
		}
		patientLisData.setZyh(zyh);
		patientLisData.setPatientID(PatientId);
		patientLisData.setJianYan(jy);
		if (jy != null) {
			patientLisData.setResult(true);
		} else {
			patientLisData.setResult(false);
		}
		patientLisData.setBeginTime(new Date());
		patientLisDataDao.addUpdate(patientLisData);
	}

	public JianYan getListDataFromHis(String pid, String zycs) {
		final List<JYBigItem> jyBigItemList = getAllJyBigItemData(pid, zycs);
		if ((null == jyBigItemList) || (jyBigItemList.size() == 0)) {
			return null;
		}

		List<JYSmallItem> JYAllSmallItemList = new ArrayList();
		List<JYSmallItem> jySmallItemList = LisDataRongChang.this.getAllJySmallItemData(pid);
		for (JYBigItem jyBigItem : jyBigItemList) {
			if ((null != jySmallItemList) && (jySmallItemList.size() != 0)) {
				JYAllSmallItemList.addAll(jySmallItemList);
			}
		}

		DecimalFormat decimalFormat = new DecimalFormat("0.##");

		Map<String, JYSmallItem> JYShowSmallItemMap = new HashMap();
		for (Iterator localIterator = JYAllSmallItemList.iterator(); localIterator.hasNext();) {
			JYSmallItem jySmallItem = (JYSmallItem) localIterator.next();
			if ((this.SMALLITEMCODE_ENNAME.containsKey(jySmallItem.code))
					&& (!JYShowSmallItemMap.containsKey(jySmallItem.code))) {
				this.logger.error("------需要的小项--------\n" + jySmallItem.toString());
				jySmallItem.eName = ((String) this.SMALLITEMCODE_ENNAME.get(jySmallItem.code));
				try {
					Double vlueDoub = Double.valueOf(Double.parseDouble(jySmallItem.vlue));
					jySmallItem.vlue = decimalFormat.format(vlueDoub);
				} catch (Exception e) {
				}
				JYShowSmallItemMap.put(jySmallItem.code, jySmallItem);
			}
		}
		if (JYShowSmallItemMap.size() == 0) {
			return null;
		}
		JianYan jianYan = new JianYan();
		for (Iterator iterator = JYShowSmallItemMap.entrySet().iterator(); iterator.hasNext();) {
			Map.Entry<String, JYSmallItem> entry = (Map.Entry) iterator.next();
			JYSmallItem jySmallItem = (JYSmallItem) entry.getValue();
			this.logger.fatal("jySmallItem = " + jySmallItem.toString());

			String property = (String) this.SMALLITEMCODE_PROPERTY.get(jySmallItem.code);
			if (("bloodType".equals(property))
					&& ((jySmallItem.code.equals("ABO")) || (jySmallItem.code.equals("RH")))) {
				if (jySmallItem.vlue.contains("型")) {
					jySmallItem.vlue = jySmallItem.vlue.replace("型", "").trim();
				} else if (jySmallItem.vlue.contains("阳性(+)")) {
					jySmallItem.vlue = "Rh﹢";
				} else if (jySmallItem.vlue.contains("阴性(-)")) {
					jySmallItem.vlue = "Rh﹣";
				}
			}
			String eName = jySmallItem.eName;
			String propertyValue = getFieldValue(jianYan, property);
			if ("".equals(eName)) {
				if (null == propertyValue) {
					propertyValue = jySmallItem.vlue;
				} else {
					propertyValue = propertyValue + " " + jySmallItem.vlue;
				}
			} else if (null == propertyValue) {
				propertyValue = eName + ":" + jySmallItem.vlue + jySmallItem.unit;
			} else {
				propertyValue = propertyValue + " " + eName + ":" + jySmallItem.vlue + jySmallItem.unit;
			}
			setFieldValue(jianYan, property, propertyValue);
		}
		String[] propertys = { "rbc", "hb", "hct", "plt", "wbc", "bloodType", "niaoChangGui", "dianJieZhi",
				"ganGongNeng", "shenGongNeng", "xueTang", "ningXueGongNeng" };
		// Map.Entry<String, JYSmallItem> entry = propertys;JYSmallItem
		// jySmallItem = entry.length;
		for (int property1 = 0; property1 < propertys.length; property1++) {
			String property = propertys[property1];
			String propertyValue = getFieldValue(jianYan, property);
			if (null == propertyValue) {
				setFieldValue(jianYan, property, "未查");
			}
		}
		return jianYan;
	}

	protected void setFieldValue(Object instance, String fieldName, Object fieldValue) {
		try {
			Field field = instance.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(instance, fieldValue);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	protected String getFieldValue(Object instance, String fieldName) {
		try {
			Field field = instance.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			return (String) field.get(instance);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(this.driverName);
			connection = DriverManager.getConnection(this.url, this.username, this.password);
			this.logger.info("Connect to HIS ok. @" + this.dbIP);
		} catch (Exception ex) {
			this.logger.fatal("Could not establish HIS connection! " + this.dbIP + ex.getMessage(), ex);
		}
		return connection;
	}

	private void closeConnection(ResultSet resultSet, Statement statement, Connection connection) {
		if (null != resultSet) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				this.logger.error("Could not close resultSet! " + e.getMessage());
			}
		}
		if (null != statement) {
			try {
				statement.close();
			} catch (SQLException e) {
				this.logger.error("Could not close statement! " + e.getMessage());
			}
		}
		if (null != connection) {
			try {
				connection.close();
			} catch (SQLException e) {
				this.logger.error("Could not close connection! " + e.getMessage());
			}
		}
	}

	public List<JYBigItem> getAllJyBigItemData(String pid, String zycs) {
		Connection conn = getConnection();
		if (null == conn) {
			return null;
		}
		if ((null == pid) || ("".equals(pid))) {
			return null;
		}
		String strSQL = "SELECT * FROM dbo.V_LisRequestNote WHERE PID = '" + pid + "' ORDER BY SfTime DESC";
		this.logger.error("strSQL = " + strSQL);
		List<JYBigItem> jyBigItemList = new ArrayList();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(strSQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				JYBigItem jyBigItem = new JYBigItem();
				jyBigItem.applyId = trimStr(rs.getString("PID"));
				jyBigItem.patientId = trimStr(rs.getString("PID"));
				jyBigItem.jyContent = trimStr(rs.getString("SfName"));

				jyBigItem.shenHeDate = trimStr(rs.getString("SfTime"));
				jyBigItemList.add(jyBigItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, ps, conn);
		}
		this.logger.fatal(jyBigItemList);
		return jyBigItemList;
	}

	public List<JYSmallItem> getAllJySmallItemData(String applyId) {
		Connection conn = getConnection();
		if (null == conn) {
			return null;
		}
		if ((null == applyId) || ("".equals(applyId))) {
			return null;
		}
		String strSQL = "SELECT * FROM dbo.V_LisToHisData WHERE Lab09 = '" + applyId + "'ORDER BY Testdate DESC ";
		this.logger.error("strSQL = " + strSQL);
		List<JYSmallItem> jySmallItemList = new ArrayList();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(strSQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				JYSmallItem jySmallItem = new JYSmallItem();
				jySmallItem.eName = trimStr(rs.getString("BFC03"));
				jySmallItem.cName = trimStr(rs.getString("BBX05"));
				jySmallItem.code = trimStr(rs.getString("BFC03"));
				jySmallItem.abnormalFlags = trimStr(rs.getString("Lac11"));
				jySmallItem.referRange = trimStr(rs.getString("Lac15"));
				jySmallItem.vlue = trimStr(rs.getString("Lac10"));
				jySmallItem.unit = trimStr(rs.getString("BDG02"));
				jySmallItemList.add(jySmallItem);
				this.logger.error(jySmallItem.toString());
			}
		} catch (SQLException e) {
			this.logger.error("getAllJySmallItemData Exception", e);
		} finally {
			closeConnection(rs, ps, conn);
		}
		return jySmallItemList;
	}

	protected String trimStr(String str) {
		if (null == str) {
			return "";
		}
		return str.trim();
	}

	public Boolean getLisDateRangChang(String zyh) {
		JianYan jy = getListDataFromHis(zyh, "");
		List<PatientLink> patientLinks = patientLinkDao.getzyh(zyh);
		Boolean flag = false;
		if (jy != null) {
			for (PatientLink patientLink : patientLinks) {
				// patientLink.getCommonShuQinaFangshi().setJg(jy.isJiaGan());
				// patientLink.getCommonShuQinaFangshi().setYg(jy.isYiGan());
				// patientLink.getCommonShuQinaFangshi().setBg(jy.isBingGan());
				// patientLink.getCommonShuQinaFangshi().setKhiv(jy.isKangHIV());
				// patientLink.getCommonShuQinaFangshi().setMd(jy.isMeiDu());
				// patientLink.getCommonShuQinaFangshi().setXcg(jy.getNiaoChangGui());
				// patientLink.getCommonShuQinaFangshi().setNcg(jy.getDianJieZhi());
				// patientLink.getCommonShuQinaFangshi().setXuetang(jy.getXueTang());
				// patientLink.getCommonShuQinaFangshi().setThdb(jy.getcFanYingDanBai());
				// patientLink.getCommonShuQinaFangshi().setEcg(jy.getEcg());
				// patientLink.getCommonShuQinaFangshi().setXueqifx(jy.getXueChangGui());
				// patientLink.getCommonShuQinaFangshi().setDjz(jy.getFeiGongNeng());
				// patientLink.getCommonShuQinaFangshi().setSgn(jy.getXiongPian());
				// patientLink.getCommonShuQinaFangshi().setQitajy(jy.getOtherJianYan());
				// patientLink.getCommonShuQinaFangshi().setXuexing(jy.getBloodType());
				// patientLink.getCommonShuQinaFangshi().setRbc(jy.getRbc());
				// patientLink.getCommonShuQinaFangshi().setHbsad(jy.getHb());
				// patientLink.getCommonShuQinaFangshi().setHbeag(jy.getHct());
				// patientLink.getCommonShuQinaFangshi().setHcvab(jy.getPlt());
				// patientLink.getCommonShuQinaFangshi().setHivagab(jy.getWbc());
				// patientLink.getCommonShuQinaFangshi().setTpab(jy.getTpab());
				// patientLink.getCommonShuQinaFangshi().setTrust(jy.getTrust());
				// patientLink.getCommonShuQinaFangshi().setGgn(jy.getGanGongNeng());
				// patientLink.getCommonShuQinaFangshi().setXuet(jy.getShenGongNeng());
				// patientLink.getCommonShuQinaFangshi().setNxgn(jy.getNingXueGongNeng());
				// patientLink.getCommonShuQinaFangshi().setChsxdt(jy.getChaoShengXDTState());
				// flag = patientLinkDao.addUpdateShuQianFnagShi(patientLink);
			}
		}
		return flag;

	}
}
