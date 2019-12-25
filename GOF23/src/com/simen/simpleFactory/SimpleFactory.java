package com.simen.simpleFactory;

public class SimpleFactory {
	public static Car makeCar(String brand) {
		if(brand.equals("Porsche")) {
			return new Porsche(); 
		}else if(brand.equals("Cadillac")) {
			return new Cadillac();
		}else {
			return null;
		}
	}
}
