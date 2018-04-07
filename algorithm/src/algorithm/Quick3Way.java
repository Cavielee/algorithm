package algorithm;

/**
 * 三向切分快排
 * 与原始快排区别在于每段元素都与关键字对比交换，而不是把段中元素比较排序后再把关键字交换
 * @author Cavielee
 *
 */
public class Quick3Way {
	public static void sort(int[] a) {
		// shuffle(a); // 打乱数组的顺序，因为快排在无序的效率较高。
		sort(a, 0, a.length - 1);
	}
	
	/**
	 * 1、先判断待排序的部分（范围lo~hi）是否只有一个元素（lo=hi）或没有元素（hi<=lo）
	 * 2、把段的第一个作为关键字point
	 * i下标下一个要比较的元素，i的左侧表示比关键字小和等于的元素，j下标右侧表示比关键字大的元素
	 * lt下标左侧表示比关键字小的元素（即lt和i之间为等于关键字的元素）
	 * 3、当i和j不相等时，此时表明该段的的元素没有比较完
	 * 4、循环比较i与关键字
	 * 小于则把i与关键字交换，i往下一个移
	 * 大于则把j与i交换，j往上一个移
	 * 等于则i++，i和lt之间的差距表明有多少个与关键字相同的元素
	 * 5、依次递归排序lt左侧段
	 * 6、依次递归排序j的右侧段
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
