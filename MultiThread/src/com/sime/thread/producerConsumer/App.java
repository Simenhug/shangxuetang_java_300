package com.sime.thread.producerConsumer;

public class App {
	
	public static void main(String[] args) {
		Resource src = new Resource();
		Producer simen = new Producer(src);
		Consumer della = new Consumer(src);
		
		new Thread(simen).start();
		new Thread(della).start();
	}

}
