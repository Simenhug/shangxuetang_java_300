package com.simen.observer2;

public class Client {
	public static void main(String[] args) {
		IntSubject sub = new IntSubject();
		
		ConcreteObserver obs1 = new ConcreteObserver();
		ConcreteObserver obs2 = new ConcreteObserver();
		ConcreteObserver obs3 = new ConcreteObserver();
		
		sub.addObserver(obs1);
		sub.addObserver(obs2);
		sub.addObserver(obs3);
		
		sub.set(3000);
		obs1.printState();
		obs2.printState();
		obs3.printState();
	}
}
