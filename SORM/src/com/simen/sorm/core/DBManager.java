package com.simen.sorm.core;
/**
 * 根据配置信息，维持连接对象的管理（增加连接池功能）
 * @author xinmianhuang
 *
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Properties;

import com.simen.sorm.bean.Configuration;
import com.simen.sorm.pool.DBConnectionPool;

public class DBManager {
	private static Configuration conf;
	private static Properties prop;
	static {
		conf = new Configuration();
		prop = new Properties();
		try {
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("sormdb.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conf.setMysqlURL(prop.getProperty("mysqlURL"));
		conf.setMysqlUser(prop.getProperty("mysqlUser"));
		conf.setMysqlPassword(prop.getProperty("mysqlPassword"));
		conf.setPoPackage(prop.getProperty("poPackage"));
		conf.setUsingDB(prop.getProperty("usingDB"));
		conf.setSrcPath(prop.getProperty("srcPath"));
		conf.setQueryClass(prop.getProperty("queryClass"));
		conf.setMaxConectionPoolSize(Integer.parseInt(prop.getProperty("maxConnectionPoolSize")));
		conf.setMinConnectionPoolSize(Integer.parseInt(prop.getProperty("minConnectionPoolSize")));
		
		Map map = TableContext.tables;//触发TableContext的重新加载
	}
	public static Configuration getConfig() {
		return conf;
	}
	public static Connection getMysqlConnection() {
		return DBConnectionPool.getConnection();
	}
	public static Connection createMysqlConnection() {
		try {
			return DriverManager.getConnection(conf.getMysqlURL(), 
					conf.getMysqlUser(), 
					conf.getMysqlPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	public static void closeAll(ResultSet rs, Statement stmt, Connection con) {
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (con != null) {
			DBConnectionPool.close(con);
		}
	}
}
