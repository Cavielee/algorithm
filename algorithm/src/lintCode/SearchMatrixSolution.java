package lintCode;

import java.util.Arrays;

/**
 * 搜索 m × n矩阵中的值。 
 * 这个矩阵具有以下特性： 每行中的整数从左到右是排序的。
 * 每行的第一个数大于上一行的最后一个整数。
 * 
 * @author CavieLee
 *
 */
public class SearchMatrixSolution {
	public boolean searchMatrix(int[][] matrix, int target) {
		boolean result = false;

		// 校验
		if (matrix == null || matrix.length == 0 || target < 0) {
			return result;
		}

		int low = 0;
		int high = matrix.length - 1;
		int mid = 0;

		// 二分查找在哪一行
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

		// target只能出现在low - 1行
		int row = low - 1;
		if (row >= 0) {
			low = 0;
			high = matrix[0].length - 1;

			// 二分查找在哪一列
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
