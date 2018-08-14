package bilibiliQuestion;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * �Ǳ����⣺��Ǳ��������ж������ͨ�Ŀռ䣩���ж��ٸ�����ͨ�Ŀռ䣬�Լ���Ӧ�ռ��ڵķ����ж��ٸ�
 * @author CavieLee
 *
 */
public class CastleProblem {

	// �������
	private static boolean[][] mark;
	// ������
	private static int possibilities = 0;
	// �ĸ�����
	private static int[] deltaX = { -1, 1, 0, 0 };
	private static int[] deltaY = { 0, 0, -1, 1 };

	// ���
	private static final Map<Integer, Integer> results = new HashMap<>();

	// �������
	public static void dfs(int[][] castle, int w, int h) {
		int row = castle.length;
		int col = castle[0].length;
		// ��·�ߵķ�����
		int roomNum = 1;

		// ��������ջ
		Stack<int[]> stack = new Stack<int[]>();
		// ��ӳ�ʼ��
		stack.push(new int[] { w, h });

		// ����
		while (!stack.isEmpty()) {
			int size = stack.size();
			// �������з�֧
			for (int i = 0; i < size; i++) {
				// ������֧
				int[] current = stack.pop();
				
				// ��ǵ�ǰλ��
				mark[current[0]][current[1]] = true;

				// �ж������ĸ�����λ��
				for (int j = 0; j < 4; j++) {
					// ��һ����
					int[] temp = new int[] { current[0] + deltaX[j], current[1] + deltaY[j] };

					// �Ƿ���Ȧ��
					if (inBound(temp, row, col)) {
						// �жϸõ��Ƿ����ߣ�û���&&ûǽ��
						if (mark[temp[0]][temp[1]] == false && castle[temp[0]][temp[1]] == 0) {
							roomNum++;
							// ��ӵ���һ��֧
							stack.push(temp);
						}
					}
				}
			}
		}
		results.put(++possibilities, roomNum);
	}

	// �Ƿ���Ȧ��
	private static boolean inBound(int[] temp, int row, int col) {
		if (temp[0] >= 0 && temp[0] < row && temp[1] >= 0 && temp[1] < col) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// ��
		int w = 5;
		// ��
		int h = 5;

		// �������
		mark = new boolean[5][5];

		// �Ǳ�
		int[][] castle = new int[][] { { 1, 1, 1, 0, 1 }, { 0, 0, 1, 0, 1 }, { 1, 0, 0, 1, 0 }, { 0, 1, 0, 1, 0 },
				{ 0, 0, 0, 1, 0 } };

		// �����������
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				// �ж��Ƿ��߹�
				if (!mark[i][j]) {
					// �ж��Ƿ�Ϊǽ
					if (castle[i][j] == 0) {
						// �������
						dfs(castle, i, j);
					}
				}
			}
		}

		// ������
		results.forEach((path, roomNum) -> System.out.println(path + " : " + roomNum));
	}

}
