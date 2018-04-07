package algorithm;

/**
 * ѡ������
 * @author Cavielee
 *
 */
public class Selection {

	/**
	 * ѡ������ ��һ��ѭ��Ϊ������������1��Ԫ�ء���2��..����ÿһ���ҳ�����������С�Ĳ��뵱ǰ�±�������
	 * һ��������һ���ܶ��������ѡȡ����������С��
	 * �Ƚϣ�ÿһ�ֶ�Ҫ�Ƚ�ÿһ����������Ԫ��
	 * ������ÿһ��ֻ�轻��һ��
	 * @param a
	 */
	public static void sort(int[] a) {
		int N = a.length;

		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++) {
				if (MyCompare.less(a[j], a[min]))
					min = j;
			}
			MyCompare.exch(a, i, min);

		}
	}
}
