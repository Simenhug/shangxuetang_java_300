package com.simen.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	private List<Observer> clients = new ArrayList<Observer>();
	
	public void addObserver(Observer obs) {
		clients.add(obs);
	}
	
	public void removeObserver(Observer obs) {
		clients.remove(obs);
	}
	
	public void notifyAllObserver() {
		for(Observer obs: clients) {
			obs.update(this);
		}
	}
}
