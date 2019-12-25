package com.simen.flyweight;

public class Coordinate {
	private int X,Y;

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public Coordinate(int x, int y) {
		super();
		X = x;
		Y = y;
	}
	
}
