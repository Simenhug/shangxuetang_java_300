package com.simen.innerclass;

public class Demo5 {
	public static void main(String[] args) {
		new Outer5().test();
	}
}
class Outer5{	
	public void test2(Della della) {
		della.run();
	}
	
	public void test() {
		Runnable run = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};
		
		Della della = new Della() {
			@Override
			public void run() {
				System.out.println("super della");
			}
		};
		della.run();
		
		test2(new Della() {
			@Override
			public void run() {
				System.out.println("beautiful della");
			}
		});
	}
}

class Della{
	public void run() {
		System.out.println("della");
	}
}