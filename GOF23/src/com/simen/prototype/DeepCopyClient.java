package com.simen.prototype;

import java.util.Date;

public class DeepCopyClient {
	public static void main(String[] args) throws CloneNotSupportedException {
		Date date = new Date(1234123453L);
		Della2 della = new Della2("della", date);
		Della2 simen = (Della2)della.clone();
		
		date.setTime(1544543453L);
		System.out.println(della.getBirthday());
		System.out.println(simen.getBirthday());
	}
}
