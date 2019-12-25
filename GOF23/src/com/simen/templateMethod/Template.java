package com.simen.templateMethod;

public abstract class Template {
	public void takeNumber() {
		System.out.println("get line number, waiting");
	}
	
	public abstract void transaction();
	
	public void evaluate() {
		System.out.println("evaluate experience");
	}
	
	public final void process() {
		takeNumber();
		transaction();
		evaluate();
	}
}
