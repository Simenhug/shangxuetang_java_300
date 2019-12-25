package com.simen.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/*
 * 网络类加载器
 */
public class NetClassLoader extends ClassLoader {
	private String rootUrl;
	public NetClassLoader(String root) {
		this.rootUrl = root;
	}
	
	@Override
		protected Class<?> findClass(String name) throws ClassNotFoundException {
			Class<?> c = findLoadedClass(name);
			//应该要先查询有没有加载过这个类。如果已经加载，则直接返回加载好的类。如果没有，则加载新类
		if (c != null) {
			return c;
		} else {
			ClassLoader parent = this.getParent();
			try {
				c = parent.loadClass(name); // 委派给父类加载器
			} catch (ClassNotFoundException e) {
				//e.printStackTrace();
			}
				if(c!=null) {
					return c;
				} else {
					byte[] classData;
					try {
						classData = getClassData(name);
						if(classData==null) {
							throw new ClassNotFoundException();
						} else {
							c = defineClass(name, classData, 0, classData.length);
							return c;
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return null;
					}
				}
			}
		}
	
	private byte[] getClassData(String className) throws IOException {
		String src = rootUrl+"/bin/"+className.replace('.', '/')+".class"; //注意.class文件在bin里，不在src里
		byte[] dest = null;
		//IOUtils, 可以使用它将流中的数据转成字节数组
		URL url = new URL(src);
		InputStream is = url.openStream(); //直接通过URL获取输入流
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		byte[] flush = new byte[1024];
		int len = 0;
		while((len=is.read(flush))!=-1) {
			bos.write(flush,0,len);
		}
		bos.flush();
		dest = bos.toByteArray();
		bos.close();
		is.close();
		return dest;
	}
}
