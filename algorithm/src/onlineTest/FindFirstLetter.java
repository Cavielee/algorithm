package onlineTest;

/**
 * 多益模拟 给出一段字符串，输出该字符串中第一次出现的只有一个的字母 思路： 
 * 1. 因为只有26个字母，所以只有26种可能+不存在（返回0） 
 * 2.创建一个辅助标记数组（容量为26，初始值为0），遍历所有字符，若字符出现一次，则在相应下标+1 
 * 3.遍历标记数组，若下标对应的值为1，则该下标对应字符出现一次，并跳出循环不再判断。若遍历完都没找到则返回-1
 * 
 * @author CavieLee
 *
 */
public class FindFirstLetter {

	public static char findFirstLetter(String sample) {
		// 标记数组
		int[] mark = new int[26];

		// 遍历所有的字符
		char[] array = sample.toCharArray();
		for (int i = 0; i < array.length; i++) {
			mark[array[i] - 'a']++;
		}

		int j = 0;
		// 遍历标记数组
		for (; j < mark.length; j++) {
			if (mark[j] == 1) {
				break;
			}
		}

		// 判断是否有出现一次的字母
		if (j == 26) {
			return '0';
		} else {
			return (char) ('a' + j);
		}
	}

	public static void main(String[] args) {
		System.out.println(findFirstLetter("aabcddeff"));
	}

}
