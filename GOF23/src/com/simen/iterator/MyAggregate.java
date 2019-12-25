package com.simen.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MyAggregate {
	private List<Object> list = new ArrayList<Object>();
	
	public void addObject(Object obj) {
		this.list.add(obj);
	}
	
	public void removeObject(Object obj) {
		this.list.remove(obj);
	}

	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}
	
	public ConcreteIterator getIterator() {
		return new ConcreteIterator();
	}
	
	private class ConcreteIterator implements MyIterator{
		private int cursor;
		@Override
		public void first() {
			// TODO Auto-generated method stub
			cursor = 0;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return cursor<list.size();
		}
		
		@Override
		public Object getCurrent() {
			return list.get(cursor);
		}

		@Override
		public void next() {
			// TODO Auto-generated method stub
			if(hasNext()) {
				cursor++;
			}else {
				System.out.println("already at last item");;
			}
		}
		
	}
}
