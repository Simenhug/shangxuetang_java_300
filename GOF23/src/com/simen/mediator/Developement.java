package com.simen.mediator;

public class Developement implements Department{
	
	private Mediator m;
	
	public Developement(Mediator m) {
		super();
		this.m = m;
		m.register("developement", this);
	}

	@Override
	public void outAction() {
		// TODO Auto-generated method stub
		System.out.println("researching, need more funds");
		m.command("finance");
	}

	@Override
	public void selfAction() {
		// TODO Auto-generated method stub
		System.out.println("conducting product research");
	}

}
