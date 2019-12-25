package com.simen.collection;

public class Node {
	
	Node previous;
	Object self;
	Node next;
	
	public Node() {
	}
	
	public Node(Object obj) {
		this.self = obj;
	}
	
	public Node(Node previous, Object self, Node next) {
		super();
		this.previous = previous;
		this.self = self;
		this.next = next;
	}
	
	public Object getPrevious() {
		return previous;
	}
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	public Object getSelf() {
		return self;
	}
	public void setSelf(Object self) {
		this.self = self;
	}
	public Object getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}

}
