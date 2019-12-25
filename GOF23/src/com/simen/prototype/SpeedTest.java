package com.simen.prototype;

public class SpeedTest {
	public static void main(String[] args) throws Exception {
		long startTime = System.currentTimeMillis();
		buildWithConstructor();
		long endTime = System.currentTimeMillis();
		System.out.println("with constructor: "+(endTime-startTime));
		
		
		long startTime2 = System.currentTimeMillis();
		buildWithPrototype();
		long endTime2 = System.currentTimeMillis();
		System.out.println("with prototype: "+(endTime2-startTime2));
	}
	
	public static void buildWithConstructor(){
		for(int i=0;i<1000;i++) {
			Laptop lap = new Laptop();
		}
	}
	
	public static void buildWithPrototype() throws Exception {
		Laptop top = new Laptop();
		for(int i=0;i<1000;i++) {
			Laptop lap = (Laptop) top.clone();
		}
	}
}

class Laptop implements Cloneable{
	public Laptop() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Object obj = super.clone();
		return obj;
	}
}