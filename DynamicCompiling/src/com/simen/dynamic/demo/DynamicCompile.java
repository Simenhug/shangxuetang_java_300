package com.simen.dynamic.demo;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class DynamicCompile {
	
	public static void main(String[] args) throws IOException {
		//动态编译源文件
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		int result = compiler.run(null, null, null, "src/files/Hello.java");
		System.out.println(result==0?"complie success":"compile failed");
		//动态编译String：将String用输出流输出到某临时文件中，然后动态编译临时文件
		String myClass = "public class Test{ public static void main(String[] args) {System.out.println(\"della\");}}";
		byte[] data = myClass.getBytes();
		File dest = new File("src/files/Test.java");
		BufferedOutputStream bis = new BufferedOutputStream(new FileOutputStream(dest));
		bis.write(data,0,data.length);
		bis.flush();
		bis.close();
		
		int result2 = compiler.run(null, null, null, "src/files/Test.java");
		System.out.println(result2==0?"complie success":"compile failed");
	}
}
