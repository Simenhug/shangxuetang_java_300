package com.simen.jdbc;
/*
 * 测试PreparedStatement的接口的用法，执行SQL语句
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Demo3 {
	public static void main(String[] args) {
		try {
			//加载驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");//this line is unnecessary
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dec2019test","root","dbfirststep");
			
			//不建议使用Statement，容易发生SQL注入
			String sql = "insert into Dec2019test.t_user (username, password, regTime) values (?,?,?)";//？是占位符
			PreparedStatement stmt = con.prepareStatement(sql);
//			stmt.setString(1, "simen");//这里的计数从1开始数，而不是0
//			stmt.setString(2, "lovedella");
			
			//使用setObject处理参数，更方便
			stmt.setObject(1, "della"); 
			stmt.setObject(2, "lovesimen");
			stmt.setObject(3, new java.sql.Date(System.currentTimeMillis()));
			stmt.execute(); //不用再写stmt.execute(sql),preparedStatement在初始化时已经包含sql了	
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
