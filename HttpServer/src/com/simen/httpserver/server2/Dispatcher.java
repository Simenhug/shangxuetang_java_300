package com.simen.httpserver.server2;

import java.io.IOException;
import java.net.Socket;

/*
 * 每一个请求与响应就产生一个此对象
 */

public class Dispatcher implements Runnable{
	private Socket client;
	private Request request;
	private Response response;
	private int statusCode = 200;
	
	@Override
	public void run() {
		Servlet servlet = WebApp.getServlet(request.getUrl());
		try {
			if(servlet==null) {
				this.statusCode = 404;
				response.sendResponse(statusCode);
				return;
			}
			servlet.service(request,response);
			response.sendResponse(statusCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				response.sendResponse(500);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		CloseUtil.closeAll(client);
	}
	public Dispatcher(Socket client) {
		this.client = client;
		this.request = new Request(client);
		this.response = new Response(client);
	}

}
