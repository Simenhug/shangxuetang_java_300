package com.simen.httpserver.server4;

public class NameToServlet {
	private String name;
	private String classPath;
	
	public NameToServlet() {
	}
	public NameToServlet(String name, String path) {
		this.name = name;
		this.classPath = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassPath() {
		return classPath;
	}
	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}
}
