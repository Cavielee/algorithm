package bilibiliQuestion;

import java.util.ArrayList;

/**
 * ��Ŀ����1-n��Ѱ���������� 
 * ˼·�� 
 * �� ��С��������2��Ȼ����������һ��������֪��Ѱ�ҵ����Ѿ�����n���򷵻ص�ǰ��������
 * �� ���˵�һ����������һ�������� 
 * �� �ж�һ�����Ƿ�Ϊ������ֻ�������֮ǰ����������ȡģ��������Ϊ0��Ϊ������
 * 
 * @author Cavielee
 *
 */
public class FindPrimeNumber {
	public int findPrimeNumber(int n) {
		// ��¼�������
		int result = 2;
		// ��ǰ�жϵ���
		int currentNum = 3;
		// �ж�n�Ƿ�Ϸ�
		if (n < 2) {
			return 0;
		} else if (n == 2) {
			return result;
		} else {
			// ������
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(2);
			while (currentNum <= n) {
				// �������
				boolean flag = true;
				for (int temp : list) {
					// ����ܱ�������������
					if (currentNum % temp == 0) {
						flag = false;
						break;
					}
				}
				if (flag) {
					// ��ӽ�������
					list.add(currentNum);
					result = currentNum;
				}
				currentNum += 2;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(new FindPrimeNumber().findPrimeNumber(-1));
	}
}
