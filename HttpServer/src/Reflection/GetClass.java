package Reflection;

public class GetClass {
	
	public static void main(String[] args) throws ClassNotFoundException {
		/*
		 * three ways to get the Class info
		 */
		
		String str = "I love Della";
		//object.getClass
		System.out.println(str.getClass());
		//Class.class (duh....)
		System.out.println(String.class);
		//most common: Class.forName() static method
		System.out.println(Class.forName("java.lang.String"));
	}

}
