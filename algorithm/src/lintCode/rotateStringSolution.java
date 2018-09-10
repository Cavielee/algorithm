package lintCode;

/**
 * 例如字符串"abcdefg"，给定偏移量求旋转后的字符串。
 *  如偏移量 offset 为3，应输出efgabcd
 * 
 * @author CavieLee
 *
 */
public class rotateStringSolution {

	// 原数组旋转
	public void rotateString(char[] str, int offset) {
		// 校验参数
		if (str == null || str.length == 0 || offset < 0) {
			return;
		}
		// 因为offset可能大于数组长度
		offset = offset % str.length;

		// 偏移量前部分 reverse
		reverse(str, 0, str.length - offset - 1);
		// 偏移量后部分 reverse
		reverse(str, str.length - offset, str.length - 1);
		// 整个字符串再 reverse
		reverse(str, 0, str.length - 1);
	}

	public void reverse(char[] str, int start, int end) {
		for (int i = start, j = end; i < j; i++, j--) {
			char temp = str[i];
			str[i] = str[j];
			str[j] = temp;
		}
	}

}
