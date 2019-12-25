package com.simen.io.otherStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class PrintStreamDemo {

	public static void main(String[] args) throws FileNotFoundException {
		test3();
	}

	public static void test1() throws FileNotFoundException {
		// output to console
		PrintStream ps = System.out;
		ps.println("test");

		// output to designated destination
		File dest = new File("src/files/printStreamTest.txt");
		PrintStream pstream = new PrintStream(new BufferedOutputStream(new FileOutputStream(dest)));
		pstream.println("Simen printing his love for Della");

		pstream.close();
	}

	public static void test2() throws FileNotFoundException {
		InputStream is = new BufferedInputStream(new FileInputStream(new File("src/files/test2.txt")));
		Scanner scan = new Scanner(is);
		System.out.println(scan.nextLine());
	}

	public static void test3() throws FileNotFoundException {
		File dest = new File("src/files/log.txt");
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
		//重定向，用于书写日志
		//true for auto flush
		System.setOut(new PrintStream(os,true));
		System.setErr(new PrintStream(os,true));
		System.out.println("this is a line of a log");
		System.err.println("this is a line of an error");
		
		//重定向，回到console
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
		System.setErr(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.err)),true));
		System.out.println("test");
		System.err.println("error test");
	}

}
