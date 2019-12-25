package com.simen.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Encrypt {
	public static void encrypt(String srcPath, String destPath) {
		File src = new File(srcPath);
		File dest = new File(destPath);
		
		try {
			FileInputStream fis = new FileInputStream(src);
			FileOutputStream fos = new FileOutputStream(dest);
			
			int temp = -1;
			while((temp=fis.read())!=-1) {
				fos.write(temp^0xff); //取反操作
			}
			
			fos.flush();
			fos.close();
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
