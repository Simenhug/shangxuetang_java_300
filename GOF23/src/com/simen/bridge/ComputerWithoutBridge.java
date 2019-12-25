package com.simen.bridge;

public interface ComputerWithoutBridge {
	void sale();
}

class Desktop implements ComputerWithoutBridge{
	@Override
	public void sale(){
		System.out.println("desktop");
	}
}

class Laptop implements ComputerWithoutBridge{
	@Override
	public void sale() {
		System.out.println("laptop");
	}
}

class Pad implements ComputerWithoutBridge{
	@Override
	public void sale() {
		System.out.println("pad");
	}
}

class MacPC extends Desktop{
	@Override
	public void sale() {
		System.out.println("Mac PC");
	}
}

class Macbook extends Laptop{
	@Override
	public void sale() {
		System.out.println("Macbook");
	}
}

class IPad extends Pad{
	@Override
	public void sale() {
		System.out.println("Ipad");
	}
}

class DellPC extends Desktop{
	@Override
	public void sale() {
		System.out.println("Dell PC");
	}
}

class DellLaptop extends Laptop{
	@Override
	public void sale() {
		System.out.println("Dell Laptop");
	}
}

class DellPad extends Pad{
	@Override
	public void sale() {
		System.out.println("Dell Pad");
	}
}