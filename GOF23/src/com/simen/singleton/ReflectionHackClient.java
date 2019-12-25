package com.simen.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ReflectionHackClient {
	public static void main(String[] args) throws Exception {
		SingletonReflectionHack srh = SingletonReflectionHack.getInstance();		
		SingletonReflectionHack srh1 = SingletonReflectionHack.getInstance();		
		System.out.println(srh);
		System.out.println(srh1);
		
		//通过反射直接调用私有构造器
//		Class<SingletonReflectionHack> clas = (Class<SingletonReflectionHack>) Class.forName("com.simen.singleton.SingletonReflectionHack");
//		Constructor<SingletonReflectionHack> c = clas.getDeclaredConstructor(null);
//		c.setAccessible(true);
//		
//		SingletonReflectionHack s2 = c.newInstance();
//		SingletonReflectionHack s3 = c.newInstance();
//		
//		System.out.println(s2);
//		System.out.println(s3);
		
		//通过反序列化创建多个对象
		FileOutputStream fos = new FileOutputStream("src/files/test.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(srh);
		fos.flush();
		oos.flush();
		oos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream("src/files/test.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		SingletonReflectionHack srh4 = (SingletonReflectionHack)ois.readObject();
		ois.close();
		fis.close();
		System.out.println(srh4);
	}
}
