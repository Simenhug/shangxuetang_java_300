package com.simen.javassistdemo;

@Author(name="Simen", year=2019)
public class GoalClass {
	private int num;
	private String name;
	
	public void sayHello() {
		System.out.println("hello there!");
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public GoalClass(){
		
	}
	public GoalClass(int num, String name) {
		this();
		this.name = name;
		this.num = num;
	}
}
