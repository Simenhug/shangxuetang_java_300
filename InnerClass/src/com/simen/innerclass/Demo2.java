package com.simen.innerclass;


public class Demo2 {
	Outer02.StaticInnerClass osic = new Outer02.StaticInnerClass();
//	StaticInnerClass sic = new StaticInnerClass(); import com.simen.innerclass.Outer02.StaticInnerClass;
}

class Outer02{
	int c = 5;
	static int d =10;
	
	void test() {
		StaticInnerClass sic = new StaticInnerClass();
	}
	
	public static class StaticInnerClass{
		int a = 3;
		static int b = 5;
		
		public void test() {
			System.out.println(a);
//			System.out.println(c);  静态内部类中不能调用外部类的普通成员。只能调用静态成员！
		}
	}
}