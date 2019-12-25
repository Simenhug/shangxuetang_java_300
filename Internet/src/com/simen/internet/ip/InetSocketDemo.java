package com.simen.internet.ip;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class InetSocketDemo {
	
	public static void main(String[] args) throws UnknownHostException {
		InetSocketAddress isa = new InetSocketAddress("127.0.0.1", 8888);
		isa = new InetSocketAddress("localhost", 8888);
		isa = new InetSocketAddress(InetAddress.getByName("127.0.0.1"),8888);
		System.out.println(isa.getHostName());
		System.out.println(isa.getPort());
		InetAddress ia = isa.getAddress();
		System.out.println(ia.getHostAddress());
		System.out.println(ia.getHostName());
	}
}
