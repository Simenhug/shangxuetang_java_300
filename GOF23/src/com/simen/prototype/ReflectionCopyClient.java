package com.simen.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class ReflectionCopyClient {
	public static void main(String[] args) throws CloneNotSupportedException, IOException, Exception {
		Della della = new Della("della", new Date(1234123453L));
		
		byte[] data;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(della);
		
		data = bos.toByteArray();
		ByteArrayInputStream bis = new ByteArrayInputStream(data);
		ObjectInputStream ois = new ObjectInputStream(bis);
		Della simen = (Della)ois.readObject();
		
		della.setBirthday(new Date(12323452345L));
		System.out.println(della.getBirthday());
		System.out.println(simen.getBirthday());
	}
}
