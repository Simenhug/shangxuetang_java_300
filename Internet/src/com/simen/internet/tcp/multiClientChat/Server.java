package com.simen.internet.tcp.multiClientChat;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	
	private List<Channel> channels = new ArrayList<Channel>();
	
	public static void main(String[] args) throws IOException {
		new Server().connect();
	}
	
	public void connect() throws IOException {
		ServerSocket server = new ServerSocket(8888);
		while (true) {
			Socket client = server.accept();
			System.out.println("connection established");
			Channel channel = new Channel(client);
			channels.add(channel);
			new Thread(channel).start();
		}
	}
	
	
	//one channel per client
	private class Channel implements Runnable{
		private DataOutputStream dos;
		private DataInputStream dis;
		private boolean isRunning = true;
		
		public Channel(Socket client) {
			try {
				dis = new DataInputStream(new BufferedInputStream(client.getInputStream()));
				dos = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
			} catch (IOException e) {
				isRunning = false;
				CloseUtil.closeAll(dis, dos);
				channels.remove(this);
			}
		}
		
		public String receive() {
			String msg = "";
			try {
				msg = dis.readUTF();
			} catch (IOException e) {
				isRunning = false;
				CloseUtil.closeAll(dis);
				channels.remove(this);
			}
			return msg;
		}

		public void send(String msg) {
			if (msg != null || !msg.contentEquals("")) {
				try {
					dos.writeUTF(msg);
					dos.flush();
				} catch (IOException e) {
					isRunning = false;
					CloseUtil.closeAll(dos);
					channels.remove(this);
				}
			}
		}
		
		private void sendToAll() {
			String msg = this.receive();
			if (msg != null || !msg.contentEquals("")) {
				for (Channel channel : channels) {
					if(channel == this) {
						continue;
					}
					channel.send(msg);
				}
			}
		}
		
		@Override
		public void run() {
			while(isRunning) {
				sendToAll();
			}
		}
	}

}
