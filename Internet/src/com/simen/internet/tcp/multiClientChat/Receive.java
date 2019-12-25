package com.simen.internet.tcp.multiClientChat;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable{
	private DataInputStream dis;
	private boolean isRunning = true;
	
	public Receive(Socket client) {
		try {
			dis = new DataInputStream(
					new BufferedInputStream(client.getInputStream()));
		} catch (IOException e) {
			isRunning = false;
			CloseUtil.closeAll(dis);
		}
	}
	
	public String receive() {
		String msg = "";
		try {
			msg = dis.readUTF();
			return msg;
		} catch (IOException e) {
			isRunning = false;
			CloseUtil.closeAll(dis);
		}
		return msg;
	}

	@Override
	public void run() {
		while (isRunning) {
			System.out.println(receive());
		}
	}
}
