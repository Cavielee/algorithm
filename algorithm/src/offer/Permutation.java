package offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 27������һ���ַ���,���ֵ����ӡ�����ַ������ַ����������п��ܡ�
 * @author Cavielee
 *
 */
public class Permutation {

	public ArrayList<String> permutation(String str) {
		ArrayList<String> res = new ArrayList<>();
		// �ж��Ƿ����ַ�
		if (str != null && str.length() > 0) {
			// ����PermutationHelper�������ַ������򣬰ѿ��������в��뵽res��
			PermutationHelper(str.toCharArray(), 0, res);
			// ��res���Ͻ�������
			Collections.sort(res);
		}
		return res;
	}

	/**
	 * cs ��ʾ�ַ�����
	 * i��ʾ��ǰ���򵽵ڼ����ַ�
	 * @param cs
	 * @param i
	 * @param list
	 */
	public void PermutationHelper(char[] cs, int i, ArrayList<String> list) {
		// ��iΪ���һ���ַ��±�ʱ���޷��γɷ�֧�������ս����
		if (i == cs.length - 1) {
			// valΪ��֧������ַ��������ж�list���Ƿ��и��ַ�����û����Ѹ��ַ�������
			String val = String.valueOf(cs);
			if (!list.contains(val))
				list.add(val);
		} else {
			// ͨ����i��j�±���ַ��������γ�һ���µķ�֧�ݹ���ȥ
			for (int j = i; j < cs.length; j++) {
				swap(cs, i, j);
				PermutationHelper(cs, i + 1, list);
				// �ݹ鷵�ر�ʾ�÷�֧�Ѿ�����ͷ�����°�i��j���ַ�������������һ���ֲ������һ��·��
				swap(cs, i, j);
			}
		}
	}

	public void swap(char[] cs, int i, int j) {
		char temp = cs[i];
		cs[i] = cs[j];
		cs[j] = temp;
	}

	public static void main(String[] args) {
		new Permutation().permutation("ABC");
	}

}
