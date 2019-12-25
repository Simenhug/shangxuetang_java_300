package com.simen.classloader;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/*
 * 自定义文件系统类加载器
 */
public class FileSystemClassLoader extends ClassLoader {
	private String rootDir;
	public FileSystemClassLoader(String root) {
		this.rootDir = root;
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
		File src = new File(rootDir+"/bin/"+className.replace('.', '/')+".class"); //注意.class文件在bin里，不在src里
		byte[] dest = null;
		//IOUtils, 可以使用它将流中的数据转成字节数组
		InputStream is = new BufferedInputStream(new FileInputStream(src));
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
