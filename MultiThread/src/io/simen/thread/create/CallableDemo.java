package io.simen.thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo implements Callable<Integer>{
	
	private String name;
	private long sleepTime;
	private boolean running =  true;
	private int meters;
	
	public void setRunning(boolean bool) {
		this.running = bool;
	}
	
	public CallableDemo(String name, long sleepTime) {
		this.name = name;
		this.sleepTime = sleepTime;
	}
	
	@Override
	public Integer call() throws Exception {
		while(running) {
			meters++;
			Thread.sleep(sleepTime);
		}
		return meters;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CallableDemo wabbit = new CallableDemo("wabbit",500);
		CallableDemo turtle = new CallableDemo("turtle",1500);
		ExecutorService exec = Executors.newFixedThreadPool(2);
		//获取值，并且开始任务
		Future<Integer> result1 = exec.submit(wabbit);
		Future<Integer> result2 = exec.submit(turtle);
		
		Thread.sleep(3000);
		wabbit.setRunning(false);
		turtle.setRunning(false);
		System.out.println("wabbit ran "+result1.get()+" meters");
		System.out.println("turtle ran "+result2.get()+" meters");
		exec.shutdownNow();
	}

}
