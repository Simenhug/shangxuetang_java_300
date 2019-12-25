package com.simen.httpserver.server2;

import java.util.Map;

public class WebApp {
	private static ServletMapping context;
	
	static {
		context = new ServletMapping();
		
		Map<String,Servlet> servlets = context.getServlets();
		servlets.put("login", new LoginServlet());
		servlets.put("register", new RegisterServlet());
				
		Map<String,String> mapping = context.getMapping();
		mapping.put("/login", "login");
		mapping.put("/signin", "login");
		mapping.put("/signup", "register");
		mapping.put("/register", "register");
	}
	
	public static Servlet getServlet(String url) {
		if(url==null||url.trim()=="") {
			return null;
		}
		String function = context.getMapping().get(url);
		return context.getServlets().get(function);
	}

}
