package com.simen.state;

public class OccupiedState implements State{

	@Override
	public void handle() {
		// TODO Auto-generated method stub
		System.out.println("room has guests");
	}
	
}
