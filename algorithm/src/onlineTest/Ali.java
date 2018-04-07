package onlineTest;

import java.util.Scanner;

/**
 * ����ȶϢ����ÿ���»�����
 * @author Cavielee
 *
 */
public class Ali {

	/**
	 * ������������������ʵ����ĿҪ��Ĺ��� ��Ȼ����Ҳ���Բ��������ģ����������ȫ�����Լ����뷨��
	 * 
	 * �㷨��
	 * [������*������*��1+�����ʣ�^��������] / [��(1+������)^����������-1]
	 *
	 * @param a
	 * ������
	 * @param i
	 * ������
	 * @param n
	 * ��������
	 * @return �»�������2λС������������
	 */
	static String calculate(int a, double i, int n) {
		double month_i = i / 12 / 100;
		int month = n * 12;
		return String.format("%.2f",
				Math.ceil(((a * month_i * Math.pow(1 + month_i, month)) / (Math.pow(1 + month_i, month) - 1))*100)/100);

	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String res;

		// ����������(������):;
		int _a;
		_a = Integer.parseInt(in.nextLine().trim());

		// ������������(��:4.35)%:;
		double _i;
		_i = Double.parseDouble(in.nextLine().trim());

		// ������������޶�����:;
		int _n;
		_n = Integer.parseInt(in.nextLine().trim());

		res = calculate(_a, _i, _n);
		System.out.println(res);
	}
}
