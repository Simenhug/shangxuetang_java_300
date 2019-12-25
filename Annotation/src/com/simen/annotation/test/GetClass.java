package com.simen.annotation.test;

public class GetClass {

	public static void main(String[] args) throws ClassNotFoundException {
		String classPath = "com.simen.annotation.test.User";
		//Class.forName
		Class clas = Class.forName(classPath);
		System.out.println(clas.hashCode());
		//name.Class
		Class clas2 = User.class;
		System.out.println(clas2.hashCode());
		//object.getClass
		User user = new User();
		Class clas3 = user.getClass();
		System.out.println(clas3.hashCode());
		
		Class intClas = int.class;
		
		int[] a1 = new int[10];
		int[] a2 = new int[20];
		System.out.println(a1.getClass().hashCode()+"\r\n"+a2.getClass().hashCode());
		
		int[][] a3 = new int[5][5];
		System.out.println(a3.getClass().hashCode());
		double[] d1 = new double[89];
		System.out.println(d1.getClass().hashCode());
	}
}
