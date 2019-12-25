package com.simen.strategy;

public class Client {
	public static void main(String[] args) {
		Context promo = new Context(new NewClientWholesale());
		
		promo.getPrice(1000);
		promo.setStrategy(new NewClientRetail());
		promo.getPrice(1000);
		promo.setStrategy(new OldClientWholesale());
		promo.getPrice(1000);
	}
}
