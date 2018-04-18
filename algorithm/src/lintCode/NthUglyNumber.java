package lintCode;

/**
 * 4.
 * 找出第n个丑数（只包含因子2,3,5的正整数被称作丑数，1默认为丑数）
 * 思路：
 * 暴力法：一个一个数的取模2/3/5，然后除以该模的数，循环下去，直到最后如果为1则是丑数，否则不是丑数
 * 最优法：每个丑数乘以2/3/5还是丑数
 * 因此创建一个有序的丑数表，每次选取三个新的丑数并选取最小的插入到丑数表中，使丑数表保持有序
 * 重复上述操作，直到选取出n个丑数
 * @author Cavielee
 *
 */
public class NthUglyNumber {

	public static int nthUglyNumber(int n) {
		if (n <= 0)
			return 0;
		// 创建一个index容量的丑数表
		int[] uglyNumbers = new int[n];
		// 1作为第一个的丑数
		uglyNumbers[0] = 1;
		//nextUglyNumberIndex用来记录当前需要插入的下标
		int nextUglyNumberIndex = 1;
		// multiplyNumber2/3/5用来指向当前因子是乘以那个丑数的下标
		int multiplyNumber2 = 0;
		int multiplyNumber3 = 0;
		int multiplyNumber5 = 0;
		/*
		 *  用当前因子的用到那个丑数的下标相乘，选取2/3/5因子乘出来的新的三个丑数最小的哪一个，并插入到丑数表中
		 *  然后更新最小的那个丑数所用到的因子基于那个丑数的下标
		 *  例如：
		 *  一开始multiplyNumber2/3/5都指向0下标（即丑数1）
		 *  得出2，3，5三个新的丑数，把2（最小的）插入到丑数表中
		 *  将multiplyNumber2（因为新的丑数是基于因子2得出来的）加1，下次该因子从这个下标的丑数相乘得出新的丑数
		 */
		while (nextUglyNumberIndex < n) {
			int min = min(uglyNumbers[multiplyNumber2] * 2, uglyNumbers[multiplyNumber3] * 3,
					uglyNumbers[multiplyNumber5] * 5);
			uglyNumbers[nextUglyNumberIndex] = min;
			nextUglyNumberIndex++;
			if (uglyNumbers[multiplyNumber2] * 2 == min)
				++multiplyNumber2;
			if (uglyNumbers[multiplyNumber3] * 3 == min)
				++multiplyNumber3;
			if (uglyNumbers[multiplyNumber5] * 5 == min)
				++multiplyNumber5;

		}
		return uglyNumbers[nextUglyNumberIndex - 1];
	}

	private static int min(int multiplyNumber2, int multiplyNumber3, int multiplyNumber5) {
		int min = (multiplyNumber2 < multiplyNumber3) ? multiplyNumber2 : multiplyNumber3;
		return (min < multiplyNumber5) ? min : multiplyNumber5;
	}

	public static void main(String[] args) {

		System.out.println(nthUglyNumber(10));
	}

}
