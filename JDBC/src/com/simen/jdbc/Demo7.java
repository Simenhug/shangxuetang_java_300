package com.simen.jdbc;

/*
 * 测试事务的原子性
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo7 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			// 加载驱动类
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dec2019test", "root", "dbfirststep");

			con.setAutoCommit(false);
			stmt = con.prepareStatement("insert into t_user (username, password, regTime) values (?,?,?)");
			stmt.setObject(1, "grandma");
			stmt.setObject(2, "lovesimen");
			stmt.setObject(3, new java.sql.Date(System.currentTimeMillis()));
			stmt.execute();
			System.out.println("first statement success!");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			stmt = con.prepareStatement("insert into t_user (username, password, regTime) values (?,?,?)");
			stmt.setObject(1, "grandpa");
			stmt.setObject(2, "lovesimen");
//			stmt.setObject(3, new java.sql.Date(System.currentTimeMillis()));//注释掉这一行，使第二个Statement出错
			stmt.execute();
			System.out.println("second statement success!");
			con.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback(); //这里rollback不加也行
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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