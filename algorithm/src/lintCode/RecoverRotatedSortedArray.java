package lintCode;
/**
 * ĳ�ַ���������������Ϊ����ƫ������ת��Ҫ��Ѹ��ַ�����ԭ����תǰ��
 * ���磺"12345" ����ƫ����2��ת��ã� "45123" ��ԭ�� "12345"
 */
import java.util.List;

public class RecoverRotatedSortedArray {
	public void recoverRotatedSortedArray(List<Integer> nums) {
		// У��
		if (nums == null || nums.size() <= 1) {
			return;
		}
		// ����
		int size = nums.size();
		int point = 0;
		// �ҵ���ת�ָ��
		while (point < size - 1) {
			if (nums.get(point) < nums.get(point + 1)) {
				break;
			}
		}
		// ǰ������ת
		reverse(nums, 0, point);
		// �󲿷���ת
		reverse(nums, point + 1, size - 1);
		// ��������ת
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
