package lintCode;
/**
 * �����ַ���A��B���ַ���ȫ�Ǵ�дӢ����ĸ
 * ��B��������ĸ�Ƿ������A�У�
 * @author CavieLee
 *
 */
public class CompareStringSolution {
	
	public boolean compareStrings(String A, String B) {
        if (A == null || B == null) {
            return false;
        }
        
        int[] letters = new int[26];
        
        for (int i = 0; i < A.length(); i++) {
        	letters[A.charAt(i) - 'A']++;
        }
        
        for (int j = 0; j < B.length(); j++) {
        	letters[B.charAt(j) - 'A']--;
        	if (letters[B.charAt(j) - 'A'] < 0) {
        		return false;
        	}
        }
        return true;
    }
}
