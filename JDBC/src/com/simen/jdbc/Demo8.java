package com.simen.jdbc;

/*
 * 搜索时间段内的数据
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Demo8 {
	public static long strToDate(String dateStr) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		long date;
		try {
			date = format.parse(dateStr).getTime();
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		ResultSet rs = null;
		try {
			// 加载驱动类
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dec2019test", "root", "sangumaolu");
			stmt = con.prepareStatement("select id,username,regTime from t_user where regTime>? and regTime<? "
					+ "order by regTime");
			stmt.setObject(1, new java.sql.Date(strToDate("2019-12-01")));
			stmt.setObject(2, new java.sql.Date(strToDate("2019-12-10")));
			rs = stmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"--"+rs.getString(2)+"--"+rs.getDate(3));
			}
			System.out.println("\r\n\r\n\r\n=================");
			stmt2 = con.prepareStatement("select id,username,regTime from t_user where regTime>? and regTime<? "
					+ "order by regTime");
			stmt2.setTimestamp(1, new Timestamp(strToDate("2019-11-10")));
			stmt2.setTimestamp(2, new Timestamp(strToDate("2019-11-25")));
			rs = stmt2.executeQuery();
			while(rs.next()) {
				//可以用column name来查询值
				System.out.println(rs.getInt("id")+"--"+rs.getString("username")+"--"+rs.getDate("regTime"));
			}
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
