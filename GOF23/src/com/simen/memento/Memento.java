package com.simen.memento;

public class Memento {
	private String name;
	private int age;
	private double salary;
	
	public Memento(Originator ori) {
		this.name = ori.getName();
		this.age = ori.getAge();
		this.salary = ori.getSalary();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
