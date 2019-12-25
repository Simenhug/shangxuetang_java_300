package com.simen.sorm.bean;
/***
 * 管理配置信息
 * @author xinmianhuang
 *
 */
public class Configuration {

	private String mysqlURL;
	private String mysqlUser;
	private String mysqlPassword;
	private String usingDB;
	/**
	 * 项目的源码路径
	 */
	private String srcPath;
	/**
	 * 扫描生成Java类的包（po的意思是 persistence object持久化对象）
	 */
	private String poPackage;
	/**
	 * 项目使用的查询类是哪一个类
	 */
	private String queryClass;
	/**
	 * 连接池最小连接数
	 */
	private int minConnectionPoolSize;
	/**
	 * 连接池最大连接数
	 */
	private int maxConectionPoolSize;
	
	public String getMysqlURL() {
		return mysqlURL;
	}
	public void setMysqlURL(String mysqlURL) {
		this.mysqlURL = mysqlURL;
	}
	public String getMysqlUser() {
		return mysqlUser;
	}
	public void setMysqlUser(String mysqlUser) {
		this.mysqlUser = mysqlUser;
	}
	public String getMysqlPassword() {
		return mysqlPassword;
	}
	public void setMysqlPassword(String mysqlPassword) {
		this.mysqlPassword = mysqlPassword;
	}
	public String getUsingDB() {
		return usingDB;
	}
	public void setUsingDB(String usingDB) {
		this.usingDB = usingDB;
	}
	public String getSrcPath() {
		return srcPath;
	}
	public void setSrcPath(String srcPath) {
		this.srcPath = srcPath;
	}
	public String getPoPackage() {
		return poPackage;
	}
	public void setPoPackage(String poPackage) {
		this.poPackage = poPackage;
	}
	public String getQueryClass() {
		return queryClass;
	}
	public void setQueryClass(String queryClass) {
		this.queryClass = queryClass;
	}
	public int getMinConnectionPoolSize() {
		return minConnectionPoolSize;
	}
	public void setMinConnectionPoolSize(int minConnectionPoolSize) {
		this.minConnectionPoolSize = minConnectionPoolSize;
	}
	public int getMaxConectionPoolSize() {
		return maxConectionPoolSize;
	}
	public void setMaxConectionPoolSize(int maxConectionPoolSize) {
		this.maxConectionPoolSize = maxConectionPoolSize;
	}
	public Configuration(String mysqlURL, String mysqlUser, String mysqlPassword, String usingDB, String srcPath,
			String poPackage, String queryClass, int minConnectionPoolSize, int maxConnectionPoolSize) {
		super();
		this.mysqlURL = mysqlURL;
		this.mysqlUser = mysqlUser;
		this.mysqlPassword = mysqlPassword;
		this.usingDB = usingDB;
		this.srcPath = srcPath;
		this.poPackage = poPackage;
		this.queryClass = queryClass;
	}
	
	public Configuration() {
		
	}
}