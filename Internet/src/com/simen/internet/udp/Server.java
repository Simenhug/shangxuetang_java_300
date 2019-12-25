package com.simen.internet.udp;
import java.net.DatagramSocket;
import java.io.IOException;
import java.net.DatagramPacket;
/*
 * 服务器端：
a. 创建服务端 DatagramSocket类 +指定端口
b. 准备接收容器 字节数组 封装 DatagramPacket
c. 接受数据
d. 分析
e. 释放资源

 */
public class Server {
	
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket(8888);
		byte[] container = new byte[1024];
		DatagramPacket packet = new DatagramPacket(container, container.length);
		socket.receive(packet);
		byte[] data = packet.getData();
		int len = packet.getLength();
		System.out.println(new String(data,0,len));
		socket.close();
	}
}
