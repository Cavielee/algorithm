package offer;

/**
 * 12.
 * 从1打印到最大n位数
 * 思路：
 * 由于n位数不确定，可能是大位数，因此可能存在溢出问题。
 * 1. 使用字符串代替数字
 * 2. 可以使用递归法解决
 * @author Cavielee
 *
 */
public class Print1ToMaxOfDigits {

	public static void print1ToMaxOfDigits(int n) {
		if (n <= 0)
			return;
		StringBuilder sb = new StringBuilder();
		// 第一位数
		for (int i = 0; i < 10; i++) {
			sb.replace(0, 1, i + "");
			print1ToMaxOfDigitsRecursively(sb, n, 0);
		}
	}

	private static void print1ToMaxOfDigitsRecursively(StringBuilder sb, int length, int index) {
		// 当index == length - 1时，此时n个位都有数
		if (index == length - 1) {
			// 去掉第一个非0数字前的0，并输出（除了0以外）
			String s = sb.toString().replaceFirst("^0+", "");
			if (s != "")
				System.out.println(s);
			return;
		}
		// 递归
		for (int i = 0; i < 10; i++) {
			sb.replace(index + 1, index + 2, i + "");
			print1ToMaxOfDigitsRecursively(sb, length, index + 1);
		}
	}

	public static void main(String[] args) {
		print1ToMaxOfDigits(3);
	}

}
