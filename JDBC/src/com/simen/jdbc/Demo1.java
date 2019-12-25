package com.simen.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo1 {
	public static void main(String[] args) {
		try {
			//加载驱动类
			//The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
			Class.forName("com.mysql.cj.jdbc.Driver");//this line is unnecessary
			//建立连接（连接对象内部其实包含了Socket对象，是一个远程的连接。比较耗时！这是Connection对象管理的一个要注意的地方）
			//真正开发中，为了提高效率，都会使用连接池来管理连接对象
			long start = System.currentTimeMillis();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dec2019test","root","dbfirststep");
			long end = System.currentTimeMillis();
			System.out.println(con);
			System.out.println("time lapse: "+(end-start)+" milliseconds");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
