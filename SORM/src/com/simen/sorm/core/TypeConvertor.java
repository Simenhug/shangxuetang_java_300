package com.simen.sorm.core;
/**
 * 负责Java数据类型和数据库数据类型的互相转换
 * @author xinmianhuang
 *
 */
public interface TypeConvertor {
	/**
	 * 将数据库数据类型转化成Java的数据类型
	 * @param columnType 数据库字段的数据类型
	 * @return java的数据类型
	 */
	public String databaseType2Java(String columnType);
	
	/**
	 * 将Java数据类型转化成数据库数据类型
	 * @param javaType Java数据类型
	 * @return 数据库类型
	 */
	public String javaType2Database(String javaType);
}
