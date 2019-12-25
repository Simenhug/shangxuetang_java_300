package com.simen.jdbc;

/*
 * 测试PreparedStatement的接口的用法，执行SQL语句
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo4 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// 加载驱动类
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dec2019test", "root", "dbfirststep");

			String sql = "select id, username, password from t_user where id>?";// ？是占位符
			stmt = con.prepareStatement(sql);
			stmt.setObject(1, 2);//把id大于2的记录都取出来
			//测试executeQuery
			rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "--" + rs.getString(2) + "--" + rs.getString(3));
			}
			
			//测试executeUpdate
			sql = "insert into t_user (username, password, regTime) values (?,?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setObject(1, "abby");
			stmt.setObject(2, "dellaboss");
			stmt.setObject(3, new java.sql.Date(System.currentTimeMillis()));
			System.out.println("updated rows:");
			System.out.println(stmt.executeUpdate());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭顺序：resultset-->statement-->connection
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
