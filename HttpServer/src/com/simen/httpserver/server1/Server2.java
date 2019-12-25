package com.simen.httpserver.server1;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
	private ServerSocket server;
	
	public static void main(String[] args) {
		Server2 httpServer = new Server2();
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
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void stop() {
		
	}

}
