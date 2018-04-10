package lintCode;

import java.util.Scanner;

/**
 * 1.
 * A+B���� Ҫ��ֱ��ʹ��+�����������ʹ��λ���� λ�����ԭ�� λ�������������롰�͡�һ�£� ��� 1^1=0��1^0=1��0^0=0 ���
 * 1+1=0��1+0=1��0+0=0 λ������������롰��λ��һ�£� λ�� 1&1=1��1&0=0��0&0=0 ��λ 1+1=1��1+0=0��0+0=0
 * ����λ��Ϊ0ʱ ���������Ľ������һλ��ԭ���ĺ������(��)�õ��µ����������λ�������㣩 ����λΪ0ʱ�����ʾ�������õ�ֵ������ֵ
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

		// ѭ����
		while (b != 0) {
			s = a ^ b;
			c = (a & b) << 1;
			a = s;
			b = c;
		}
		return a;

		// �ݹ鷨
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
