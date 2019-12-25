package com.simen.chainOfResponsibility;

public class GeneralManager extends Management{

	public GeneralManager(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleRequest(LeaveRequest request) {
		int days = request.getDays();
		String empName = request.getEmpName();
		
		if(days<30) {
			System.out.println("employee: "+empName+" |days: "+days+" |reason: "+request.getReason());
			System.out.println("general manager "+name+" approved.");
		} else {
			System.out.println("leave days unreasonable, request rejected");
		}
	}
	
}
