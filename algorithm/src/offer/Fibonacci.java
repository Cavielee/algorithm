package offer;

/**
 * 7.求第n项斐波那契数列 
 * 斐波那契数列1,1,2,3,5,8...即第n项为第n-1+n-2项 
 * 思路： 
 * ①n=0时，默认为0
 * ②n=1,n=2时，以为不存在前两项所以默认为1
 * ③当n>=3时，则通过记录first(n-2项)second(n-1项)third(n项)
 * 返回第n项（third）
 * @author Cavielee
 *
 */
public class Fibonacci {

	/**
	 * 时间复杂度O(n)
	 * 从后往前算
	 */
	public int fibonacci(int n) {
		if (n <= 0) 
			return 0;
		if (n == 1 || n == 2)
			return 1;
		
		int first = 1;
		int second = 1;
		int result = 0;
		
		for (int i = 2; i < n; i++) {
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
	public int fibonacci_1(int n) {
		if (n <= 0) 
			return 0;
		if (n == 1 || n == 2)
			return 1;
		
		return fibonacci_1(n - 1) + fibonacci_1(n - 2);
	}

	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		System.out.println(f.fibonacci(3));
	}

}
