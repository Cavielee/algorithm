package offer;

/**
 * 2 求1+2+3+...+n
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * 思路：不能使用工具方法（因为内部实现就是使用了循环之类）
 * 递归思想（通过递归累加，但要解决什么时候跳出递归）
 * 通过短路与来实现判断什么时候跳出递归
 * 
 * @author Cavielee
 *
 */
public class Sum_Solution {

	public int sum_Solution(int n) {
		int result = n;
		boolean t = (n > 0) && ((result += sum_Solution(n-1)) > 0);
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(new Sum_Solution().sum_Solution(5));
	}
}
