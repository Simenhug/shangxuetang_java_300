package com.simen.chainOfResponsibility;

public class Client {
	public static void main(String[] args) {
		LeaveRequest request = new LeaveRequest("simen", 10, "visiting della");
		
		Director director = new Director("Brendan");
		Manager manager = new Manager("Shen");
		GeneralManager gm = new GeneralManager("laodao");
		
		director.setNextManager(manager);
		manager.setNextManager(gm);
		
		director.handleRequest(request);
	}
}
