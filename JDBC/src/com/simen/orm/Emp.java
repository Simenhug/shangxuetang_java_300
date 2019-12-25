package com.simen.orm;

import java.sql.Date;

public class Emp {
	private int id;
	private String empname;
	private Date birthday;
	private double salary;
	private int age;
	private int deptId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public Emp(int id, String empname, Date birthday, double salary, int age, int deptId) {
		super();
		this.id = id;
		this.empname = empname;
		this.birthday = birthday;
		this.salary = salary;
		this.age = age;
		this.deptId = deptId;
	}
	public Emp(String empname, Date birthday, double salary, int age, int deptId) {
		super();
		this.empname = empname;
		this.birthday = birthday;
		this.salary = salary;
		this.age = age;
		this.deptId = deptId;
	}
	public Emp() {
		
	}
}
