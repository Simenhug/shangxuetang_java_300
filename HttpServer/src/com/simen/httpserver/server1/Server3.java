package com.simen.httpserver.server1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server3 {
	private ServerSocket server;
	public static final String CRLF = "\r\n";
	public static final String SPACE = " ";
	
	public static void main(String[] args) {
		Server3 httpServer = new Server3();
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
			
			StringBuilder response = new StringBuilder();
			response.append("HTTP/1.1").append(SPACE).append("200").append(SPACE).append("OK").append(CRLF);
			response.append("Server:simen Server/1.0.0").append(CRLF);
			response.append("Date:").append(new Date()).append(CRLF);
			response.append("Content-type:text/html;charset=utf-8").append(CRLF);
			response.append("Content-Length:").append(responseContent.toString().getBytes().length).append(CRLF);
			response.append(CRLF);
			response.append(responseContent);
			
			BufferedWriter responseWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			responseWriter.write(response.toString());
			responseWriter.flush();
			responseWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void stop() {
		
	}

}
