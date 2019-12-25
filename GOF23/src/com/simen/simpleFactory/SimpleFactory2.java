package com.simen.simpleFactory;

public class SimpleFactory2 {
	public static Car makePorsche() {
		return new Porsche();
	}
	public static Car makeCadi() {
		return new Cadillac();
	}
}
