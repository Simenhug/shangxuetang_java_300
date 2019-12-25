package com.simen.io.convert;

import java.io.UnsupportedEncodingException;

public class Demo {
	
	public static void main(String[] args) {
		String str = "偲钰";
		byte[] data = str.getBytes();//default to IDE's current preference
		System.out.println(new String(data));
		
		try {
			data = str.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(new String(data));
		
		//字节数不完整
		System.out.println(new String(data,0,4));
		
	}

}
