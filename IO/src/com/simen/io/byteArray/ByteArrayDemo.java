package com.simen.io.byteArray;

/*
 * 
 * 文件 ---程序—->字节数组
 * 字节数组 ----程序--->文件
 * 
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteArrayDemo {

	public static void main(String[] args) throws IOException {
		byte[] data = getByteFromFile("src/files/Della.jpg");
		byteArrayToFile(data, "src/files/Della2.jpg");
	}
	
	public static void byteArrayToFile(byte[] src, String destPath) throws IOException {
		File dest = new File(destPath);
		
		InputStream boi = new ByteArrayInputStream(src);
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
		
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1!=(len=boi.read(flush))) {
			os.write(flush,0,len);
		}
		os.flush();
		os.close();
		boi.close();
	}
	
	public static byte[] getByteFromFile(String srcPath) throws IOException {
		File src = new File(srcPath);
		byte[] dest = null;
		
		InputStream is = new BufferedInputStream(new FileInputStream(src));
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1!=(len=is.read(flush))) {
			bos.write(flush,0,len);
		}
		bos.flush();
		
		dest = bos.toByteArray();
		
		bos.close();
		is.close();
		return dest;
	}

}
