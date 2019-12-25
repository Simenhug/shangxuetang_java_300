package com.simen.chainOfResponsibility;

public class Director extends Management{

	public Director(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleRequest(LeaveRequest request) {
		int days = request.getDays();
		String empName = request.getEmpName();
		
		if(days<3) {
			System.out.println("employee: "+empName+" |days: "+days+" |reason: "+request.getReason());
			System.out.println("director "+name+" approved.");
		} else if (nextManager!=null) {
			this.nextManager.handleRequest(request);
		} else {
			System.out.println("next level management absent, request rejected");
		}
	}
	
}
