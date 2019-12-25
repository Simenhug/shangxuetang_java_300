package com.simen.io.otherStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 
 * 数据类型处理流：基本类型，String
 * 输入流 DataInputStream
 * 输出流 DataOutputStream
 */
public class DataDemo {
	
	public static void main(String[] args) throws IOException {
//		writeData("src/files/test4.txt");
//		readData("src/files/test4.txt");
		
		byte[] data = writeData();
		readData(data);
	}
	
	public static void writeData(String destPath) throws IOException {
		double point = 2.5;
		long num = 100L;
		String str = "Della";
		
		File dest = new File(destPath);
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(
				new FileOutputStream(dest)));
		
		//write顺序要和读取顺序一致
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str);
		
		dos.flush();
		dos.close();
	}
	
	public static void readData(String srcPath) throws IOException {

		File dest = new File(srcPath);
		DataInputStream dis = new DataInputStream(new BufferedInputStream(
				new FileInputStream(dest)));
		
		//读取顺序要和写入顺序一致
		double db = dis.readDouble();
		long lon = dis.readLong();
		String str = dis.readUTF();
		System.out.println(db+" "+lon+" "+str);
		
		dis.close();
	}
	
	public static byte[] writeData() throws IOException {
		double point = 2.5;
		long num = 100L;
		String str = "Della";
		
		byte[] dest = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(bos));
		
		//write顺序要和读取顺序一致
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str);
		//flush before toByteArray()
		dos.flush();
		dest = bos.toByteArray();
		
		bos.flush();
		dos.close();
		bos.close();
		return dest;
	}
	
	public static void readData(byte[] src) throws IOException {

		DataInputStream dis = new DataInputStream(new BufferedInputStream(
				new ByteArrayInputStream(src)));
		
		//读取顺序要和写入顺序一致
		double db = dis.readDouble();
		long lon = dis.readLong();
		String str = dis.readUTF();
		System.out.println(db+" "+lon+" "+str);
		
		dis.close();
	}

}
