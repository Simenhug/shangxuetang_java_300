package com.simen.mediator;

public class Client {
	public static void main(String[] args) {
		Manager simen = new Manager();
		
		Department dev = new Developement(simen);
		Department finance = new Finance(simen);
		Department market = new Marketing(simen);
		
		dev.selfAction();
		dev.outAction();
		market.outAction();
		finance.outAction();
	}
}
