package com.simen.abstractFactory;

public class LowerCarFactory implements CarFactoryInterface{

	@Override
	public Engine createEngine() {
		// TODO Auto-generated method stub
		return new LowerEngine();
	}

	@Override
	public Tire createTire() {
		// TODO Auto-generated method stub
		return new LowerTire();
	}

	@Override
	public Seat createSeat() {
		// TODO Auto-generated method stub
		return new LowerSeat();
	}

}
