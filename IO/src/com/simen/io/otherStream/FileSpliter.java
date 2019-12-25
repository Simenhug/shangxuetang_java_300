package com.simen.io.otherStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class FileSpliter {
	
	private String filePath;
	private String name;
	private long fileLength;
	//number of blocks
	private int size;
	//size of each block
	private long blockSize;
	
	private List<String> blockNames;
	private List<String> srcPaths;
	
	public FileSpliter() {
		blockNames = new ArrayList<String>();
		srcPaths = new ArrayList<String>();
	}
	
	public FileSpliter(String filePath, long blockSize) {
		this();
		this.blockSize = blockSize;
		this.filePath = filePath;
		init();
	}
	
	public FileSpliter(String filePath) {
		this(filePath,200);
	}
	
	public void init() {
		File src = null;
		
		//no filePath or filePath does not exist
		if(null==filePath||!((src=new File(filePath)).exists())) {
			return;
		}
		//source is a directory
		if((src=new File(filePath)).isDirectory()) {
			return;
		}
		
		name = src.getName();
		this.fileLength = src.length();
		//adjust blockSize if necessary
		if(blockSize>fileLength) {
			blockSize=(int)fileLength;
		}
		//determine the number of blocks
		size = (int)Math.ceil(fileLength*1.0/blockSize);
		initBlockName();
	}
	
	public void initBlockName() {
		if(size!=0) {
			for(int i=0;i<size;i++) {
				blockNames.add(name+".part"+i);
			}
		}
	}
	
	public List<String> getBlockNames(){
		return blockNames;
	}
	
	//destPath here should include "/" at the end
	public void split(String destPath) throws IOException {
		int beginPos = 0;
		int length = (int)blockSize;
		for(int i=0;i<size;i++) {
			//last block might be smaller
			if(i==size-1) {
				length = (int)(fileLength - beginPos);
			}
			splitDetail(beginPos,i,length,destPath);
			beginPos += length;
		}
	}
	
	public void splitDetail(int startPos, int index, int length, String destPath) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(new File(filePath), "r");
		OutputStream os = new BufferedOutputStream(
				new FileOutputStream(destPath+blockNames.get(index)+".txt"));
		
		srcPaths.add(destPath+blockNames.get(index)+".txt");
		raf.seek(startPos);
		
		//int flushSize = (length>1024)? 1024:length;
		byte[] flush = new byte[40];
		int len = 0;
		
		//only want to read from byte 4 to 200
		while(-1!=(len=raf.read(flush))) {
			if(length>=len) {
				os.write(flush, 0, len);
				length-=len;
			} else {
				os.write(flush, 0, length);
				break;
			}
		}
		os.flush();
		os.close();
		raf.close();
	}
	
	public void mergeFiles(List<String> srcPaths, String destPath) throws IOException {
		File dest = new File(destPath);
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest,true));
		
		for(String src:srcPaths) {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(src)));
			byte[] flush = new byte[1024];
			int len = 0;
			while(-1!=(len=bis.read(flush))) {
				bos.write(flush,0,len);
			}
			bos.flush();
			bis.close();
		}
		
		bos.close();
	}
	
	public void mergeFileStream (List<String> srcPaths, String destPath) throws IOException {
		File dest = new File(destPath);
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest,true));
		Vector<InputStream> inStreams = new Vector<InputStream>();
		SequenceInputStream sis = null;
		
		for(String src:srcPaths) {
			inStreams.add(new BufferedInputStream(new FileInputStream(new File(src))));
		}
		sis = new SequenceInputStream(inStreams.elements());
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1!=(len=sis.read(flush))) {
			bos.write(flush,0,len);
		}
		bos.flush();
		sis.close();
		
		bos.close();
	}
	
	public static void main(String[] args) throws IOException {
		FileSpliter sf = new FileSpliter("src/files/test.txt");
		sf.split("src/files/");
		sf.mergeFileStream(sf.srcPaths, "src/files/mergeTest.txt");
	}

}
