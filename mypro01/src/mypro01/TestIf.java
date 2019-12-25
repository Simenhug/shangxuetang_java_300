package mypro01;
/*
 * 测试if语句
 */
public class TestIf {
	public static void main(String[] args) {
		double d = Math.random();
		int e = (int)(d*5);
		System.out.println(e);
		if(e>3) {
			System.out.println("大数！");
		}
		
	}
}
