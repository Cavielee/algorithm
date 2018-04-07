package onlineTest;

import java.util.Scanner;

/**
 * 阿里等额本息，求每个月还款金额
 * @author Cavielee
 *
 */
public class Ali {

	/**
	 * 请完成下面这个函数，实现题目要求的功能 当然，你也可以不按照这个模板来作答，完全按照自己的想法来
	 * 
	 * 算法：
	 * [贷款金额*月利率*（1+月利率）^还款月数] / [（(1+月利率)^还款月数）-1]
	 *
	 * @param a
	 * 贷款金额
	 * @param i
	 * 年利率
	 * @param n
	 * 贷款期限
	 * @return 月还款额，保留2位小数，向上舍入
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

		// 请出入贷款金额(正整数):;
		int _a;
		_a = Integer.parseInt(in.nextLine().trim());

		// 请输入年利率(如:4.35)%:;
		double _i;
		_i = Double.parseDouble(in.nextLine().trim());

		// 请输入贷款期限多少年:;
		int _n;
		_n = Integer.parseInt(in.nextLine().trim());

		res = calculate(_a, _i, _n);
		System.out.println(res);
	}
}
