package com.simen.io.byteIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Demo {

	public static void main(String[] args) {
		copyTest();
	}
	
	public static void inputTest() {
		File src = new File("/Users/simenhuang/Documents/webull/Committees/ACH AML.docx");
		InputStream instream = null;
		try {
			instream = new FileInputStream(src);
			byte[] car = new byte[1024];
			int len =0;
			while(-1!=(len=instream.read(car))) {
				String info = new String(car,0,len);
				System.out.println(info);
			}
		} catch (FileNotFoundException e) {
			System.out.println("file not exist");
		} catch (IOException e) {
			System.out.println("file read failed");
		} finally {
			if(null!=instream) {
				try {
					instream.close();
				} catch (IOException e) {
					System.out.println("failed to close input stream");
				}
			}
		}
	}
	
	public static void outputTest() {
		File dest = new File("src/files/test.txt");
		OutputStream outstream = null;
		try {
			outstream = new FileOutputStream(dest, true);
			String content = "my very first output stream \r\n";
			byte[] data = content.getBytes();
			outstream.write(data, 0, data.length);
			
			//IMPORTANT!!! Make it a habit
			outstream.flush();
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("file write failed");
		} finally {
			if(null!=outstream) {
				try {
					outstream.close();
				} catch (IOException e) {
					System.out.println("file write stream closing failed");
				}
			}
		}
	}
	
	public static void copyTest() {
		File src = new File("/Users/simenhuang/Documents/wallpapers/MyDella.jpeg");
		File dest = new File("src/files/Della.jpg");
		InputStream is = null;
		OutputStream os = null;
		
		byte[] flush = new byte[1024];
		int len = 0;
		try {
			is = new FileInputStream(src);
			os = new FileOutputStream(dest);
			
			while(-1!=(len=is.read(flush))) {
				os.write(flush, 0, len);
			}
			os.flush();
			
			//opened first, closed last
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void copyFile(String srcPath, String destPath) {
		File src = new File(srcPath);
		File dest = new File(destPath);
		copyFile(src,dest);
	}
	
	public static void copyFile(File src, File dest) {
		if(!src.isFile()) {
			System.out.println("can only copy files!");
			return;
		}
		
		if(dest.isDirectory()) {
			System.out.println("destination must not be a folder");
			return;
		}
		InputStream is = null;
		OutputStream os = null;
		
		byte[] flush = new byte[1024];
		int len = 0;
		try {
			is = new FileInputStream(src);
			os = new FileOutputStream(dest);
			
			while(-1!=(len=is.read(flush))) {
				os.write(flush, 0, len);
			}
			os.flush();
			
			//opened first, closed last
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void copyDir(String srcPath, String destPath) {
		File src = new File(srcPath);
		File dest = new File(destPath);
		copyDir(src,dest);
	}
	
	public static void copyDir(File src, File dest) {
		if(src.isDirectory()) {
			dest = new File(dest,src.getName());
		}
		copySubDir(src, dest);
	}
	
	public static void copySubDir(File src, File dest) {
		if(src.isFile()) {
			copyFile(src, dest);
		} else if(src.isDirectory()) {
			dest.mkdirs();
			
			for(File sub:src.listFiles()) {
				copySubDir(sub, new File(dest,sub.getName()));
			}
		}
	}

}
