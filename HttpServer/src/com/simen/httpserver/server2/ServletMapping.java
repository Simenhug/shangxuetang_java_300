package com.simen.httpserver.server2;

import java.util.HashMap;
import java.util.Map;

public class ServletMapping {
	//给每一个servlet起个别名
	//login ---> LoginServlet
	private Map<String, Servlet> servlets;
	//url ---> function
	/*
	 * /login ---> login
	 * /signin ---> login
	 */
	private Map<String, String> mapping;
	
	public ServletMapping() {
		servlets = new HashMap<String, Servlet>();
		mapping = new HashMap<String, String>();
	}
	public Map<String, Servlet> getServlets() {
		return servlets;
	}
	public void setServlets(Map<String, Servlet> servlets) {
		this.servlets = servlets;
	}
	public Map<String, String> getMapping() {
		return mapping;
	}
	public void setMapping(Map<String, String> mapping) {
		this.mapping = mapping;
	}
	
	

}
