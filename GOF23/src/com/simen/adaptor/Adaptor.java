package com.simen.adaptor;

public class Adaptor extends Adaptee implements Target{
	@Override
	public void handleRequest() {
		super.request();
	}
}
