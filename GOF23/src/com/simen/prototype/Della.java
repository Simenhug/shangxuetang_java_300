package com.simen.prototype;

import java.io.Serializable;
import java.util.Date;

public class Della implements Cloneable, Serializable{
	private String name;
	private Date birthday;
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Object obj = super.clone();
		return obj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Della(String name, Date birthday) {
		super();
		this.name = name;
		this.birthday = birthday;
	}
	
}
