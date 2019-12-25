package com.simen.io.otherStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFiles {

	public static void main(String[] args) throws IOException {
		
		RandomAccessFile raf = new RandomAccessFile(new File("src/files/test.txt"), "r");
		
		raf.seek(4);
		
		byte[] flush = new byte[1024];
		int len = 0;
		
		//only want to read from byte 4 to 200
		while(-1!=(len=raf.read(flush))) {
			if(len>=200) {
				System.out.println(new String(flush,0,200));
				break;
			} else {
				System.out.println(new String(flush,0,len));
			}
		}
		
		raf.close();

	}

}
