package onlineTest;

import java.util.Scanner;

/**
 * ����n��k
 * 1 <= n <= 10^5, 0 <= k <= n - 1
 * Ҫ��
 * �� x��y<=n
 * �� x%y>=k
 * ������x��y
 * ˼·��
 * ��k=0ʱ��x��yȡ�κ�ֵ�������㣬�����Ϊn*n
 * ��k!=0ʱ��ֻ��Ҫ�����Ϊk+1~n(��Ϊ����ֻ�д�k+1��ʼ�Ŵ�������Ϊk�Ŀ���)
 * ����n=5,k=2
 * ������Ϊ3ʱ��1%3=1,2%3=2��3%3=0,4%3=1��5%3=2�����Կ�������Ϊ1��2,0,1,2,0...��
 * �٣�
 * n/iΪ�ж�����
 * ������һ��ȡֵʱ��������ÿһ����1�����з��ϣ��ڶ���ʱȡֵʱ��������ÿһ����2�����з���
 * ���ÿһ��ѭ��n / i * j������
 * �ڣ�
 * ���г����Ĳ���һ��������ģ����ж϶�����ĸ����Ƿ���ڵ���k
 * (n % i) >= k
 * ���ڵ�������(n % i) - k + 1�����з���
 * С����Ϊ0��
 * ���հ�ÿһ��ѭ���Ģٺ͢ڼ�������Ϊ���ϸ���
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
