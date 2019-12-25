package com.simen.gameTest;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * creating game frame
 * @author xinmianhuang
 *
 */
public class GameFrame extends Frame{
	
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
	
	@Override
	public void paint(Graphics g) {
		g.drawLine(100, 100, 200, 200);
		g.drawRect(100, 100, 200, 200);
		g.drawOval(100, 100, 200, 200);
		
		Font font = new Font("Simen font", Font.BOLD, 100);
		g.setFont(font);
		g.drawString("I am Lord Simen", 200, 200);
		
		g.fillRect(100, 100, 20, 20);
		Color originColor = g.getColor();
		g.setColor(Color.red);
		g.fillOval(300, 300, 20, 20);
		g.setColor(originColor);
		
		g.drawImage(img, (int)x, (int)y, null);
		
		x += 3;
		y += 3;
	}
	

	public static void main(String[] args) {
		GameFrame gf = new GameFrame();
		gf.launchFrame();
	}
}
