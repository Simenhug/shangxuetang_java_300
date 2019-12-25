package com.simen.composite;

public class Client {
	public static void main(String[] args) {
		Folder f1 = new Folder("simen");
		ImageFile image = new ImageFile("simen.jpg");
		TextFile text = new TextFile("lovelettter");
		
		Folder f2 = new Folder("della");
		VideoFile video = new VideoFile("della.avi");
		f1.add(image);
		f1.add(text);
		f2.add(video);
		f1.add(f2);
		f1.killVirus();
	}
}
 