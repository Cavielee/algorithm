package lintCode;

/**
 * ����m��n�����е�ֵ���������ֵ���ֵĴ�����
 * �����������������ԣ�
 * ÿ���е�����������������ġ� 
 * ÿһ�е��������ϵ���������ġ� 
 * ��ÿһ�л�ÿһ����û���ظ���������
 * 
 * @author CavieLee
 *
 */
public class SearchMatrixIISolution {

	public int searchMatrix(int[][] matrix, int target) {
		int result = 0;
		// У��
		if (matrix == null || matrix.length == 0 || target < 0) {
			return result;
		}
		// ��
		int row = matrix.length;
		// ��
		int col = matrix[0].length;
		// �����½Ǵ���
		for (int i = row - 1, j = 0; i >= 0 && j < col;) {
			// �жϴ�С
			if (matrix[i][j] == target) {
				result++;
				// ��������
				i--;
				j++;
			} else if (matrix[i][j] < target) {
				// ������
				j++;
			} else {
				// ��������
				i--;
			}
		}
		return result;
	}
}
