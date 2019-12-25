package com.simen.reflection.demo;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

//反射机制操作泛型
public class GenericReflection {
	public void test1(Map<String,User> map, List<User> list) {
		System.out.println("simen");
	}
	
	public Map<Integer, User> test2() {
		System.out.println("della");
		return null;
	}
	
	public static void main(String[] args) {
		try {
			//获得指定方法的参数泛型信息
			Method m = GenericReflection.class.getMethod("test1", Map.class, List.class);
			Type[] types = m.getGenericParameterTypes();
			for(Type paramType: types) {
				System.out.println("#"+paramType);
				if(paramType instanceof ParameterizedType) {
					Type[] genericTypes = ((ParameterizedType)paramType).getActualTypeArguments();
					for(Type genericType: genericTypes) {
						System.out.println("泛型类型"+genericType);
					}
				}
			}
			
			//获得指定方法的返回值泛型信息
			Method m2 = GenericReflection.class.getMethod("test2", null);
			Type returnType = m2.getGenericReturnType();
			if(returnType instanceof ParameterizedType) {
				Type[] genericTypes = ((ParameterizedType)returnType).getActualTypeArguments();
				for(Type genericType: genericTypes) {
					System.out.println("返回值，泛型类型："+genericType);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
