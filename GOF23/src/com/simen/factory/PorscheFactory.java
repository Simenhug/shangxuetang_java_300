package com.simen.factory;

public class PorscheFactory implements CarFactoryInterface{
	public Car makeCar() {
		return new Porsche();
	}
}
