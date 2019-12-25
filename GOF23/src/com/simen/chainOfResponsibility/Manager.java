package com.simen.chainOfResponsibility;

public class Manager extends Management{

	public Manager(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleRequest(LeaveRequest request) {
		int days = request.getDays();
		String empName = request.getEmpName();
		
		if(days<10) {
			System.out.println("employee: "+empName+" |days: "+days+" |reason: "+request.getReason());
			System.out.println("manager "+name+" approved.");
		} else if (nextManager!=null) {
			this.nextManager.handleRequest(request);
		} else {
			System.out.println("next level management absent, request rejected");
		}
	}
	
}
