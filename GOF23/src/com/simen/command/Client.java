package com.simen.command;

public class Client {
	public static void main(String[] args) {
		Invoker della = new Invoker();
		Receiver simen = new Receiver();
		della.setCommand(new ConcreteCommand(simen) );
		
		della.call();
	}
}
