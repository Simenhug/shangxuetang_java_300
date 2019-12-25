package com.simen.sorm.bean;

import java.util.List;
import java.util.Map;

/**
 * 存储表结构的信息
 * @author xinmianhuang
 *
 */
public class TableInfo {
	private String tname;
	private Map<String,ColumnInfo> columns;
	/**
	 * 不支持有一个以上主键的表格
	 */
	private ColumnInfo primKey;
	private List<ColumnInfo> primKeys;
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Map<String, ColumnInfo> getColumns() {
		return columns;
	}
	public void setColumns(Map<String, ColumnInfo> columns) {
		this.columns = columns;
	}
	public ColumnInfo getPrimKey() {
		return primKey;
	}
	public void setPrimKey(ColumnInfo primKey) {
		this.primKey = primKey;
	}
	
	public List<ColumnInfo> getPrimKeys() {
		return primKeys;
	}
	public void setPriKeys(List<ColumnInfo> primKeys) {
		this.primKeys = primKeys;
	}
	public TableInfo(String tname, Map<String, ColumnInfo> columns, ColumnInfo primKey) {
		super();
		this.tname = tname;
		this.columns = columns;
		this.primKey = primKey;
	}
	public TableInfo(String tname, List<ColumnInfo> priKeys, Map<String, ColumnInfo> columns) {
		super();
		this.tname = tname;
		this.columns = columns;
		this.primKeys = priKeys;
	}
	
	public TableInfo() {
		
	}
}
