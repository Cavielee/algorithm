package lintCode;

/**
 * �ж��ַ����Ƿ�Ϊ���Ĵ��������ַ����Ĵ�Сд�ͷ���ĸ�����ַ���
 * ���ַ�Ĭ��Ϊ���Ĵ�
 * @author CavieLee
 *
 */
public class ValidPalindRomeSolution {
	public static void main(String[] args) {
		System.out.println(new ValidPalindRomeSolution().isPalindrome("race a car"));
	}
	public boolean isPalindrome(String s) {
        // У��
        if (s == null) {
            return false;
        }
        
        // ���⣨���ַ�����
        if (s.length() == 0) {
            return true;
        }
        // ȥ������ĸ�������ַ��Ͷ���ĸ���д�д
        s = s.replaceAll("\\W", "").toUpperCase();
        
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        
        return true;
    }
}
