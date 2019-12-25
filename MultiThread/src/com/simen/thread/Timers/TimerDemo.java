package com.simen.thread.Timers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
	
	public static void main(String[] args) {
		Timer timer = new Timer();
		TimerTask1 calendar = new TimerTask1();
		TimerTask2 interval = new TimerTask2();
		
		//trigger after 5 seconds
		timer.schedule(calendar, new Date(System.currentTimeMillis()+5*1000));
		
		//trigger every 2 seconds
		timer.schedule(interval, new Date(), 2000);
	}

}

class TimerTask1 extends TimerTask{

	@Override
	public void run() {
		System.out.println("task started based on designated time "
				+ (new SimpleDateFormat("mm:ss").format(System.currentTimeMillis())));
	}
}

class TimerTask2 extends TimerTask{
	
	@Override
	public void run() {
		System.out.println("task started based on interval "
				+ (new SimpleDateFormat("mm:ss").format(System.currentTimeMillis())));
	}
}
