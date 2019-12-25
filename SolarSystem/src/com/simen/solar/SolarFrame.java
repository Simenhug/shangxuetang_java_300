package com.simen.solar;

import java.awt.Graphics;
import java.awt.Image;

import com.simen.util.Constant;
import com.simen.util.GameUtil;
import com.simen.util.MyFrame;

/**
 * main frame of the solar system
 * 
 * @author simenhuang
 *
 */
public class SolarFrame extends MyFrame {
	Image backGround = GameUtil.getImage("images/bg.jpg");
	Star sun = new Star("images/sun.jpg", Constant.frameWidth/2, Constant.frameHight/2);
	Planet mercury = new Planet("images/Mercury.jpg", 90, 70, 0.15, sun);
	Planet venus = new Planet("images/Venus.jpg", 120, 85, 0.2, sun);
	Planet earth = new Planet("images/Earth.jpg", 150, 100, 0.1, sun);
	Planet moon = new Planet("images/moon.jpg", 30, 20, 0.1, earth, true);
	Planet mars = new Planet("images/Mars.jpg", 200, 130, 0.2, sun);
	Planet jupiter = new Planet("images/Jupiter.jpg", 250, 160, 0.17, sun);
	Planet saturn = new Planet("images/Saturn.jpg", 300, 190, 0.13, sun);
	Planet uranus = new Planet("images/Uranus.jpg", 350, 220, 0.14, sun);
	Planet neptune = new Planet("images/Neptune.jpg", 400, 250, 0.11, sun);

	public void paint(Graphics g) {
		g.drawImage(backGround, 0, 0, null);
		sun.draw(g);
		mercury.draw(g);
		venus.draw(g);
		earth.draw(g);
		mars.draw(g);
		moon.draw(g);
		jupiter.draw(g);
		saturn.draw(g);
		uranus.draw(g);
		neptune.draw(g);
	}

	public static void main(String[] args) {
		SolarFrame solar = new SolarFrame();
		solar.launchFrame();
	}
}
