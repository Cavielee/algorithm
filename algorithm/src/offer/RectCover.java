package offer;

/**
 * 10.��2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ���n��2*1��С�������ص��ظ���һ��2*n�Ĵ����
 * ˼·��
 * ��n=1ʱ��ֻ��1�ְڷŷ���
 * ��n=2ʱ��ֻ�����ַ��������ŷź����ŷţ�
 * ��n>2ʱ�����Կ���ÿһ��ѡ�����ѡ��
 * �����ŷţ�ʣ��ķ�����Ϊf(n-1)��
 * �ں��ŷţ���Ҫʹ������ϳ�һ�����飬ʣ��ķ�����Ϊf(n-2)��
 * ���f(n) = f(n-1) + f(n-2)
 * �ܽ᣺���Կ�����һ����Ϊ쳲���������
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
