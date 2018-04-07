package algorithm;

/**
 * 选择排序
 * @author Cavielee
 *
 */
public class Selection {

	/**
	 * 选择排序 第一个循环为有序区（即第1个元素、第2个..），每一轮找出无序区中最小的并与当前下标做交换
	 * 一般用作在一个很多的数据中选取几个最大或最小的
	 * 比较：每一轮都要比较每一个无序区的元素
	 * 交换：每一轮只需交换一次
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
