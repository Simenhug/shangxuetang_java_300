package com.simen.collection;

import java.util.*;

public class MyMap {
	
	Entry[] elements = new Entry[1000];
	
	int size;
	
	public void put(Object key, Object value) {
		if(size>0) {
			for(int i=0; i<size; i++) {
				if(key.equals(elements[i].key)) {
					elements[i].value = value;
					return;
				}
			}
		}
		elements[size] = new Entry(key, value);
		size++;
	}
	
	public Object get(Object key) {
		for(int i=0; i<size; i++) {
			if(key.equals(elements[i].key)){
				return elements[i].value;
			}
		}
		System.out.println("key not found!");
		return null;
	}
	
	public boolean contansKey(Object key) {
		for(int i=0; i<size; i++) {
			if(key.equals(elements[i].key)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean contansValue(Object value) {
		for(int i=0; i<size; i++) {
			if(value.equals(elements[i].value)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		MyMap mm = new MyMap();
		mm.put("Simen", "Della");
		mm.put("Love", "Forever");
		System.out.println(mm.get("Simen"));
	}

}



class Entry{
	
	Object key;
	Object value;
	
	
	public Entry(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	
}