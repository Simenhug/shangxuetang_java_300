package com.simen.io.otherStream;

import java.io.Closeable;
import java.io.IOException;

public class closeStream {
	
	//... 可变形参，确定类，数量未知。必须放在最后一个形参声明。用法和数组一致
	public static void closeStreams(Closeable ... io) {
		for (Closeable temp: io) {
			if(null!=temp) {
				try {
					temp.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
	}
	
	public static <T extends Closeable> void closeAll(T ... io) {
		for (Closeable temp: io) {
			if(null!=temp) {
				try {
					temp.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
	}
	

}
