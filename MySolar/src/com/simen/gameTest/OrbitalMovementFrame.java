package com.simen.gameTest;

import java.awt.Graphics;

public class OrbitalMovementFrame extends MyFrame{
	

	private double x = 100, y = 100;
	private double degree = 3.14 / 3;

	@Override
	public void paint(Graphics g) {
		
		g.drawImage(img, (int)x, (int)y, null);
		
		//slow down movement
		
//		if(Constant.speed>0) {
//			Constant.speed -= 0.02;
//		}else {
//			Constant.speed = 0;
//		}
//		Constant.speed = 100;
		
		x = 100 + 100*Math.cos(degree);
		y = 200 + 50*Math.sin(degree);
		degree += 0.1;
		
//		if(Constant.y>500-30||Constant.y<30) {
//			Constant.degree = -Constant.degree;
//		}
//		
//		if(Constant.x<0||Constant.x>500-30) {
//			Constant.degree = Math.PI-Constant.degree;
//		}
	}
	

	public static void main(String[] args) {
		OrbitalMovementFrame frame = new OrbitalMovementFrame();
		frame.launchFrame();
	}

}
