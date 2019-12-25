package com.simen.reflection.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//应用反射机制 获取类的信息（类的名字、属性、方法、构造器等）；
public class GetClassInfo {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, NoSuchMethodException {
		String classPath = "com.simen.reflection.demo.User";
		// Class.forName
		Class clas = Class.forName(classPath);
		System.out.println(clas.getName());//获得包名+类名
		System.out.println(clas.getSimpleName());//获得类名
		
		System.out.println("==============");
		//获得属性信息
		Field[] fields = clas.getFields();//只能获取声明public的属性
		System.out.println(fields.length);
		fields = clas.getDeclaredFields();//获取所有属性
		System.out.println(fields.length);
		Field f = clas.getDeclaredField("name");
		for(Field field: fields) {
			System.out.println("field: "+field);
		}
		System.out.println("==========");
		//获得方法信息
		Method[] methods = clas.getMethods();//所有public的本类方法和父类方法
		System.out.println(methods.length);
		for(Method method: methods) {
			System.out.println("method: "+method);
		}
		methods = clas.getDeclaredMethods();//所有本类方法
		System.out.println(methods.length);
		Method method = clas.getDeclaredMethod("getName", null);
		Method method2 = clas.getDeclaredMethod("setName", String.class);
		//获得构造器信息
		Constructor[] cons = clas.getDeclaredConstructors();
		for(Constructor cs: cons) {
			System.out.println(cs);
		}
		Constructor construct = clas.getConstructor(null);
		Constructor construct2 = clas.getConstructor(String.class);
		System.out.println(construct2);
	}
}
