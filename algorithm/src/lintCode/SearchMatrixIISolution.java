package lintCode;

/**
 * 搜索m×n矩阵中的值，返回这个值出现的次数。
 * 这个矩阵具有以下特性：
 * 每行中的整数从左到右是排序的。 
 * 每一列的整数从上到下是排序的。 
 * 在每一行或每一列中没有重复的整数。
 * 
 * @author CavieLee
 *
 */
public class SearchMatrixIISolution {

	public int searchMatrix(int[][] matrix, int target) {
		int result = 0;
		// 校验
		if (matrix == null || matrix.length == 0 || target < 0) {
			return result;
		}
		// 行
		int row = matrix.length;
		// 列
		int col = matrix[0].length;
		// 从左下角触发
		for (int i = row - 1, j = 0; i >= 0 && j < col;) {
			// 判断大小
			if (matrix[i][j] == target) {
				result++;
				// 往右上走
				i--;
				j++;
			} else if (matrix[i][j] < target) {
				// 往右走
				j++;
			} else {
				// 往右上走
				i--;
			}
		}
		return result;
	}
}
