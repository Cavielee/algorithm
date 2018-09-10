package lintCode;

/**
 * 给定一串字符串，要求把字符串的单词顺序翻转
 * 注：每个单词之间可能存在多个空格，但最终输出单词间隔为一个空格
 * 例如："how are  you?" -> "you? are How"
 * @author CavieLee
 *
 */
public class ReverseWordsSolution {

	public String reverseWords(String s) {
		String reverseString = "";
		String[] words = s.split("[\\s]+");

		// 校验字符串
		if (s == null || words.length == 0) {
			return reverseString;
		}

		reverseString = reverseString + words[words.length - 1];
		for (int i = words.length - 2; i >= 0; i--) {
			reverseString = reverseString + " " +  words[i];
		}
		return reverseString;
	}
}
