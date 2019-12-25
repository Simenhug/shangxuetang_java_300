package com.simen.dynamic.demo;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoarderExecute {

		public static void main(String[] args) {
			try {
				URL[] urls;
				urls = new URL[] {new URL("file:/"+"/Users/xinmianhuang/Documents/codeheaven/shangxuetang/DynamicCompiling/src")};
				URLClassLoader loader = new URLClassLoader(urls);
				Class c = loader.loadClass("files.Hello");
				//调用加载类的main方法
				c.getMethod("main", String[].class).invoke(null, (Object)new String[] {}); //使用数组时一定要用（Object）强制转型！！
			} catch (MalformedURLException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
