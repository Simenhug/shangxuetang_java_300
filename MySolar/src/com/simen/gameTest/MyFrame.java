package com.simen.gameTest;

import java.awt.Frame;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.simen.gameTest.GameFrame2.PaintThread;

public class MyFrame extends Frame {
	
	Image img = GameUtil.getImage("sun.jpg");
	
	/**
	 * define a class to repaint window.
	 * @author xinmianhuang
	 *
	 */
	class PaintThread extends Thread {
		
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void launchFrame() {
		setSize(Constant.frameWidth, Constant.frameHight);
		setLocation(100, 100);
		setVisible(true);
		
		new PaintThread().start();
		
		addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
	}
	
}
