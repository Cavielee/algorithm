package offer;

/**
 * �滻�ַ����еĿո� ����ֱ����String.replace(regex,replace)������regexΪ������ʽ��replaceΪ�滻������
 * �����\s����ʾȥ�����пհ׷���
 * 
 * @author Cavielee
 *
 */
public class ReplaceSpace {

	// ���⣬������һ��StringBuilder��������ԭ�ַ������Ƶ���������,����' '�����%20
	public static String replaceSpace_1(StringBuffer str) {
		if (str == null)
			return null;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				sb.append("%20");
			} else {
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}

	// ֱ��ͨ�������滻
	public static String replaceSpace(StringBuffer str) {
		String replaceStr = str.toString().replaceAll("\\s", "%20");
		return replaceStr;
	}

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("we are children");
		// System.out.println(replaceSpace(sb));
		System.out.println(replaceSpace_1(sb));
	}

}
