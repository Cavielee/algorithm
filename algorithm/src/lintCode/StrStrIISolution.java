package lintCode;

/**
 * strStr ����Ŀ���ַ�����Դ�ַ����е�һ�γ��ֵĵ�һ���ַ���λ��. 
 * Ŀ���ִ��ĳ���Ϊ m , Դ�ִ��ĳ���Ϊ n . 
 * ���Ŀ���ִ�����Դ�ִ����򷵻� -1��
 * @author CavieLee
 *
 */
public class StrStrIISolution {

	private static final int HASH_SIZE = 1000000007;

	public int strStr2(String source, String target) {
	    // У��
	    if (source == null || target == null) {
	        return -1;
	    }
	    int TLen = target.length();
	    // ����ֵ(targetΪ"")
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
	    // ����
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
