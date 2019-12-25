package com.simen.chainOfResponsibility;

public abstract class Management {
	protected String name;
	protected Management nextManager;
	
	public Management(String name) {
		super();
		this.name = name;
	}
	
	public void setNextManager(Management m) {
		this.nextManager = m;
	}
	
	public abstract void handleRequest(LeaveRequest request);
}
