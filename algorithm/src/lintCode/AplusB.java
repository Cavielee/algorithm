package lintCode;

import java.util.Scanner;

/**
 * 1.
 * A+B问题 要求不直接使用+号运算符，即使用位运算 位运算符原理 位运算的异或运算与“和”一致： 异或 1^1=0；1^0=1；0^0=0 求和
 * 1+1=0；1+0=1；0+0=0 位运算的与运算与“进位”一致： 位与 1&1=1；1&0=0；0&0=0 进位 1+1=1；1+0=0；0+0=0
 * 当进位不为0时 则把与运算的结果左移一位和原本的和做异或(和)得到新的数，再求进位（与运算） 当进位为0时，则表示异或所获得的值即最终值
 * 
 * @author Cavielee
 *
 */
public class AplusB {
	/**
	 * @param a:
	 *            An integer
	 * @param b:
	 *            An integer
	 * @return: The sum of a and b
	 */
	static int aplusb(int a, int b) {
		// write your code here
		int s, c;

		// 循环法
		while (b != 0) {
			s = a ^ b;
			c = (a & b) << 1;
			a = s;
			b = c;
		}
		return a;

		// 递归法
		// if (b == 0)
		// return a;
		// s = a ^ b;
		// c = (a & b) << 1;
		// return aplusb(s, c);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = Integer.parseInt(in.nextLine().trim());
		int b = Integer.parseInt(in.nextLine().trim());
		aplusb(a, b);
	}
}
