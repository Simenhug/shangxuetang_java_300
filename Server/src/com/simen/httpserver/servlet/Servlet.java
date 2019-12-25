package com.simen.httpserver.servlet;

import java.io.IOException;
import java.net.Socket;

import com.simen.httpserver.server.Request;
import com.simen.httpserver.server.Response;

public abstract class Servlet {
	
	public void service(Request request,Response response) throws Exception {
		this.doGet(request, response);
		this.doPost(request, response);
	}
	
	public abstract void doGet(Request request,Response response) throws Exception;
	public abstract void doPost(Request request,Response response) throws Exception;
}
