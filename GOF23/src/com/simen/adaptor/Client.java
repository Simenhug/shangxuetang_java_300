package com.simen.adaptor;

public class Client {
	public static void test1(Target target) {
		target.handleRequest();
	}
	
	public static void main(String[] args) {
		Client della = new Client();
		Adaptee adaptee = new Adaptee();
		Target t = new Adaptor();
		Target t1 = new Adaptor2(adaptee);
		della.test1(t);
		della.test1(t1);
	}
}
