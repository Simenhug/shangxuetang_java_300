package io.simen.thread.status;

public class YieldDemo implements Runnable{
	
	@Override
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println("Yield: "+i);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		YieldDemo demo = new YieldDemo();
		Thread t = new Thread(demo);
		t.start();
		
		for(int i=0;i<100;i++) {
			if(i%20==0) {
				Thread.yield();
			}
			System.out.println("main: "+i);
		}
	}
	
}
