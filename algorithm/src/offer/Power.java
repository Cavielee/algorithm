package offer;

/**
 * 12.�󸡵���base��exponent�������ͣ����ݵ�ֵ
 * 
 * @author Cavielee
 *
 */
public class Power {

	/**
	 * ˼·��ֱ��ʹ��Math.pow()����
	 * 
	 * @param base
	 * @param exponent
	 * @return
	 */
	public double power(double base, int exponent) {
		return Math.pow(base, exponent);
	}

	/**
	 * ���Ž�
	 * ˼·��
	 * 1.ȫ�濼��ָ���������������Ƿ�Ϊ��������
	 * 2.д��ָ���Ķ����Ʊ�����13���Ϊ������1101��
	 * 3.����:10^1101 = 10^0001*10^0100*10^1000��
	 * 4.ͨ��&1��>>1����λ��ȡ1101��Ϊ1ʱ����λ����ĳ����۳˵����ս����
	 * ͨ��n������λ���㣬���ָ��Ϊ���������մ���Ϊres�ĵ���
	 * @param base
	 * @param exponent
	 * @return
	 */
	public double power_2(double base, int exponent) {
		double res = 1, curr = base;
		int n;
		if (exponent > 0) {
			n = exponent;
		} else if (exponent < 0) {
			if (base == 0)
				throw new RuntimeException("��ĸ����Ϊ0");
			n = -exponent;
		} else {
			return 1;// 0��0�η�
		}
		while (n != 0) {
			if ((n & 1) == 1)
				res *= curr;
			curr *= curr;// ����
			n >>= 1;// ����һλ
		}
		return exponent >= 0 ? res : (1 / res);
	}

	public static void main(String[] args) {
		System.out.println(new Power().power_2(2, -3));
	}
}
