package com.simen.internet.tcp.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 1.创建服务器 指定端口 ServerSocket(int port)
 * 2.接收客户端连接 阻塞式
 * 3.接收，发送数据
 */
public class Server {
	
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8888);
		Socket socket = server.accept();
		System.out.println("connection established");
		String msg = "welcome, Lord Simen";
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		bw.write(msg);
		bw.newLine();//manually put in a new line symbol, or the input stream's readLine() won't work
		bw.flush();
		//don't close the stream, or TCP connection will end
	}
}
