package io.simen.thread.status;

public class DeadLock {
	
	public static void main(String[] args) {
		Object simen = new Object();
		Object della = new Object();
		
		Thread t1 = new Thread(new DeadPool(simen,della));
		Thread t2 = new Thread(new DeathStroke(simen,della));
		
		t1.start();
		t2.start();
	}

}

class DeadPool implements Runnable{
	Object simen;
	Object della;
	
	public DeadPool(Object simen,Object della) {
		this.simen = simen;
		this.della = della;
	}
	
	@Override
	public void run() {
		while(true) {
			test();
		}		
	}
	
	public void test() {
		synchronized (della) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (simen) {
				
			}
		}
		System.out.println("della waiting for simen to confess his feelings for her");
	}
}

class DeathStroke implements Runnable{
	Object simen;
	Object della;
	
	public DeathStroke(Object simen,Object della) {
		this.simen = simen;
		this.della = della;
	}
	
	@Override
	public void run() {
		while(true) {
			test();
		}		
	}
	
	public void test() {
		synchronized (simen) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (della) {
				
			}
		}
		System.out.println("simen waiting for della to give him signs");
	}
}