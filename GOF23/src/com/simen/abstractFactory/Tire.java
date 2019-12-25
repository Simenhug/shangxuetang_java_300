package com.simen.abstractFactory;

public interface Tire {
	void rotate();
}

class LuxuryTire implements Tire{

	@Override
	public void rotate() {
		System.out.println("rotate fast");
	}
}

class LowerTire implements Tire{
	@Override
	public void rotate() {
		System.out.println("rotate slow");
	}
}