package com.simen.httpserver.server1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server4 {
	private ServerSocket server;
	public static final String CRLF = "\r\n";
	public static final String SPACE = " ";
	
	public static void main(String[] args) {
		Server4 httpServer = new Server4();
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
			StringBuilder builder = new StringBuilder();
			String requestMsg;
			//read bytes instead of lines
			byte[] data = new byte[20480];
			int len = client.getInputStream().read(data);
			String requestInfo = new String(data,0,len).trim();
			System.out.println(requestInfo);
			
			StringBuilder responseContent = new StringBuilder();
			responseContent.append("<html><head><title>HTTP响应示例</title></head><body>"
					+"Hello Della!</body></html>");
			
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
