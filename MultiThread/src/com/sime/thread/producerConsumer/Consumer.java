package com.sime.thread.producerConsumer;

public class Consumer implements Runnable{
	
	private Resource src = null;
	
	public Consumer(Resource src) {
		this.src = src;
	}
	
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			src.consume();
			System.out.println("consuming");
		}
	}

}
