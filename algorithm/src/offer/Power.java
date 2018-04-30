package offer;

/**
 * 12.求浮点数base的exponent（整数型）次幂的值
 * 
 * @author Cavielee
 *
 */
public class Power {

	/**
	 * 思路：直接使用Math.pow()函数
	 * 
	 * @param base
	 * @param exponent
	 * @return
	 */
	public double power(double base, int exponent) {
		return Math.pow(base, exponent);
	}

	/**
	 * 最优解
	 * 思路：
	 * 1.全面考察指数的正负、底数是否为零等情况。
	 * 2.写出指数的二进制表达，例如13表达为二进制1101。
	 * 3.举例:10^1101 = 10^0001*10^0100*10^1000。
	 * 4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
	 * 通过n来做移位运算，如果指数为负数，最终答案则为res的倒数
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
				throw new RuntimeException("分母不能为0");
			n = -exponent;
		} else {
			return 1;// 0的0次方
		}
		while (n != 0) {
			if ((n & 1) == 1)
				res *= curr;
			curr *= curr;// 翻倍
			n >>= 1;// 右移一位
		}
		return exponent >= 0 ? res : (1 / res);
	}

	public static void main(String[] args) {
		System.out.println(new Power().power_2(2, -3));
	}
}
