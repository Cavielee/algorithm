package onlineTest;

import java.util.Scanner;

/**
 * 输入n和k
 * 1 <= n <= 10^5, 0 <= k <= n - 1
 * 要求：
 * ① x、y<=n
 * ② x%y>=k
 * 求数对x和y
 * 思路：
 * 当k=0时，x和y取任何值都能满足，组合数为n*n
 * 当k!=0时，只需要求除数为k+1~n(因为除数只有从k+1开始才存在余数为k的可能)
 * 例如n=5,k=2
 * 当除数为3时，1%3=1,2%3=2，3%3=0,4%3=1，5%3=2（可以看出规律为1，2,0,1,2,0...）
 * ①：
 * n/i为有多少组
 * 除数第一次取值时，规律中每一组有1个数列符合，第二次时取值时，规律中每一组有2个数列符合
 * 因此每一次循环n / i * j个符合
 * ②：
 * 当有超出的不足一个规律组的，则判断多出来的个数是否大于等于k
 * (n % i) >= k
 * 大于等于则有(n % i) - k + 1个数列符合
 * 小于则为0个
 * 最终把每一轮循环的①和②加起来即为符合个数
 * @author Cavielee
 *
 */
public class NetEasy_5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1 <= n <= 10^5
		int n = sc.nextInt();
		// 0 <= k <= n - 1
		int k = sc.nextInt();

		long num = 0;
		if (k == 0) {
			num = (long) Math.pow(n, 2);
		} else {
			for (int i = k + 1, j = 1; i <= n; i++, j++) {
				int expect = (n % i) >= k ? ((n % i) - k + 1) : 0;
				num += n / i * j + expect;
			}
		}
		System.out.println(num);
	}

}
