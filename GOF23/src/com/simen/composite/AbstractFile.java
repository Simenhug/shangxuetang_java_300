package com.simen.composite;

import java.util.ArrayList;
import java.util.List;

public interface AbstractFile {
	void killVirus();
}

class TextFile implements AbstractFile{
	private String name;
	
	public TextFile(String name) {
		this.name = name;
	}
	@Override
	public void killVirus() {
		System.out.println("TextFile "+name+" killing virus");
	}
}
class VideoFile implements AbstractFile{
	private String name;
	
	public VideoFile(String name) {
		this.name = name;
	}
	@Override
	public void killVirus() {
		System.out.println("VideoFile "+name+" killing virus");
	}
}

class ImageFile implements AbstractFile{
	private String name;
	
	public ImageFile(String name) {
		this.name = name;
	}
	@Override
	public void killVirus() {
		System.out.println("ImageFile "+name+" killing virus");
	}
}

class Folder implements AbstractFile{
	private String name;
	List<AbstractFile> files = new ArrayList<AbstractFile>();
	public Folder(String name) {
		this.name = name;
	}
	@Override
	public void killVirus() {
		System.out.println("----Folder "+name+" killing virus----");
		for(AbstractFile file: files) {
			file.killVirus();
		}
	}
	
	public void add(AbstractFile file) {
		files.add(file);
	}
	
	public void remove(AbstractFile file) {
		files.remove(file);
	}
	
	public AbstractFile getChild(int index) {
		return files.get(index);
	}
}
