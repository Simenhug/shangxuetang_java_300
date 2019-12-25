package com.simen.sorm.utils;
/**
 * 封装了字符串常用的操作
 * @author xinmianhuang
 *
 */
public class StringUtils {
	/**
	 * 将首字母变成大写
	 * @param str 源字符串
	 * @return 新字符串
	 */
	public static String capFirstLetter(String str) {
		return str.substring(0, 1).toUpperCase()+str.substring(1);
	}
}
