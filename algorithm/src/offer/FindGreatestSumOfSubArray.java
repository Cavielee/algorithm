package offer;

/**
 * 31.查找数组中的连续子数组最大和
 * 
 * @author Cavielee
 *
 */
public class FindGreatestSumOfSubArray {
	// 解法一
	public int findGreatestSumOfSubArray(int[] array) {
		// 判断数组是否为空或长度为0
		if (array == null || array.length == 0) {
			return 0;
		}

		int max = array[0];
		int temp = array[0];

		for (int i = 1; i < array.length; i++) {
			// 累加到temp中
			temp += array[i];
			// 如果temp比当前元素小，则表示之前连续子数组和是负增加，把temp初始为当前元素
			if (temp < array[i]) {
				temp = array[i];
			}
			// 如果temp素比max大，则更新max
			if (temp > max) {
				max = temp;
			}
		}
		return max;
	}

	// 解法二（动态规划，递归）
	public int findGreatestSumOfSubArray_2(int[] array) {
		// 判断数组是否为空或长度为0
		if (array == null || array.length == 0) {
			return 0;
		}

		int max = array[0];
		int temp = array[0];

		for (int i = 1; i < array.length; i++) {
			// 判断当前子数组和是否比当前元素小，如果小则把当前元素替换掉max
			temp = Math.max(array[i] + max, array[i]);
			// 判断当前子数组和是否比最大子数组和大，是则更新最大子数组和
			max = Math.max(max, temp);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] array = new int[] { -2, -8, -1, -5, -9 };
		int max = new FindGreatestSumOfSubArray().findGreatestSumOfSubArray_2(array);
		System.out.println(max);
	}
}
