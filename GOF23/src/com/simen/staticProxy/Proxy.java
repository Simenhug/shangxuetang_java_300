package com.simen.staticProxy;

public class Proxy implements Star{
	private RealStar star;
	@Override
	public void bookTicket() {
		// TODO Auto-generated method stub
		System.out.println("proxy booking ticket");
	}

	@Override
	public void interview() {
		// TODO Auto-generated method stub
		System.out.println("proxy interview");
	}

	@Override
	public void confer() {
		// TODO Auto-generated method stub
		System.out.println("proxy confer");
	}

	@Override
	public void sing() {
		// TODO Auto-generated method stub
		star.sing();
	}

	@Override
	public void collectPayment() {
		// TODO Auto-generated method stub
		System.out.println("proxy collect payment");
	}
	
	public Proxy(RealStar star) {
		this.star = star;
	}
	
}
