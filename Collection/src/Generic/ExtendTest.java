package Generic;

import java.util.ArrayList;
import java.util.List;

public class ExtendTest {
	
	public static void main(String[] args) {
		List<? extends Grandpa> list;
		
		list = new ArrayList<Grandpa>();
		list = new ArrayList<Father>();
		list = new ArrayList<Uncle>();
		list = new ArrayList<Son>();
		
		test(list);
		
		List<? extends Father> list2 = new ArrayList<Son>();
		test(list2);
		
		List<?> list3 = new ArrayList<Uncle>();
		// cannot do this, because <?> is same as <? extends Object>
//		test(list3);
		
	}
	
	public static void test(List<? extends Grandpa> list) {
		//can't do, because what if the list is ArrayList<Son>?
//		list.add(new Father());
//		list.add(new Uncle());
//		list.add(new Son());
		list.add(null);
	}
}
