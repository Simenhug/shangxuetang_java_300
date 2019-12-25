package com.simen.decorator;

public class Client {
	public static void main(String[] args) {
		Car car = new Car();
		car.move();
		
		System.out.println("adding flying ability----");
		FlyCar flyer = new FlyCar(car);
		flyer.move();
		
		System.out.println("adding diving ability----");
		DiveCar diver = new DiveCar(flyer);
		diver.move();
		
	}
}
