package com.simen.builderDirector;

public class DellaShipBuilder implements SpaceShipBuilder{

	@Override
	public OrbitalModule moduleBuilder() {
		// TODO Auto-generated method stub
		System.out.println("building Della module");
		return new OrbitalModule("dellaModule");
	}

	@Override
	public Engine engineBuilder() {
		// TODO Auto-generated method stub
		System.out.println("building Della engine");
		return new Engine("dellaEngine");
	}

	@Override
	public EscapeTower towerBuilder() {
		// TODO Auto-generated method stub
		System.out.println("building Della tower");
		return new EscapeTower("dellaTower");
	}
	
}
