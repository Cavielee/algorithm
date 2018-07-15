package offer;

/**
 * 7.���n��쳲��������� 
 * 쳲���������1,1,2,3,5,8...����n��Ϊ��n-1+n-2�� 
 * ˼·�� 
 * ��n=0ʱ��Ĭ��Ϊ0
 * ��n=1,n=2ʱ����Ϊ������ǰ��������Ĭ��Ϊ1
 * �۵�n>=3ʱ����ͨ����¼first(n-2��)second(n-1��)third(n��)
 * ���ص�n�third��
 * @author Cavielee
 *
 */
public class Fibonacci {

	/**
	 * ʱ�临�Ӷ�O(n)
	 * �Ӻ���ǰ��
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
	 * ʱ�临�Ӷ�O(n^2)
	 * �������£��ݹ��㷨
	 * ȱ�㣬���ڴ������£�nԽ���ظ��������Խ�ࡣ
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
