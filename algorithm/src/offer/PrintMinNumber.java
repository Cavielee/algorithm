package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * 33.�������ų���С����
 * 
 * @author Cavielee
 *
 */
public class PrintMinNumber {

	/*
	 * �ⷨһ�� ���õݹ����ÿһ��������ɵ����У�������TreeSet���ҵ���С��ֵ
	 */
	public String printMinNumber(int[] numbers) {
		// �ж������Ƿ�Ϊ�ջ򳤶�Ϊ0
		if (numbers == null || numbers.length == 0) {
			return "";
		}
		TreeSet<String> ts = new TreeSet<String>();
		permutationHelper(0, numbers, ts);
		String min = ts.first();
		return min;
	}

	public static void permutationHelper(int index, int[] numbers, TreeSet<String> ts) {
		// ��Ϊ���һ��Ԫ��ʱ
		if (index == numbers.length - 1) {
			String val = "";
			for (int n : numbers) {
				val += n;
			}
			// �жϸ������Ƿ���������У������������
			if (!ts.contains(val)) {
				ts.add(val);
			}
		}
		// ��Ϊ���һ��Ԫ��
		else {
			for (int i = index; i < numbers.length; i++) {
				// �������ڵ�Ԫ��
				int temp = numbers[index];
				numbers[index] = numbers[i];
				numbers[i] = temp;

				// �ݹ���ȥ��������Ԫ��
				permutationHelper(index + 1, numbers, ts);

				// ��������
				temp = numbers[index];
				numbers[index] = numbers[i];
				numbers[i] = temp;
			}
		}
	}

	/*
	 * �ⷨ���� ���õݹ����ÿһ��������ɵ����У�������TreeSet���ҵ���С��ֵ
	 */
	public String printMinNumber_2(int[] numbers) {
		// �ж������Ƿ�Ϊ�ջ򳤶�Ϊ0
		if (numbers == null || numbers.length == 0) {
			return "";
		}
		// ����ArrayList�����涨����ıȽ���
		ArrayList<String> list = new ArrayList<String>();
		// ��numbers����תΪString���Է�ֹ���������String��ӵ�ArrayList��
		for (int n : numbers) {
			list.add(n + "");
		}
		// ��ArrayList��������
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// ���o1o2>o2o1����o2<o1ͬ���е��ں�С�����
				return (o1 + o2).compareTo(o2 + o1);
			}
		});
		String min = "";
		for (String s : list) {
			min += s;
		}
		return min;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 1, 11, 111 };
		System.out.println(new PrintMinNumber().printMinNumber_2(array));
	}

}
