package offer;

/**
 * 1.有序二维数组查找
 * @author Cavielee
 *
 */
public class Find {
	static boolean find_1(int target, int[][] array) {
		/**
		 * 二分查找法 通过i控制行的查询 每一行按照二分查找法比较target 如果都没查到则返回false
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
		 * 因为是有序数组，从下往上递减，从左往右递增 因此只需从左下角开始比较，如果target大于则往右移，小于则往上移，直到超过范围
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
