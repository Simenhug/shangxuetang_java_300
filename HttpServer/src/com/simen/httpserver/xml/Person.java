package com.simen.httpserver.xml;

public class Person {
	private String name;
	private int age;
	
	public Person() {
	}
	public Person(String name,int age) {
		this();
		this.name = name;
		this.age = age;
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
	
	
}
