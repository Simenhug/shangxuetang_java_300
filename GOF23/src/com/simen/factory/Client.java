package com.simen.factory;

public class Client {
	public static void main(String[] args) {
		Car porsche = new PorscheFactory().makeCar();
		Car della = new CadillacFactory().makeCar();
		Car benz = new BenzFactory().makeCar();
		
		porsche.run();
		della.run();
		benz.run();
	}
}
