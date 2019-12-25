package io.simen.thread.create;

public class StaticProxy {

	public static void main(String[] args) {
		//创建真实角色
		Me me = new Me("Simen");
		//创建代理角色 + 真实角色的引用
		WeddingAgency wa = new WeddingAgency(me);
		//执行任务
		wa.marry();
	}

}

interface Marry{
	void marry();
}

class Me implements Marry{
	
	private String name;
	
	@Override
	public void marry() {
		System.out.println(name+" is getting married with Della~");		
	}
	
	public Me(String name) {
		this.name = name;
	}
}

class WeddingAgency implements Marry{
	//代理角色要有真实角色的引用
	private Me me;
	
	private void before() {
		System.out.println("looking for love");
	}
	
	private void after() {
		System.out.println("found love and happiness");
	}
	
	@Override
	public void marry() {
		before();
		me.marry();
		after();
	}
	
	public WeddingAgency(Me guy) {
		this.me = guy;
	}
}
