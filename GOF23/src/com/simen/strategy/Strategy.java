package com.simen.strategy;

public interface Strategy {
	double setPrice(double standardPrice);
}

class NewClientRetail implements Strategy{
	@Override
	public double setPrice(double standardPrice) {
		System.out.println("no sale");
		return standardPrice;
	}
}

class NewClientWholesale implements Strategy{
	@Override
	public double setPrice(double standardPrice) {
		System.out.println("10% off");
		return standardPrice*0.9;
	}
}

class OldClientRetail implements Strategy{
	@Override
	public double setPrice(double standardPrice) {
		System.out.println("15% off");
		return standardPrice*0.85;
	}
}

class OldClientWholesale implements Strategy{
	@Override
	public double setPrice(double standardPrice) {
		System.out.println("20% off");
		return standardPrice*0.8;
	}
}