package com.simen.state;

public class Client {
	public static void main(String[] args) {
		Context room1610 = new Context();
		room1610.setState(new AvailableState());
		room1610.setState(new BookedState());
		room1610.setState(new OccupiedState());
	}
}
