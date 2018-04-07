package algorithm;

/**
 * 快速排序
 * 
 * @author Cavielee
 *
 */
public class QuickSort {
	public static void sort(int[] a) {
		// shuffle(a); // 打乱数组的顺序，因为快排在无序的效率较高。
		sort(a, 0, a.length - 1);
	}

	/**
	 * 1、先判断待排序的部分（范围lo~hi）是否只有一个元素（lo=hi）或没有元素（hi<=lo）
	 * 2、如果不是①则先以关键字进行分割排序
	 * 3、以关键字左边部分进行再排序，递归下去
	 * 4、以关键字右边部分进行再排序，递归下去
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
	 * 把该段第一个元素作为关键字进行分割排序
	 * 以i为标记先从左往右寻找第一个比关键字大的
	 * 以j为标记从右往左寻找第一个比关键字小的
	 * 判断i>=j,如果成立则证明i的左侧都比关键字大，跳出循环交换关键字和j下表的值
	 * 如果不成立则交换i下标和j下标的元素，使得在i下标左侧都是比关键字小，j右侧都比关键字大
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
