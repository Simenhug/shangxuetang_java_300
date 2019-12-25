package com.simen.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MySet {
	
	HashMap map;
	private static final Object PRESENT = new Object();
	
	public MySet() {
		map = new HashMap();
	}
	
	public void add(Object o) {
		map.put(o, PRESENT);
	}
	
	public void remove(Object o) {
		
	}
	
	public int size() {
		return map.size();
	}
	
	public static void main(String[] args) {
		Set set = new HashSet();
		set.add("aaa");
		System.out.println(set.size());
	}
}
