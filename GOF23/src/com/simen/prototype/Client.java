package com.simen.prototype;

import java.util.Date;

public class Client {
	public static void main(String[] args) throws CloneNotSupportedException {
		Della della = new Della("della", new Date(1234123453L));
		Della simen = (Della)della.clone();
		
		System.out.println(simen.getName());
		simen.setName("simen");
		System.out.println(simen.getName());
		System.out.println(simen.getBirthday());
	}
}
