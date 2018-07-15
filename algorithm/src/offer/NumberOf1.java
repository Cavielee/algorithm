package offer;

/**
 * 11.求一个整数二进制中有多少个1
 * 
 * @author Cavielee
 *
 */
public class NumberOf1 {

	/**
	 * 最优解
	 * 把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.
	 * 那么一个整数的二进制有多少个1，就可以进行多少次这样的操作
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
	 * 正解
	 * 通过用n&1判断最后一位是否为1
	 * 然后把n右移一位（重复32次，因为int为32个位）
	 * 注意需要使用无符号右移，因为当n为负数时，普通右移会自动在前面补1，因此会无限循环
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
	/**
	 * 正解
	 * 通过用一个flag（初始为1）与n做与运算
	 * 如果为1则表明该位为1
	 * 把flag往左移一位，继续上述操作（循环32次）
	 */
	public int numberOf1_3 (int n) {
		int num = 0;
		int flag = 1;
		if (n == 0)
			return 0;
		while (flag != 0) {
			if ((n & flag) != 0) {
				num++;
			}
			flag = flag << 1;
		}
		return num;
	}

	public static void main(String[] args) {
		NumberOf1 no1 = new NumberOf1();
		System.out.println(no1.numberOf1_3(11));
	}

}
