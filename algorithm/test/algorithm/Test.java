package algorithm;

public class Test {
	// private static int[] aux;
	//
	// public static void sort(int[] array, int start, int end) {
	// if (start < end) {
	// int mid = (start + end) / 2;
	// sort(array, start, mid);
	// sort(array, mid + 1, end);
	// merge(array, start, mid, end);
	// }
	// }
	//
	// private static void merge(int[] a, int lo, int mid, int hi) {
	// // iָ���һ�Σ�jָ��ڶ���
	// int i = lo, j = mid + 1;
	//
	// for (int k = lo; k <= hi; k++) {
	// aux[k] = a[k]; // �����ݸ��Ƶ���������
	// }
	//
	// // �߽緶ΧΪlo~hi�����ѭ��hi-lo+1�Σ��������ε�Ԫ�غϲ����µ�
	// for (int k = lo; k <= hi; k++) {
	// if (i > mid)
	// a[k] = aux[j++]; // ��i����midʱ���������һ���Ѿ��ź���ʣ��ĵڶ��ζ��ȵ�ǰ�źõ�Ԫ�ش����ֱ�Ӹ���
	// else if (j > hi)
	// a[k] = aux[i++]; // ��j���ڱ߽磨hi��ʱ��������ڶ����Ѿ��ź���ʣ��ĵ�һ�ζ��ȵ�ǰ�źõ�Ԫ�ش����ֱ�Ӹ���
	// else if (aux[i] < a[j])
	// a[k] = aux[i++]; // �Ƚ�����һ������֤�ȶ��ԡ��Ӹ��������һ�κ͵�ǰ����ڶ���Ԫ�رȽϣ���С��Ԫ�ذ��±�һ�θ��ǵ�ԭ������
	// else
	// a[k] = aux[j++];
	// }
	// }

	public static void main(String[] args) {
		int[] array = new int[] { 3, 5, 2, 4, 1, 8, 6, 7 };

		/**
		 * �鲢����
		 */
		// aux = new int[array.length];
		// Test.sort(array, 0, array.length - 1);

		/**
		 * ����
		 */

		Quick3Way.sort(array);
		for (int i : array) {
			System.out.println(i);
		}
	}

	public static void sort(int[] array, int start, int end) {
		if (start >= end)
			return;
		int j = partition(array, start, end);
		sort(array, start, j - 1);
		sort(array, j + 1, end);
	}

	// �з�
	public static int partition(int[] array, int start, int end) {
		int i = start;
		int j = end + 1;
		// ȡ��һ����Ϊ�зֵ�Ԫ��
		int key = array[start];
		while (true) {
			// ���������ҵ����з�Ԫ�ش��
			while (array[++i] < key && i != end)
				;
			// ���������ҵ����з�Ԫ��С��
			while (array[--j] > key && j != start)
				;
			// �ж��Ƿ������
			if (i >= j)
				break;
			// ����Ԫ��
			int temp = array[j];
			array[j] = array[i];
			array[i] = temp;
		}
		// �ָ����ؼ��ֽ���
		int temp = array[j];
		array[j] = array[start];
		array[start] = temp;
		return j;
	}
}
