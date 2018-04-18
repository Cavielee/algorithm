package lintCode;

/**
 * 2.
 * 给定一个正整数，求出该数阶乘后结果尾部有多少个连续的0
 * 思路：看阶乘的数有多少个能被5整除的个数即为答案
 * 注意：例如25可以拆分成5*5，因此有两个，同理125（5*5*5）有三个
 * @author Cavielee
 *
 */
public class TrailingZeros {
	public static long trailingZeros(long n) {
		// write your code here, try to do it without arithmetic operators.
		long count = 0;
		for (long i = 5; i <= n; i*=5) {
			count += n/i;
		}
		return count;
	}

	

	public static void main(String[] args) {
		System.out.println(trailingZeros(30));
	}
}
