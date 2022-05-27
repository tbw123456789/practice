package cn.medigical.publish.interfaces.nis.fuyou;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.Date;

/**
 * Created by Medicare on 2016/4/12.
 * Copy right by Medicare
 */
public class YuanGanLinkFuyou  {
    protected Logger logger = Logger.getLogger("YuanGanLink");

    public Connection getConnection() {
        Connection connection = null;
        final String DBDRIVER = "common.mysql.jdbc.Driver";
        final String DBUSER = "zing";
        final String DBURL = "jdbc:mysql://1.1.8.166:3306/yuangan?useUnicode=true&characterEncoding=utf8&autoReconnect=true";
        final String DBPASS = "123456";

        try {
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage());
            logger.error(e.getStackTrace());
        }

        try {
            connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            logger.error(e.getStackTrace());

        }

        return connection;
    }

    public void closeConnection(Connection connection) {
        if (null != connection) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("Could not close connection! " + e.getMessage());
            }
        }
    }

    public boolean addBatch(PatientLink patientLink, PreparedStatement ps) {
        PojoYuanganFuyou pojo = preparePojo(patientLink);
        if (null == pojo) return false;
        try {
            YuanGanLinkFuyou.putData2PS(ps, pojo);
            ps.addBatch();
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            logger.trace(ex.getStackTrace());
            return false;
        } finally {
        }
        return true;
    }

    public static void putData2PS(PreparedStatement ps, Object pojo) throws IllegalAccessException, SQLException {
        Field[] fields = pojo.getClass().getDeclaredFields();
        int i = 1;
        for (Field f : fields) {
            String fn = f.getName();
            if (fn.contains("this")) {
                continue;
            }
            String t = f.getGenericType().toString();
            if (t.equals("class java.lang.String")) {
                if (null != f.get(pojo)) ps.setString(i, (String) f.get(pojo));
                else ps.setString(i, null);
            } else if (t.equalsIgnoreCase("class java.lang.Integer")) {
                if (null != f.get(pojo)) ps.setInt(i, (Integer) f.get(pojo));
                else ps.setString(i, null);
            } else if (t.equalsIgnoreCase("class java.lang.Float")) {
                if (null != f.get(pojo)) ps.setFloat(i, (Float) f.get(pojo));
                else ps.setString(i, null);
            } else if (t.equalsIgnoreCase("class java.util.Date")) {
                if (null != f.get(pojo)) ps.setTimestamp(i, new Timestamp(((Date) f.get(pojo)).getTime()));
                else ps.setTimestamp(i, null);
            } else {
                System.out.println("xxx");
                ps.setString(i, null);
            }
            i++;
        }
    }

    public boolean add(PatientLink patientLink) {
        if (null == patientLink) return false;
        Connection conn = getConnection();
        if (null == conn) {
            return false;
        }
        PojoYuanganFuyou pojo = preparePojo(patientLink);
        if (null == pojo) return false;
        String strSQL = YuanGanLinkFuyou.buildInsertSQL("V_NIS_OPERATION_EVENT", pojo);
        PreparedStatement ps = null;
        boolean isOK = false;
        try {
            ps = conn.prepareStatement(strSQL);
            YuanGanLinkFuyou.putData2PS(ps, pojo);
            int rs = ps.executeUpdate();
            int updatedCount = ps.getUpdateCount();
            if (1 == rs && updatedCount == 1) {
                isOK = true;
            } else {
                System.out.println("Update Event fail rs = " + rs + " count =" + updatedCount + ps);
                isOK = false;
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            logger.trace(ex.getStackTrace());
        } finally {
            try {
                if (null != ps) {
                    ps.close();
                }
                closeConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isOK;
    }

    public static String buildInsertSQL(String tableName, Object object) {
        if (null == object) return "";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" INSERT INTO " + tableName + " ( ");
        Field[] fields = object.getClass().getDeclaredFields();
        boolean isFirst = true;
        int count = 0;
        for (Field f : fields) {
            String fn = f.getName();
            if (fn.contains("this")) continue;
            if (isFirst) {
                isFirst = false;
            } else {
                stringBuffer.append(",");
            }
            stringBuffer.append(fn);
            count++;
        }
        stringBuffer.append(") VALUES ( ");
        isFirst = true;
        for (int i = 0; i < count; i++) {
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

    public Integer find(PatientLink patientLink, Connection conn) throws SQLException {
        String strSQL = "SELECT id from jk_operation WHERE sm_yid = ?";
        PreparedStatement ps = conn.prepareStatement(strSQL);
        ps.setString(1, patientLink.getId());
        ResultSet rs = ps.executeQuery();
        if (null == rs) return null;
        Integer id = null;
        while (rs.next()) {
            id = rs.getInt("id");
            break;
        }
        if (null != rs) {
            rs.close();
        }
        if (null != ps) {
            ps.close();
        }
        return id;
    }

    private PojoYuanganFuyou preparePojo(PatientLink patientLink) {
        PojoYuanganFuyou pojo = new PojoYuanganFuyou();
        if (null == patientLink.getAnesthesiaRecord()) {
            return null;
        }
        if (null != patientLink.getAnesthesiaRecord().getAsa() && null != patientLink.getAnesthesiaRecord().getAsa().getLevel()) {
            switch (patientLink.getAnesthesiaRecord().getAsa().getLevel()) {

            }
        }
        return pojo;
    }
}
