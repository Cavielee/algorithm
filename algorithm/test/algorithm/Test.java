package algorithm;

public class Test {
	// private static int[] aux;
	//
	// public static void sort(int[] array, int start, int end) {
	// if (start < end) {
	// int mid = (start + end) / 2;
	// sort(array, start, mid);
	// sort(array, mid + 1, end);
	// merge(array, start, mid, end);
	// }
	// }
	//
	// private static void merge(int[] a, int lo, int mid, int hi) {
	// // i指向第一段，j指向第二段
	// int i = lo, j = mid + 1;
	//
	// for (int k = lo; k <= hi; k++) {
	// aux[k] = a[k]; // 将数据复制到辅助数组
	// }
	//
	// // 边界范围为lo~hi，因此循环hi-lo+1次，即把两段的元素合并到新的
	// for (int k = lo; k <= hi; k++) {
	// if (i > mid)
	// a[k] = aux[j++]; // 当i大于mid时，则表明第一段已经排好序，剩余的第二段都比当前排好的元素大，因此直接复制
	// else if (j > hi)
	// a[k] = aux[i++]; // 当j大于边界（hi）时，则表明第二段已经排好序，剩余的第一段都比当前排好的元素大，因此直接复制
	// else if (aux[i] < a[j])
	// a[k] = aux[i++]; // 先进行这一步，保证稳定性。从辅助数组第一段和当前数组第二段元素比较，把小的元素按下标一次覆盖到原来数组
	// else
	// a[k] = aux[j++];
	// }
	// }

	public static void main(String[] args) {
		int[] array = new int[] { 3, 5, 2, 4, 1, 8, 6, 7 };

		/**
		 * 归并排序
		 */
		// aux = new int[array.length];
		// Test.sort(array, 0, array.length - 1);

		/**
		 * 快排
		 */

		Quick3Way.sort(array);
		for (int i : array) {
			System.out.println(i);
		}
	}

	public static void sort(int[] array, int start, int end) {
		if (start >= end)
			return;
		int j = partition(array, start, end);
		sort(array, start, j - 1);
		sort(array, j + 1, end);
	}

	// 切分
	public static int partition(int[] array, int start, int end) {
		int i = start;
		int j = end + 1;
		// 取第一个作为切分的元素
		int key = array[start];
		while (true) {
			// 从左往右找到比切分元素大的
			while (array[++i] < key && i != end)
				;
			// 从右往左找到比切分元素小的
			while (array[--j] > key && j != start)
				;
			// 判断是否遍历完
			if (i >= j)
				break;
			// 交换元素
			int temp = array[j];
			array[j] = array[i];
			array[i] = temp;
		}
		// 分割点与关键字交换
		int temp = array[j];
		array[j] = array[start];
		array[start] = temp;
		return j;
	}
}
