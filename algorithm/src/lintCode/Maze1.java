package lintCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 迷宫问题1： 一个球从起点到终点（起点和终点都为空的空位），球只能沿着方向一直滚，直到碰到墙（该方向下一个位置有阻碍，或者出界）才停下来。
 * 求是否有一条路径到达终点，并且终点刚好停下来。
 * 
 * @author CavieLee
 *
 */
public class Maze1 {

	// 四个方向,右下左上
	public static final int[][] DirectionArray = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	// 深度搜索
	public static boolean dfs(int[][] maze, int[] start, int[] destination) {
		// 栈存储路径起始点
		Stack<int[]> stack = new Stack<int[]>();
		// 四个方向
		int row = maze.length, col = maze[0].length;
		int[] deltaX = { -1, 1, 0, 0 };
		int[] deltaY = { 0, 0, -1, 1 };
		// 辅助数组，标记已经走过的点
		boolean[][] visited = new boolean[row][col];
		// 以起点为默认路径起点
		stack.push(start);
		// 标记当前分支已走过
		visited[start[0]][start[1]] = true;

		// 所有的分支，都未能到达终点且都遇到墙时（死路），则返回false
		while (!stack.isEmpty()) {
			// 获取当前所有分支起点数量
			int size = stack.size();
			// 遍历所有分支的下一分支
			for (int i = 0; i < size; i++) {
				int[] point = stack.pop();

				// 判断该分支起点的四个方向是否存在下一分支起点（未走过）
				for (int j = 0; j < 4; j++) {
					// 当前方向的下一点
					int[] tmp = { point[0] + deltaX[j], point[1] + deltaY[j] };
					// 如果在范围内且是空的空间
					while (inBound(tmp, row, col) && maze[tmp[0]][tmp[1]] == 0) {
						// 判断是否为终点
						if (tmp[0] == destination[0] && tmp[1] == destination[1]) {
							// 如果终点沿该方向的下一个点是墙或不在范围内，则true
							tmp[0] += deltaX[j];
							tmp[1] += deltaY[j];
							if (!inBound(tmp, row, col) || maze[tmp[0]][tmp[1]] == 1) {
								return true;
							}
						}
						// 该方向往下走
						tmp[0] += deltaX[j];
						tmp[1] += deltaY[j];

					}
					// 此时状态是碰到边界，还原到碰到边界之前的坐标
					tmp[0] -= deltaX[j];
					tmp[1] -= deltaY[j];
					// 如果该分支点没走过，添加到栈中作为下一次起点继续找分支
					if (!visited[tmp[0]][tmp[1]]) {
						// 标记当前分支已走过
						visited[tmp[0]][tmp[1]] = true;
						stack.push(tmp);
					}
				}
			}
		}
		return false;
	}

	// 广度搜索
	public static boolean bfs(int[][] maze, int[] start, int[] destination) {
		// 队列存储路径起始点
		Queue<int[]> que = new LinkedList<int[]>();
		// 四个方向
		int row = maze.length, col = maze[0].length;
		int[] deltaX = { -1, 1, 0, 0 };
		int[] deltaY = { 0, 0, -1, 1 };
		// 辅助数组，标记已经走过的点
		boolean[][] visited = new boolean[row][col];
		// 以起点为默认路径起点
		que.offer(start);
		// 标记当前分支已走过
		visited[start[0]][start[1]] = true;

		// 所有的分支，都未能到达终点且都遇到墙时（死路），则返回false
		while (!que.isEmpty()) {
			// 获取当前所有分支起点数量
			int size = que.size();
			// 遍历所有分支的下一分支
			for (int i = 0; i < size; i++) {
				int[] point = que.poll();

				// 判断该分支起点的四个方向是否存在下一分支起点（未走过）
				for (int j = 0; j < 4; j++) {
					// 当前方向的下一点
					int[] tmp = { point[0] + deltaX[j], point[1] + deltaY[j] };
					// 如果在范围内且是空的空间
					while (inBound(tmp, row, col) && maze[tmp[0]][tmp[1]] == 0) {
						// 判断是否为终点
						if (tmp[0] == destination[0] && tmp[1] == destination[1]) {
							// 如果终点沿该方向的下一个点是墙或不在范围内，则true
							tmp[0] += deltaX[j];
							tmp[1] += deltaY[j];
							if (!inBound(tmp, row, col) || maze[tmp[0]][tmp[1]] == 1) {
								return true;
							}
						}
						// 该方向往下走
						tmp[0] += deltaX[j];
						tmp[1] += deltaY[j];

					}
					// 此时状态是碰到边界，还原到碰到边界之前的坐标
					tmp[0] -= deltaX[j];
					tmp[1] -= deltaY[j];
					// 如果该分支点没走过，添加到队列中作为下一次起点继续找分支
					if (!visited[tmp[0]][tmp[1]]) {
						// 标记当前分支已走过
						visited[tmp[0]][tmp[1]] = true;
						que.offer(tmp);
					}
				}
			}
		}
		return false;
	}

	// 判断是否在圈内
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
