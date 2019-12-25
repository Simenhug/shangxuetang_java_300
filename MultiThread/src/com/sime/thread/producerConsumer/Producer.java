package com.sime.thread.producerConsumer;

public class Producer implements Runnable{
	
	private Resource src = null;
	
	public Producer(Resource src) {
		this.src = src;
	}
	
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			src.produce();
			System.out.println("producing");
		}
	}

}
