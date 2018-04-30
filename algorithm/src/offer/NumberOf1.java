package offer;

/**
 * 11.��һ���������������ж��ٸ�1
 * 
 * @author Cavielee
 *
 */
public class NumberOf1 {

	/**
	 * ���Ž�
	 * ��һ��������ȥ1���ٺ�ԭ�����������㣬��Ѹ��������ұ�һ��1���0.
	 * ��ôһ�������Ķ������ж��ٸ�1���Ϳ��Խ��ж��ٴ������Ĳ���
	 * @param n
	 * @return
	 */
	public int numberOf1 (int n) {
		int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
	}
	/**
	 * ����
	 * ͨ����n&1�ж����һλ�Ƿ�Ϊ1
	 * Ȼ���n����һλ���ظ�32�Σ���ΪintΪ32��λ��
	 * ע����Ҫʹ���޷������ƣ���Ϊ��nΪ����ʱ����ͨ���ƻ��Զ���ǰ�油1����˻�����ѭ��
	 * @param n
	 * @return
	 */
	public int numberOf1_2 (int n) {
		int num = 0;
		if (n == 0)
			return 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				num++;
			}
			n = n >>> 1;
		}
		return num;
	}

	public static void main(String[] args) {
		NumberOf1 no1 = new NumberOf1();
		System.out.println(no1.numberOf1(10));
	}

}
