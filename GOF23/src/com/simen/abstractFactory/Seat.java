package com.simen.abstractFactory;

public interface Seat {
	void message();
}

class LuxurySeat implements Seat{
	@Override
	public void message() {
		System.out.println("message with heat");
	}
}

class LowerSeat implements Seat{
	@Override
	public void message() {
		System.out.println("message without heat");
	}
}