package io.simen.thread.create;

public class RabbitTurtle {

	public static void main(String[] args) {
		Rabbit wabbit = new Rabbit();
		Turtle turtle = new Turtle();
		
		wabbit.start();
		turtle.start();

	}

}

class Rabbit extends Thread{
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("the wabbit is running "+i+" steps");
		}
	}
}

class Turtle extends Thread{
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("the turtle is crawling "+i+" steps");
		}
	}
}
