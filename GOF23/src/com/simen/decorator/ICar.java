package com.simen.decorator;
//component
public interface ICar {
	void move();
}
//concrete component
class Car implements ICar{
	@Override
	public void move() {
		System.out.println("car running");
	}
}
//decorator
class SuperCar implements ICar{
	private ICar car;
	public SuperCar(ICar car) {
		super();
		this.car = car;
	}
	
	@Override
	public void move() {
		car.move();
	}
}
//concrete decorator
class FlyCar extends SuperCar{
	private ICar car;
	public FlyCar(ICar car) {
		super(car);
	}
	
	public void fly() {
		System.out.println("flying");
	}
	@Override
	public void move() {
		super.move();
		fly();
	}
}

class DiveCar extends SuperCar{
	private ICar car;
	public DiveCar(ICar car) {
		super(car);
	}
	
	public void dive() {
		System.out.println("diving");
	}
	@Override
	public void move() {
		super.move();
		dive();
	}
}

class AICar extends SuperCar{
	private ICar car;
	public AICar(ICar car) {
		super(car);
	}
	
	public void autopilot() {
		System.out.println("auto driving");
	}
	@Override
	public void move() {
		super.move();
		autopilot();
	}
}