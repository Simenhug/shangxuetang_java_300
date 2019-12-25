package com.simen.internet.tcp.singleThreadChat;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SingleThreadClient {

	public static void main(String[] args) throws IOException {
		Socket client = new Socket("localhost", 8888);
		//console input
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		//output stream
		DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(client.getOutputStream()));
		//input stream
		DataInputStream dis = new DataInputStream(
				new BufferedInputStream(client.getInputStream()));
		//interactive
		while(true) {
			String msg = console.readLine();
			dos.writeUTF(msg);
			dos.flush();
			String received = dis.readUTF();
			System.out.println(received);
		}

	}

}
