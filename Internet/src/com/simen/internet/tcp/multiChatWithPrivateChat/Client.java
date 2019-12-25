package com.simen.internet.tcp.multiChatWithPrivateChat;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	

	public static void main(String[] args) throws IOException {
		System.out.println("please enter your name:");
		BufferedReader nameReader = new BufferedReader(new InputStreamReader(System.in));
		String name = nameReader.readLine();
		if(name==null||name=="") {
			return;
		}
		
		Socket client = new Socket("localhost", 8888);
		new Thread(new Send(client, name)).start();
		new Thread(new Receive(client)).start();
	}

}
