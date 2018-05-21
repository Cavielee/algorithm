package onlineTest;

import java.util.Scanner;

/**
 * �������� ţţ׼���μ�ѧУ��֯�Ĵ���, ����ǰţţ׼����������װ��һЩ��ʳ, ţţ�ı�������Ϊw��
 * ţţ����һ����n����ʳ, ��i����ʳ���Ϊv[i]��
 * ţţ��֪������������������������������,��һ���ж�������ʳ�ŷ�(�����Ϊ0Ҳ��һ�ַŷ�)��
 * 
 * �����������
 * ��һ��Ϊ����������n��w(1 <= n <= 30, 1 <= w <= 2 * 10^9),��ʾ��ʳ�������ͱ�����������
 * �ڶ���n��������v[i](0 <= v[i] <= 10^9),��ʾÿ����ʳ�������
 * 
 * ˼·�����ڱ����������󣬲����ö�̬�滮
 * ʹ������Ż���������������
 * �ٴӵ�һ����Ʒ��ʼ������ѡ����ӻ����
 * �������ӣ�����Ҫ�ж���Ӻ��Ƿ񳬹���������������������Է��벢�ҷ���+1��������ýڵ�û�з�֧��
 * �����ж�ʣ�µ���Ʒ�����ظ�������������
 * @author Cavielee
 *
 */
public class NetEasy_8 {
	public static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// ��ʳ����
		int n = sc.nextInt();
		// ��������
		int w = sc.nextInt();

		int[] v = new int[n];
		long sum = 0;
		for (int i = 0; i < n; i++) {
			v[i] = sc.nextInt();
			sum += v[0];
		}

		// ���������Ʒ�����С�ڱ�����������һ����2^n��
		if (sum <= w) {
			System.out.println((int) Math.pow(2, n));
		} else {
			dfs(0, 0, n, w, v);
			System.out.println(count + 1);
		}

	}

	// ����Ż�����
	/**
	 * 
	 * @param sum
	 *            ��ǰʹ������
	 * @param cur
	 *            ��ǰ������Ʒ�±�
	 * @param n
	 *            �ܼ���
	 * @param w
	 *            ��������
	 * @param v
	 *            ��Ʒ�������
	 */
	private static void dfs(long sum, int cur, int n, int w, int[] v) {
		// �ж��Ƿ�����Ʒ
		if (cur < n) {
			// �жϵ�ǰ�����Ƿ񳬳���������
			if (sum > w) {
				return;
			}
			// ѡ�񲻼�����Ʒ
			dfs(sum, cur + 1, n, w, v);
			// ѡ�������Ʒ
			// ��������cur����Ʒʱ���ڱ�����������ֹ�ݹ�
			if ((sum + v[cur]) <= w) {
				count++;
				dfs(sum + v[cur], cur + 1, n, w, v);
			}
		}

	}

}
