package com.simen.regexTest;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumbers {
	public static void main(String[] args) throws Exception {
		InputStream is = new BufferedInputStream(new FileInputStream(new File("src/files/test.txt")));
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		byte[] dest;
		byte[] flush = new byte[1024];
		int len = 0;
		
		while(-1!=(len=is.read(flush))) {
			bos.write(flush, 0, len);
		}
		bos.flush();
		dest = bos.toByteArray();
		String text = new String(dest);
		
		Pattern pattern = Pattern.compile("0\\d{2,3}-\\d{7,8}");
		Matcher matcher = pattern.matcher(text);
		
		while(matcher.find()) {
			System.out.println(matcher.group());
		}
	}
}
