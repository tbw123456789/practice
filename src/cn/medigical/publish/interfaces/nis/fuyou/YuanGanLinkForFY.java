package cn.medigical.publish.interfaces.nis.fuyou;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import cn.medigical.publish.dao.impl.AccountDao;
import cn.medigical.publish.dao.impl.PatientDrugsDao;
import cn.medigical.publish.dao.impl.PatientLinkDao;
import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.pojo.patient.PatientDrugs;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.utils.Constants;
import cn.medigical.publish.utils.MyDateFormat;
import cn.medigical.publish.utils.MysqlConnection;
import cn.medigical.publish.utils.SpringUtils;

public class YuanGanLinkForFY {
	private Logger logger =Logger.getLogger(YuanGanLinkForFY.class);
	private static YuanGanLinkForFY instance;
	private AccountDao accountDao=SpringUtils.getBean(AccountDao.class);
	private PatientLinkDao patientLinkDao=SpringUtils.getBean(PatientLinkDao.class);
	private PatientDrugsDao patientDrugsDao=SpringUtils.getBean(PatientDrugsDao.class);
	
	public static YuanGanLinkForFY getInstance() {
		if (instance==null) {
			instance=new YuanGanLinkForFY();
		}
		return instance;
	}
	
	
	
	public void AddAnesData(boolean isFirst){
		logger.info("add anesData to mysql~~~");
		List<PatientLink> patientLinks;;
		if (isFirst) {
			patientLinks=patientLinkDao.getFinishOperList();
		}else {
			patientLinks=patientLinkDao.getRecentOperList();
		}
		logger.info("this operList count is :"+patientLinks.size());
		Connection connection=MysqlConnection.getMysqlConnection();
		try {
		for (PatientLink patientLink : patientLinks) {
			if (patientLink.getStatus().getInRoomTime()==null) {
				continue;
			}
			Statement statement=null;
			String insert_doc_operate="insert into  doc_operate (order_id) values ('"+patientLink.getHisID()+"')";
			String insert_doc_clinic_order="insert into  doc_clinic_order (order_id,operator_date) values ('"+patientLink.getHisID()+"','"+getYYmmDDhhmmss(patientLink.getStatus().getInRoomTime())+"')";
			String insert_MED_CUSTOM_DATA="insert into MED_CUSTOM_DATA(patient_id,item_value)values ('"+patientLink.getId()+"','"+patientLink.getAnesthesiaRecord().getAsa().getLevel()+"')";
			String insert_med_operation_master="insert into med_operation_master(patient_id,SCHEDULED_DATE_TIME)values('"+patientLink.getId()+"','"+getYYmmDDhhmmss(patientLink.getStatus().getInRoomTime())+"')";
			
			String select_doc_operate="select count(*) from doc_operate where order_id='"+patientLink.getHisID()+"'";
			String select_doc_clinic_order="select count(*) from doc_clinic_order where order_id='"+patientLink.getHisID()+"'";
			String select_MED_CUSTOM_DATA="select count(*) from MED_CUSTOM_DATA where patient_id='"+patientLink.getId()+"'";
			String select_med_operation_master="select count(*) from med_operation_master where patient_id='"+patientLink.getId()+"'";
			
			//手术操作记录
			if (!exit(select_doc_operate, connection)) {
				statement = connection.createStatement();
				statement.execute(insert_doc_operate);
			}
			//住院医嘱记录
			if (!exit(select_doc_clinic_order, connection)) {
				statement = connection.createStatement();
				statement.execute(insert_doc_clinic_order);
			}
			//记录手术评估
			if (!exit(select_MED_CUSTOM_DATA, connection)) {
				statement = connection.createStatement();
				statement.execute(insert_MED_CUSTOM_DATA);
			}
			//记录病人手术
			if (!exit(select_med_operation_master, connection)) {
				statement = connection.createStatement();
				statement.execute(insert_med_operation_master);
			}
		}	
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void AddYuanGanData(boolean isFirst){
		logger.info("add yunganData to mysql~~~");
		List<PatientLink> patientLinks;;
		if (isFirst) {
			patientLinks=patientLinkDao.getFinishOperList();
		}else {
			patientLinks=patientLinkDao.getRecentOperList();
		}
		logger.info("this operList count is :"+patientLinks.size());
		Connection connection=MysqlConnection.getMysqlConnectionForYuanGan();
		try {
			if (patientLinks!=null && patientLinks.size()>0) {
				for (PatientLink patientLink : patientLinks) {
					if (patientLink.getStatus().getInRoomTime()==null || patientLink.getStatus().getOutRoomTime()==null) {
						continue;
					}
					String YUANGAN_EXIT_SQL="select count(*) from V_LQT_OPER where ID='"+patientLink.getId()+"'";
					if (!exit(YUANGAN_EXIT_SQL, connection)) {
						PojoYuanganFuyou pojoYuanganFuyou=new PojoYuanganFuyou();
						pojoYuanganFuyou.setID(patientLink.getId());
						pojoYuanganFuyou.setZYID(patientLink.getPatient().getZyh());
						if (patientLink.getPatient().getZycs()!=null && !("").equals(patientLink.getPatient().getZycs().trim())) {
							try {
								pojoYuanganFuyou.setVISIT_ID(Integer.valueOf(patientLink.getPatient().getZycs()));
							} catch (Exception e) {
								e.printStackTrace();
							}
							
						}
						pojoYuanganFuyou.setPATIENT_ID(patientLink.getPatient().getZyh());
						pojoYuanganFuyou.setPATIENT_NAME(patientLink.getPatient().getBrxm());
						pojoYuanganFuyou.setOPER_ORDER_NO(patientLink.getHisID());
						
						pojoYuanganFuyou.setOPER_ROOM(patientLink.getSchedule().getPbssjh());
						pojoYuanganFuyou.setOPER_NAME(patientLink.getAnesthesiaRecord().getYsss1());
						pojoYuanganFuyou.setOPER_ID(patientLink.getId());
						pojoYuanganFuyou.setOPER_AT(patientLink.getStatus().getInRoomTime());
						
						if (patientLink.getQualityPojo().getQgss()) {
							pojoYuanganFuyou.setOPER_BW("器官手术");
						}else if (patientLink.getQualityPojo().getQxnss()) {
							pojoYuanganFuyou.setOPER_BW("腔隙手术");
						}else if (patientLink.getQualityPojo().getSbzzss()) {
							pojoYuanganFuyou.setOPER_BW("深层组织手术");
						}else if (patientLink.getQualityPojo().getJczzsh()) {
							pojoYuanganFuyou.setOPER_BW("浅层组织手术");
						}
						
						pojoYuanganFuyou.setOPEDOC_ID(getAccountWorkIdByid(patientLink.getAnesthesiaRecord().getOperDoctor1()));
						pojoYuanganFuyou.setOPEDOC_NAME(getAccountNameByid(patientLink.getAnesthesiaRecord().getOperDoctor1()));
						pojoYuanganFuyou.setANES_DR_NAME(getAccountWorkIdByid(patientLink.getAnesthesiaRecord().getZmys()));
						pojoYuanganFuyou.setOPER_DIAGNOSE(patientLink.getAnesthesiaRecord().getShzd1());
						
						if (patientLink.getQualityPojo().getSsqkfl1()) {
							pojoYuanganFuyou.setINCISION_GRADE(1);
						}else if (patientLink.getQualityPojo().getSsqkfl2()) {
							pojoYuanganFuyou.setINCISION_GRADE(2);
						}
						else if (patientLink.getQualityPojo().getSsqkfl3()) {
							pojoYuanganFuyou.setINCISION_GRADE(3);
						}
						else if (patientLink.getQualityPojo().getSsqkfl4()) {
							pojoYuanganFuyou.setINCISION_GRADE(4);
						}

						if (("Ⅰ").equals(patientLink.getAnesthesiaRecord().getAsa().getLevel())) {
							pojoYuanganFuyou.setASA(1);
						}else if (("Ⅱ").equals(patientLink.getAnesthesiaRecord().getAsa().getLevel())) {
							pojoYuanganFuyou.setASA(2);
						}else if (("Ⅲ").equals(patientLink.getAnesthesiaRecord().getAsa().getLevel())) {
							pojoYuanganFuyou.setASA(3);
						}else if (("Ⅳ").equals(patientLink.getAnesthesiaRecord().getAsa().getLevel())) {
							pojoYuanganFuyou.setASA(4);
						}else if (("Ⅴ").equals(patientLink.getAnesthesiaRecord().getAsa().getLevel())) {
							pojoYuanganFuyou.setASA(5);
						}
						
						if (patientLink.getAnesthesiaRecord().getAsa().getJz()) {
							pojoYuanganFuyou.setURGENT_OPE(0);
						}else {
							pojoYuanganFuyou.setURGENT_OPE(1);
						}
						
						pojoYuanganFuyou.setNARC_KIND(patientLink.getAnesthesiaRecord().getMzff());
					
						if (patientLink.getStatus().getInRoomTime()!=null && patientLink.getStatus().getOutRoomTime()!=null) {
							pojoYuanganFuyou.setOPER_START_TIME(patientLink.getStatus().getInRoomTime());
							pojoYuanganFuyou.setOPER_END_TIME(patientLink.getStatus().getOutRoomTime());
							try {
								double minu= (patientLink.getStatus().getOutRoomTime().getTime()-patientLink.getStatus().getInRoomTime().getTime())/(1000*60);
								pojoYuanganFuyou.setOPER_LENG_TIME(String.valueOf((int)minu) );
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						
						pojoYuanganFuyou.setDEPT_ID(patientLink.getApplication().getSqksbh());
						pojoYuanganFuyou.setDEPT_NAME(patientLink.getApplication().getSqksmc());
						pojoYuanganFuyou.setOPEDOC_NAME2(getAccountNameByid(patientLink.getAnesthesiaRecord().getOperDoctor1Assistant1()));
						pojoYuanganFuyou.setOPEDOC_NAME3(getAccountNameByid(patientLink.getAnesthesiaRecord().getOperDoctor1Assistant2()));
						
						List<PatientDrugs> list=patientDrugsDao.getPatientDrugs8PatientId(patientLink.getId());
						if (list!=null && list.size()>0) {
							pojoYuanganFuyou.setWSQYY(1);
						}else {
							pojoYuanganFuyou.setWSQYY(0);
						}
						
						insertToDB(connection,pojoYuanganFuyou,"V_LQT_OPER");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private boolean exit(String sql,Connection connection) {
		try { 
			Statement sta = connection.createStatement(); 
			ResultSet rs = sta.executeQuery(sql); 
			int count = 0; 
			while (rs.next()) { 
			count = rs.getInt(1); 
			} 
			if(count == 0) { 
			return false;
			} else { 
			return true;
			} 
			} catch (SQLException e) { 
			e.printStackTrace(); 
			return false;
			} 
	}
	
	private String getAccountWorkIdByid(String id){
		if (id==null||("").equals(id)) {
			return " ";
		}
		Account account=accountDao.findById(id);
		if (account!=null) {
			return account.getWorkID();
		}else {
			return " ";
		}
	}
	
	private String getAccountNameByid(String id){
		if (id==null||("").equals(id)) {
			return " ";
		}
		Account account=accountDao.findById(id);
		if (account!=null) {
			return account.getTrueName();
		}else {
			return " ";
		}
	}
	
	private String getAccountWoridByName(String name){
		if (name==null||("").equals(name)) {
			return " ";
		}
		Account account=accountDao.findAccountByName(name);
		if (account!=null) {
			return account.getWorkID();
		}else {
			return " ";
		}
	}
	private String getUrgent(String status){
		if (Constants.OR_TYPE_SCHEDULE.equals(status)) {
			return "否";
		}else {
			return "是";
		}
	}
	private String getYYmmDDhhmmss(Date date){
		if (date==null) {
			return " ";
		}else {
			return MyDateFormat.DATE_FORMAT_YMDHMS.format(date);
		}
		
	}
	
	private boolean insertToDB(Connection conn, Object pojo, String tableName)
	   {
		boolean isOK;
	     String strSQL = buildInsertSQL(tableName, pojo);
	     java.sql.PreparedStatement ps = null;
	     isOK= false;
	     try
	     {
	       ps = conn.prepareStatement(strSQL);
	       putData2PS(ps, pojo);
	       
	       int rs = ps.executeUpdate();
	       int updatedCount = ps.getUpdateCount();
	       if ((1 == rs) && (updatedCount == 1)) {
	         isOK = true;
	       } else {
	         this.logger.error("Update Event fail rs = " + rs + " count =" + updatedCount + ps);
	       }
	       return false;
	     }
	     catch (Exception ex)
	     {
	    	
	       this.logger.error(ex.getMessage(), ex);
	       return false;
	     }
	     finally
	     {
	       try
	       {
	         if (null != ps) {
	           ps.close();
	         }
	//         closeConnection(conn);
	         return false;
	       }
	       catch (SQLException e)
	       {
	         this.logger.error(e.getMessage(), e);
	       }
	     }
	   }
	   
	   public static String buildInsertSQL(String tableName, Object object)
	   {
	     if (null == object) {
	       return "";
	     }
	     StringBuffer stringBuffer = new StringBuffer();
	     stringBuffer.append(" INSERT INTO " + tableName + " ( ");
	     
	     Field[] fields = object.getClass().getDeclaredFields();
	     boolean isFirst = true;
	     int count = 0;
	     for (Field f : fields)
	     {
	       String fn = f.getName();
	       if (!fn.contains("this"))
	       {
	         if (isFirst) {
	           isFirst = false;
	         } else {
	           stringBuffer.append(",");
	         }
	         stringBuffer.append(fn);
	         count++;
	       }
	     }
	     stringBuffer.append(") VALUES ( ");
	     
	     isFirst = true;
	     for (int i = 0; i < count; i++)
	     {
	       if (isFirst) {
	         isFirst = false;
	       } else {
	         stringBuffer.append(",");
	       }
	       stringBuffer.append(" ? ");
	     }
	     stringBuffer.append(")");
	     return stringBuffer.toString();
	   }
	   public  void putData2PS(java.sql.PreparedStatement ps, Object pojo)
			     throws IllegalAccessException, SQLException
			   {
			     Field[] fields = pojo.getClass().getDeclaredFields();
			     int i = 1;
			     for (Field f : fields)
			     {
			       String fn = f.getName();
			       if (!fn.contains("this"))
			       {
			         String t = f.getGenericType().toString();
			         if (t.equals("class java.lang.String"))
			         {
			           if (null != f.get(pojo)) {
			             ps.setString(i, (String)f.get(pojo));
			           } else {
			             ps.setString(i, null);
			           }
			         }
			         else if (t.equalsIgnoreCase("class java.lang.Integer"))
			         {
			           if (null != f.get(pojo)) {
			             ps.setInt(i, ((Integer)f.get(pojo)).intValue());
			           } else {
			             ps.setString(i, null);
			           }
			         }
			         else if (t.equalsIgnoreCase("class java.lang.Float"))
			         {
			           if (null != f.get(pojo)) {
			             ps.setFloat(i, ((Float)f.get(pojo)).floatValue());
			           } else {
			             ps.setString(i, null);
			           }
			         }
			         else if (t.equalsIgnoreCase("class java.util.Date"))
			         {
			           if (null != f.get(pojo)) {
			             ps.setTimestamp(i, new Timestamp(((Date)f.get(pojo)).getTime()));
			           } else {
			             ps.setTimestamp(i, null);
			           }
			         }
			         else
			         {
			           System.out.println("xxx");
			           ps.setString(i, null);
			         }
			         i++;
			       }
			     }
			   }
}
