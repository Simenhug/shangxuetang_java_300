package com.simen.builderDirector;

public interface SpaceShipBuilder {
	OrbitalModule moduleBuilder();
	Engine engineBuilder();
	EscapeTower towerBuilder();

}
