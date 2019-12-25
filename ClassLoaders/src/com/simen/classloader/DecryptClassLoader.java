package com.simen.classloader;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/*
 * 解密被取反加密的类加载器
 */
public class DecryptClassLoader extends ClassLoader {
	private String rootDir;
	boolean convert = true;
	public DecryptClassLoader(String root, boolean convert) {
		this.rootDir = root;
		this.convert = convert;
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
							//"name" must be full name (include package name)
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
		File src = null;
		if (convert) {
			src = new File(rootDir + "/bin/" + className.replace('.', '/') + ".Class"); // 注意.class文件在bin里，不在src里
		} else {
			String[] path = className.split("\\.");
			src = new File(rootDir + "/" + path[path.length-1] + ".Class");
		}
		byte[] dest = null;
		//IOUtils, 可以使用它将流中的数据转成字节数组
		InputStream is = new BufferedInputStream(new FileInputStream(src));
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		int temp = -1;
		while((temp=is.read())!=-1) {
			bos.write(temp^0xff); //取反操作
		}
		bos.flush();
		dest = bos.toByteArray();
		bos.close();
		is.close();
		return dest;
	}
}
