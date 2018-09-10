package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * 33.把数组排成最小的数
 * 
 * @author Cavielee
 *
 */
public class PrintMinNumber {

	/*
	 * 解法一： 利用递归求出每一个可能组成的排列，并放入TreeSet中找到最小的值
	 */
	public String printMinNumber(int[] numbers) {
		// 判断数组是否为空或长度为0
		if (numbers == null || numbers.length == 0) {
			return "";
		}
		TreeSet<String> ts = new TreeSet<String>();
		permutationHelper(0, numbers, ts);
		String min = ts.first();
		return min;
	}

	public static void permutationHelper(int index, int[] numbers, TreeSet<String> ts) {
		// 当为最后一个元素时
		if (index == numbers.length - 1) {
			String val = "";
			for (int n : numbers) {
				val += n;
			}
			// 判断该排列是否存在容器中，不存在则添加
			if (!ts.contains(val)) {
				ts.add(val);
			}
		}
		// 不为最后一个元素
		else {
			for (int i = index; i < numbers.length; i++) {
				// 交换相邻的元素
				int temp = numbers[index];
				numbers[index] = numbers[i];
				numbers[i] = temp;

				// 递归下去继续交换元素
				permutationHelper(index + 1, numbers, ts);

				// 交换回来
				temp = numbers[index];
				numbers[index] = numbers[i];
				numbers[i] = temp;
			}
		}
	}

	/*
	 * 解法二： 利用递归求出每一个可能组成的排列，并放入TreeSet中找到最小的值
	 */
	public String printMinNumber_2(int[] numbers) {
		// 判断数组是否为空或长度为0
		if (numbers == null || numbers.length == 0) {
			return "";
		}
		// 创建ArrayList，并规定特殊的比较器
		ArrayList<String> list = new ArrayList<String>();
		// 对numbers数组转为String，以防止溢出。并将String添加到ArrayList中
		for (int n : numbers) {
			list.add(n + "");
		}
		// 对ArrayList进行排序
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// 如果o1o2>o2o1，则o2<o1同理还有等于和小于情况
				return (o1 + o2).compareTo(o2 + o1);
			}
		});
		String min = "";
		for (String s : list) {
			min += s;
		}
		return min;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 1, 11, 111 };
		System.out.println(new PrintMinNumber().printMinNumber_2(array));
	}

}
