package com.simen.classloader;
/*
 * 线程上下文类加载器的测试
 */
public class ContextClassLoaderDemo {
	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader loader = ContextClassLoaderDemo.class.getClassLoader();
		System.out.println(loader);
		
		ClassLoader contextLoader = Thread.currentThread().getContextClassLoader();
		System.out.println(contextLoader);
		
		Thread.currentThread().setContextClassLoader(
				new FileSystemClassLoader("/Users/xinmianhuang/Documents/codeheaven/shangxuetang/ClassLoaders/src/com/simen/classloader"));
		System.out.println(Thread.currentThread().getContextClassLoader());
		
		Class<Encrypt> c =(Class<Encrypt>) Thread.currentThread().getContextClassLoader().loadClass("com.simen.classloader.Encrypt");
		System.out.println(c);
		System.out.println(c.getClassLoader());//still AppClassLoader, because FileSystemClassLoader使用了双亲委派机制
	}
}
