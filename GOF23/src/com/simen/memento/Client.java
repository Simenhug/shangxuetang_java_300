package com.simen.memento;

public class Client {
	public static void main(String[] args) {
		CareTaker simen = new CareTaker();
		
		Originator della = new Originator("della", 18, 60000);
		simen.setMeme(della.memento());
		System.out.println(della.getName()+" "+della.getAge()+" "+della.getSalary());
		
		System.out.println("update data");
		della = new Originator("siyu", 23, 50000);
		System.out.println(della.getName()+" "+della.getAge()+" "+della.getSalary());
		
		System.out.println("rollback to last memento");
		della.rollback(simen.getMeme());
		System.out.println(della.getName()+" "+della.getAge()+" "+della.getSalary());
	}
}
