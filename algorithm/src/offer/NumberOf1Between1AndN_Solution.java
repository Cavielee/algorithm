package offer;

/**
 * 32.整数中1出现的次数
 * 
 * @author Cavielee
 *
 */
public class NumberOf1Between1AndN_Solution {

	// 解法一（O（n*logn））
	public int numberOf1Between1AndN_Solution(int n) {
		int num = 0;
		// 判断n是否大于等于1
		if (n < 1) {
			return num;
		}
		// 累加至n
		for (int i = 1; i <= n; i++) {
			// 判断每一个数的每一位是否为1
			for (int j = i; j > 0; j /= 10) {
				if (j % 10 == 1) {
					num++;
				}
			}
		}
		return num;
	}

	// 解法二（O（logn））
	public int numberOf1Between1AndN_Solution_2(int n) {
		int num = 0;
		// 判断n是否大于等于1
		if (n < 1) {
			return 0;
		}
		/*
		 * 用i表示当前位数 
		 * 把数字分为两种（高位n/i和低位n%i）然后分三种情况出现1
		 * ①当前位数字大于1，则高位有n/10*i+1个数字1
		 * ②当前位数字等于1，则高位有n/10*i个数字1，低位有n%i+1个数字1
		 * ③当前位数字等于0，则高位有n/10*i个数字1
		 */
		for (int i = 1; i <= n; i *= 10) {
			int high = n / i;
			int low = n % i;
			int currentDigit = high % 10;
			if (currentDigit == 0) {
				num += high / 10 * i;
			}
			else if (currentDigit == 1) {
				num += high / 10 * i + low + 1;
			}
			else {
				num += (high / 10 + 1) * i;
			}
		}
		return num;
	}

	public static void main(String[] args) {
		int num = new NumberOf1Between1AndN_Solution().numberOf1Between1AndN_Solution_2(10);
		System.out.println(num);
	}

}
