package algorithm;

/**
 * 插入排序
 * @author Cavielee
 *
 */
public class Insertion {

	/**
	 * 第一个循环控制有序区的范围（默认从第一个开始）
	 * 第二个循环则是把无序区第一个（当前有序区的边界的下一个）逐一和有序区比较
	 * 如果有序区元素大，则和该元素交换，如果小则跳出循环
	 * 比较：每一轮都需要把无序区的第一个和有序区比较，直到有序区中找到比该元素小的
	 * 交换：和比较一样，知道有序区中找到比该元素小的
	 * 缺点：对于大规模的数组，插入排序很慢，因为它只能交换相邻的元素，如果要把元素从一端移到另一端，就需要很多次操作。
	 * @param a
	 */
	public static void sort(int[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0 && MyCompare.less(a[j], a[j - 1]); j--) {
				MyCompare.exch(a, j, j - 1);
			}
		}
	}
}
