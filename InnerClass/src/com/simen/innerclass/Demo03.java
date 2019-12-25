package com.simen.innerclass;

import java.util.Date;

public class Demo03 {
	public static void main(String[] args) {
//		InnerClass ic = new Outer3.InnerClass();
		Outer3 o3 = new Outer3();
		Outer3.InnerClass ic = o3.new InnerClass();
		ic.test();
	}
}

class Outer3{
	private int a = 3;
	int b = 10;
	
	public void testing() {
		InnerClass ic = new InnerClass();
	}
	
	//成员内部类
	class InnerClass{
//		static int c = 5; 成员内部类不可以有静态属性或方法，除非声明为final
		final static int c = 5;
//		final static Date meet = new Date(); //这样也不行。final static的只能是编译器可以确定值的常量表达式
		void test() {
			System.out.println(a);
			System.out.println("inner class instance "+this); //成员内部类对象的创建，必须先有外部类对象！
			System.out.println("outer class instance "+Outer3.this); //引用了外部类的对象！
		}
	}
}