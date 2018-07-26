package lintCode;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * ����һ�����飬����δ���ֵ���С����
 * 
 * @author Cavielee
 *
 */
public class FirstMissingPrime {

	public int firstMissingPrime(int[] nums) {
		int result = 2;
		// 1���ж������Ƿ�Ϊ��
		if (nums.length == 0) {
			return result;
		}
		// 2���ȶ������������
		Arrays.sort(nums);
		// 3���ж�����ĵ�һ�����Ƿ�Ϊ2
		int first = nums[0];

		// 3�����first����2�ģ���δ���ֵ���С����Ϊ2
		if (first != 2) {
			// ����С������2
			return result;
		} else {
			// �����2��ʼ����Ѱ����һ�����������ж��Ƿ��������г���
			// ����һ��������
			TreeSet<Integer> prime_set = new TreeSet<Integer>();
			prime_set.add(2);

			// ��min_scope ~ max_scope֮��
			while (true) {
				// �Ƿ�Ϊ�������
				boolean flag = true;

				// �ҵ���һ������
				if (prime_set.size() == 1) {
					result = result + 1;
				} else {
					result = result + 2;
				}
				// �ж�result�Ƿ�Ϊ������ͨ����prime_set��ÿһ������ȡģ���ж�
				for (int n : prime_set) {
					// ���ȡģ��Ϊ0����result��������
					if ((result % n) == 0) {
						flag = false;
						break;
					}
				}
				// �жϱ��
				if (flag) {
					// ���Ϊ�������ж��Ƿ���������
					if (Arrays.binarySearch(nums, result) < 0) {
						// ���������result��Ϊ���
						return result;
					}
					prime_set.add(result);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 3, 5, 7, 11, 13, 17, 19 };
		System.out.println(new FirstMissingPrime().firstMissingPrime(nums));
	}

}
