package com.simen.singleton;

import java.util.concurrent.CountDownLatch;

public class ClientEfficiency {
	public static void main(String[] args) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		int threadNum = 10;
		final CountDownLatch latch = new CountDownLatch(threadNum);
		
		for(int i=0;i<threadNum;i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for(int j=0;j<1000000;j++) {
						Singleton2.getInstance();
					}
					latch.countDown();
				}
			}).start();
		}
		latch.await();
		
		long endTime = System.currentTimeMillis();
		System.out.println("total time: "+(endTime-startTime));
	}
}
