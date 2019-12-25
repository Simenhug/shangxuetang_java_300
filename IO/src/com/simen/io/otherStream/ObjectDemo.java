package com.simen.io.otherStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class ObjectDemo {

	public static void main(String[] args) {
		try {
			serialize("src/files/test5.txt");
			
			//will see "name is null salary is 1000000.0" because field "name" is transient
			deserialize("src/files/test5.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void serialize(String destPath) throws FileNotFoundException, IOException {
		File dest = new File(destPath);
		Employee emp = new Employee("della", 1000000);
		int[] arr = new int[] {1,2,3,4,5};
		
		ObjectOutputStream oos = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(dest)));
		
		oos.writeObject(emp);
		oos.writeObject(arr);
		oos.close();
	}
	
	public static void deserialize(String srcPath) throws FileNotFoundException, IOException, ClassNotFoundException {
		File src = new File(srcPath);
		
		try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(src)));) {
			// read order must be same as write order
			Object obj = ois.readObject();
			int[] arr = (int[]) ois.readObject();

			if (obj instanceof Employee) {
				Employee emp = (Employee) obj;
				System.out.println("name is " + emp.getName() + " salary is " + emp.getSalary());
				System.out.println(Arrays.toString(arr));
			}

			ois.close();
		}
	}

}
