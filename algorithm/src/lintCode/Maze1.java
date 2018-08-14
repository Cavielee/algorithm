package lintCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * �Թ�����1�� һ�������㵽�յ㣨�����յ㶼Ϊ�յĿ�λ������ֻ�����ŷ���һֱ����ֱ������ǽ���÷�����һ��λ�����谭�����߳��磩��ͣ������
 * ���Ƿ���һ��·�������յ㣬�����յ�պ�ͣ������
 * 
 * @author CavieLee
 *
 */
public class Maze1 {

	// �ĸ�����,��������
	public static final int[][] DirectionArray = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	// �������
	public static boolean dfs(int[][] maze, int[] start, int[] destination) {
		// ջ�洢·����ʼ��
		Stack<int[]> stack = new Stack<int[]>();
		// �ĸ�����
		int row = maze.length, col = maze[0].length;
		int[] deltaX = { -1, 1, 0, 0 };
		int[] deltaY = { 0, 0, -1, 1 };
		// �������飬����Ѿ��߹��ĵ�
		boolean[][] visited = new boolean[row][col];
		// �����ΪĬ��·�����
		stack.push(start);
		// ��ǵ�ǰ��֧���߹�
		visited[start[0]][start[1]] = true;

		// ���еķ�֧����δ�ܵ����յ��Ҷ�����ǽʱ����·�����򷵻�false
		while (!stack.isEmpty()) {
			// ��ȡ��ǰ���з�֧�������
			int size = stack.size();
			// �������з�֧����һ��֧
			for (int i = 0; i < size; i++) {
				int[] point = stack.pop();

				// �жϸ÷�֧�����ĸ������Ƿ������һ��֧��㣨δ�߹���
				for (int j = 0; j < 4; j++) {
					// ��ǰ�������һ��
					int[] tmp = { point[0] + deltaX[j], point[1] + deltaY[j] };
					// ����ڷ�Χ�����ǿյĿռ�
					while (inBound(tmp, row, col) && maze[tmp[0]][tmp[1]] == 0) {
						// �ж��Ƿ�Ϊ�յ�
						if (tmp[0] == destination[0] && tmp[1] == destination[1]) {
							// ����յ��ظ÷������һ������ǽ���ڷ�Χ�ڣ���true
							tmp[0] += deltaX[j];
							tmp[1] += deltaY[j];
							if (!inBound(tmp, row, col) || maze[tmp[0]][tmp[1]] == 1) {
								return true;
							}
						}
						// �÷���������
						tmp[0] += deltaX[j];
						tmp[1] += deltaY[j];

					}
					// ��ʱ״̬�������߽磬��ԭ�������߽�֮ǰ������
					tmp[0] -= deltaX[j];
					tmp[1] -= deltaY[j];
					// ����÷�֧��û�߹�����ӵ�ջ����Ϊ��һ���������ҷ�֧
					if (!visited[tmp[0]][tmp[1]]) {
						// ��ǵ�ǰ��֧���߹�
						visited[tmp[0]][tmp[1]] = true;
						stack.push(tmp);
					}
				}
			}
		}
		return false;
	}

	// �������
	public static boolean bfs(int[][] maze, int[] start, int[] destination) {
		// ���д洢·����ʼ��
		Queue<int[]> que = new LinkedList<int[]>();
		// �ĸ�����
		int row = maze.length, col = maze[0].length;
		int[] deltaX = { -1, 1, 0, 0 };
		int[] deltaY = { 0, 0, -1, 1 };
		// �������飬����Ѿ��߹��ĵ�
		boolean[][] visited = new boolean[row][col];
		// �����ΪĬ��·�����
		que.offer(start);
		// ��ǵ�ǰ��֧���߹�
		visited[start[0]][start[1]] = true;

		// ���еķ�֧����δ�ܵ����յ��Ҷ�����ǽʱ����·�����򷵻�false
		while (!que.isEmpty()) {
			// ��ȡ��ǰ���з�֧�������
			int size = que.size();
			// �������з�֧����һ��֧
			for (int i = 0; i < size; i++) {
				int[] point = que.poll();

				// �жϸ÷�֧�����ĸ������Ƿ������һ��֧��㣨δ�߹���
				for (int j = 0; j < 4; j++) {
					// ��ǰ�������һ��
					int[] tmp = { point[0] + deltaX[j], point[1] + deltaY[j] };
					// ����ڷ�Χ�����ǿյĿռ�
					while (inBound(tmp, row, col) && maze[tmp[0]][tmp[1]] == 0) {
						// �ж��Ƿ�Ϊ�յ�
						if (tmp[0] == destination[0] && tmp[1] == destination[1]) {
							// ����յ��ظ÷������һ������ǽ���ڷ�Χ�ڣ���true
							tmp[0] += deltaX[j];
							tmp[1] += deltaY[j];
							if (!inBound(tmp, row, col) || maze[tmp[0]][tmp[1]] == 1) {
								return true;
							}
						}
						// �÷���������
						tmp[0] += deltaX[j];
						tmp[1] += deltaY[j];

					}
					// ��ʱ״̬�������߽磬��ԭ�������߽�֮ǰ������
					tmp[0] -= deltaX[j];
					tmp[1] -= deltaY[j];
					// ����÷�֧��û�߹�����ӵ���������Ϊ��һ���������ҷ�֧
					if (!visited[tmp[0]][tmp[1]]) {
						// ��ǵ�ǰ��֧���߹�
						visited[tmp[0]][tmp[1]] = true;
						que.offer(tmp);
					}
				}
			}
		}
		return false;
	}

	// �ж��Ƿ���Ȧ��
	private static boolean inBound(int[] tmp, int row, int col) {
		if (tmp[0] >= 0 && tmp[0] < row && tmp[1] >= 0 && tmp[1] < col) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] maze = new int[][] { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 1 } };
		int[] start = new int[] { 1, 0 };
		int[] end = new int[] { 0, 2 };
		System.out.println(bfs(maze, start, end));

	}
}
