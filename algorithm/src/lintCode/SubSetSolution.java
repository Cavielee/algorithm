package lintCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����һ������ͬ�����ļ��ϣ����������е��Ӽ���
 * ע�����ص��Ӽ�Ҫ���ֵ�����
 * @author CavieLee
 *
 */
public class SubSetSolution {
	public List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> results = new ArrayList<>();

		// У��
		if (nums == null) {
			return results;
		}

		// ����
		Arrays.sort(nums);

		// �ݹ�
		ArrayList<Integer> subSet = new ArrayList<>();
		subSetsHelper(nums, 0, subSet, results);

		return results;
	}

	// �ݹ�
	public void subSetsHelper(int[] nums, int start, List<Integer> subSet, List<List<Integer>> results) {
		// ��¡���
		results.add(new ArrayList<Integer>(subSet));
		// �ݹ�
		for (int i = start; i < nums.length; i++) {
			subSet.add(nums[i]);
			// �ݹ�
			subSetsHelper(nums, i + 1, subSet, results);
			// ����
			subSet.remove(subSet.size() - 1);
		}
	}
}
