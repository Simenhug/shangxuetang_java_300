package com.simen.internet.udp;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class DataClient {
	
	public static void main(String[] args) throws IOException {
		DatagramSocket client = new DatagramSocket(6666);
		byte[] data = doubleToByte(13.14);
		DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress("localhost",8888));
		client.send(packet);
		client.close();
	}
	
	public static byte[] doubleToByte(double data) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(bos));
		
		byte[] dest = null;
		dos.writeDouble(data);
		dos.flush();
		dest = bos.toByteArray();
		dos.close();
		bos.close();
		return dest;
	}

}
