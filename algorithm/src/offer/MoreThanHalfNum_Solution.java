package offer;

public class MoreThanHalfNum_Solution {

	public int moreThanHalfNum_Solution(int[] array) {
		// 判断array是否为null或长度为0
		if (array == null || array.length == 0)
			return 0;
		int start = 0;
		int end = array.length - 1;
		int index = partition(array, start, end);
		while (index != (array.length >> 1)) {
			// 如果index大于数组一半，则往小的部分继续找
			if (index > (array.length >> 1)) {
				end = index - 1;
			}
			// 否则则往大的部分找
			else {
				start = index + 1;
			}
			index = partition(array, start, end);
		}

		int result = array[index];

		// 判断index的数书否出现超过数组一半次数
		int time = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == result) {
				time++;
			}
		}
		if ((time << 1) <= array.length)
			return 0;

		return result;
	}

	// 快排
	public int partition(int[] array, int start, int end) {
		// 一个元素或无元素时退出。
		if (start >= end)
			return start;
		int i = start;
		int j = end + 1;
		// 第一个元素作为关键字
		int key = array[start];
		while (true) {
			// 从左往右找出比第一个分割数小的
			while (array[++i] <= key)
				if (i == end)
					break;
			// 从右往左找出第一个比分割数大的
			while (array[--j] >= key)
				if (j == start)
					break;
			if (i >= j)
				break;
			// 交换下标i和j两个元素
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
		array[start] = array[j];
		array[j] = key;
		return j;
	}

	public int moreThanHalfNum_Solution_2(int[] array) {
		// 判断array是否为null或长度为0
		if (array == null || array.length == 0)
			return 0;

		int result = array[0];
		int time = 1;
		for (int i = 0; i < array.length; i++) {
			// 当次数为0时，则把判断下一个数
			if (time == 0) {
				result = array[i];
				time = 1;
			} else if (array[i] == result)
				time++;
			else
				time--;
		}

		// 判断index的数书否出现超过数组一半次数
		time = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == result) {
				time++;
			}
		}
		if ((time << 1) <= array.length)
			return 0;

		return result;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 4, 2, 1, 4, 2, 4 };
		System.out.println(new MoreThanHalfNum_Solution().moreThanHalfNum_Solution(array));
	}

}
