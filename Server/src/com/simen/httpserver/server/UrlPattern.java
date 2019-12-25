package com.simen.httpserver.server;

import java.util.ArrayList;
import java.util.List;

public class UrlPattern {
	private String name;
	private List<String> urls;
	
	public UrlPattern() {
		this.urls = new ArrayList<String>();
	}
	public UrlPattern(String name) {
		this();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getUrls() {
		return urls;
	}
	public void setUrls(List<String> urls) {
		this.urls = urls;
	}
	
}
