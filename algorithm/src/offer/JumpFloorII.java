package offer;

/**
 * 9.��̬��¥�ݣ����ܣ�ÿ�ο���ѡ����n��̨��
 * ˼·��ÿһ�ε�ѡ����n��
 * ��f(n) = f(n-1) + f(n-2) +...+ f(n-n)
 * ��f(n-1) = f(n-2) +...+ f(n-n)
 * ���f(n) = 2*f(n-1)
 * ��f(1) = 1��f(2) = 2
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
