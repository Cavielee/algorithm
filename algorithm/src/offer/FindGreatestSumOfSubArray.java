package offer;

/**
 * 31.���������е���������������
 * 
 * @author Cavielee
 *
 */
public class FindGreatestSumOfSubArray {
	// �ⷨһ
	public int findGreatestSumOfSubArray(int[] array) {
		// �ж������Ƿ�Ϊ�ջ򳤶�Ϊ0
		if (array == null || array.length == 0) {
			return 0;
		}

		int max = array[0];
		int temp = array[0];

		for (int i = 1; i < array.length; i++) {
			// �ۼӵ�temp��
			temp += array[i];
			// ���temp�ȵ�ǰԪ��С�����ʾ֮ǰ������������Ǹ����ӣ���temp��ʼΪ��ǰԪ��
			if (temp < array[i]) {
				temp = array[i];
			}
			// ���temp�ر�max�������max
			if (temp > max) {
				max = temp;
			}
		}
		return max;
	}

	// �ⷨ������̬�滮���ݹ飩
	public int findGreatestSumOfSubArray_2(int[] array) {
		// �ж������Ƿ�Ϊ�ջ򳤶�Ϊ0
		if (array == null || array.length == 0) {
			return 0;
		}

		int max = array[0];
		int temp = array[0];

		for (int i = 1; i < array.length; i++) {
			// �жϵ�ǰ��������Ƿ�ȵ�ǰԪ��С�����С��ѵ�ǰԪ���滻��max
			temp = Math.max(array[i] + max, array[i]);
			// �жϵ�ǰ��������Ƿ�����������ʹ������������������
			max = Math.max(max, temp);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] array = new int[] { -2, -8, -1, -5, -9 };
		int max = new FindGreatestSumOfSubArray().findGreatestSumOfSubArray_2(array);
		System.out.println(max);
	}
}
