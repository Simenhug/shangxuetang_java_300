package com.simen.mediator;

public class Marketing implements Department{
	
	private Mediator m;
	
	public Marketing(Mediator m) {
		super();
		this.m = m;
		m.register("marketing", this);
	}

	@Override
	public void outAction() {
		// TODO Auto-generated method stub
		System.out.println("marketing, need more funds");
		m.command("finance");
	}

	@Override
	public void selfAction() {
		// TODO Auto-generated method stub
		System.out.println("raising promotional campaign");
	}

}
