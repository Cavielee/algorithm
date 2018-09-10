package lintCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可能具有重复数字的列表，返回其所有可能的子集
 * 注：返回的子集要按字典排序
 * @author CavieLee
 *
 */
public class SubSetIISolution {

	public List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> results = new ArrayList<>();

		// 校验
		if (nums == null) {
			return results;
		}

		// 排序
		Arrays.sort(nums);

		// 递归
		ArrayList<Integer> subSet = new ArrayList<>();
		subSetsHelper(nums, 0, subSet, results);

		return results;
	}

	// 递归
	public void subSetsHelper(int[] nums, int start, List<Integer> subSet, List<List<Integer>> results) {
		// 克隆添加
		results.add(new ArrayList<Integer>(subSet));
		// 递归
		for (int i = start; i < nums.length; i++) {
			// 判断是否重复
			if (i != 0 && nums[i - 1] == nums[i] && i > start) {
				continue;
			}
			subSet.add(nums[i]);
			// 递归
			subSetsHelper(nums, i + 1, subSet, results);
			// 回溯
			subSet.remove(subSet.size() - 1);
		}
	}
}
