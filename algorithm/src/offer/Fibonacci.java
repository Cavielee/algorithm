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
