package algorithm;

/**
 * �鲢����
 * @author Cavielee
 *
 */
public class MergeSort {

	private static int[] aux;

	/**
	 * ȱ�㣺С����ĵݹ���������Ƶ���������������Сʱ�л�������������������ܡ�
	 * @param a
	 * @param lo
	 * @param mid
	 * @param hi
	 */
	private static void merge(int[] a, int lo, int mid, int hi) {
		// iָ���һ�Σ�jָ��ڶ���
		int i = lo, j = mid + 1;

		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k]; // �����ݸ��Ƶ���������
		}

		// �߽緶ΧΪlo~hi�����ѭ��hi-lo+1�Σ��������ε�Ԫ�غϲ����µ�
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++]; // ��i����midʱ���������һ���Ѿ��ź���ʣ��ĵڶ��ζ��ȵ�ǰ�źõ�Ԫ�ش����ֱ�Ӹ���
			else if (j > hi)
				a[k] = aux[i++]; // ��j���ڱ߽磨hi��ʱ��������ڶ����Ѿ��ź���ʣ��ĵ�һ�ζ��ȵ�ǰ�źõ�Ԫ�ش����ֱ�Ӹ���
			else if (aux[i] < a[j])
				a[k] = aux[i++]; // �Ƚ�����һ������֤�ȶ��ԡ��Ӹ��������һ�κ͵�ǰ����ڶ���Ԫ�رȽϣ���С��Ԫ�ذ��±�һ�θ��ǵ�ԭ������
			else
				a[k] = aux[j++];
		}
	}

	public static void sort(int[] a) {
		aux = new int[a.length];
		sort(a, 0, a.length - 1);
	}

	/**
	 * ��һ����ηֳ����Σ�һֱ�ݹ�ֱ���εĳ���Ϊ1ʱ
	 * ����߶ηֳ�����1�Ķ�Ȼ��ϲ����ٰ�ʣ����ұ߶�ͬ���Ĳ���������Ҷγ��Ȳ�Ϊ1�����Ҷ�Ҳ���зָ�ϲ����ϲ����Ϊ��һ�ε��ҶΣ�����Ȼ��ϲ�����Ϊ�ݹ����Ժϲ����Ϊ��һ�ε���Σ������������ظ�����
	 * @param a
	 * @param lo
	 * @param hi
	 */
	private static void sort(int[] a, int lo, int hi) {
		// �ж϶εĳ����Ƿ�Ϊ1��Ϊ1�����и�
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid);
		sort(a, mid + 1, hi);
		merge(a, lo, mid, hi);
	}
}
