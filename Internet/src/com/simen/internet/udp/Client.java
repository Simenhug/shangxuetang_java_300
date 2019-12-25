package com.simen.internet.udp;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
/*
 * 客户端：
a. 创建客户端 DatagramSocket类 +指定端口
b. 准备数据 字节数组
c. 打包 DatagramPacket +服务器地址以及端口
d. 发送
e. 释放资源

 */
public class Client {
	
	public static void main(String[] args) throws IOException {
		DatagramSocket client = new DatagramSocket(6666);
		String msg = "love Della";
		byte[] data =msg.getBytes();
		DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress("localhost",8888));
		client.send(packet);
		client.close();
	}

}
