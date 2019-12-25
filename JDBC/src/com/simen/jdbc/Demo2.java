package com.simen.jdbc;
/*
 * 测试Statement接口的用法，执行SQL语句
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo2 {
	public static void main(String[] args) {
		try {
			//加载驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");//this line is unnecessary
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dec2019test","root","dbfirststep");
			
			//不建议使用Statement，容易发生SQL注入
			Statement stmt = con.createStatement();
			String sql = "insert into Dec2019test.t_user (username, password, regTime) values ('gabe','simenfriend',now())";
			stmt.execute(sql);
			
			//测试SQL注入
			String id = "3 or 1=1"; //这么写的话永远是true，会删除整个table
			String sql1 = "delete from t_user where id="+id;
			stmt.execute(sql1);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
