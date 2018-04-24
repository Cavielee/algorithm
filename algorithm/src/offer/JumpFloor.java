package offer;

/**
 * 8.��¥��
 * a.�������������1�׻���2�ף���ô�ٶ���һ��������һ�ף���ôʣ�µ���n-1��̨�ף�������f(n-1);
 * b.�ٶ���һ��������2�ף���ôʣ�µ���n-2��̨�ף�������f(n-2)
 * c.��a\b������Եó�������Ϊ: f(n) = f(n-1) + f(n-2) 
 * d.Ȼ��ͨ��ʵ�ʵ�������Եó���ֻ��һ�׵�ʱ�� f(1) = 1 ,ֻ�����׵�ʱ������� f(2) = 2
 * e.���Է������յó�����һ��쳲��������У�
 * 
 * @author Cavielee
 *
 */
public class JumpFloor {

	public int jumpFloor(int target) {
		if (target <= 0)
			return 0;
		if (target == 1)
			return 1;
		if (target == 2)
			return 2;
		int one = 1;
		int two = 2;
		int result = 0;
		for (int i = 2; i < target; i++) {
			result = one + two;
			one = two;
			two = result;
		}
		return result;
	}
}
