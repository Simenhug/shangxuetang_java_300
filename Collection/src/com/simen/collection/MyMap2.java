package com.simen.collection;

import java.util.Collections;

public class MyMap2 {
	
	MyLinkedList[] elements = new MyLinkedList[1000];
	
	int size;
	
	public void put(Object key, Object value) {
		Entry e = new Entry(key,value);
		int hash = key.hashCode();
		hash = hash<0?-hash:hash;
		int index = hash%elements.length;
		if(elements[index]==null) {
			MyLinkedList ll = new MyLinkedList();
			ll.add(e);
			elements[index] = ll;
		}else {
			MyLinkedList ll = elements[index];
			for (int i = 0; i < ll.size(); i++) {
				Entry entry = (Entry) ll.get(i);
				if (key.equals(entry.key)) {
					entry.value = value;
					return;
				}
			}
			elements[index].add(e);
		}
		size++;
	}
	
	public Object get(Object key) {
		int index = key.hashCode()%1000;
		MyLinkedList ll = elements[index];
		if(ll!=null) {
			for(int i=0;i<ll.size();i++) {
				Entry e = (Entry)ll.get(i);
				if(key.equals(e.key)) {
					return e.value;
				}
			}
		}
		System.out.println("key not found!");
		return null;
	}
	
	public boolean contansKey(Object key) {
		int index = key.hashCode()%1000;
		MyLinkedList ll = elements[index];
		if(ll!=null) {
			for(int i=0; i<ll.size(); i++) {
				Entry e = (Entry)ll.get(i);
				if(key.equals(e.key)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean contansValue(Object value) {
		for (int index = 0; index < elements.length; index++) {
			MyLinkedList ll = elements[index];
			if (ll != null) {
				for (int i = 0; i < ll.size(); i++) {
					Entry e = (Entry) ll.get(i);
					if (value.equals(e.value)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		MyMap2 mm = new MyMap2();
		mm.put("Simen", "Della");
		mm.put("Love", "Forever");
		System.out.println(mm.get("Simen"));
	}

}