package offer;

/**
 * 8.跳楼梯
 * a.如果两种跳法，1阶或者2阶，那么假定第一次跳的是一阶，那么剩下的是n-1个台阶，跳法是f(n-1);
 * b.假定第一次跳的是2阶，那么剩下的是n-2个台阶，跳法是f(n-2)
 * c.由a\b假设可以得出总跳法为: f(n) = f(n-1) + f(n-2) 
 * d.然后通过实际的情况可以得出：只有一阶的时候 f(1) = 1 ,只有两阶的时候可以有 f(2) = 2
 * e.可以发现最终得出的是一个斐波那契数列：
 * 
 * @author Cavielee
 *
 */
public class JumpFloor {

	/**
	 * 时间复杂度O(n)
	 * 从后往前算
	 */
	public int jumpFloor(int target) {
		if (target <= 0)
			return 0;
		if (target == 1)
			return 1;
		if (target == 2)
			return 2;
		
		int first = 1;
		int second = 2;
		int result = 0;
		for (int i = 2; i < target; i++) {
			result = first + second;
			first = second;
			second = result;
		}
		return result;
	}
	/**
	 * 时间复杂度O(n^2)
	 * 从上往下，递归算法
	 * 缺点，由于从上往下，n越大，重复计算的项越多。
	 */
	public int jumpFloor_1(int target) {
		if (target <= 0)
			return 0;
		if (target == 1)
			return 1;
		if (target == 2)
			return 2;
		
		return jumpFloor_1(target - 1) + jumpFloor_1(target - 2);
	}
}
