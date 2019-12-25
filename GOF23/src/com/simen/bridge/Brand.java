package com.simen.bridge;

public interface Brand {
	void sale();
}

class Dell implements Brand{
	@Override
	public void sale() {
		System.out.println("Dell");
	}
}

class Mac implements Brand{
	@Override
	public void sale() {
		System.out.println("Mac");
	}
}

class Alienware implements Brand{
	@Override
	public void sale() {
		System.out.println("Alienware");
	}
}

