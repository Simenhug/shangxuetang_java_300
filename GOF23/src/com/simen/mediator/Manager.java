package com.simen.mediator;

import java.util.HashMap;
import java.util.Map;

public class Manager implements Mediator{
	private Map<String, Department> pool = new HashMap<String, Department>();

	@Override
	public void register(String dname, Department department) {
		pool.put(dname, department);	
	}

	@Override
	public void command(String dname) {
		// TODO Auto-generated method stub
		pool.get(dname).selfAction();
	}

}
