package com.simen.httpserver.server3;

import java.util.Map;

public class WebApp {
	private static ServletMapping context;
	
	static {
		context = new ServletMapping();
		
		Map<String,String> servlets = context.getServlets();
		servlets.put("login", "com.simen.httpserver.server3.LoginServlet");
		servlets.put("register", "com.simen.httpserver.server3.RegisterServlet");
				
		Map<String,String> mapping = context.getMapping();
		mapping.put("/login", "login");
		mapping.put("/signin", "login");
		mapping.put("/signup", "register");
		mapping.put("/register", "register");
	}
	
	public static Servlet getServlet(String url) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		if(url==null||url.trim()=="") {
			return null;
		}
		String function = context.getMapping().get(url);
		String className = context.getServlets().get(function);
		//动态创建对象
		return (Servlet) Class.forName(className).newInstance();
	}

}
