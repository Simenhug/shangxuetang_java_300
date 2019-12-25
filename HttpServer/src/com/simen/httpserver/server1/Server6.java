package com.simen.httpserver.server1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server6 {
	private ServerSocket server;
	public static final String CRLF = "\r\n";
	public static final String SPACE = " ";
	
	public static void main(String[] args) {
		Server6 httpServer = new Server6();
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
			Response response = new Response(client);
			Request request = new Request(client);
			Servlet servlet = new Servlet(request,response);
			servlet.service();
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
