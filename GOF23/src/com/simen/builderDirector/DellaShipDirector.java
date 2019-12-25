package com.simen.builderDirector;

public class DellaShipDirector implements SpaceShipDirector{
	private SpaceShip dellaShip;
	private SpaceShipBuilder builder;
	
	public DellaShipDirector(SpaceShipBuilder builder) {
		// TODO Auto-generated constructor stub
		this.builder = builder;
	}

	@Override
	public SpaceShip directSpaceShip() {
		// TODO Auto-generated method stub
		Engine engine = builder.engineBuilder();
		OrbitalModule module = builder.moduleBuilder();
		EscapeTower tower = builder.towerBuilder();
		
		dellaShip = new SpaceShip();
		dellaShip.setEngine(engine);
		dellaShip.setModule(module);
		dellaShip.setTower(tower);
		
		return dellaShip;
	}
	
	
}
