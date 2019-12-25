package com.simen.innerclass;

public class Demo04 {
	public static void main(String[] args) {
		Outer4 o4 = new Outer4();
		o4.test();
	}
}

class Outer4{
	public void test() {
		int a = 3;
		final int d = 4;
//		Inner tooearly = new Inner(); 必须先声明，后引用
		class Inner{
//			static int b = 5; 方法内部类中只能定义非静态成员
			int c = 6;
			void test() {
				System.out.println(c);
//				System.out.println(a); 方法内部类中不能引用所在方法的普通局部变量，除非是final常量。
				//原因：方法内部类和方法的生命周期不一定一致
				System.out.println(d);
			}
		}
		Inner inner = new Inner();
		inner.test();
		a = 4; //解除effectively final
	}
	
	void test2() {
//		Inner inner = new Inner(); 不可见
	}
}
