package com.simen.io.charIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dest = new File("src/files/test.txt");
		Writer wr = null;
		try {
			wr = new FileWriter(dest);
			String msg = "Simen loves Della\r\nDoes she love him back?";
			wr.write(msg);
			wr.append("\r\nyes, you guessed it~");
			wr.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(null!=wr) {
				try {
					wr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
