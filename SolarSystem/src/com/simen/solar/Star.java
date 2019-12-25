package com.simen.solar;

import java.awt.Graphics;
import java.awt.Image;

import com.simen.util.GameUtil;

/**
 * create a class for stars
 * @author simenhuang
 *
 */
public class Star {
	Image img;
	double x,y;
	int width,height;
	
	public void draw(Graphics g) {
		g.drawImage(img, (int)x, (int)y, null);
	}
	
	public Star() {}
	
	public Star(Image img) {
		this.img = img;
		width = img.getWidth(null);
		height = img.getHeight(null);
	}
	
	public Star(Image img, double x, double y) {
		this(img);
		this.x = x;
		this.y = y;
	}
	
	public Star(String imgPath, double x, double y) {
		this(GameUtil.getImage(imgPath), x, y);
	}
}
