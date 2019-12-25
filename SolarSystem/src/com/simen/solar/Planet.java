package com.simen.solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import com.simen.util.GameUtil;

/**
 * create a class for planets
 * @author simenhuang
 *
 */
public class Planet extends Star{
	
	double longAxis;
	double shortAxis;
	double speed;
	double degree;
	Star center; //center of its orbit
	
	boolean isSatellite;
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		if(!isSatellite) {
			drawOrbit(g);
		}
		move();
	}
	
	public void drawOrbit(Graphics g) {
		double ovalX, ovalY, ovalWidth, ovalHeight;
		ovalX = center.x + center.width/2 - longAxis;
		ovalY = center.y + center.height/2 - shortAxis;
		ovalWidth = longAxis * 2;
		ovalHeight = shortAxis * 2;
		Color c = g.getColor();
		g.setColor(Color.blue);
		g.drawOval((int)ovalX, (int)ovalY, (int)ovalWidth, (int)ovalHeight);
		g.setColor(c);
	}
	
	public void move() {
		x = center.x + center.width/2 + longAxis*Math.cos(degree);
		y = center.y + center.height/2 + shortAxis*Math.sin(degree);
		degree += speed;
	}

	public Planet(String imgPath, double longAxis, double shortAxis, 
			double speed, Star center) {
		super(GameUtil.getImage(imgPath));
		this.center = center;
		this.x = center.x + longAxis;
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;
		this.center = center;
	}
	
	public Planet(String imgPath, double longAxis, double shortAxis, 
			double speed, Star center, boolean satellite) {
		this(imgPath, longAxis, shortAxis, speed, center);
		isSatellite = satellite;
	}

	public Planet(String imgPath, double x, double y) {
		super(imgPath, x, y);
	}
	
	public Planet(Image img, double x, double y) {
		super(img, x, y);
	}

}
