package com.simen.regexTest;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("([a-z]+)(\\d+)");
		Matcher m = p.matcher("assdfasd2&&sdf3323");
		while(m.find()) {
			System.out.println(m.group());
			System.out.println(m.group(0));//group(), group(0)匹配整个表达式的子字符串
			System.out.println(m.group(1));
		}
		
		System.out.println("========替换=========");
		p = Pattern.compile("\\d");
		m = p.matcher("assdfasd2234&&sdf3323");
		
		String newstr = m.replaceAll("#");
		System.out.println(newstr);
		
		System.out.println("========分割=========");
		String test = "assdfasd2234&&sdf3323";
		String[] result = test.split("\\d+");
		System.out.println(Arrays.toString(result));
	}
}
