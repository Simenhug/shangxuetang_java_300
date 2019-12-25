package com.simen.collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test01 {
	
	public static void main(String[] args) {
		List list1 = new ArrayList();
		list1.add("aaa");
		list1.add(123);
		List list2 = new ArrayList();
		list2.add(new Date());
		list2.add("bbb");
		list2.add(true);
		list1.add(list2);
		System.out.println(list1.size());
	}

}
