package onlineTest;

import java.util.Scanner;

/**
 * ��Ѷ�����ͨ����100%��2������
 * һ����һ��ʼ����������
 * ����n��m��n�ܱ�2m������
 * n��ʾ�����ж��ٸ�Ԫ��
 * m��ʾÿ�����ٸ����Ÿı䣨��ʼ����Ϊ-��
 * ����4 1�������кͣ�
 * -1 2 -3 4
 * �����к�Ϊ2
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
		 * ���n/m == 2
		 * ��������ֻ��һ�����磺
		 * -1 -2 3 4
		 * ��ֻ��Ҫ�Ѹ��������ۼ����
		 * �����m���������ۼ����
		 */
		if (n / m == 2) {
			fusum = -((1 + (n >> 1)) * n >> 2);
		} else {
			for (int i = 1; i <= m; i++) {
				fusum += -(i * N + (N * (N - 1) * (m << 1) >> 1));
			}
		}

		/*
		 * ���Ϊ�������������ͼ�ȥ����������
		 */
		System.out.println((n * (1 + n) >> 1) + (2 * fusum));

	}

}
