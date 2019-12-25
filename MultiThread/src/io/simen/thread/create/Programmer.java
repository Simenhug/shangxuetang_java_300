package io.simen.thread.create;

public class Programmer implements Runnable{
	
	@Override
	public void run() {
		for(int i=0;i<200;i++) {
			System.out.println("边敲代码。。。");
		}
	}
	
	public static void main(String[] args) {
		Programmer me = new Programmer();
		Thread programming = new Thread(me);
		programming.start();
		
		for(int i=0;i<200;i++) {
			System.out.println("边看视频。。。");
		}
	}
}

