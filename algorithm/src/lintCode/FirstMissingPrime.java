package lintCode;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * 给定一个数组，查找未出现的最小素数
 * 
 * @author Cavielee
 *
 */
public class FirstMissingPrime {

	public int firstMissingPrime(int[] nums) {
		int result = 2;
		// 1、判断数组是否为空
		if (nums.length == 0) {
			return result;
		}
		// 2、先对数组进行排序
		Arrays.sort(nums);
		// 3、判断数组的第一个数是否为2
		int first = nums[0];

		// 3、如果first不是2的，则未出现的最小素数为2
		if (first != 2) {
			// 则最小素数是2
			return result;
		} else {
			// 否则从2开始依次寻找下一个素数，并判断是否在数组中出现
			// 建立一个素数表
			TreeSet<Integer> prime_set = new TreeSet<Integer>();
			prime_set.add(2);

			// 在min_scope ~ max_scope之间
			while (true) {
				// 是否为素数标记
				boolean flag = true;

				// 找到下一个素数
				if (prime_set.size() == 1) {
					result = result + 1;
				} else {
					result = result + 2;
				}
				// 判断result是否为素数，通过与prime_set的每一个素数取模来判断
				for (int n : prime_set) {
					// 如果取模不为0，则result不是素数
					if ((result % n) == 0) {
						flag = false;
						break;
					}
				}
				// 判断标记
				if (flag) {
					// 如果为素数则判断是否在数组中
					if (Arrays.binarySearch(nums, result) < 0) {
						// 如果不在则result即为结果
						return result;
					}
					prime_set.add(result);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 3, 5, 7, 11, 13, 17, 19 };
		System.out.println(new FirstMissingPrime().firstMissingPrime(nums));
	}

}
