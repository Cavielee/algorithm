package lintCode;

/**
 * �����ַ���"abcdefg"������ƫ��������ת����ַ�����
 *  ��ƫ���� offset Ϊ3��Ӧ���efgabcd
 * 
 * @author CavieLee
 *
 */
public class rotateStringSolution {

	// ԭ������ת
	public void rotateString(char[] str, int offset) {
		// У�����
		if (str == null || str.length == 0 || offset < 0) {
			return;
		}
		// ��Ϊoffset���ܴ������鳤��
		offset = offset % str.length;

		// ƫ����ǰ���� reverse
		reverse(str, 0, str.length - offset - 1);
		// ƫ�����󲿷� reverse
		reverse(str, str.length - offset, str.length - 1);
		// �����ַ����� reverse
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
