package com.simen.bridge;

public class Client {
	public static void main(String[] args) {
		Brand mac = new Mac();
		Desktop2 pc = new Desktop2(mac);
		
		pc.sale();
		
		Brand alien = new Alienware();
		Pad2 pad = new Pad2(alien);
		
		pad.sale();
	}
}
