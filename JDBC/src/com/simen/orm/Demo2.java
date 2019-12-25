package com.simen.orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/*
 * 测试使用Object数组来封装记录到map中
 */
public class Demo2 {
	public static void main(String[] args) {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement stmt = null;
		Map<String,Map<String,Object>> records = new HashMap<String,Map<String,Object>>();
		try {
			con = JDBCUtil.getMysqlConnection();
			stmt = con.prepareStatement("select empname,birthday,salary from emp");
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String,Object> item = new HashMap<String,Object>();
				item.put("empname", rs.getString("empname"));
				item.put("birthday", rs.getDate("birthday"));
				item.put("salary", rs.getInt("salary"));
				records.put(rs.getString(1), item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAll(rs, stmt, con);
			for(String key: records.keySet()) {
				Map<String, Object> temp = records.get(key);
				for(String key1: temp.keySet()) {
					System.out.print(temp.get(key1)+"\t");
				}
				System.out.println();
			}
		}
	}
}
