package com.simen.singleton;
//线程安全，调用效率高，延时加载
public class StaticInner {
	//初始化时不被加载，使用时才被加载
	private static class StaticInnerSingleton{
		//静态内部类被加载时自然生成instance，JVM类加载机制保证了线程安全
		private static final StaticInnerSingleton sis = new StaticInnerSingleton();
	}
	public static StaticInnerSingleton getInstance() {
		return StaticInnerSingleton.sis;
	}
	private StaticInner() {
	}
}
