package Generic;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WildCardTest {
	
	public static void main(String[] args) {
		List<?> list, list1, list2, list3;
		list = new ArrayList<Integer>();
		list1 = new ArrayList<String>();
		list2 = new ArrayList<Date>();
		list3 = new ArrayList<Graphics>();
		
		test(list);
		test(list1);
		test(list2);
		test(list3);
	}
	
	public static void test(List<?> list) {
		System.out.println("it works");
	}

}
