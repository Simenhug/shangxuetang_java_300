package com.simen.httpserver.server1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/*
 * 封装响应信息
 */
public class Response {
	private StringBuilder headerInfo;
	public static final String CRLF = "\r\n";
	public static final String SPACE = " ";
	private StringBuilder content;
	private BufferedWriter writer;
	private int contentLength = 0;
	
	public Response() {
		headerInfo = new StringBuilder();
		content = new StringBuilder();
	}
	
	public Response(Socket client) {
		this();
		try {
			writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			headerInfo = null;
			CloseUtil.closeAll(writer);
		}
	}

	// build headerInfo header
	private void createHeader(int code) {
		headerInfo.append("HTTP/1.1").append(SPACE).append("200").append(SPACE);
		switch (code) {
		case 200:
			headerInfo.append("OK");
			break;
		case 404:
			headerInfo.append("PAGE NOT FOUND");
			break;
		case 500:
			headerInfo.append("SERVER ERROR");
			break;
		}
		headerInfo.append(CRLF);
		headerInfo.append("Server:simen Server/1.0.0").append(CRLF);
		headerInfo.append("Date:").append(new Date()).append(CRLF);
		headerInfo.append("Content-type:text/html;charset=utf-8").append(CRLF);
		headerInfo.append("Content-Length:").append(contentLength).append(CRLF);
		headerInfo.append(CRLF);
	}
	
	public Response add(String info) {
		content.append(info);
		contentLength+=info.getBytes().length;
		return this;
	}
	
	public Response addLine(String info) {
		content.append(info).append(CRLF);
		contentLength+=(info+CRLF).getBytes().length;
		return this;
	}
	
	public void sendResponse(int code) throws IOException {
		if(headerInfo==null) {
			code = 500;
		}
		//create header
		createHeader(code);
		writer.append(headerInfo.toString());
		//add content
		writer.append(content.toString());
		//use stream to output
		writer.flush();
	}
	
	public void close() {
		CloseUtil.closeAll(writer);
	}
}
