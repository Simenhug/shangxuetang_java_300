package com.simen.observer2;

import java.util.Observable;
import java.util.Observer;

public class ConcreteObserver implements Observer {
	private int myState;
	@Override
	public void update(Observable o,Object arg) {
		// TODO Auto-generated method stub
		myState = ((IntSubject)o).getState();
	}
	public void printState() {
		System.out.println(myState);
	}

}
