package lintCode;
/**
 * 两个字符串A和B，字符串全是大写英文字母
 * 问B的所有字母是否存在于A中？
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
