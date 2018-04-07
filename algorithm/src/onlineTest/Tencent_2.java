package onlineTest;

import java.util.Scanner;

/**
 * СQ�����׸�
 * һ�׳���ΪA(A>1)������ΪX(X<=100)��һ�׳���ΪB(B>1)������ΪY(Y<=100)
 * ���ڸ���һ��K(k<=100)��Ҫ��A��B�ϳɸպôﵽk���ȵ�һ���¸�
 * ��Ϊ����ܴ���Ҫȡģ1000000007
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
		
		for (double i = 1; i <= X; i++) { // forѭ����ʾA���ȸ�����ȡ������
			// ������A���Ⱥ�ʣ����Ҫ�ĳ���
			long left = (long) (K - i * A); 
			// ���ʣ�೤���ܱ�B����&����ҪB������С��Y&ʣ�೤��Ҫ����0
			if (left % B == 0 & left / B < Y & left > 0) { 
				// ��Ҫj��B���ȵĸ�
				double j = left / B;
				/*
				 *  �жϸ�����Ҫ�������Ƿ񳬹�ӵ����һ��
				 *  ��ΪC(n,m)Ϊ�������ʽ��ֻҪ����һ�뼴���ò�������
				 *  ����C(3,2)������C(3, 1)����
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
				// ���������Ľ�����ۼӵ�sum
				sum += Multiply_Denominator(X, number_A) / Multiply_Numerator(number_A, number_A)
						* Multiply_Denominator(Y, number_B) / Multiply_Numerator(number_B, number_B);
			}
		}
		System.out.println(sum % 1000000007);
		System.out.println(String.format("%.2f", Math.ceil(4.0/3.3)));
	}

	/**
	 * ��ĸ���۳ˣ�n����һ������numberΪ�۳˵ĸ���
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
	 * ���ӵ��۳ˣ�n����һ������numberΪ�۳˵ĸ���
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
