package onlineTest;

/**
 * ����ģ�� ����һ���ַ�����������ַ����е�һ�γ��ֵ�ֻ��һ������ĸ ˼·�� 
 * 1. ��Ϊֻ��26����ĸ������ֻ��26�ֿ���+�����ڣ�����0�� 
 * 2.����һ������������飨����Ϊ26����ʼֵΪ0�������������ַ������ַ�����һ�Σ�������Ӧ�±�+1 
 * 3.����������飬���±��Ӧ��ֵΪ1������±��Ӧ�ַ�����һ�Σ�������ѭ�������жϡ��������궼û�ҵ��򷵻�-1
 * 
 * @author CavieLee
 *
 */
public class FindFirstLetter {

	public static char findFirstLetter(String sample) {
		// �������
		int[] mark = new int[26];

		// �������е��ַ�
		char[] array = sample.toCharArray();
		for (int i = 0; i < array.length; i++) {
			mark[array[i] - 'a']++;
		}

		int j = 0;
		// �����������
		for (; j < mark.length; j++) {
			if (mark[j] == 1) {
				break;
			}
		}

		// �ж��Ƿ��г���һ�ε���ĸ
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
