package com.simen.internet.ip;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

public class URLresource {
	
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.google.com");
		
		//获取资源，网络流
		InputStream is = url.openStream();
		//使用转换流
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("src/files/google.html"))));
		String msg = null;
		while(null!=(msg=br.readLine())) {
			bw.append(msg);
			bw.newLine();
		}
		bw.flush();
		
		bw.close();
		br.close();
		is.close();
	}

}
