package com.simen.abstractFactory;

public interface Engine {
	void run();
	void start();
}

class LuxuryEngine implements Engine{

	@Override
	public void run() {
		System.out.println("runs fast");
	}

	@Override
	public void start() {
		System.out.println("starts fast");
	}
	
}

class LowerEngine implements Engine{

	@Override
	public void run() {
		System.out.println("runs slow");
	}

	@Override
	public void start() {
		System.out.println("starts slow");
	}
	
}
