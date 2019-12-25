package com.simen.io.convert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(
								new File("src/files/test.txt")), "UTF-8"));
		
		BufferedWriter wr = new BufferedWriter(
				new FileWriter(new File("src/files/test2.txt")));
		
		String info = null;
		while(null!=(info=br.readLine())) {
			wr.write(info);
			wr.newLine();
		}
		
		wr.close();
	}

}
