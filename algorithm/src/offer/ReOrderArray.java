package offer;

/**
 * 13.����һ���������飬ʵ��һ�����������������������ֵ�˳��
 * ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ��λ������ĺ�벿�֣�
 * ����֤������������ż����ż��֮������λ�ò��䡣
 * @author Cavielee
 *
 */
public class ReOrderArray {

	/**
	 * ˼·��������ð������
	 * iָ��Ϊ���λ�ķ�Χ����������
	 * ��һ��ѭ��������iָ�룬��0�±꿪ʼ
	 * �ڶ���ѭ������jָ�룬��β�±꿪ʼ��ͨ���ж�[i,j]��ΧԪ�����ڵ����������ǰż�����򽻻�
	 * ͨ���ڶ���ѭ��ʹ������������֮�䣬ż����ż��֮�䱣�����˳�򣬲���ÿһ�ֶ�����һ��������λ
	 * @param arr
	 * @return
	 */
	public int[] reOrderArray(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = array.length - 1; j>i; j--) {
				if (array[j] % 2 == 1 && array[j - 1]%2 == 0) {//ǰż���潻��
					int temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				}
			}
		}
		return array;
	}

	public static void main(String[] args) {

		int[] arr = new int[] { 0, 1, 2, 3 };
		System.out.println(new ReOrderArray().reOrderArray(arr));
	}

}
