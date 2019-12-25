package Generic;

import java.util.ArrayList;
import java.util.List;

public class SuperTest {
	
	public static void main(String[] args) {
		
		List<Father> list = new ArrayList<Father>();
		test(list);
		List<Grandpa> list2 = new ArrayList<Grandpa>();
		list2.add(new Father());
		list2.add(new Son());
		test(list2);
		List<Object> list3 = new ArrayList<Object>();
		test(list3);
		
		List<? super Father> list4 = new ArrayList<Father>();
		test(list4);
		List<? super Father> list5 = new ArrayList<Object>();
		test(list5);
		
	}
	
	public static void test(List<? super Father> list) {
		list.add(new Father());
		list.add(new Son());
//		list.add(new Uncle());
//		list.add(new Grandpa());
	}
}
