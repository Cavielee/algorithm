package algorithm;

/**
 * �����зֿ���
 * ��ԭʼ������������ÿ��Ԫ�ض���ؼ��ֶԱȽ����������ǰѶ���Ԫ�رȽ�������ٰѹؼ��ֽ���
 * @author Cavielee
 *
 */
public class Quick3Way {
	public static void sort(int[] a) {
		// shuffle(a); // ���������˳����Ϊ�����������Ч�ʽϸߡ�
		sort(a, 0, a.length - 1);
	}
	
	/**
	 * 1�����жϴ�����Ĳ��֣���Χlo~hi���Ƿ�ֻ��һ��Ԫ�أ�lo=hi����û��Ԫ�أ�hi<=lo��
	 * 2���Ѷεĵ�һ����Ϊ�ؼ���point
	 * i�±���һ��Ҫ�Ƚϵ�Ԫ�أ�i������ʾ�ȹؼ���С�͵��ڵ�Ԫ�أ�j�±��Ҳ��ʾ�ȹؼ��ִ��Ԫ��
	 * lt�±�����ʾ�ȹؼ���С��Ԫ�أ���lt��i֮��Ϊ���ڹؼ��ֵ�Ԫ�أ�
	 * 3����i��j�����ʱ����ʱ�����öεĵ�Ԫ��û�бȽ���
	 * 4��ѭ���Ƚ�i��ؼ���
	 * С�����i��ؼ��ֽ�����i����һ����
	 * �������j��i������j����һ����
	 * ������i++��i��lt֮��Ĳ������ж��ٸ���ؼ�����ͬ��Ԫ��
	 * 5�����εݹ�����lt����
	 * 6�����εݹ�����j���Ҳ��
	 * @param a
	 * @param lo
	 * @param hi
	 */
	private static void sort(int[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int lt = lo, i = lo + 1, j = hi;
		int point = a[lo];
		while (i <= j) {
			int cmp = a[i] - point;
			if (cmp < 0)
				MyCompare.exch(a, lt++, i++);
			else if (cmp > 0)
				MyCompare.exch(a, i, j--);
			else
				i++;
		}
		sort(a, lo, lt - 1);
		sort(a, j + 1, hi);
	}
}
