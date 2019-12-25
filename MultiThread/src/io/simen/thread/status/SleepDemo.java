package io.simen.thread.status;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SleepDemo {
	
	public static void main(String[] args) throws InterruptedException {
		test1();
	}
	
	public static void test1() throws InterruptedException {

		Date endTime = new Date(System.currentTimeMillis()+10*1000);
		long end = endTime.getTime();
		while(true) {
			System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
			endTime = new Date(endTime.getTime()-1000);
			Thread.sleep(1000);
			if(endTime.getTime()-1000<end-10000) {
				break;
			}
		}
	}

}
