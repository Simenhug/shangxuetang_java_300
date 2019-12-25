package com.simen.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/*
 * 测试懒汉式单例模式（如何防止反射和反序列化）
 */
public class SingletonReflectionHack implements Serializable{
	//类初始化时，不初始化对象，延时加载，资源利用率高
	public static SingletonReflectionHack instance;
	//私有化构造器
	private SingletonReflectionHack() {
		if(instance!=null) {
			throw new RuntimeException(); //防止通过反射创建额外对象
		}
	}
	//方法同步，调用效率低
	public static synchronized SingletonReflectionHack getInstance() {
		if(instance==null) {
			instance = new SingletonReflectionHack();
		}
		return instance;
	}
	//反序列化时，如果
	private Object readResolve() throws ObjectStreamException{
		return instance;
	}
}
