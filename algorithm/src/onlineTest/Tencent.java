package onlineTest;

import java.util.Scanner;

/**
 * 腾讯编程题通过率100%，2秒以内
 * 一个从一开始递增的数列
 * 输入n和m（n能被2m整除）
 * n表示数列有多少个元素
 * m表示每隔多少个符号改变（初始符号为-）
 * 例如4 1（求数列和）
 * -1 2 -3 4
 * 该数列和为2
 * @author Cavielee
 *
 */
public class Tencent {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		long m = sc.nextInt();
		long N = n / (m << 1);
		long fusum = 0;

		/*
		 * 如果n/m == 2
		 * 即正负数只有一组例如：
		 * -1 -2 3 4
		 * 则只需要把负数部分累加求和
		 * 否则把m个负数组累加求和
		 */
		if (n / m == 2) {
			fusum = -((1 + (n >> 1)) * n >> 2);
		} else {
			for (int i = 1; i <= m; i++) {
				fusum += -(i * N + (N * (N - 1) * (m << 1) >> 1));
			}
		}

		/*
		 * 结果为该数组所有数和减去两倍负数和
		 */
		System.out.println((n * (1 + n) >> 1) + (2 * fusum));

	}

}
