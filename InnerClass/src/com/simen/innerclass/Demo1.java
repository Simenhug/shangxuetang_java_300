package com.simen.innerclass;

public class Demo1 {
	//静态内部类
	private static class StaticNestedClass{
		
	}
	//普通内部类
	private class FieldNestedClass{
		
	}
	
	void test(){
		//方法内部类（局部内部类）
		class MethodInnerClass{
			
		}
		//匿名内部类
		Runnable runnable = new Runnable() {//两个作用：定义了匿名内部类的类体；创建了匿名内部类的一个实例
			public void run() {};
		};
	}

}
