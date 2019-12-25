package com.simen.reflection.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//通过反射机制，动态操作 构造器、方法、属性
public class UseClassInfo {

	public static void main(String[] args) {
		try {
			String classPath = "com.simen.reflection.demo.User";
			//调用构造器
			Class<User> clas = (Class<User>)Class.forName(classPath);
			User user = clas.newInstance();//注意这里调用的是无参构造，所以写Java beans一定要加无参构造！！！！！！
			System.out.println(user);

			Constructor<User> con = clas.getDeclaredConstructor(String.class);
			User user2 = con.newInstance("simen");
			System.out.println(user2.getName());
			//调用方法
			Method method = clas.getDeclaredMethod("setName", String.class);
			method.invoke(user, "della");
			System.out.println(user.getName());
			//操作属性
			Field field = clas.getDeclaredField("name");
			field.setAccessible(true);//访问private属性
			field.set(user, "simensays");
			System.out.println(user.getName());
			System.out.println(field.get(user));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
