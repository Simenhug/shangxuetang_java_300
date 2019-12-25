package com.simen.flyweight;

public class Client {
	public static void main(String[] args) {
		ChessFlyWeight chess1 = ChessFlyWeightFactory.getChess("black");
		ChessFlyWeight chess2 = ChessFlyWeightFactory.getChess("black");
		
		System.out.println(chess1);
		System.out.println(chess2);
		
		chess1.display(new Coordinate(13, 14));
		chess2.display(new Coordinate(520, 521));
	}
}
