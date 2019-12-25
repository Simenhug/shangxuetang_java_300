package com.simen.webCrawler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawler {
	
	/**
	 * @param urlString
	 * @return
	 */
	public static String getHTML(String urlString, String charset) {
		StringBuilder sb = new StringBuilder();
		
		try {
			URL url = new URL(urlString);
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName(charset)));
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src/files/bbcHTML.txt")));
			String temp = "";
			while((temp=reader.readLine())!=null) {
				sb.append(temp);
				sb.append("\r\n");
				writer.write(temp);
				writer.newLine();
			}
			writer.flush();
			writer.close();
			reader.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
		
	}
	
	public static List<String> getURLs(String html) {
		Pattern p = Pattern.compile("(?<=href=\")[\\w\\-.:/]+");
		Matcher m = p.matcher(html);
		List<String> results = new ArrayList<String>();
		while(m.find()) {
			results.add(m.group());
		}
		return results;
	}
	public static void main(String[] args) {
		String html = getHTML("https://www.163.com/", "gbk");
		for(String str: getURLs(html)) {
			System.out.println(str);
		};
	}
}
