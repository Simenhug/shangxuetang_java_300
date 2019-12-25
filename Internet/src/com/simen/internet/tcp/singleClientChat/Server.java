package com.simen.internet.tcp.singleClientChat;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8888);
		Socket client = server.accept();
		System.out.println("connect established");
		// output stream
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
		// input stream
		DataInputStream dis = new DataInputStream(new BufferedInputStream(client.getInputStream()));
		while (true) {
			String msg = dis.readUTF();
			System.out.println("server received: " + msg);
			dos.writeUTF("server: "+msg);
			dos.flush();
		}
	}

}
