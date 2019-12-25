package com.simen.sorm.core;
/**
 * mysql数据类型和Java数据类型的转换
 * @author xinmianhuang
 *
 */
public class MySqlTypeConvertor implements TypeConvertor{

	@Override
	public String databaseType2Java(String columnType) {
		switch (columnType) {
		case "VARCHAR":
		case "TEXT":
			return "String";
		// 整数类
		case "INT":
		case "INT UNSIGNED":
		case "TINYINT":
		case "SMALLINT":
		case "INTEGER":
			return "Integer";
		case "BIGINT":
		case "BIGINT UNSIGNED":
			return "Long";
		case "DOUBLE":
		case "FLOAT":
			return "Double";
		case "CLOB":
			return "java.sql.Clob";
		case "BLOB":
		case "LONGBLOB":
			return "java.sql.Blob";
		case "DATE":
			return "java.sql.Date";
		case "TIME":
			return "java.sql.Time";
		case "TIMESTAMP":
			return "java.sql.Timestamp";
		}
		System.out.println(columnType + " currently not supported by MqlTypeConvertor");
		return null;
	}

	@Override
	public String javaType2Database(String javaType) {
		// TODO Auto-generated method stub
		return null;
	}

}
