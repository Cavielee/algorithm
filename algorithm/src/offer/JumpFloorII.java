package offer;

/**
 * 9.变态跳楼梯，青蛙，每次可以选择条n阶台阶
 * 思路：每一次的选择都有n种
 * 即f(n) = f(n-1) + f(n-2) +...+ f(n-n)
 * 而f(n-1) = f(n-2) +...+ f(n-n)
 * 因此f(n) = 2*f(n-1)
 * 而f(1) = 1，f(2) = 2
 * 
 * @author Cavielee
 *
 */
public class JumpFloorII {

	public int jumpFloorII(int target){
		if (target < 0)
			return 0;
		if (target == 1)
			return 1;

		return 2 * jumpFloorII(target - 1);
	}
}
