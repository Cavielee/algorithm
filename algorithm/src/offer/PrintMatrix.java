package offer;

import java.util.ArrayList;

/**
 * 19.˳ʱ���ӡ���󣨶�ά���飩
 * @author Cavielee
 *
 */
public class PrintMatrix {

	public ArrayList<Integer> printMatrix(int[][] matrix) {
		if (matrix == null) {
			return null;
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		// ������
		int rowNum = matrix.length;
		// ������
		int colNum = matrix[0].length;
		// ��ӡ����Ȧ
		int round = (((rowNum > colNum ? colNum : rowNum) -1)/2+1);
		// iΪ��ӡ���ڼ�Ȧ
		for (int i = 0; i < round; i++) {
			// ������,��һȦΪ��ǰ������i,��Ϊi����ӡ[j,colNum-i]��
			for (int j = i; j < colNum - i; j++) {
				list.add(matrix[i][j]);
			}
			// �ϵ��£���һȦΪ��ǰ������i+1����ΪcolNum - 1 - i����ӡ[k,rowNum-i]��
			for (int k = i + 1; k < rowNum - i; k++) {
				list.add(matrix[k][colNum - 1 - i]);
			}
			
			/*
			 * �ҵ��󣬵�һȦΪ��ǰ������rowNum - i - 1����ΪcolNum - i - 2
			 * ��ӡ[i,colNum - i - 2]��,��ֻ��һ�е�ʱ���������rowNum - i - 1 != i��
			 */
			for (int m = colNum - i - 2; (m >= i) && (rowNum - i - 1 != i); m--) {
				list.add(matrix[rowNum - i - 1][m]);
			}
			/*
			 * �µ��ϣ���һȦΪ��ǰ������rowNum - i - 1����ΪcolNum - i - 2
			 * ��ӡ[i,rowNum - i - 2]��,��ֻ��һ�е�ʱ���������colNum - i - 1 != i��
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
