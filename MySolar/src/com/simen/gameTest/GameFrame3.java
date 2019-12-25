package com.simen.gameTest;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * making objects move in predefined orbits
 * @author xinmianhuang
 *
 */
public class GameFrame3 extends Frame{
	
	Image img = GameUtil.getImage("images/sun.jpg");
	
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
		setSize(500,500);
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
	
	private double x=100, y=100;
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(img, (int)x, (int)y, null);
		
		if(left) {
			x -= 3;
		}else {
			x += 3;
		}
		
		if(x>500-30) {
			left = true;
		}
		if(x<0) {
			left = false;
		}

		
		if(up) {
			y -= 10;
		}else {
			y += 10;
		}
		
		if(y>500-30) {
			up = true;
		}
		if(y<30) {
			up = false;
		}
	}
	

	public static void main(String[] args) {
		GameFrame3 gf = new GameFrame3();
		gf.launchFrame();
	}
}
