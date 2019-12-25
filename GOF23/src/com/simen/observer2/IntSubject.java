package com.simen.observer2;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class IntSubject extends Observable{
	private int state;
	
	private List<Observer> clients = new ArrayList<Observer>();

	public int getState() {
		return state;
	}

	public void set(int state) {
		this.state = state;
		setChanged();//表示目标对象已经做了更改
		notifyObservers(state);//通知所有观察者
	}
}
