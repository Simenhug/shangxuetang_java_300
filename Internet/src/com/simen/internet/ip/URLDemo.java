package com.simen.internet.ip;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
	
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://www.baidu.com:80/index.html#aa?username=simen");
		
		url = new URL("http://www.baidu.com:8080/simen/love/");
		url = new URL(url, "della.txt");
		System.out.println(url.toString());
		System.out.println("=================");
		
		url = new URL("http://www.baidu.com:80/index.html#aa?username=simen");
		System.out.println("protocol: "+url.getProtocol());
		System.out.println("domain name: "+url.getHost());
		System.out.println("port: "+url.getPort());
		System.out.println("resource: "+url.getFile());
		System.out.println("relative path: "+url.getPath());
		System.out.println("anchor: "+url.getRef());
		
		//参数是？后面的值。参数和锚点存在冲突：如果锚点存在，getQuery返回null；不存在则正确返回。
		System.out.println("parameter: "+url.getQuery());
	}
}
