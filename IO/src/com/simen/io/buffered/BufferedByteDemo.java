package com.simen.io.buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedByteDemo {
	
	public static void main(String[] args) {
		File src = new File("/Users/simenhuang/Documents/wallpapers/MyDella.jpeg");
		File dest = new File("src/files/Della.jpg");
		InputStream is = null;
		OutputStream os = null;
		
		byte[] flush = new byte[1024];
		int len = 0;
		try {
			is = new BufferedInputStream(new FileInputStream(src));
			os = new BufferedOutputStream(new FileOutputStream(dest));
			
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

}
