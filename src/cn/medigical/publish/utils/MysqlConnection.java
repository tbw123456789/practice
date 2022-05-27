package cn.medigical.publish.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

public class MysqlConnection {
	private static Connection connection = null;
	private static String username = "zing";
	private static String password = "123456";
//	private static String DB_URL = "jdbc:mysql://192.168.35.41:3306/wxzt?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
//	private static String DB_URL = "jdbc:mysql://192.168.100.203:3306/yuangan?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
//	private static String DB_URL = "jdbc:mysql://172.16.16.235:3306/AnesData?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
//	private static String DB_URL = "jdbc:mysql://192.168.169.2:3306/AnesData?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
	private static String DB_URL = "jdbc:mysql://192.168.2.21:3306/AnesData?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
	private static String DB_URL_YUANGAN = "jdbc:mysql://192.168.2.21:3306/yuangan?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
	private static String DB_DRIVER = "com.mysql.jdbc.Driver";

	public static Connection getMysqlConnection() {
		Logger logger = Logger.getLogger("MysqlConnection");
		try {
			Class.forName(DB_DRIVER);
			connection = DriverManager.getConnection(DB_URL, username, password);
			System.out.println("Connect to mysql successfully：" + connection);
			logger.info("Connect to mysql successfully......");
		} catch (Exception e) {
			System.out.println("Connect to mysql failed...");
			e.printStackTrace();
		}
		return connection;
	}

	public static Connection getMysqlConnectionForYuanGan() {
		Logger logger = Logger.getLogger("MysqlConnection");
		try {
			Class.forName(DB_DRIVER);
			connection = DriverManager.getConnection(DB_URL_YUANGAN, username, password);
			System.out.println("Connect to mysql successfully：" + connection);
			logger.info("Connect to mysql successfully......");
		} catch (Exception e) {
			System.out.println("Connect to mysql failed...");
			e.printStackTrace();
		}
		return connection;
	}

}