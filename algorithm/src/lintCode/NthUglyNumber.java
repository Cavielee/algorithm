package lintCode;

/**
 * 4.
 * �ҳ���n��������ֻ��������2,3,5��������������������1Ĭ��Ϊ������
 * ˼·��
 * ��������һ��һ������ȡģ2/3/5��Ȼ����Ը�ģ������ѭ����ȥ��ֱ��������Ϊ1���ǳ����������ǳ���
 * ���ŷ���ÿ����������2/3/5���ǳ���
 * ��˴���һ������ĳ�����ÿ��ѡȡ�����µĳ�����ѡȡ��С�Ĳ��뵽�������У�ʹ������������
 * �ظ�����������ֱ��ѡȡ��n������
 * @author Cavielee
 *
 */
public class NthUglyNumber {

	public static int nthUglyNumber(int n) {
		if (n <= 0)
			return 0;
		// ����һ��index�����ĳ�����
		int[] uglyNumbers = new int[n];
		// 1��Ϊ��һ���ĳ���
		uglyNumbers[0] = 1;
		//nextUglyNumberIndex������¼��ǰ��Ҫ������±�
		int nextUglyNumberIndex = 1;
		// multiplyNumber2/3/5����ָ��ǰ�����ǳ����Ǹ��������±�
		int multiplyNumber2 = 0;
		int multiplyNumber3 = 0;
		int multiplyNumber5 = 0;
		/*
		 *  �õ�ǰ���ӵ��õ��Ǹ��������±���ˣ�ѡȡ2/3/5���ӳ˳������µ�����������С����һ���������뵽��������
		 *  Ȼ�������С���Ǹ��������õ������ӻ����Ǹ��������±�
		 *  ���磺
		 *  һ��ʼmultiplyNumber2/3/5��ָ��0�±꣨������1��
		 *  �ó�2��3��5�����µĳ�������2����С�ģ����뵽��������
		 *  ��multiplyNumber2����Ϊ�µĳ����ǻ�������2�ó����ģ���1���´θ����Ӵ�����±�ĳ�����˵ó��µĳ���
		 */
		while (nextUglyNumberIndex < n) {
			int min = min(uglyNumbers[multiplyNumber2] * 2, uglyNumbers[multiplyNumber3] * 3,
					uglyNumbers[multiplyNumber5] * 5);
			uglyNumbers[nextUglyNumberIndex] = min;
			nextUglyNumberIndex++;
			if (uglyNumbers[multiplyNumber2] * 2 == min)
				++multiplyNumber2;
			if (uglyNumbers[multiplyNumber3] * 3 == min)
				++multiplyNumber3;
			if (uglyNumbers[multiplyNumber5] * 5 == min)
				++multiplyNumber5;

		}
		return uglyNumbers[nextUglyNumberIndex - 1];
	}

	private static int min(int multiplyNumber2, int multiplyNumber3, int multiplyNumber5) {
		int min = (multiplyNumber2 < multiplyNumber3) ? multiplyNumber2 : multiplyNumber3;
		return (min < multiplyNumber5) ? min : multiplyNumber5;
	}

	public static void main(String[] args) {

		System.out.println(nthUglyNumber(10));
	}

}
