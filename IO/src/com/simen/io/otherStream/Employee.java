package com.simen.io.otherStream;

public class Employee implements java.io.Serializable{
	
	//不需要序列化
	private transient String name;
	private double salary;
	
	

	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public Employee() {};


	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public double getSalary() {
		return salary;
	}




	public void setSalary(double salary) {
		this.salary = salary;
	}




	public static void main(String[] args) {
		

	}

}
