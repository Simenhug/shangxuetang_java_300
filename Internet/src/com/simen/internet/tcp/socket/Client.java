package com.simen.internet.tcp.socket;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 1.创建客户端 必须指定服务器端+端口 此时就在连接
 * Socket (Strint host, int port)
 * 2.接收、发送数据
 */
public class Client {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("localhost",8888);
//		BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
//		String echo = br.readLine();
//		System.out.println(echo);
		
		DataInputStream dis = new DataInputStream(new BufferedInputStream(client.getInputStream()));
		String echo = dis.readUTF();
		System.out.println(echo);
		dis.close();
	}

}
