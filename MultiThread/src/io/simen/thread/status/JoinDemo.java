package io.simen.thread.status;

public class JoinDemo implements Runnable{
	
	@Override
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println("Join: "+i);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		JoinDemo demo = new JoinDemo();
		Thread t = new Thread(demo);
		t.start();
		
		for(int i=0;i<100;i++) {
			if(50==i) {
				t.join();
			}
			System.out.println("main: "+i);
		}
		
		
	}

}
