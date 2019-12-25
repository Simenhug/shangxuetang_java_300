package com.simen.builderDirector;

public class Client {
	public static void main(String[] args) {
		SpaceShipDirector director = new DellaShipDirector(new DellaShipBuilder());
		SpaceShip ship = director.directSpaceShip();
		
		ship.launch();
	}
}
