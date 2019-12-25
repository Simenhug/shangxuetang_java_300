package com.simen.adaptor;

public class Adaptor2 implements Target{
	private Adaptee adaptee;
	
	@Override
	public void handleRequest() {
		adaptee.request();
	}
	
	public Adaptor2(Adaptee adaptee) {
		super();
		this.adaptee = adaptee;
	}
}
