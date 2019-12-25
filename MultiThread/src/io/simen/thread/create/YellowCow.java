package io.simen.thread.create;

public class YellowCow implements Runnable{
	
	private int tickets = 50;
	
	@Override
	public void run() {
		while(tickets>=0) {
			if(tickets==0) {
				System.out.println(Thread.currentThread().getName()+"抢到了"+tickets--+" 最后一张！！！");
				break;
			}
			System.out.println(Thread.currentThread().getName()+"抢到了"+tickets--);
		}
	}
	
	public static void main(String[] args) {
		YellowCow cow = new YellowCow();
		Thread t1 = new Thread(cow,"黄牛");
		Thread t2 = new Thread(cow,"金牛");
		Thread t3 = new Thread(cow,"肥牛");
		t1.start();t2.start();t3.start();
	}
}
