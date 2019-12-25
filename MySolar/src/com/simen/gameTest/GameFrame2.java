package com.simen.gameTest;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * making objects move in any arbitrary orbits
 * make a pool game
 * @author xinmianhuang
 *
 */
public class GameFrame2 extends Frame{
	
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
	
	private double speed = 10;
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	private double x=100, y=100;
	private double degree = 3.14/3; //[0,2π]
	
	public void setDegree(double degree) {
		this.degree = degree;
	}


	@Override
	public void paint(Graphics g) {
		
		g.drawImage(img, (int)x, (int)y, null);
		
		if(speed>0) {
			speed -= 0.02;
		}else {
			speed = 0;
		}
		
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		
		if(y>500-30||y<30) {
			degree = -degree;
		}
		
		if(x<0||x>500-30) {
			degree = Math.PI-degree;
		}
	}
	

	public static void main(String[] args) {
		GameFrame2 gf = new GameFrame2();
		gf.launchFrame();
	}
}
