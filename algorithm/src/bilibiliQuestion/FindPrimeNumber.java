package bilibiliQuestion;

import java.util.ArrayList;

/**
 * 题目：在1-n中寻找最大的素数 
 * 思路： 
 * ① 最小的素数是2，然后往上找下一个素数，知道寻找的数已经大于n，则返回当前最大的素数
 * ② 除了第一个以外素数一定是奇数 
 * ③ 判断一个数是否为奇数，只需与该数之前的所有素数取模（若都不为0则为素数）
 * 
 * @author Cavielee
 *
 */
public class FindPrimeNumber {
	public int findPrimeNumber(int n) {
		// 记录最大素数
		int result = 2;
		// 当前判断的数
		int currentNum = 3;
		// 判断n是否合法
		if (n < 2) {
			return 0;
		} else if (n == 2) {
			return result;
		} else {
			// 素数表
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(2);
			while (currentNum <= n) {
				// 素数标记
				boolean flag = true;
				for (int temp : list) {
					// 如果能被整除则不是素数
					if (currentNum % temp == 0) {
						flag = false;
						break;
					}
				}
				if (flag) {
					// 添加进素数表
					list.add(currentNum);
					result = currentNum;
				}
				currentNum += 2;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(new FindPrimeNumber().findPrimeNumber(-1));
	}
}
