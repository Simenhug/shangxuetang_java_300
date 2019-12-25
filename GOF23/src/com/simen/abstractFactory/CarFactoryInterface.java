package com.simen.abstractFactory;

public interface CarFactoryInterface {
	Engine createEngine();
	Tire createTire();
	Seat createSeat();
}
