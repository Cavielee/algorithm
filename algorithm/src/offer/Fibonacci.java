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

	public int fibonacci(int n) {
		int first = 0;
		int second = 1;
		int third = 0;

		if (n == 0) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		while (n-- > 1) {
			third = first + second;
			first = second;
			second = third;
		}
		return third;
	}

	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		System.out.println(f.fibonacci(3));
	}

}
