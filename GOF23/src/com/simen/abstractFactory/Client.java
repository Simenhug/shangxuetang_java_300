package com.simen.abstractFactory;

public class Client {
	public static void main(String[] args) {
		LuxuryCarFactory luxury = new LuxuryCarFactory();
		LowerCarFactory low = new LowerCarFactory();
		
		Engine ferrari = luxury.createEngine();
		Seat honda = low.createSeat();
		
		ferrari.start();
		ferrari.run();
		honda.message();
	}
}
