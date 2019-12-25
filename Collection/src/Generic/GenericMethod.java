package Generic;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

//this is not a generic type
public class GenericMethod {
	
	public static <T> void method(T t) {
		System.out.println(t);
	}
	
	public static <T extends List> void method2(T t) {
		t.add("aaa");
		System.out.println(t);
	}
	
	public static<T extends Closeable> void methodClose(T... t) {
		for (T temp: t) {
			try {
				if(null!=temp) {temp.close();}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		method("Simen loves Della");
		methodClose(new FileInputStream("src/Generic/della.txt"));
	}

}
