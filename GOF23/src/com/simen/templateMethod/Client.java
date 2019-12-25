package com.simen.templateMethod;

public class Client {
	public static void main(String[] args) {
		Template withdraw = new WithdrawTemplate();
		withdraw.process();
		
		Template deposit = new Template() {
			
			@Override
			public void transaction() {
				// TODO Auto-generated method stub
				System.out.println("making deposit");
			}
		};
		
		deposit.process();
	}
}
