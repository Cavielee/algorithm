package offer;

/**
 * 32.������1���ֵĴ���
 * 
 * @author Cavielee
 *
 */
public class NumberOf1Between1AndN_Solution {

	// �ⷨһ��O��n*logn����
	public int numberOf1Between1AndN_Solution(int n) {
		int num = 0;
		// �ж�n�Ƿ���ڵ���1
		if (n < 1) {
			return num;
		}
		// �ۼ���n
		for (int i = 1; i <= n; i++) {
			// �ж�ÿһ������ÿһλ�Ƿ�Ϊ1
			for (int j = i; j > 0; j /= 10) {
				if (j % 10 == 1) {
					num++;
				}
			}
		}
		return num;
	}

	// �ⷨ����O��logn����
	public int numberOf1Between1AndN_Solution_2(int n) {
		int num = 0;
		// �ж�n�Ƿ���ڵ���1
		if (n < 1) {
			return 0;
		}
		/*
		 * ��i��ʾ��ǰλ�� 
		 * �����ַ�Ϊ���֣���λn/i�͵�λn%i��Ȼ��������������1
		 * �ٵ�ǰλ���ִ���1�����λ��n/10*i+1������1
		 * �ڵ�ǰλ���ֵ���1�����λ��n/10*i������1����λ��n%i+1������1
		 * �۵�ǰλ���ֵ���0�����λ��n/10*i������1
		 */
		for (int i = 1; i <= n; i *= 10) {
			int high = n / i;
			int low = n % i;
			int currentDigit = high % 10;
			if (currentDigit == 0) {
				num += high / 10 * i;
			}
			else if (currentDigit == 1) {
				num += high / 10 * i + low + 1;
			}
			else {
				num += (high / 10 + 1) * i;
			}
		}
		return num;
	}

	public static void main(String[] args) {
		int num = new NumberOf1Between1AndN_Solution().numberOf1Between1AndN_Solution_2(10);
		System.out.println(num);
	}

}
