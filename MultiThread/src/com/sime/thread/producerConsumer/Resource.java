package com.sime.thread.producerConsumer;

public class Resource {
	
	private boolean producing = true;

	public synchronized void produce() {
		if (!producing) {
			try {
				this.wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		// production start
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		producing = false;
		this.notifyAll();
	}

	public synchronized void consume() {
		if (producing) {
			try {
				this.wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		// production start
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		producing = true;
		this.notifyAll();
	}

}
