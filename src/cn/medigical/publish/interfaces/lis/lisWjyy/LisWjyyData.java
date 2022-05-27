package cn.medigical.publish.interfaces.lis.lisWjyy;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import cn.medigical.publish.dao.impl.PatientLisDataDao;
import cn.medigical.publish.interfaces.lis.LisData;
import cn.medigical.publish.pojo.lis.JianYan;
import cn.medigical.publish.pojo.patient.PatientLisData;
import cn.medigical.publish.utils.SpringUtils;

public class LisWjyyData {
	private static LisWjyyData instance;
	private Logger logger=Logger.getLogger(LisWjyyData.class);
	String driverName = "oracle.jdbc.driver.OracleDriver";
    String dbIP = "192.168.0.2";
    String url = "jdbc:oracle:thin:@//192.168.0.2:1521/orcl";
    String username = "bcsm";
    String password = "bcsm";
    private double HBSAG = 0.05;
    private double HBEAG = 1;
    private double HCVAB = 1;
    private double HIVAGAB = 1;
    private double TPAB = 1;
    public Map<String, String> SMALLITEMCODE_PROPERTY;
    PatientLisDataDao patientLisDataDao = SpringUtils.getBean(PatientLisDataDao.class);
    
    public static LisWjyyData getInstance() {
    	if (instance==null) {
			instance=new LisWjyyData();
		}
		return instance;
	}
    
