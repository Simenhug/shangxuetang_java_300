package com.simen.strategy;
/*
 * 如果使用spring的依赖注入功能，则可以通过配置文件，动态注入不同的策略对象
 */
public class Context {
	private Strategy strategy;
	//可以通过反射构造器动态注入
	public Context(Strategy s) {
		this.strategy = s;
	}
	//可以通过set方法注入
	public void setStrategy(Strategy s) {
		this.strategy = s;
	}
	
	public double getPrice(double standardPrice) {
		return strategy.setPrice(standardPrice);
	}
}
