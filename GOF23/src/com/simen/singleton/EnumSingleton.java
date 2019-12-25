package com.simen.singleton;
//缺点：没有延时加载 优点：实现简单，线程安全，避免通过反射和反序列化的漏洞
public enum EnumSingleton {
	//枚举元素本身就是单例
	INSTANCE;
	//单例可以有自己的操作
	public void singletonOperation() {
		
	}
}
