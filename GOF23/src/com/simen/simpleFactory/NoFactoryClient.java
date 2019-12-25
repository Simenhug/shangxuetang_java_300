package com.simen.simpleFactory;

public class NoFactoryClient {
	public static void main(String[] args) {
		Car porsch = new Porsche();
		Car della = new Cadillac();
		
		porsch.run();
		della.run();
	}
	//不使用工厂模式时，调用者需要了解所有接口以及实现类，低耦合度，不方便
}
