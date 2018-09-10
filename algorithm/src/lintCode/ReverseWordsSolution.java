package lintCode;

/**
 * ����һ���ַ�����Ҫ����ַ����ĵ���˳��ת
 * ע��ÿ������֮����ܴ��ڶ���ո񣬵�����������ʼ��Ϊһ���ո�
 * ���磺"how are  you?" -> "you? are How"
 * @author CavieLee
 *
 */
public class ReverseWordsSolution {

	public String reverseWords(String s) {
		String reverseString = "";
		String[] words = s.split("[\\s]+");

		// У���ַ���
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
