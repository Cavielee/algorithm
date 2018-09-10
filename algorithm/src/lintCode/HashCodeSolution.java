package lintCode;
/**
 * Ä£Äâ hashcode() ÊµÏÖ
 * @author CavieLee
 *
 */
public class HashCodeSolution {
	
	public int hashCode(char[] key, int HASH_SIZE) {
        if (key == null || HASH_SIZE == 0) {
            return 0;
        }
        
        long res = 0;
        for (int i = 0; i < key.length; i++){
            res = (res * 33 + key[i]) % HASH_SIZE;
        }
        
        return (int)res;
    }
}
