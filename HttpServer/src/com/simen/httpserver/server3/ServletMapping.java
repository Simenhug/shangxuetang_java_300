package com.simen.httpserver.server3;

import java.util.HashMap;
import java.util.Map;

public class ServletMapping {
	//给每一个servlet起个别名
	//login ---> com.simen.httpserver.server3.LoginServlet
	private Map<String, String> servlets;
	//url ---> function
	/*
	 * /login ---> login
	 * /signin ---> login
	 */
	private Map<String, String> mapping;
	
	public ServletMapping() {
		servlets = new HashMap<String, String>();
		mapping = new HashMap<String, String>();
	}
	public Map<String, String> getServlets() {
		return servlets;
	}
	public void setServlets(Map<String, String> servlets) {
		this.servlets = servlets;
	}
	public Map<String, String> getMapping() {
		return mapping;
	}
	public void setMapping(Map<String, String> mapping) {
		this.mapping = mapping;
	}
	
	

}
