package com.simen.io.buffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class BufferedCharDemo {
	public static void main(String[] args) {
		File src = new File("src/files/test.txt");
		File dest = new File("src/files/test2.txt");
		
		//no polymorphism here
		BufferedReader reader = null;
		BufferedWriter wr = null;
		try {
			//adding Buffer
			reader = new BufferedReader(new FileReader(src));
			wr = new BufferedWriter(new FileWriter(dest));
			/*
			char[] flush = new char[1024];
			int len = 0;
			while (-1 != (len = reader.read(flush))) {
				wr.write(flush, 0, len);
				wr.flush();
			}
			*/
			//new feature: read by lines
			String line = null;
			while(null!=(line=reader.readLine())) {
				wr.write(line);
				// wr.append("\r\n");
				wr.newLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != reader) {
				if (null != wr) {
					try {
						wr.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
