package com.simen.command;

public interface Command {
	void execute();
}

class ConcreteCommand implements Command{
	private Receiver r;
	public ConcreteCommand(Receiver r) {
		super();
		this.r = r;
	}
	
	@Override
	public void execute() {
		r.action();
	}
}