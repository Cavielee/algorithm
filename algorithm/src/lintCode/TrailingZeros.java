package lintCode;

/**
 * 2.
 * ����һ������������������׳˺���β���ж��ٸ�������0
 * ˼·�����׳˵����ж��ٸ��ܱ�5�����ĸ�����Ϊ��
 * ע�⣺����25���Բ�ֳ�5*5�������������ͬ��125��5*5*5��������
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
