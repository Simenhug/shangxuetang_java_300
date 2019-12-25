package com.simen.abstractFactory;

public class LuxuryCarFactory implements CarFactoryInterface{

	@Override
	public Engine createEngine() {
		// TODO Auto-generated method stub
		return new LuxuryEngine();
	}

	@Override
	public Tire createTire() {
		// TODO Auto-generated method stub
		return new LuxuryTire();
	}

	@Override
	public Seat createSeat() {
		// TODO Auto-generated method stub
		return new LuxurySeat();
	}

}
