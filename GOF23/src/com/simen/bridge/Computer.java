package com.simen.bridge;

public class Computer {
	protected Brand brand;
	public Computer(Brand brand) {
		this.brand = brand;
	}
	
	public void sale() {
		brand.sale();
	}
}

class Desktop2 extends Computer{
	public Desktop2(Brand brand) {
		super(brand);
	}
	
	@Override
	public void sale() {
		super.sale();
		System.out.println("desktop");
	}
}

class Laptop2 extends Computer{
	public Laptop2(Brand brand) {
		super(brand);
	}
	
	@Override
	public void sale() {
		super.sale();
		System.out.println("laptop");
	}
}

class Pad2 extends Computer{
	public Pad2(Brand brand) {
		super(brand);
	}
	
	@Override
	public void sale() {
		super.sale();
		System.out.println("Pad");
	}
}
