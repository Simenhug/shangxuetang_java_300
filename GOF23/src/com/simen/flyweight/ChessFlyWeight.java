package com.simen.flyweight;

public interface ChessFlyWeight {
	String getColor();
	void display(Coordinate c);
}

class ConcreteChess implements ChessFlyWeight{
	private String color;
	
	public ConcreteChess(String color) {
		this.color = color;
	}

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return this.color;
	}

	@Override
	public void display(Coordinate c) {
		// TODO Auto-generated method stub
		System.out.println("color: "+this.color+" | position: "+c.getX()+","+c.getY());
		
	}
	
}
