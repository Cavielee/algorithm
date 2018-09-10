package lintCode;
/**
 * 某字符串（单调递增）为按照偏移量旋转后，要求把该字符串还原成旋转前。
 * 例如："12345" 按照偏移量2旋转后得： "45123" 还原成 "12345"
 */
import java.util.List;

public class RecoverRotatedSortedArray {
	public void recoverRotatedSortedArray(List<Integer> nums) {
		// 校验
		if (nums == null || nums.size() <= 1) {
			return;
		}
		// 个数
		int size = nums.size();
		int point = 0;
		// 找到旋转分割点
		while (point < size - 1) {
			if (nums.get(point) < nums.get(point + 1)) {
				break;
			}
		}
		// 前部分旋转
		reverse(nums, 0, point);
		// 后部分旋转
		reverse(nums, point + 1, size - 1);
		// 整体再旋转
		reverse(nums, 0, size - 1);
	}

	public void reverse(List<Integer> nums, int start, int end) {
		while (start < end) {
			int temp = nums.get(start);
			nums.set(start, nums.get(end));
			nums.set(end, temp);

			start++;
			end--;
		}
	}
}
