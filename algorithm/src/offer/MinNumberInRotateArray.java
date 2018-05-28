package offer;

/**
 * 6.求旋转数组的最小数字 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 思路： 通过二分法找到中间元素 
 * 旋转数组分左右部分，最小元素一定在右部分 
 * 如果中间比第一个元素大，则证明最小元素在左边部分，
 * 如果中间比最后一个元素小，则证明最小元素在右边部分
 * 
 * 存在特殊情况，就是1，0，1，1，1（中间、第一个、最后一个都是相等） 此时需要对这部分进行顺序查找
 * 
 * @author Cavielee
 *
 */
public class MinNumberInRotateArray {

	public int minNumberInRotateArray(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		if (array.length == 1) {
			return array[0];
		}
		int min = 0;
		int max = array.length - 1;
		int mid;
		// 旋转数组分左右部分，最小元素一定在右部分
		while (true) {
			mid = (min + max) / 2;
			if (array[mid] < array[mid - 1])
				return array[mid];
			// 特殊例子，如果中间，第一个，最后一个都相等,只能顺序查找
			if (array[mid] == array[min] && array[mid] == array[max])
				return MinInOrder(array, min, max);
			// 如果中间比第一个元素大，则证明最小元素在左边部分
			if (array[mid] >= array[min]) {
				min = mid;
			}
			// 如果中间比最后一个元素小，则证明最小元素在右边部分
			else if (array[mid] <= array[max]) {
				max = mid;
			}
		}
	}

	public static int MinInOrder(int[] array, int min, int max) {
		int result = array[min];
		for (int i = min; i < max; i++) {
			if (array[i] < result) {
				result = array[i];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		MinNumberInRotateArray minNumberInRotateArray = new MinNumberInRotateArray();
		int[] arr = new int[] { 1, 1, 1, 0, 1 };
		System.out.println(minNumberInRotateArray.minNumberInRotateArray(arr));
	}

}
