package com.simen.dynamic.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RuntimeExecute {

	public static void main(String[] args) throws IOException {
		//Runtime动态执行
		Runtime runtime = Runtime.getRuntime();
		Process process = runtime.exec("java -cp /Users/xinmianhuang/Documents/codeheaven/shangxuetang/DynamicCompiling/src files.Hello");
		//Process process = runtime.exec("java -cp ~/Documents/codeheaven/shangxuetang/DynamicCompiling/src files.Hello");
		InputStream is = process.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String info = "";
		while((info=br.readLine())!=null) {
			System.out.println(info);
		}
	}
}
