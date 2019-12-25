package com.simen.builderDirector;

public class SpaceShip {
	private OrbitalModule module;
	private Engine engine;
	private EscapeTower tower;
	
	public void launch() {
		System.out.println("ignite");
		System.out.println("detach escape tower");
		System.out.println("launch");
	}
	
	public OrbitalModule getModule() {
		return module;
	}
	public void setModule(OrbitalModule module) {
		this.module = module;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public EscapeTower getTower() {
		return tower;
	}
	public void setTower(EscapeTower tower) {
		this.tower = tower;
	}
	
}

class OrbitalModule{
	private String name;
	public OrbitalModule(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
}

class Engine{
	private String name;
	public Engine(String name) {
		this.name = name;
	}
}

class EscapeTower{
	private String name;
	public EscapeTower(String name) {
		this.name = name;
	}
}