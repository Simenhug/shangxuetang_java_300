package com.simen.internet.tcp.singleClientChat;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send implements Runnable{
	
	private BufferedReader console;
	private DataOutputStream dos;
	private boolean isRunning = true;
	
	public Send() {
		console = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public Send(Socket client) {
		this();
		try {
			dos = new DataOutputStream(
					new BufferedOutputStream(client.getOutputStream()));
		} catch (IOException e) {
			isRunning = false;
			CloseUtil.closeAll(dos,console);
		}
	}
	
	public String getMsgFromConsole() {
		try {
			String msg = console.readLine();
			return msg;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void send() {
		String msg = getMsgFromConsole();
		if(null!=msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				isRunning = false;
				CloseUtil.closeAll(dos,console);
			}
		}
		
	}
	
	@Override
	public void run() {
		while(isRunning) {
			send();
		}
	}
	
}
