package Reflection;

import com.simen.httpserver.server3.Servlet;

public class CreateInstance {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> clas = Class.forName("com.simen.httpserver.server3.LoginServlet");
		Servlet servlet = (Servlet) clas.newInstance();	
	}
}
