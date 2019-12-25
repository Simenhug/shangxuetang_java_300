package io.simen.thread.create;

public class SingleObject {
	
	public static void main(String[] args) throws InterruptedException {
		Thread simen = new Thread(new SingularThread());
		Thread della = new Thread(new SingularThread());
		
		simen.start();
		Thread.sleep(200);
		della.start();
	}

}

class SingularThread implements Runnable{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" address: "+Singular.getInstance());
	}
}

/*
 * 
 * 1. 声明一个静态变量，变量为本类对象
 * 2. 创建私有构造器，避免外部创建对象
 * 3. 提供公共的静态方法访问该变量，如果变量没有对象（null），创建该对象
 * 
 */
class Singular{
	//1. 声明一个静态变量，变量为本类对象
	private static Singular instance = null;
	//2. 创建私有构造器，避免外部创建对象
	private Singular() {
		
	}
	//3. 提供公共的静态方法访问该变量，如果变量没有对象（null），创建该对象
	public static synchronized Singular getInstance() {
		if(instance==null) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			instance = new Singular();
		}
		return instance;
	}
	
	public static Singular getInstance2() {
		//提高效率
		if (instance == null) {
			// 这里不能用 synchronized(this)
			synchronized (Singular.class) {
				//保证安全
				if (instance == null) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					instance = new Singular();
				}
			}
		}
		return instance;
	}
}