package lintCode;

import java.util.Arrays;

/**
 * ���� m �� n�����е�ֵ�� 
 * �����������������ԣ� ÿ���е�����������������ġ�
 * ÿ�еĵ�һ����������һ�е����һ��������
 * 
 * @author CavieLee
 *
 */
public class SearchMatrixSolution {
	public boolean searchMatrix(int[][] matrix, int target) {
		boolean result = false;

		// У��
		if (matrix == null || matrix.length == 0 || target < 0) {
			return result;
		}

		int low = 0;
		int high = matrix.length - 1;
		int mid = 0;

		// ���ֲ�������һ��
		while (low <= high) {
			mid = (low + high) >> 1;
			if (target > matrix[mid][0]) {
				low = mid + 1;
			} else if (target < matrix[mid][0]) {
				high = mid - 1;
			} else {
				return true;
			}
		}

		// targetֻ�ܳ�����low - 1��
		int row = low - 1;
		if (row >= 0) {
			low = 0;
			high = matrix[0].length - 1;

			// ���ֲ�������һ��
			while (low <= high) {
				mid = (low + high) >> 1;

				if (target > matrix[row][mid]) {
					low = mid + 1;
				} else if (target < matrix[row][mid]) {
					high = mid - 1;
				} else {
					return true;
				}
			}
		}

		return result;
	}
}
