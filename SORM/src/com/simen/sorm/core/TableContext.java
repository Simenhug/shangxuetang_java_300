package com.simen.sorm.core;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.simen.sorm.bean.ColumnInfo;
import com.simen.sorm.bean.TableInfo;
import com.simen.sorm.utils.JavaFileUtils;
import com.simen.sorm.utils.StringUtils;

/**
 * 负责获取管理数据库所有表结构和类结构的关系，并可以根据表结构生成类结构
 * 
 * @author xinmianhuang
 *
 */
public class TableContext {
	public static Map<String, TableInfo> tables = new HashMap<String, TableInfo>();
	/**
	 * 将po的class对象和表信息对象关联起来，便于重用
	 */
	public static Map<Class, TableInfo> poClassTableMap = new HashMap<Class, TableInfo>();

	private TableContext() {
	};

	static {
		try {
			Connection con = DBManager.getMysqlConnection();
			DatabaseMetaData dbmd = con.getMetaData();

			ResultSet tableRet = dbmd.getTables(null, "%", "%", new String[] { "TABLE" });
			while (tableRet.next()) {
				String tableName = (String) tableRet.getObject("TABLE_NAME");
				TableInfo ti = new TableInfo(tableName, new ArrayList<ColumnInfo>(), new HashMap<String, ColumnInfo>());
				tables.put(tableName, ti);
				ResultSet set = dbmd.getColumns(null, "%", tableName, "%");// 查询表中的所有字段
				while (set.next()) {
					ColumnInfo ci = new ColumnInfo(set.getString("COLUMN_NAME"), set.getString("TYPE_NAME"), 0);
					ti.getColumns().put(set.getString("COLUMN_NAME"), ci);
				}

				ResultSet set2 = dbmd.getPrimaryKeys(null, "5", tableName);
				while (set2.next()) {
					ColumnInfo ci2 = (ColumnInfo) ti.getColumns().get(set2.getObject("COLUMN_NAME"));
					ci2.setKeyType(1);
					ti.getPrimKeys().add(ci2);
				}
				if (ti.getPrimKeys().size() > 0) { // 取唯一主键。。。如果是联合主键，则为空
					ti.setPrimKey(ti.getPrimKeys().get(0));
				}
			}
			// 更新类结构
			createAllJavaFiles();
			//加载po包中所有类，便于重用
			loadTableClasses();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Map<String, TableInfo> getTableInfos() {
		return tables;
	}

	/**
	 * 根据表结构，更新配置的po包下面的Java类 实现了从表结构转化到类结构
	 */
	public static void createAllJavaFiles() {
		Map<String, TableInfo> map = TableContext.tables;
		TypeConvertor convertor = new MySqlTypeConvertor();
		for (TableInfo info : map.values()) {
			JavaFileUtils.makeFile(info, convertor);
		}
	}
	
	/**
	 * 加载所有表的Java类到poClassTableMap中并与表信息关联
	 */
	public static void loadTableClasses() {
		String pkage = DBManager.getConfig().getPoPackage();
		for (TableInfo tableInfo: tables.values()) {
			try {
				Class c = Class.forName(pkage+"."+StringUtils.capFirstLetter(tableInfo.getTname()));
				poClassTableMap.put(c, tableInfo);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		
	}
}
