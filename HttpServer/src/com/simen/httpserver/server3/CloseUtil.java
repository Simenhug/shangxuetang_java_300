package com.simen.httpserver.server3;

import java.io.Closeable;
import java.io.IOException;

public class CloseUtil {
	
	public static void closeAll(Closeable... io) {
		for(Closeable stream: io) {
			if(null!=stream) {
				try {
					stream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
