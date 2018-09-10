package lintCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����һ�����ܾ����ظ����ֵ��б����������п��ܵ��Ӽ�
 * ע�����ص��Ӽ�Ҫ���ֵ�����
 * @author CavieLee
 *
 */
public class SubSetIISolution {

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
			// �ж��Ƿ��ظ�
			if (i != 0 && nums[i - 1] == nums[i] && i > start) {
				continue;
			}
			subSet.add(nums[i]);
			// �ݹ�
			subSetsHelper(nums, i + 1, subSet, results);
			// ����
			subSet.remove(subSet.size() - 1);
		}
	}
}
