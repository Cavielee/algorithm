package offer;

/**
 * 2 ��1+2+3+...+n
 * Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C��
 * ˼·������ʹ�ù��߷�������Ϊ�ڲ�ʵ�־���ʹ����ѭ��֮�ࣩ
 * �ݹ�˼�루ͨ���ݹ��ۼӣ���Ҫ���ʲôʱ�������ݹ飩
 * ͨ����·����ʵ���ж�ʲôʱ�������ݹ�
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
