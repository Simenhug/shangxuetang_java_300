package com.simen.prototype;

import java.util.Date;

public class Della2 implements Cloneable{
	private String name;
	private Date birthday;
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Object obj = super.clone();
		
		//深复制
		Della2 d = (Della2) obj;
		d.setBirthday((Date)this.birthday.clone());
		return d;
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

	public Della2(String name, Date birthday) {
		super();
		this.name = name;
		this.birthday = birthday;
	}
	
}
