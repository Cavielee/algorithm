package lintCode;

/**
 * strStr 返回目标字符串在源字符串中第一次出现的第一个字符的位置. 
 * 目标字串的长度为 m , 源字串的长度为 n . 
 * 如果目标字串不在源字串中则返回 -1。
 * @author CavieLee
 *
 */
public class StrStrIISolution {

	private static final int HASH_SIZE = 1000000007;

	public int strStr2(String source, String target) {
	    // 校验
	    if (source == null || target == null) {
	        return -1;
	    }
	    int TLen = target.length();
	    // 特殊值(target为"")
	    if (TLen == 0) {
	        return 0;
	    }

	    // 33^TLen-1
	    long power = 1;
	    for (int i = 0; i < TLen; i++) {
	        power = power * 33 % HASH_SIZE;
	    }
	    // targetCode
	    long targetCode = 0;
	    for (int i = 0; i < TLen; i++) {
	        targetCode = (targetCode * 33 + target.charAt(i)) % HASH_SIZE;
	    }
	    // 查找
	    long hashCode = 0;
	    for (int i = 0; i < source.length(); i++) {
	        hashCode = (hashCode * 33 + source.charAt(i)) % HASH_SIZE;

	        if (i < TLen - 1) {
	            continue;
	        }
	        if (i >= TLen) {
	            hashCode = hashCode - (source.charAt(i - TLen) * power) % HASH_SIZE;
	            if (hashCode < 0) {
	                hashCode += HASH_SIZE;
	            }
	        }

	        // double check
	        if (hashCode == targetCode) {
	            if (source.substring(i - TLen + 1, i + 1).equals(target))
	                return i - TLen + 1;
	        }
	    }
	    return -1;
	}
}
