package algorithm;

/**
 * �ԱȺͽ��������Ĺ�����
 * @author Cavielee
 *
 */
public class MyCompare {
	
	/**
	 * �ж�i�Ƿ�С��j
	 * @param i
	 * @param j
	 * @return
	 */
	public static boolean less(int i, int j) {
		return i - j < 0;
	}
	
	/**
	 * ��������a���±�Ϊi��j������Ԫ��
	 * @param a
	 * @param i
	 * @param j
	 */
	public static void exch(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
}
