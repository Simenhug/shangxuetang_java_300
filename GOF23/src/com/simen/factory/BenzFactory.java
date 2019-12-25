package com.simen.factory;

public class BenzFactory implements CarFactoryInterface{
	public Car makeCar() {
		return new Benz();
	}
}
