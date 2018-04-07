package algorithm;

/**
 * ��������
 * 
 * @author Cavielee
 *
 */
public class QuickSort {
	public static void sort(int[] a) {
		// shuffle(a); // ���������˳����Ϊ�����������Ч�ʽϸߡ�
		sort(a, 0, a.length - 1);
	}

	/**
	 * 1�����жϴ�����Ĳ��֣���Χlo~hi���Ƿ�ֻ��һ��Ԫ�أ�lo=hi����û��Ԫ�أ�hi<=lo��
	 * 2��������Ǣ������Թؼ��ֽ��зָ�����
	 * 3���Թؼ�����߲��ֽ��������򣬵ݹ���ȥ
	 * 4���Թؼ����ұ߲��ֽ��������򣬵ݹ���ȥ
	 * @param a
	 * @param lo
	 * @param hi
	 */
	private static void sort(int[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int point = partition(a, lo, hi);
		sort(a, lo, point - 1);
		sort(a, point + 1, hi);
	}

	/**
	 * �Ѹöε�һ��Ԫ����Ϊ�ؼ��ֽ��зָ�����
	 * ��iΪ����ȴ�������Ѱ�ҵ�һ���ȹؼ��ִ��
	 * ��jΪ��Ǵ�������Ѱ�ҵ�һ���ȹؼ���С��
	 * �ж�i>=j,���������֤��i����඼�ȹؼ��ִ�����ѭ�������ؼ��ֺ�j�±��ֵ
	 * ����������򽻻�i�±��j�±��Ԫ�أ�ʹ����i�±���඼�Ǳȹؼ���С��j�Ҳ඼�ȹؼ��ִ�
	 * @param a
	 * @param lo
	 * @param hi
	 * @return
	 */
	private static int partition(int[] a, int lo, int hi) {
		int i = lo, j = hi + 1;
		int v = a[lo];
		while (true) {
			while (MyCompare.less(a[++i], v))
				if (i == hi)
					break;
			while (MyCompare.less(v, a[--j]))
				if (j == lo)
					break;
			if (i >= j)
				break;
			MyCompare.exch(a, i, j);
		}
		MyCompare.exch(a, lo, j);
		return j;
	}
}
