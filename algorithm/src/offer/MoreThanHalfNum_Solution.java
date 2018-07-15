package offer;

public class MoreThanHalfNum_Solution {

	public int moreThanHalfNum_Solution(int[] array) {
		// �ж�array�Ƿ�Ϊnull�򳤶�Ϊ0
		if (array == null || array.length == 0)
			return 0;
		int start = 0;
		int end = array.length - 1;
		int index = partition(array, start, end);
		while (index != (array.length >> 1)) {
			// ���index��������һ�룬����С�Ĳ��ּ�����
			if (index > (array.length >> 1)) {
				end = index - 1;
			}
			// ����������Ĳ�����
			else {
				start = index + 1;
			}
			index = partition(array, start, end);
		}

		int result = array[index];

		// �ж�index���������ֳ�������һ�����
		int time = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == result) {
				time++;
			}
		}
		if ((time << 1) <= array.length)
			return 0;

		return result;
	}

	// ����
	public int partition(int[] array, int start, int end) {
		// һ��Ԫ�ػ���Ԫ��ʱ�˳���
		if (start >= end)
			return start;
		int i = start;
		int j = end + 1;
		// ��һ��Ԫ����Ϊ�ؼ���
		int key = array[start];
		while (true) {
			// ���������ҳ��ȵ�һ���ָ���С��
			while (array[++i] <= key)
				if (i == end)
					break;
			// ���������ҳ���һ���ȷָ������
			while (array[--j] >= key)
				if (j == start)
					break;
			if (i >= j)
				break;
			// �����±�i��j����Ԫ��
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
		array[start] = array[j];
		array[j] = key;
		return j;
	}

	public int moreThanHalfNum_Solution_2(int[] array) {
		// �ж�array�Ƿ�Ϊnull�򳤶�Ϊ0
		if (array == null || array.length == 0)
			return 0;

		int result = array[0];
		int time = 1;
		for (int i = 0; i < array.length; i++) {
			// ������Ϊ0ʱ������ж���һ����
			if (time == 0) {
				result = array[i];
				time = 1;
			} else if (array[i] == result)
				time++;
			else
				time--;
		}

		// �ж�index���������ֳ�������һ�����
		time = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == result) {
				time++;
			}
		}
		if ((time << 1) <= array.length)
			return 0;

		return result;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 4, 2, 1, 4, 2, 4 };
		System.out.println(new MoreThanHalfNum_Solution().moreThanHalfNum_Solution(array));
	}

}
