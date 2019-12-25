package com.simen.httpserver.server2;

public class LoginServlet extends Servlet {

	@Override
	public void doGet(Request request, Response response) throws Exception {
		StringBuilder responseContent = new StringBuilder();
		responseContent.append("<html><head><title>登录页面</title></head><body>");
		/*
		 * 用户名：<input type="text" name="username" id="name"/> 密码：<input type="password"
		 * name="password" id="pass"/>
		 */
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username == null || username.trim().equals("")) {
			responseContent.append("please enter usernmae");
		} else if (password == null || password.trim().equals("")) {
			responseContent.append("please enter password");
		} else if (loginSuccess(username, password)) {
			responseContent.append("Welcome back, " + username);
		} else {
			responseContent.append("username or password incorrect");
		}
		responseContent.append("</body></html>");
		response.add(responseContent.toString());	
	}
	
	public boolean loginSuccess(String username, String password) {
		//for testing
		return username.equals("simen")&&password.contentEquals("lovesdella");
	}

	@Override
	public void doPost(Request request,Response response) throws Exception {
		
		
	}

}
