package com.simen.orm;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class ORMBeanDemo {
	public static void main(String[] args) {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement stmt = null;
		Map<String,Emp> records = new HashMap<String,Emp>();
		try {
			con = JDBCUtil.getMysqlConnection();
			stmt = con.prepareStatement("select empname,birthday,salary,age,deptId from emp");
			rs = stmt.executeQuery();
			while(rs.next()) {
				Emp emp = new Emp(rs.getString(1), rs.getDate(2), rs.getDouble(3), rs.getInt(4), rs.getInt(5));
				records.put(rs.getString(1), emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAll(rs, stmt, con);
			for(String key: records.keySet()) {
				Emp emp = records.get(key);
				System.out.print(""+emp.getEmpname()+"\t"+emp.getBirthday()+"\tsalary: "+emp.getSalary()+"\tage: "+emp.getAge());
				System.out.println();
			}
		}
	}
}
