package com.simen.jdbc;

/*
 * 测试batch用法
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo5 {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;

		try {
			// 加载驱动类
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dec2019test", "root", "dbfirststep");

			con.setAutoCommit(false);//关闭自动提交事务
			stmt = con.createStatement();
			long start = System.currentTimeMillis();
			for(int i=0;i<20000;i++) {
				stmt.addBatch("insert into t_user(username, password, regTime) values ('simen"+i+"', 'lovedella', now())");
			}
			stmt.executeBatch();
			con.commit();//提交事务
			long end = System.currentTimeMillis();
			System.out.println("time lapse for executing 20000 statements: "+(end-start));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭顺序：resultset-->statement-->connection
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
