package com.simen.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ChessFlyWeightFactory {
	public static Map<String,ChessFlyWeight> chessPool = new HashMap<String,ChessFlyWeight>();
	public static ChessFlyWeight getChess(String color) {
		if(chessPool.get(color)!=null) {
			return chessPool.get(color);
		}else {
			ChessFlyWeight chess = new ConcreteChess(color);
			chessPool.put(color, chess);
			return chess;
		}
	}
}
