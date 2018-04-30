package offer;

/**
 * 13.输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author Cavielee
 *
 */
public class ReOrderArray {

	/**
	 * 思路：类似于冒泡排序
	 * i指针为左归位的范围（即奇数）
	 * 第一个循环来控制i指针，从0下标开始
	 * 第二个循环控制j指针，从尾下标开始，通过判断[i,j]范围元素相邻的两个，如果前偶后奇则交换
	 * 通过第二个循环使的奇数与奇数之间，偶数与偶数之间保持相对顺序，并且每一轮都会有一个奇数归位
	 * @param arr
	 * @return
	 */
	public int[] reOrderArray(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = array.length - 1; j>i; j--) {
				if (array[j] % 2 == 1 && array[j - 1]%2 == 0) {//前偶后奇交换
					int temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				}
			}
		}
		return array;
	}

	public static void main(String[] args) {

		int[] arr = new int[] { 0, 1, 2, 3 };
		System.out.println(new ReOrderArray().reOrderArray(arr));
	}

}
