package com.simen.httpserver.server1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server5 {
	private ServerSocket server;
	public static final String CRLF = "\r\n";
	public static final String SPACE = " ";
	
	public static void main(String[] args) {
		Server5 httpServer = new Server5();
		httpServer.start(8888);
	}
	
	public void start(int port) {
		try {
			server = new ServerSocket(port);
			this.receive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void receive() {
		try {
			Socket client = server.accept();
			//receive the request message from client side
			Request request = new Request(client);
			
			StringBuilder responseContent = new StringBuilder();
			responseContent.append("<html><head><title>HTTP响应示例</title></head><body>");
			String username = request.getParameter("username");
			username = username==null?"Lord Simen":username;
			responseContent.append("Welcome back, "+username);
			responseContent.append("</body></html>");
			Response response = new Response(client);
			response.add(responseContent.toString());
			response.sendResponse(200);
			response.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void stop() {
		
	}

}
