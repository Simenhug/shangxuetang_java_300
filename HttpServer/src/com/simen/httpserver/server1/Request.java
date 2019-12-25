package com.simen.httpserver.server1;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Request {
	//请求方式
	private String method;
	//请求资源
	private String resource;
	//请求参数
	private Map<String,List<String>> parameters;
	
	private static final String CRLF = "\r\n";
	private static final String SPACE = " ";
	
	private InputStream is;
	private String requestInfo;
	
	public Request() {
		method = "";
		resource = "";
		parameters = new HashMap<String,List<String>>();
		requestInfo = "";
	}
	
	public Request(Socket client) {
		this();
		try {
			is = new BufferedInputStream(client.getInputStream());
			byte[] info = new byte[20480];
			int len = is.read(info);
			requestInfo = new String(info,0,len);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		parseRequest();
	}
	
	private void parseRequest() {
		if(requestInfo.trim().equals("")) {
			return;
		}
		String paramString = "";
		//method
		String firstLine = requestInfo.substring(0,requestInfo.indexOf(CRLF));
		int slashIndx = requestInfo.indexOf("/");
		method = firstLine.substring(0, slashIndx).trim();
		//resource url: if POST there's no parameters in rul. if GET there might be
		String url = firstLine.substring(slashIndx,firstLine.indexOf("HTTP")).trim();
		if(method.equalsIgnoreCase("GET")) {
			if(firstLine.contains("?")) {
				String[] urlElements = url.split("\\?");
				resource = urlElements[0];
				paramString = urlElements[1];
			} else {
				resource = firstLine.substring(slashIndx,firstLine.indexOf("HTTP")).trim();
			}
		}else if(method.equalsIgnoreCase("Post")) {
			resource = url;
			//parameters are in the body. Body follows the last CRLF line
			paramString = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();
		}
		
		parseParams(paramString);
	}
	
	private void parseParams(String paramString) {
		//parse parameters
		if(paramString=="") {
			return;
		}
		StringTokenizer token = new StringTokenizer(paramString,"&");
		while(token.hasMoreTokens()) {
			String keyValue = token.nextToken();
			String[] keyValues = keyValue.split("=");
			//格式统一性，应对键或值不存在的情况
			if(keyValues.length==1) {
				keyValues = Arrays.copyOf(keyValues, 2);
				keyValues[1] = null;
			}
			//put it into the map
			String key = keyValues[0].trim();
			//decode if value is in Chinese
			String value = null==keyValues[1]?null:decode(keyValues[1].trim(),"gbk");
			if (parameters.containsKey(key)) {
				if (value != null) {
					parameters.get(key).add(value);
				}
			} else {
				if (value != null) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(value);
					parameters.put(key, list);
				}
			}
		}
		
	}
	
	//get parameter values by javascript "name"
	//recommended return type is array, not ArrayList
	public String[] getParameters(String name){
		if(!parameters.containsKey(name)) {
			return null;
		}
		return parameters.get(name).toArray(new String[0]);
	}
	//get parameter value by javascript "name"
	public String getParameter(String name){
		String[] values = getParameters(name);
		if(null==values) {
			return null;
		}
		return values[0];
	}
	//for input Strings that are not English
	private String decode(String value,String code) {
		try {
			return java.net.URLDecoder.decode(value,code);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
