package mypro01;
/*
 * 测试switch语句
 */
public class TestSwitch {
	public static void main(String[] args) {
		double d = Math.random();
		int e = (int)(d*5);
		System.out.println(e);

		switch(e) {
		case 6: 
			System.out.println("运气非常好！");
			break;
		case 5: 
			System.out.println("运气不错！");
			break;
		case 4: 
			System.out.println("运气非常好！");
			break;
		default:
			System.out.println("运气不好。。");
		}
	}
}
