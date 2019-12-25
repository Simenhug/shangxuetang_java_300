package com.simen.regexTest;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Emails {
	public static void main(String[] args) throws IOException {
		BufferedInputStream fis = new BufferedInputStream(new FileInputStream("src/files/test.txt"));
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		byte[] dest;
		byte[] flush = new byte[1024];
		int len = 0;
		
		while(-1!=(len=fis.read(flush))) {
			bos.write(flush, 0, len);
		}
		bos.flush();
		dest = bos.toByteArray();
		String text = new String(dest);
		
		Pattern pattern = Pattern.compile("[\\w\\-]+@[\\-\\w]+(\\.\\w{2,4}){1,2}",Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(text);
		
		while(matcher.find()) {
			System.out.println(matcher.group());
		}
	}
}
