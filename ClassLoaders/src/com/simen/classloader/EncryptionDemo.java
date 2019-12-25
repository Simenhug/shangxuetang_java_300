package com.simen.classloader;
/*
 * 测试简单加密解密（取反）操作
 */
public class EncryptionDemo {
	public static void main(String[] args) throws ClassNotFoundException {
		int a = 3; //00000011
		System.out.println(Integer.toBinaryString(a^0xff));
		
		Encrypt.encrypt("/Users/xinmianhuang/Documents/codeheaven/shangxuetang/JavassistDemo/bin/com/simen/javassistdemo/GoalClass.class", 
				"src/files/GoalClass.Class");
		
		DecryptClassLoader loader = new DecryptClassLoader("src/files", false);
		Class<?> c = loader.loadClass("com.simen.javassistdemo.GoalClass");
		System.out.println(c);
	}
}
