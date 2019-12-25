package com.simen.classloader;
/*
 * 测试自定义的FileSystemClassLoader
 */
public class Demo1 {
	 public static void main(String[] args) throws ClassNotFoundException {
		FileSystemClassLoader loader = new FileSystemClassLoader("/Users/xinmianhuang/Documents/codeheaven/shangxuetang/JavassistDemo");
		FileSystemClassLoader loader2 = new FileSystemClassLoader("/Users/xinmianhuang/Documents/codeheaven/shangxuetang/JavassistDemo");
		
		Class<?> c = loader.loadClass("com.simen.javassistdemo.GoalClass");
		Class<?> c2 = loader.loadClass("com.simen.javassistdemo.GoalClass");
		//同一个类被不同的类加载器加载，JVM认为是不同的类
		Class<?> c3 = loader2.loadClass("com.simen.javassistdemo.GoalClass");
		//Java核心包
		Class<?> c4 = loader2.loadClass("java.lang.String");
		Class<?> c5 = loader2.loadClass("com.simen.classloader.Demo1");
		
		System.out.println(c.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(c3.hashCode());
		System.out.println(c4.getClassLoader()); //引导类加载器
		System.out.println(c3.getClassLoader()); //自定义的类加载器
		System.out.println(c5.getClassLoader()); //系统默认的类加载器
	}
}
