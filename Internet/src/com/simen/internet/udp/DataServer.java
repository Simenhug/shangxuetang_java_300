package com.simen.internet.udp;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DataServer {
	
	public static void main(String[] args) throws IOException {
		DatagramSocket server = new DatagramSocket(8888);
		byte[] container = new byte[1024];
		DatagramPacket packet = new DatagramPacket(container, container.length);
		server.receive(packet);
		byte[] data = packet.getData();
		ByteArrayInputStream bis = new ByteArrayInputStream(data);
		DataInputStream dis = new DataInputStream(new BufferedInputStream(bis));
		double db = dis.readDouble();
		System.out.println(db);
		dis.close();
		server.close();
	}
}
