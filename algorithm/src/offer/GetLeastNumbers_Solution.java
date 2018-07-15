package offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class GetLeastNumbers_Solution {

	// 基于快排实现
	public ArrayList<Integer> getLeastNumber_Solution(int[] array, int k) {
		final ArrayList<Integer> list = new ArrayList<Integer>();
		// 判断数组是否为空或长度为0，k是否小于等于0
		if (array == null || array.length == 0 || k <= 0 || k > array.length)
			return list;

		// 通过快排找到第k个数
		int start = 0;
		int end = array.length - 1;
		int index = partition(array, start, end);
		while (index != (k - 1)) {
			// 如果index大于数组一半，则往小的部分继续找
			if (index > (k - 1)) {
				end = index - 1;
			}
			// 否则则往大的部分找
			else {
				start = index + 1;
			}
			index = partition(array, start, end);
		}

		// 添加最小的k个数
		for (int i = 0; i <= index; i++) {
			list.add(array[i]);
		}

		return list;
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
			// 从右往左找出第一个比
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

	// 基于最大堆实现
	public ArrayList<Integer> getLeastNumber_Solution_2(int[] array, int k) {
		final ArrayList<Integer> list = new ArrayList<Integer>();
		// 判断数组是否为空或长度为0，k是否小于等于0
		if (array == null || array.length == 0 || k <= 0 || k > array.length)
			return list;
		// 建立PriorityQueue（即最大堆）
		PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});

		// 遍历每一个元素
		for (int i = 0; i < array.length; i++) {
			// 当还没有k个元素时，直接添加
			if (maxheap.size() != k)
				maxheap.offer(array[i]);
			// 当有k个元素时，则和最大元素（队列顶部）相比,比最大元素小则删除后添加
			else {
				if (maxheap.peek() > array[i]) {
					maxheap.poll();
					maxheap.offer(array[i]);
				}
			}
		}
		list.addAll(maxheap);
		return list;
	}

	// 基于红黑树实现
	public ArrayList<Integer> getLeastNumber_Solution_3(int[] array, int k) {
		final ArrayList<Integer> list = new ArrayList<Integer>();
		// 判断数组是否为空或长度为0，k是否小于等于0
		if (array == null || array.length == 0 || k <= 0 || k > array.length)
			return list;
		// 建立TreeSet（红黑树）
		new TreeSet<Integer>();
		// 建立PriorityQueue（即最大堆）
		PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});

		// 遍历每一个元素
		for (int i = 0; i < array.length; i++) {
			// 当还没有k个元素时，直接添加
			if (maxheap.size() != k)
				maxheap.offer(array[i]);
			// 当有k个元素时，则和最大元素（队列顶部）相比,比最大元素小则删除后添加
			else {
				if (maxheap.peek() > array[i]) {
					maxheap.poll();
					maxheap.offer(array[i]);
				}
			}
		}
		list.addAll(maxheap);
		return list;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 4, 6, 8, 9, 10 };
		new GetLeastNumbers_Solution().getLeastNumber_Solution_2(array, 5);

	}

}
