package com.simen.collection;

import java.util.Date;

public class MyArrayList {
	
	private Object[] elementData;
	
	private int size;
	
	public int size() {
		return size;
	}
	
	public MyArrayList() {
		this(10);
	};
	
	public MyArrayList(int initialCapacity) {
		if(initialCapacity<0) {
			throw new IllegalArgumentException("Illegal Capacity: "+initialCapacity);
		}
		this.elementData = new Object[initialCapacity];
	}
	
	public void add(Object obj) {
		if(size+1>elementData.length) {
			Object[] newArray = new Object[size*2+1];
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			elementData = newArray;
		}
		elementData[size] = obj;
		size++;
	}
	
	public void add(int index, Object obj) {
		rangeCheck(index);
		if(size+1>elementData.length) {
			Object[] newArray = new Object[size*2+1];
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			elementData = newArray;
		}
		System.arraycopy(elementData, index, elementData, index+1, size-index);
		elementData[index] = obj;
		size++;
	}
	
	private void rangeCheck(int index) {
		if(index<0||index>=size) {
			throw new IllegalArgumentException("index out of bound");
		}
	}
	
	public void remove(int index) {
		rangeCheck(index);
//		size--;
//		for(int i=index;i<size;i++) {
//			elementData[i] = elementData[i+1];
//		}
//		elementData[size] = null;
		int length = size - index - 1;
		if(length>0) {
			System.arraycopy(elementData, index+1, elementData, index, length);
		}
		elementData[--size] = null;
	}
	
	public void remove(Object obj) {
		for(int i=0;i<size;i++) {
			if(obj.equals(elementData[i])) {
				remove(i);
			}
		}
	}
	
	public Object set(int index, Object obj) {
		rangeCheck(index);
		Object oldValue = elementData[index];
		elementData[index] = obj;
		return oldValue;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public Object get(int index) {
		rangeCheck(index);
		return elementData[index];
	}
	
	public static void main(String[] args) {
		MyArrayList alita = new MyArrayList(3);
		alita.add(new Date());
		alita.add("bbb");
		alita.add(true);
		alita.add("aaa");
		alita.add(123);
		System.out.println(alita.size());
	}

}
