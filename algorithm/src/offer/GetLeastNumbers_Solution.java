package offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class GetLeastNumbers_Solution {

	// ���ڿ���ʵ��
	public ArrayList<Integer> getLeastNumber_Solution(int[] array, int k) {
		final ArrayList<Integer> list = new ArrayList<Integer>();
		// �ж������Ƿ�Ϊ�ջ򳤶�Ϊ0��k�Ƿ�С�ڵ���0
		if (array == null || array.length == 0 || k <= 0 || k > array.length)
			return list;

		// ͨ�������ҵ���k����
		int start = 0;
		int end = array.length - 1;
		int index = partition(array, start, end);
		while (index != (k - 1)) {
			// ���index��������һ�룬����С�Ĳ��ּ�����
			if (index > (k - 1)) {
				end = index - 1;
			}
			// ����������Ĳ�����
			else {
				start = index + 1;
			}
			index = partition(array, start, end);
		}

		// �����С��k����
		for (int i = 0; i <= index; i++) {
			list.add(array[i]);
		}

		return list;
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
			// ���������ҳ���һ����
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

	// ��������ʵ��
	public ArrayList<Integer> getLeastNumber_Solution_2(int[] array, int k) {
		final ArrayList<Integer> list = new ArrayList<Integer>();
		// �ж������Ƿ�Ϊ�ջ򳤶�Ϊ0��k�Ƿ�С�ڵ���0
		if (array == null || array.length == 0 || k <= 0 || k > array.length)
			return list;
		// ����PriorityQueue�������ѣ�
		PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});

		// ����ÿһ��Ԫ��
		for (int i = 0; i < array.length; i++) {
			// ����û��k��Ԫ��ʱ��ֱ�����
			if (maxheap.size() != k)
				maxheap.offer(array[i]);
			// ����k��Ԫ��ʱ��������Ԫ�أ����ж��������,�����Ԫ��С��ɾ�������
			else {
				if (maxheap.peek() > array[i]) {
					maxheap.poll();
					maxheap.offer(array[i]);
				}
			}
		}
		list.addAll(maxheap);
		return list;
	}

	// ���ں����ʵ��
	public ArrayList<Integer> getLeastNumber_Solution_3(int[] array, int k) {
		final ArrayList<Integer> list = new ArrayList<Integer>();
		// �ж������Ƿ�Ϊ�ջ򳤶�Ϊ0��k�Ƿ�С�ڵ���0
		if (array == null || array.length == 0 || k <= 0 || k > array.length)
			return list;
		// ����TreeSet���������
		new TreeSet<Integer>();
		// ����PriorityQueue�������ѣ�
		PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});

		// ����ÿһ��Ԫ��
		for (int i = 0; i < array.length; i++) {
			// ����û��k��Ԫ��ʱ��ֱ�����
			if (maxheap.size() != k)
				maxheap.offer(array[i]);
			// ����k��Ԫ��ʱ��������Ԫ�أ����ж��������,�����Ԫ��С��ɾ�������
			else {
				if (maxheap.peek() > array[i]) {
					maxheap.poll();
					maxheap.offer(array[i]);
				}
			}
		}
		list.addAll(maxheap);
		return list;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 4, 6, 8, 9, 10 };
		new GetLeastNumbers_Solution().getLeastNumber_Solution_2(array, 5);

	}

}
