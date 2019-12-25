package com.simen.staticProxy;

public class Client {
	public static void main(String[] args) {
		RealStar star = new RealStar("della");
		Proxy proxy = new Proxy(star);
		
		proxy.bookTicket();
		proxy.confer();
		proxy.interview();
		proxy.sing();
		proxy.collectPayment();
	}
}
