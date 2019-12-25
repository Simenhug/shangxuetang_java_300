package com.simen.sorm.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simen.sorm.core.DBManager;

public class DBConnectionPool {
	private static DBConnectionPool self;
	private static List<Connection> conPool = null;
	/**
	 * 最小连接数
	 */
	private static final int POOL_MIN_SIZE = DBManager.getConfig().getMinConnectionPoolSize();
	/**
	 * 最大连接数
	 */
	private static final int POOL_MAX_SIZE = DBManager.getConfig().getMaxConectionPoolSize();
	
	static {
		self = new DBConnectionPool();
	}

	private void init() {
		if (conPool == null) {
			conPool = new ArrayList<Connection>();
		}
		while(conPool.size()<POOL_MIN_SIZE) {
			conPool.add(DBManager.createMysqlConnection());
		}
	}
	
	private DBConnectionPool() {
		this.init();
	}
	
	public static synchronized Connection getConnection() {
		Connection con = conPool.remove(conPool.size()-1);
		if(conPool.size()<POOL_MIN_SIZE) {
			conPool.add(DBManager.createMysqlConnection());
		}
		return con;
	}
	
	public static synchronized void close(Connection con) {
		if(conPool.size()<POOL_MAX_SIZE) {
			conPool.add(con);
		} else {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
