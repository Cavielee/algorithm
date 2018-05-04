package offer;

import java.util.ArrayList;

/**
 * 19.顺时针打印矩阵（二维数组）
 * @author Cavielee
 *
 */
public class PrintMatrix {

	public ArrayList<Integer> printMatrix(int[][] matrix) {
		if (matrix == null) {
			return null;
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		// 多少行
		int rowNum = matrix.length;
		// 多少列
		int colNum = matrix[0].length;
		// 打印多少圈
		int round = (((rowNum > colNum ? colNum : rowNum) -1)/2+1);
		// i为打印到第几圈
		for (int i = 0; i < round; i++) {
			// 左向右,第一圈为当前操作行i,列为i，打印[j,colNum-i]个
			for (int j = i; j < colNum - i; j++) {
				list.add(matrix[i][j]);
			}
			// 上到下，第一圈为当前操作行i+1，列为colNum - 1 - i，打印[k,rowNum-i]个
			for (int k = i + 1; k < rowNum - i; k++) {
				list.add(matrix[k][colNum - 1 - i]);
			}
			
			/*
			 * 右到左，第一圈为当前操作行rowNum - i - 1，列为colNum - i - 2
			 * 打印[i,colNum - i - 2]个,当只有一行的时候不用输出（rowNum - i - 1 != i）
			 */
			for (int m = colNum - i - 2; (m >= i) && (rowNum - i - 1 != i); m--) {
				list.add(matrix[rowNum - i - 1][m]);
			}
			/*
			 * 下到上，第一圈为当前操作行rowNum - i - 1，列为colNum - i - 2
			 * 打印[i,rowNum - i - 2]个,当只有一列的时候不用输出（colNum - i - 1 != i）
			 */
			for (int n = rowNum - i - 2; (n > i) && (colNum - i - 1 != i); n--) {
				list.add(matrix[n][i]);
			}
		}
		return list;

	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1 }, { 2 }, { 3 }, { 4 }, { 5 } };
		new PrintMatrix().printMatrix(matrix);

	}

}
