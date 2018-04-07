package algorithm;

/**
 * 希尔排序
 * @author Cavielee
 *
 */
public class Shell {
	/**
	 * h为间隔，通过依次把相邻间隔的两个元素比较并交换
	 * 然后依次把h缩小重复上面操作，直到h=1,此时即为插入排序。
	 * 优点：因为插入排序只能交换相邻的元素，因此如果较大规模的数组，两个相距很远的元素交换位置，则需要多次交换。
	 * 	而希尔排序，通过交换相距为h的元素，使得每一轮交换时，部分的元素已经归位，当最后一轮（h=1时的插入排序）已经接近
	 * 	所有元素归位的状态，因此在较大规模无序的数组中，希尔排序比插入排序快。
	 * 缺点：每一轮相距h的排序，结果都是不稳定的，知道最后一轮才能确定有序区。
	 * @param a
	 */
	public static void sort(int[] a) {
		int N = a.length;
		int h = 1;
		while (h < N / 3) {
			h = 3 * h + 1; // 1, 4, 13, 40, ...
		}
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && MyCompare.less(a[j], a[j - h]); j -= h) {
					MyCompare.exch(a, j, j - h);
				}
			}
			h = h / 3;
		}
	}
}
