package mypro01;
/*
 * 测试while循环
 */
public class TestWhile {
	public static void main(String[] args) {
		int a = 1; //initialize
		
		while(a<=100) { //control condition
			System.out.println(a);  //loop body
			a++;  //iterate
		}
		
		System.out.println("while loop ended");
	}
}
