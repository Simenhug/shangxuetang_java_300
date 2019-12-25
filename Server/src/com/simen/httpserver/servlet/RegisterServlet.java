package com.simen.httpserver.servlet;

import com.simen.httpserver.server.Request;
import com.simen.httpserver.server.Response;

public class RegisterServlet extends Servlet{

	@Override
	public void doGet(Request request, Response response) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doPost(Request request, Response response) throws Exception {
		StringBuilder responseContent = new StringBuilder();
		responseContent.append("<html><head><title>欢迎注册</title></head><body>");
		String username = request.getParameter("username");
		username = username==null?"Lord Simen":username;
		responseContent.append("Welcome aboard, "+username);
		responseContent.append("</body></html>");
		response.add(responseContent.toString());			
	}

}
