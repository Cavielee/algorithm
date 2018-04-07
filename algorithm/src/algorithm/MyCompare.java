package algorithm;

/**
 * 对比和交换方法的工具类
 * @author Cavielee
 *
 */
public class MyCompare {
	
	/**
	 * 判断i是否小于j
	 * @param i
	 * @param j
	 * @return
	 */
	public static boolean less(int i, int j) {
		return i - j < 0;
	}
	
	/**
	 * 交换数组a中下标为i和j的两个元素
	 * @param a
	 * @param i
	 * @param j
	 */
	public static void exch(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
}
