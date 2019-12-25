package com.simen.collection;

public class MyLinkedList {
	
	private Node head;
	private Node tail;
	private int size;
	
	public void add(Object obj) {
		Node n = new Node();
		if(head==null) {
			n.setSelf(obj);
			head = n;
			tail = n;
		}else {
			n.setPrevious(tail);
			tail.setNext(n);
			n.setSelf(obj);
			tail = n;
		}
		size++;
	}
	
	public void insert(int index, Object obj) {
		Node n = new Node(obj);
		rangeCheck(index);
		Node formerNode = getNode(index);
		n.previous = formerNode.previous;
		n.next = formerNode;
		formerNode.previous.next = n;
		formerNode.previous = n;
		size++;
	}
	
	public Object get(int index) {
		rangeCheck(index);
		if(head==null) {
			return null;
		} else {
			Node temp;
			int midpoint = size >> 1;
			if (index < midpoint) {
				temp = head;
				for (int i = 0; i < index; i++) {
					if (temp.next == null) {
						return null;
					}
					temp = temp.next;
				}
			}else {
				temp = tail;
				for(int i=size-1;i>=index;i--) {
					temp = temp.previous;
				}
			}
			return temp.self;
		}
	}
	
	public Node getNode(int index) {
		rangeCheck(index);
		if(head==null) {
			return null;
		}else {
			Node temp = head;
			for(int i=0;i<index;i++) {
				if(temp.next==null) {
					return null;
				}
				temp = temp.next;
			}
			return temp;
		}
	}
	
	public void remove(int index) {
		rangeCheck(index);
		if(head==null) {
			System.out.println("list already empty");
			return;
		}
		if(index==0){
			head = head.next;
			head.previous = null;
			size--;
		}else {
			Node temp = head;
			for(int i=0;i<index;i++) {
				if(temp.next==null) {
					return;
				}
				temp = temp.next;
				if(temp==null) {
					System.out.println("node already is null");
					return;
				}
			}
			temp.previous.next = temp.next;
			temp.next.previous = temp.previous;
			size--;
		}
			
	}
	
	public int size() {
		return size;
	}
	
	private void rangeCheck(int index) {
		if(index<0||index>=size) {
			throw new IllegalArgumentException("index out of bound");
		}
	}
	
	public static void main(String[] args) {
		MyLinkedList alita = new MyLinkedList();
		alita.add("aaa");
		alita.add("bbb");
		alita.add("ccc");
		alita.insert(1, "della");
		alita.remove(0);
		System.out.println(alita.size());
		System.out.println(alita.get(0));
		System.out.println(alita.get(1));
		System.out.println(alita.get(2));
	}

}

