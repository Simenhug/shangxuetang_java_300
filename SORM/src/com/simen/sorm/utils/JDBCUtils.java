package com.simen.sorm.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 封装了JDBC查询常用的操作
 * @author xinmianhuang
 *
 */
public class JDBCUtils {
	/**
	 * 用参数填充SQL语句
	 * @param stmt 预编译SQL语句
	 * @param params
	 */
	public static void fillStatement(PreparedStatement stmt, Object[] params) {
		if (params != null) {
			for (int i=0;i<params.length;i++) {
				try {
					stmt.setObject(i+1, params[i]);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} //setObject从1开始数
			}
		}
	}
}