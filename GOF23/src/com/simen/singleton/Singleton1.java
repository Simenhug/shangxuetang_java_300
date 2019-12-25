package com.simen.singleton;

public class Singleton1 {
	//类初始化时立刻加载对象，因此天然的保障了线程安全
	public static Singleton1 instance = new Singleton1();
	//私有化构造器
	private Singleton1() {
	}
	//方法没有同步，调用效率高
	public static Singleton1 getInstance() {
		return instance;
	}
}
