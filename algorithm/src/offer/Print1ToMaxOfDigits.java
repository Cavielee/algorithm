package offer;

/**
 * 12.
 * ��1��ӡ�����nλ��
 * ˼·��
 * ����nλ����ȷ���������Ǵ�λ������˿��ܴ���������⡣
 * 1. ʹ���ַ�����������
 * 2. ����ʹ�õݹ鷨���
 * @author Cavielee
 *
 */
public class Print1ToMaxOfDigits {

	public static void print1ToMaxOfDigits(int n) {
		if (n <= 0)
			return;
		StringBuilder sb = new StringBuilder();
		// ��һλ��
		for (int i = 0; i < 10; i++) {
			sb.replace(0, 1, i + "");
			print1ToMaxOfDigitsRecursively(sb, n, 0);
		}
	}

	private static void print1ToMaxOfDigitsRecursively(StringBuilder sb, int length, int index) {
		// ��index == length - 1ʱ����ʱn��λ������
		if (index == length - 1) {
			// ȥ����һ����0����ǰ��0�������������0���⣩
			String s = sb.toString().replaceFirst("^0+", "");
			if (s != "")
				System.out.println(s);
			return;
		}
		// �ݹ�
		for (int i = 0; i < 10; i++) {
			sb.replace(index + 1, index + 2, i + "");
			print1ToMaxOfDigitsRecursively(sb, length, index + 1);
		}
	}

	public static void main(String[] args) {
		print1ToMaxOfDigits(3);
	}

}
