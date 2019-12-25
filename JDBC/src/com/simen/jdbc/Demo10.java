package com.simen.jdbc;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
/*
 * 测试CLOB文本大对象的用法
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Demo10 {
	
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		ResultSet rs = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			// 加载驱动类
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dec2019test", "root", "sangumaolu");
			stmt = con.prepareStatement("insert into t_user (username,avatar) values (?,?)");
			stmt.setObject(1, "della");
//			stmt.setClob(2, new FileReader("src/files/text.txt"));
			stmt.setBlob(2, new FileInputStream("src/files/della.JPG"));
			stmt.execute();
			
			stmt2 = con.prepareStatement("select * from t_user where id=?");
			stmt2.setObject(1, "5004");
			rs = stmt2.executeQuery();
			while(rs.next()) {
				Blob blob = rs.getBlob("avatar");
				int temp = 0;
				is = blob.getBinaryStream();
				os = new FileOutputStream("src/files/copy.jpg");
				while(-1!=(temp=is.read())) {
					os.write(temp);
				}
				os.flush();
			}
		} catch (Exception e) {
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
				if(is!=null) {
					is.close();
				}
				if(os!=null) {
					os.close();
				}
			} catch (IOException e) {
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
