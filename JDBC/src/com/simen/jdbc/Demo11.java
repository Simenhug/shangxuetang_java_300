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
/*
 * 使用工具类和资源文件
 */
public class Demo11 {
	
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = JDBCUtil.getMysqlConnection();
			stmt = con.prepareStatement("insert into t_user (username,password) values (?,?)");
			stmt.setObject(1, "tom");
			stmt.setObject(2, "simenfriend");
			stmt.execute();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			//关闭顺序：resultset-->statement-->connection
			JDBCUtil.closeAll(rs, stmt, con);
		}
	}
}
