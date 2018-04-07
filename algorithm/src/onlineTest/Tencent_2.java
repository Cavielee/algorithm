package onlineTest;

import java.util.Scanner;

/**
 * 小Q有两首歌
 * 一首长度为A(A>1)，数量为X(X<=100)；一首长度为B(B>1)，数量为Y(Y<=100)
 * 现在给出一个K(k<=100)，要用A和B合成刚好达到k长度的一首新歌
 * 因为结果很大需要取模1000000007
 * @author Cavielee
 *
 */
public class Tencent_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long K = sc.nextInt();
		long A = sc.nextInt();
		long X = sc.nextInt();
		long B = sc.nextInt();
		long Y = sc.nextInt();
		long number_A;
		long number_B;
		long sum = 0;
		
		for (double i = 1; i <= X; i++) { // for循环表示A长度歌曲的取多少首
			// 计算用A长度后剩余需要的长度
			long left = (long) (K - i * A); 
			// 如果剩余长度能被B除尽&所需要B的数量小于Y&剩余长度要大于0
			if (left % B == 0 & left / B < Y & left > 0) { 
				// 需要j首B长度的歌
				double j = left / B;
				/*
				 *  判断歌曲需要的数量是否超过拥有数一般
				 *  因为C(n,m)为组合数公式，只要超过一半即可用补数代替
				 *  例如C(3,2)可以用C(3, 1)代替
				 */
				if (i >= Math.round(X / 2)) {
					number_A = X - (long) i;
				} else {
					number_A = (long) i;
				}
				if (j >= Math.round(Y / 2)) {
					number_B = Y - (long) j;
				} else {
					number_B = (long) j;
				}
				// number_A = (long) i;
				// number_B = (long) j;
				// 计算该情况的结果并累加到sum
				sum += Multiply_Denominator(X, number_A) / Multiply_Numerator(number_A, number_A)
						* Multiply_Denominator(Y, number_B) / Multiply_Numerator(number_B, number_B);
			}
		}
		System.out.println(sum % 1000000007);
		System.out.println(String.format("%.2f", Math.ceil(4.0/3.3)));
	}

	/**
	 * 分母的累乘，n而第一个数，number为累乘的个数
	 * @param n
	 * @param number
	 * @return
	 */
	private static long Multiply_Denominator(long n, long number) {
		if (number == 0)
			return 1;
		return n * Multiply_Denominator(n - 1, --number) % 1000000007;
	}

	/**
	 * 分子的累乘，n而第一个数，number为累乘的个数
	 * @param n
	 * @param number
	 * @return
	 */
	private static long Multiply_Numerator(long n, long number) {
		if (number == 0)
			return 1;
		return n * Multiply_Numerator(n - 1, --number) % 1000000007;
	}
}
