package lintCode;

/**
 * ���ַ���A�в����ַ���B ������ڣ��򷵻ص�һ�����ֵ��ַ���Bλ�� ��������ڷ��� -1
 * 
 * @author CavieLee
 *
 */
public class StrIndexStr {
	public int strStr(String source, String target) {
		// У�����
		if (source == null || target == null || source.length() < target.length()) {
			return -1;
		}
		if (target.length() == 0) {
			return 0;
		}
		// �����ԱȽϵĴ���
		int max = source.length() - target.length();
		char[] sourceArray = source.toCharArray();
		char[] targetArray = target.toCharArray();
		// Ŀ���һ���ַ�
		char first = targetArray[0];
		for (int i = 0; i <= max; i++) {
			// ����source��Ŀ���һ���ַ���ͬ���ڵ��±�
			if (sourceArray[i] != first) {
				while (++i <= max && sourceArray[i] != first)
					;
			}
			if (i <= max) {
				// �ж�targetʣ����ַ��Ƿ�ȫƥ��
				int j;
				for (j = 1; j < targetArray.length; j++) {
					// �����ƥ��������
					if (sourceArray[i + j] != targetArray[j]) {
						break;
					}
				}
				// ���ƥ����jӦ�õ���targetArray.length
				if (j == targetArray.length) {
					return i;
				}
			}
		}
		return -1;
		// return source.indexOf(target);
	}
}
