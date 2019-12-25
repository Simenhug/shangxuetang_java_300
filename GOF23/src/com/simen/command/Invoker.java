package com.simen.command;

public class Invoker {
	private Command command;
	
	void setCommand(Command c) {
		this.command = c;
	}
	
	void call() {
		if(command!=null) {
			command.execute();
		}else {
			System.err.println("no commands available");
		}
	}
	
}
