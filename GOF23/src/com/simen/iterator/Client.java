package com.simen.iterator;

public class Client {
	public static void main(String[] args) {
		MyAggregate agg = new MyAggregate();
		MyIterator iterator = agg.getIterator();
		
		agg.addObject("simen");
		agg.addObject("della");
		
		while(iterator.hasNext()) {
			System.out.println(iterator.getCurrent());
			iterator.next();
		}
	}
}
