package io.simen.thread.status;

public class Demo {
	
	public static void main(String[] args) throws InterruptedException {
		Program program = new Program();
		new Thread(program).start();
		
		Thread.sleep(2000);
		//外部干涉
		program.setFlag(false);
	}
}

class Program implements Runnable{
	/*
	 * 1.线程类中定义可控制线程终止的标识
	 * 2.线程体中使用该标识
	 * 3.对外提供方法改变标识
	 */
	//1.线程类中定义可控制线程终止的标识
	private boolean flag = true;
	
	@Override
	public void run() {
		//2.线程体中使用该标识
		while(flag) {
			System.out.println("program running...");
		}
	}	
	//3.对外提供方法改变标识
	public void setFlag(boolean bool) {
		this.flag = bool;
	}
}
