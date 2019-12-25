package com.simen.memento;

public class Originator {
	private String name;
	private int age;
	private double salary;
	
	public Memento memento() {
		return new Memento(this);
	}
	
	public void rollback(Memento meme) {
		this.name = meme.getName();
		this.age = meme.getAge();
		this.salary = meme.getSalary();
	}
	
	public Originator(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
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
