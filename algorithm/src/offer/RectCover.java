package offer;

/**
 * 10.用2*1的小矩形横着或者竖着去覆盖更大的矩形。用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形
 * 思路：
 * 当n=1时，只有1种摆放方法
 * 当n=2时，只有两种方法（横着放和竖着放）
 * 当n>2时，可以看成每一次选择可以选择
 * ①竖着放（剩余的方案则为f(n-1)）
 * ②横着放（需要使用两块合成一个整块，剩余的方案则为f(n-2)）
 * 因此f(n) = f(n-1) + f(n-2)
 * 总结：可以看出是一个答案为斐波那契数列
 * @author Cavielee
 *
 */
public class RectCover {
	public int rectCover(int target) {
		if (target == 0)
			return 0;
		if (target == 1)
			return 1;
		if (target == 2)
			return 2;
		return rectCover(target - 1) + rectCover(target - 2); 
	}
}
