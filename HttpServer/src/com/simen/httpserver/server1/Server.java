package com.simen.httpserver.server1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket server;
	
	public static void main(String[] args) {
		Server httpServer = new Server();
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
			BufferedReader requestReader = new BufferedReader(
					new InputStreamReader(client.getInputStream()));
			while((requestMsg=requestReader.readLine()).length()>0) {
				builder.append(requestMsg);
				builder.append("\r\n");
			}
			String requestInfo = builder.toString().trim();
			System.out.println(requestInfo);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void stop() {
		
	}

}
