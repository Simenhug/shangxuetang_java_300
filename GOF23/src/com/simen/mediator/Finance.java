package com.simen.mediator;

public class Finance implements Department{
	
	private Mediator m;
	
	public Finance(Mediator m) {
		super();
		this.m = m;
		m.register("finance", this);
	}

	@Override
	public void outAction() {
		// TODO Auto-generated method stub
		System.out.println("raised more runds");
	}

	@Override
	public void selfAction() {
		// TODO Auto-generated method stub
		System.out.println("raising funds");
	}

}
