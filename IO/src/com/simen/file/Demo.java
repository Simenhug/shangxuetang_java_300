package com.simen.file;

import java.io.File;
import java.util.Arrays;

/*
 * 1.路径分隔符 ；
 * 2.名称分隔符 \(windows)   /(linux)
 * 
 * 相对路径与绝对路径构造file对象
 */
public class Demo {
	
	public static void main(String[] args) {
		rootTest();
	}
	
	public static void test1() {
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		
		//路径表示形式
		String path = "E:\\xp\\test\\2.jpg";
		
		//适合动态生成，可跨平台
		path = "E:"+File.separator+"xp"+File.separator+"test"+File.separator+"2.jpg";
		
		//推荐方式
		path = "E:/xp/test/2.jpg";
		
		String parentPath = "E:/xp/test";
		String name="2.jpg";
		//相对路径
		File src = new File(parentPath,name);
		src = new File(new File(parentPath),name);
		
		System.out.println(src.getName());
		System.out.println(src.getPath());
		
		//绝对路径
		src =new File("E:/xp/test/2.jpg");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		
		//没有盘符：以user.dir构建
		src = new File("test.txt");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println(src.getAbsolutePath());
		
	}
	
	public static void predicateTest() {
		File src = new File("2.txt");
		System.out.println("does this file exist? "+src.exists());
	}
	
	public static void pathTest() {
		String path = "/Users/simenhuang/Documents/webull/";
		File src = new File(path);
		if(src.isDirectory()) {
			String[]subs = src.list();
			for(String temp:subs) {
				System.out.println(temp);
			}
		}
	}
	
	public static void rootTest() {
		File[] roots = File.listRoots();
		System.out.println(Arrays.toString(roots));
	}

}
