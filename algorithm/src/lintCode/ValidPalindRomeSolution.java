package lintCode;

/**
 * 判断字符串是否为回文串（忽略字符串的大小写和非字母数字字符）
 * 空字符默认为回文串
 * @author CavieLee
 *
 */
public class ValidPalindRomeSolution {
	public static void main(String[] args) {
		System.out.println(new ValidPalindRomeSolution().isPalindrome("race a car"));
	}
	public boolean isPalindrome(String s) {
        // 校验
        if (s == null) {
            return false;
        }
        
        // 特殊（空字符串）
        if (s.length() == 0) {
            return true;
        }
        // 去掉非字母和数字字符和对字母进行大写
        s = s.replaceAll("\\W", "").toUpperCase();
        
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        
        return true;
    }
}
