package com.simen.observer;

public class ConcreteObserver implements Observer{
	private int myState;
	
	@Override
	public void update(Subject subject) {
		this.myState = ((IntSubject)subject).getState();
	}
	public int getState() {
		return myState;
	}
}
