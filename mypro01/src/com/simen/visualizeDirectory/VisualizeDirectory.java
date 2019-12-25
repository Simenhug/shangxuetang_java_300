package com.simen.visualizeDirectory;
import java.io.File;
import java.io.IOException;
import java.util.*;
/**
 * print a directory tree in console
 * @author simenhuang
 *
 */

public class VisualizeDirectory {
	public static void printPathTree(String path, int indentation) {
		File source = new File(path);
		String[] content = source.list();
		for (String sub: content) {
			String subPath = path + "/" + sub;
			File temp = new File (subPath);
			StringBuilder indent = new StringBuilder();
			for (int i=0; i<indentation; i++) {
				indent.append("\t");
			}
			if(temp.isFile()) {
				System.out.println(indent + sub);
			}
			if(temp.isDirectory()) {
				System.out.println("\n" + indent + "+" + sub);
				indentation++;
				printPathTree(subPath, indentation);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		System.out.println("Please enter a starting complete path:");
		Scanner scanner = new Scanner(System.in);
		String sourcePath = scanner.nextLine();
		scanner.close();
		File source = new File(sourcePath);
		System.out.println(sourcePath);
		VisualizeDirectory.printPathTree(sourcePath, 1);
	}

}
