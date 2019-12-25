package com.simen.httpserver.server1;

import java.io.IOException;
import java.net.Socket;

public class Servlet {
	
	private Response response;
	private Request request;
	
	public void service() throws IOException {
		
		StringBuilder responseContent = new StringBuilder();
		responseContent.append("<html><head><title>HTTP响应示例</title></head><body>");
		String username = request.getParameter("username");
		username = username==null?"Lord Simen":username;
		responseContent.append("Welcome back, "+username);
		responseContent.append("</body></html>");
		response.add(responseContent.toString());
	}
	
	public Servlet(Request request,Response response) {
		this.request = request;
		this.response = response;
	}
}
