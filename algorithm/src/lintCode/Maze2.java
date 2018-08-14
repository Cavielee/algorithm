package lintCode;

import java.util.Stack;

/**
 * �Թ�����2�� һ�������㵽�յ㣨�����յ㶼Ϊ�յĿ�λ������ֻ�����ŷ���һֱ����ֱ������ǽ���÷�����һ��λ�����谭�����߳��磩��ͣ������
 * �󵽴��յ㣬�����յ�պ�ͣ���������·���������򷵻�-1��
 * 
 * @author CavieLee
 *
 */
public class Maze2 {
	class Point {
		int[] cur = new int[2];
		int len;

		Point(int[] arr, int z) {
			this.cur[0] = arr[0];
			this.cur[1] = arr[1];
			this.len = z;
		}
	}

	// �������
	public int dfs(int[][] maze, int[] start, int[] destination) {

		// ���·������Ϊ���Ϳ�������100������Ĭ��ֵΪ10000��
		int minStep = 10000;
		// ��������
		Stack<Point> stack = new Stack<Point>();

		// �������飬����������߹���·��
		int row = maze.length;
		int col = maze[0].length;
		boolean[][] markMap = new boolean[row][col];

		// �ĸ�����
		int[] deltaX = { -1, 1, 0, 0 };
		int[] deltaY = { 0, 0, -1, 1 };
		// �������ΪĬ�Ϸ�֧���
		stack.push(new Point(start, 0));
		// ������߹�
		markMap[start[0]][start[1]] = true;
		while (!stack.isEmpty()) {
			int size = stack.size();
			for (int i = 0; i < size; i++) {
				Point currentPoint = stack.pop();

				// �ĸ��������
				for (int j = 0; j < 4; j++) {
					// �µĵ�
					int[] temp = new int[] { currentPoint.cur[0] + deltaX[j], currentPoint.cur[1] + deltaY[j] };

					int tempLen = currentPoint.len;
					// �жϸõ��Ƿ�ײǽ
					while (inBound(temp, row, col) && maze[temp[0]][temp[1]] == 0) {
						// ����+1
						tempLen++;
						// �����ǰ·���ѳ������·������÷����ü����ж�
						if (tempLen >= minStep) {
							break;
						}
						// �ж��Ƿ񵽴��յ�
						if (temp[0] == destination[0] && temp[1] == destination[1]) {
							// �ж���һ�����Ƿ�Ϊǽ
							temp[0] += deltaX[j];
							temp[1] += deltaY[j];
							// �����յ㲢��ֹͣ
							if (!inBound(temp, row, col) || maze[temp[0]][temp[1]] == 1) {
								minStep = minStep > tempLen ? tempLen : minStep;
							}
						}

						// �Ÿ÷������������
						temp[0] += deltaX[j];
						temp[1] += deltaY[j];
					}

					// �����ǰ·�����������·��������Ҫ����µķ�֧
					if (tempLen < minStep) {
						// ײ��ǽ�����ص�ײǽǰ״̬
						temp[0] -= deltaX[j];
						temp[1] -= deltaY[j];
						// �ж��µķ�֧���Ƿ��߹���û���������Ϊ�´η�֧�����
						if (!markMap[temp[0]][temp[1]]) {
							// ������߹�
							markMap[temp[0]][temp[1]] = true;
							stack.push(new Point(temp, tempLen));
						}
					}
				}
			}
		}

		if (minStep == 10000) {
			return -1;
		} else {
			return minStep;
		}

	}

	// �ж��Ƿ���Ȧ��
	public static boolean inBound(int[] index, int row, int col) {
		if (index[0] > -1 && index[1] > -1 && index[0] < row && index[1] < col) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		int[][] maze = new int[][] { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 },
				{ 0, 0, 0, 0, 0 } };
		int[] start = new int[] { 0, 4 };
		int[] end = new int[] { 4, 4 };
		System.out.println(new Maze2().dfs(maze, start, end));

	}
}
