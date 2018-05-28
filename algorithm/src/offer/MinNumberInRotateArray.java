package offer;

/**
 * 6.����ת�������С���� ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
 * NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 * ˼·�� ͨ�����ַ��ҵ��м�Ԫ�� 
 * ��ת��������Ҳ��֣���СԪ��һ�����Ҳ��� 
 * ����м�ȵ�һ��Ԫ�ش���֤����СԪ������߲��֣�
 * ����м�����һ��Ԫ��С����֤����СԪ�����ұ߲���
 * 
 * �����������������1��0��1��1��1���м䡢��һ�������һ��������ȣ� ��ʱ��Ҫ���ⲿ�ֽ���˳�����
 * 
 * @author Cavielee
 *
 */
public class MinNumberInRotateArray {

	public int minNumberInRotateArray(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		if (array.length == 1) {
			return array[0];
		}
		int min = 0;
		int max = array.length - 1;
		int mid;
		// ��ת��������Ҳ��֣���СԪ��һ�����Ҳ���
		while (true) {
			mid = (min + max) / 2;
			if (array[mid] < array[mid - 1])
				return array[mid];
			// �������ӣ�����м䣬��һ�������һ�������,ֻ��˳�����
			if (array[mid] == array[min] && array[mid] == array[max])
				return MinInOrder(array, min, max);
			// ����м�ȵ�һ��Ԫ�ش���֤����СԪ������߲���
			if (array[mid] >= array[min]) {
				min = mid;
			}
			// ����м�����һ��Ԫ��С����֤����СԪ�����ұ߲���
			else if (array[mid] <= array[max]) {
				max = mid;
			}
		}
	}

	public static int MinInOrder(int[] array, int min, int max) {
		int result = array[min];
		for (int i = min; i < max; i++) {
			if (array[i] < result) {
				result = array[i];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		MinNumberInRotateArray minNumberInRotateArray = new MinNumberInRotateArray();
		int[] arr = new int[] { 1, 1, 1, 0, 1 };
		System.out.println(minNumberInRotateArray.minNumberInRotateArray(arr));
	}

}
