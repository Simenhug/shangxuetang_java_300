package mypro01;
import java.io.File;
import java.io.IOException;


public class TestFile {
	public static void main(String[] args) {
		File file = new File("/Users/simenhuang/Documents/BMO Harris/WIRE/FedWire/"
				+ "pain001FedwireSample.xml.xml");
		File file2 = new File("/Users/simenhuang/Documents");
		File file3 = new File(file2, "Trex templet.xlsx");
		File file4 = new File(file2, "TestFile.java");
		File file5 = new File("/Users/simenhuang/Documents/test");
		file5.mkdir();
		file5.delete();
//		File file6 = new File("/Users/simenhuang/Documents/test/my/della");
//		file6.mkdirs();
//		file6.delete();
		try {
			file4.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		file4.delete();
		if (file.isFile()) {
			System.out.println("it's a file");
		}
		
		if(file2.isDirectory()) {
			System.out.println("it's a directory");
		}
	}
}
