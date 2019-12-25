package com.simen.javassistdemo;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;

public class Demo2 {
	public static void main(String[] args) throws Exception {
		test6();
	}

	public static void test1() throws Exception {
		// 获得已有类
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("com.simen.javassistdemo.GoalClass");
		
		byte[] byteCode = cc.toBytecode();
		System.out.println(Arrays.toString(byteCode));
		
		System.out.println(cc.getName());//获取完整类名
		System.out.println(cc.getSimpleName());//获取简单类名
		System.out.println(cc.getSuperclass());//获得父类
		System.out.println(cc.getInterfaces());//获得接口	
	}
	
	//测试产生新方法
	public static void test2() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("com.simen.javassistdemo.GoalClass");
		
//		CtMethod m1 = CtMethod.make("public void setNum(int num){this.num = num;}",cc);
		CtMethod m1 = new CtMethod(CtClass.intType, "sum", new CtClass[] {CtClass.intType,CtClass.intType}, cc);
		m1.setModifiers(Modifier.PUBLIC);
		m1.setBody("{System.out.println(\"Della is coming\"); return $1+$2;}");
		cc.addMethod(m1);
		
		//通过反射调用新方法
		Class clas = cc.toClass();
		Method method = clas.getDeclaredMethod("sum", int.class, int.class);
		Object obj = clas.newInstance();
		Object result = method.invoke(obj, 1314, 521);
		System.out.println(result);	
	}
	
	//修改已有方法
	public static void test3() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("com.simen.javassistdemo.GoalClass");
		//获取现有方法
		CtMethod cm = cc.getDeclaredMethod("sayHello", null);
		cm.insertBefore("System.out.println(\"start\");");
		cm.insertBefore("System.out.println(\"hey yo\");");//永远加在当前方法体的最前面，因此这一行在上一个insertBefore前面
		cm.insertAfter("System.out.println(\"end\");");
		
		Class clas = cc.toClass();
		Method m2 = clas.getDeclaredMethod("sayHello");
		Object obj2 = clas.newInstance();
		m2.invoke(obj2);	
	}
	
	//修改属性
	public static void test4() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("com.simen.javassistdemo.GoalClass");
		
//		CtField f1 = CtField.make("private int age", cc);
		CtField f1 = new CtField(CtClass.intType, "age", cc);
		f1.setModifiers(Modifier.PRIVATE);
		cc.addField(f1,"18");//可以初始化属性
		
//		cc.getDeclaredField("age"); 获取属性
		//创建getter setter
		CtNewMethod.getter("getAge", f1);
		CtNewMethod.setter("setAge", f1);
	}
	
	//获得所有构造器
	public static void test5() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("com.simen.javassistdemo.GoalClass");
		
		CtConstructor[] cs = cc.getConstructors();
		for(CtConstructor c: cs) {
			c.insertBefore("System.out.println(\"creation!\");");
			System.out.println(c.getLongName());
		}
	}
	
	//获得注解
	public static void test6() throws Exception {
		CtClass cc = ClassPool.getDefault().get("com.simen.javassistdemo.GoalClass");
		
		Object[] annos = cc.getAnnotations();
		Author author = (Author)annos[0];
		String name = author.name();
		int year = author.year();
		System.out.println("name: "+name+" year: "+year);
	}
}
