package mypro01;
/*
 * 打印九九乘法表
 */
public class NineNineMutiplication {
	public static void printOneLine(int num) {
		for(int i=1;i<=num;i++) {
			System.out.print(i+"*"+num+"="+" "+ i*num);
			System.out.print("  ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		for(int i=1; i<10; i++) {
			printOneLine(i);
		}
	}
}