package com.simen.observer;

public class Client {
	public static void main(String[] args) {
		IntSubject subject = new IntSubject();
		
		ConcreteObserver obs1 = new ConcreteObserver();
		ConcreteObserver obs2 = new ConcreteObserver();
		ConcreteObserver obs3 = new ConcreteObserver();
		
		subject.addObserver(obs1);
		subject.addObserver(obs2);
		subject.addObserver(obs3);
		
		subject.setState(3000);
		
		System.out.println(obs1.getState());
		System.out.println(obs2.getState());
		System.out.println(obs3.getState());
	}
}