    public  LisWjyyData(){
    	this.SMALLITEMCODE_PROPERTY = new HashMap();

		this.SMALLITEMCODE_PROPERTY.put("RBC", "rbc");
		this.SMALLITEMCODE_PROPERTY.put("HGB", "hb");
		this.SMALLITEMCODE_PROPERTY.put("HCT", "hct");
		this.SMALLITEMCODE_PROPERTY.put("PLT", "plt");
		this.SMALLITEMCODE_PROPERTY.put("WBC", "wbc");
		
		this.SMALLITEMCODE_PROPERTY.put("HBsAg", "hbsag");
		this.SMALLITEMCODE_PROPERTY.put("HBeAg", "hbeag");
		this.SMALLITEMCODE_PROPERTY.put("HCV", "hcvab");
		
		this.SMALLITEMCODE_PROPERTY.put("HIV", "hcvagab");
		this.SMALLITEMCODE_PROPERTY.put("TP-AB", "tpab");
		

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
    
    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driverName.trim());
            connection = DriverManager.getConnection(url, username, password);
            logger.info("Connect to HIS Oracle ok. @" + dbIP);
        } catch (Exception ex) {
            logger.fatal(ex.getMessage(), ex);
        }

        return connection;
    }

    private void closeConnection(Connection connection) {
        if (null != connection) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }
    
    public void getLisDataFromHis(String zyh,String PatientId){
    	JianYan jy;
		String cxlx;
		jy = getJianYan(zyh);
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
    public JianYan getJianYan(String zyh){
    	 Connection conn = getConnection();
         if (null == conn) {
             return null;
         }
         JianYan jYan = new JianYan();
         String strSQL = "SELECT * FROM V_LIS_REP where MRN = '" + zyh + "' ORDER BY AUTHTIME desc";
         // String strSQL = "SELECT * FROM `1` where MRN = '" + zyh + "' ORDER BY AUTHTIME desc";
         ResultSet rs = null;
         PreparedStatement preparedStatement = null;
         try {
             preparedStatement = conn.prepareStatement(strSQL);
             rs = preparedStatement.executeQuery();
             while (rs.next()) {
                 getLisResult(conn, jYan, rs);
             }
         } catch (SQLException e) {
             logger.error(e.getMessage());
         }
         setXueChangGui(jYan);
         closeConnection(conn);
         return jYan;
    }
    
    private void getLisResult(Connection conn, JianYan jianYan, ResultSet rs) throws SQLException {
        if (rs == null)
            return;
        String jy_id = rs.getString("REPORTID");
        if (jy_id == null)
            jy_id = "";
        jy_id = jy_id.trim();
        String strSQL = "SELECT * FROM V_LIS_REPITEMS where EXAMID = '" + jy_id + "' ORDER BY AUTHTIME DESC";
        // String strSQL = "SELECT * FROM `2` where EXAMID = '" + jy_id + "'";
        ResultSet rsRet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(strSQL);
            rsRet = preparedStatement.executeQuery();
            while (rsRet.next()) {
                String itemCode = rsRet.getString("ITEMSHORTNAME");
                if (itemCode == null)
                    itemCode = "";
                itemCode = itemCode.trim();
                String value = rsRet.getString("RESULT");
                if (value == null)
                    value = "";
                value = value.trim();
 //               System.out.println(itemCode+"+++++++++++++++"+value);
                setJianYan(jianYan, itemCode, value);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

	private void setJianYan(JianYan jianYan, String itemCode, String value) {
		try {
			 String itemName="";
		     String fieldName="";
		     String fieldValue="";
		     if (itemCode.contains("RBC")) {
		    	 itemName="RBC";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
		    }
		     else if (itemCode.contains("HGB")) {
		    	 itemName="HGB";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("HGB")) {
		    	 itemName="HGB";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("HCT")) {
		    	 itemName="HCT";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("PLT")) {
		    	 itemName="PLT";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("WBC")) {
		    	 itemName="WBC";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.equals("血型")){
		    	 itemName="ABO";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("RH")) {
		    	 itemName="RH";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("PRO")) {
		    	 itemName="PRO";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("GLU")) {
		    	 itemName="GLU";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("KET")) {
		    	 itemName="KET";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("BLD")) {
		    	 itemName="BLD";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("K")) {
		    	 itemName="K";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}else if (itemCode.contains("Na")) {
		    	 itemName="NA";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("Ca")) {
		    	 itemName="CA";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("Mg")) {
		    	 itemName="MG";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("IP")) {
		    	 itemName="P";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("梅毒螺旋体抗体试验")) {
		    	 itemName="TP-AB";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("TP")) {
		    	 itemName="TP";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("ALB")) {
		    	 itemName="ALB";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("GLB")) {
		    	 itemName="GLB";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("ALT")) {
		    	 itemName="ALT";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("AST")) {
		    	 itemName="AST";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("UREA")) {
		    	 itemName="UREA";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("CREA")) {
		    	 itemName="CREA";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("UA")) {
		    	 itemName="UA";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("GLU")) {
		    	 itemName="GLU";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("HbA1C")) {
		    	 itemName="HbA1C";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("PT-R")) {
		    	 itemName="PT";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("PT-INR")) {
		    	 itemName="PT-INR";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("APTT-T")) {
		    	 itemName="APTT";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("TT-T")) {
		    	 itemName="TT";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("FIB")) {
		    	 itemName="FIB";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("D-Dimer")) {
		    	 itemName="D-Dimer";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("HBsAg")) {
		    	 itemName="HBsAg";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("HBeAg")) {
		    	 itemName="HBeAg";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("HCV")) {
		    	 itemName="HCV";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     else if (itemCode.contains("HIV")) {
		    	 itemName="HIV";
		    	 fieldName= this.SMALLITEMCODE_PROPERTY.get(itemName);
			}
		     if (fieldName!=null && !("").equals(fieldName)) {
		    	 String exitValue=getFieldValue(jianYan, fieldName);
				    if (exitValue!=null) {
						fieldValue=exitValue;
					}
				    if (fieldName.equals("niaoChangGui") ||fieldName.equals("dianJieZhi") ||fieldName.equals("ganGongNeng") ||fieldName.equals("shenGongNeng") ||fieldName.equals("ningXueGongNeng")) {
				    	if (!fieldValue.contains(itemName)) {
				    		fieldValue=fieldValue+itemName+":"+value+" ";
						}
					}else if (fieldName.equals("bloodType")) {
						if (value.equals("阳性")) {
							value="Rh+";
						}
						if (value.equals("阴性")) {
							value="Rh-";
						}
						if (fieldValue!=null&&!("").equals(fieldValue)) {
							if (fieldValue.contains("Rh")) {
								fieldValue=value+" "+fieldValue;
							}else {
								fieldValue=fieldValue+" "+value;
							}
						}else {
							fieldValue=fieldValue+""+value;
						}
					}else if (fieldName.equals("hbsag")) {
						double initValue=Double.parseDouble(value);
						if (initValue>=HBSAG) {
							value="(+)";
						}else {
							value="(-)";
						}
						fieldValue=value;
					}
					else if (fieldName.equals("hbeag")) {
						double initValue=Double.parseDouble(value);
						if (initValue>=HBEAG) {
							value="(+)";
						}else {
							value="(-)";
						}
						fieldValue=value;
					}
					else if (fieldName.equals("hcvab")) {
						double initValue=Double.parseDouble(value);
						if (initValue>=HCVAB) {
							value="(+)";
						}else {
							value="(-)";
						}
						fieldValue=value;
					}
					else if (fieldName.equals("hcvagab")) {
						double initValue=Double.parseDouble(value);
						if (initValue>=HIVAGAB) {
							value="(+)";
						}else {
							value="(-)";
						}
						fieldValue=value;
					}
					else if (fieldName.equals("tpab")) {
						double initValue=Double.parseDouble(value);
						if (initValue>=TPAB) {
							value="(+)";
						}else {
							value="(-)";
						}
						fieldValue=value;
					}
					else {
						fieldValue=value;
					}
				    setFieldValue(jianYan, fieldName, fieldValue);
			}
		} catch (Exception e) {
			logger.error(e);
		}
	    
	}
	
	private void setXueChangGui(JianYan jianYan) {
		StringBuffer buffer=new StringBuffer();
		buffer.append("");
		if (jianYan.getHb()!=null && !("").equals(jianYan.getHb())) {
			buffer.append("HGB:"+jianYan.getHb()+" ");
		}
		if (jianYan.getWbc()!=null && !("").equals(jianYan.getWbc())) {
			buffer.append("WBC:"+jianYan.getWbc()+" ");
		}
		if (jianYan.getPlt()!=null && !("").equals(jianYan.getPlt())) {
			buffer.append("PLT:"+jianYan.getPlt());
		}
		String xcg=buffer.toString();
		if (!("").equals(xcg)) {
			jianYan.setXueChangGui(xcg);
		}
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
}
