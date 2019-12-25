package com.simen.singleton;

public class Singleton2 {
	//类初始化时，不初始化对象，延时加载，资源利用率高
	public static Singleton2 instance;
	//私有化构造器
	private Singleton2() {
	}
	//方法同步，调用效率低
	public static synchronized Singleton2 getInstance() {
		if(instance==null) {
			instance = new Singleton2();
		}
		return instance;
	}
}
