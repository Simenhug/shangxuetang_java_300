package com.simen.simpleFactory;

public class SimpleFactoryClient {
	public static void main(String[] args) {
		Car porsch = SimpleFactory.makeCar("Porsche");
		Car della = SimpleFactory.makeCar("Cadillac");
		//使用工厂模式后，调用者只需要和接口打交道。
		porsch.run();
		della.run();
	}
}
