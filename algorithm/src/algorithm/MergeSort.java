package algorithm;

/**
 * 归并排序
 * @author Cavielee
 *
 */
public class MergeSort {

	private static int[] aux;

	/**
	 * 缺点：小数组的递归操作会过于频繁，可以在数组过小时切换到插入排序来提高性能。
	 * @param a
	 * @param lo
	 * @param mid
	 * @param hi
	 */
	private static void merge(int[] a, int lo, int mid, int hi) {
		// i指向第一段，j指向第二段
		int i = lo, j = mid + 1;

		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k]; // 将数据复制到辅助数组
		}

		// 边界范围为lo~hi，因此循环hi-lo+1次，即把两段的元素合并到新的
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++]; // 当i大于mid时，则表明第一段已经排好序，剩余的第二段都比当前排好的元素大，因此直接复制
			else if (j > hi)
				a[k] = aux[i++]; // 当j大于边界（hi）时，则表明第二段已经排好序，剩余的第一段都比当前排好的元素大，因此直接复制
			else if (aux[i] < a[j])
				a[k] = aux[i++]; // 先进行这一步，保证稳定性。从辅助数组第一段和当前数组第二段元素比较，把小的元素按下标一次覆盖到原来数组
			else
				a[k] = aux[j++];
		}
	}

	public static void sort(int[] a) {
		aux = new int[a.length];
		sort(a, 0, a.length - 1);
	}

	/**
	 * 将一个大段分成两段，一直递归直到段的长度为1时
	 * 将左边段分成两个1的段然后合并，再把剩余的右边段同样的操作（如果右段长度不为1，则右段也进行分割合并（合并后成为上一段的右段）），然后合并（因为递归所以合并后成为上一段的左段），再往上跳重复操作
	 * @param a
	 * @param lo
	 * @param hi
	 */
	private static void sort(int[] a, int lo, int hi) {
		// 判断段的长度是否为1，为1则不再切割
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid);
		sort(a, mid + 1, hi);
		merge(a, lo, mid, hi);
	}
}
