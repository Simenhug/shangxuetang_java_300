package com.simen.httpserver.server;
/*
 * 支持多线程和dispatcher
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
	private ServerSocket server;
	public static final String CRLF = "\r\n";
	public static final String SPACE = " ";
	private boolean isRunning = true;
	
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
			stop();
		}
	}

	private void receive() {
		try {
			while (isRunning) {
				Socket client = server.accept();
				// receive the request message from client side
				new Thread(new Dispatcher(client)).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			stop();
		}
	}
	
	public void stop() {
		isRunning = false;
		CloseUtil.closeAll(server);
	}

}
