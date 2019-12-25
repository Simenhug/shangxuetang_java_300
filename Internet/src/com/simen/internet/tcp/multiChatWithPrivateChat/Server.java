package com.simen.internet.tcp.multiChatWithPrivateChat;

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
		private String name;
		private boolean isRunning = true;
		
		public String getName() {
			return name;
		}
		
		public Channel(Socket client) {
			try {
				dis = new DataInputStream(new BufferedInputStream(client.getInputStream()));
				dos = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
				this.name = dis.readUTF();
				this.send("welcome to the chat room, "+name);
				sendToOther(name+" has joined the chat", true);
			} catch (IOException e) {
				isRunning = false;
				CloseUtil.closeAll(dis, dos);
				channels.remove(this);
				sendToOther(name+" has left the chat", true);
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
				sendToOther(name+" has left the chat", true);
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
					sendToOther(name+" has left the chat", true);
				}
			}
		}
		//if system message, no need to start with sender's name
		private void sendToOther(String msg, boolean isSystemMessage) {
			if (msg != null || !msg.contentEquals("")) {
				// messages that starts with @ are meant for private chat
				// String between @ and : is the receiver's name
				if (msg.startsWith("@") && msg.contains(":")) {
					// get name
					String receiver = msg.substring(1, msg.indexOf(":"));
					// get content
					String content = msg.substring(msg.indexOf(":") + 1);
					for (Channel channel : channels) {
						if (channel.getName().contentEquals(receiver)) {
							channel.send(name + " whispered to you: " + content);
							break;
						}
					}
				} else {
					msg = isSystemMessage?msg:name+": "+msg;
					for (Channel channel : channels) {
						if (channel == this) {
							continue;
						}
						channel.send(msg);
					}
				}
			}
		}
		
		@Override
		public void run() {
			while(isRunning) {
				sendToOther(receive(), false);
			}
		}
	}

}
