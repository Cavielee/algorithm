package offer;

/**
 * 1.�����ά�������
 * @author Cavielee
 *
 */
public class Find {
	static boolean find_1(int target, int[][] array) {
		/**
		 * ���ֲ��ҷ� ͨ��i�����еĲ�ѯ ÿһ�а��ն��ֲ��ҷ��Ƚ�target �����û�鵽�򷵻�false
		 */
		for (int i = 0; i < array.length; i++) {
			int min = 0;
			int max = array[i].length - 1;
			while (min <= max) {
				int mid = (min + max) >> 1;
				if (target > array[i][mid]) {
					min = mid + 1;
				} else if (target < array[i][mid]) {
					max = mid - 1;
				} else {
					return true;
				}
			}
		}
		return false;
	}

	static boolean find_2(int target, int[][] array) {
		/**
		 * ��Ϊ���������飬�������ϵݼ����������ҵ��� ���ֻ������½ǿ�ʼ�Ƚϣ����target�����������ƣ�С���������ƣ�ֱ��������Χ
		 */
		int line = array.length - 1;
		int row = 0;
		while (line >= 0 && row <= array[line].length - 1) {
			int position = array[line][row];
			if (target > position) {
				row++;
			} else if (target < position) {
				line--;
			} else {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] array = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		find_2(15,array);
	}
}
