package com.simen.observer;

public class IntSubject extends Subject{
	private int state;
	
	public void setState(int state) {
		this.state = state;
		this.notifyAllObserver();
	}
	
	public int getState() {
		return state;
	}
}
