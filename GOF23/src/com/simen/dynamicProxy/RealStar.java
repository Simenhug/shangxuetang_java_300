package com.simen.dynamicProxy;

public class RealStar implements Star{
	private String name;
	@Override
	public void bookTicket() {
		// TODO Auto-generated method stub
		System.out.println("real star booking tickets");
	}

	@Override
	public void interview() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sing() {
		// TODO Auto-generated method stub
		System.out.println(name+" singing");
	}

	@Override
	public void collectPayment() {
		// TODO Auto-generated method stub
		
	}
	
	public RealStar(String name) {
		this.name = name;
	}

}
