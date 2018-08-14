package lintCode;

import java.util.Stack;

/**
 * 迷宫问题2： 一个球从起点到终点（起点和终点都为空的空位），球只能沿着方向一直滚，直到碰到墙（该方向下一个位置有阻碍，或者出界）才停下来。
 * 求到达终点，并且终点刚好停下来的最短路径，若无则返回-1。
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

	// 深度搜索
	public int dfs(int[][] maze, int[] start, int[] destination) {

		// 最短路径（因为长和宽都不超过100，所以默认值为10000）
		int minStep = 10000;
		// 创建队列
		Stack<Point> stack = new Stack<Point>();

		// 辅助数组，用来标记已走过的路线
		int row = maze.length;
		int col = maze[0].length;
		boolean[][] markMap = new boolean[row][col];

		// 四个方向
		int[] deltaX = { -1, 1, 0, 0 };
		int[] deltaY = { 0, 0, -1, 1 };
		// 以起点作为默认分支起点
		stack.push(new Point(start, 0));
		// 标记已走过
		markMap[start[0]][start[1]] = true;
		while (!stack.isEmpty()) {
			int size = stack.size();
			for (int i = 0; i < size; i++) {
				Point currentPoint = stack.pop();

				// 四个方向查找
				for (int j = 0; j < 4; j++) {
					// 新的点
					int[] temp = new int[] { currentPoint.cur[0] + deltaX[j], currentPoint.cur[1] + deltaY[j] };

					int tempLen = currentPoint.len;
					// 判断该点是否撞墙
					while (inBound(temp, row, col) && maze[temp[0]][temp[1]] == 0) {
						// 步数+1
						tempLen++;
						// 如果当前路径已超过最短路径，则该方向不用继续判断
						if (tempLen >= minStep) {
							break;
						}
						// 判断是否到达终点
						if (temp[0] == destination[0] && temp[1] == destination[1]) {
							// 判断下一个点是否为墙
							temp[0] += deltaX[j];
							temp[1] += deltaY[j];
							// 到达终点并能停止
							if (!inBound(temp, row, col) || maze[temp[0]][temp[1]] == 1) {
								minStep = minStep > tempLen ? tempLen : minStep;
							}
						}

						// 放该方向继续往下走
						temp[0] += deltaX[j];
						temp[1] += deltaY[j];
					}

					// 如果当前路径不超过最短路径，才需要添加新的分支
					if (tempLen < minStep) {
						// 撞到墙，换回到撞墙前状态
						temp[0] -= deltaX[j];
						temp[1] -= deltaY[j];
						// 判断新的分支点是否走过，没有则添加作为下次分支点起点
						if (!markMap[temp[0]][temp[1]]) {
							// 标记已走过
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

	// 判断是否在圈内
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
