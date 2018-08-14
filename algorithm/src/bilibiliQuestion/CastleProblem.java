package bilibiliQuestion;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 城堡问题：求城堡（可能有多个不连通的空间）内有多少个不连通的空间，以及对应空间内的房间有多少个
 * @author CavieLee
 *
 */
public class CastleProblem {

	// 标记数组
	private static boolean[][] mark;
	// 方案数
	private static int possibilities = 0;
	// 四个方向
	private static int[] deltaX = { -1, 1, 0, 0 };
	private static int[] deltaY = { 0, 0, -1, 1 };

	// 结果
	private static final Map<Integer, Integer> results = new HashMap<>();

	// 深度搜索
	public static void dfs(int[][] castle, int w, int h) {
		int row = castle.length;
		int col = castle[0].length;
		// 该路线的房间数
		int roomNum = 1;

		// 创建辅助栈
		Stack<int[]> stack = new Stack<int[]>();
		// 添加初始点
		stack.push(new int[] { w, h });

		// 搜索
		while (!stack.isEmpty()) {
			int size = stack.size();
			// 遍历所有分支
			for (int i = 0; i < size; i++) {
				// 弹出分支
				int[] current = stack.pop();
				
				// 标记当前位置
				mark[current[0]][current[1]] = true;

				// 判断相邻四个方向位置
				for (int j = 0; j < 4; j++) {
					// 下一个点
					int[] temp = new int[] { current[0] + deltaX[j], current[1] + deltaY[j] };

					// 是否在圈内
					if (inBound(temp, row, col)) {
						// 判断该点是否能走（没标记&&没墙）
						if (mark[temp[0]][temp[1]] == false && castle[temp[0]][temp[1]] == 0) {
							roomNum++;
							// 添加到下一分支
							stack.push(temp);
						}
					}
				}
			}
		}
		results.put(++possibilities, roomNum);
	}

	// 是否在圈内
	private static boolean inBound(int[] temp, int row, int col) {
		if (temp[0] >= 0 && temp[0] < row && temp[1] >= 0 && temp[1] < col) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// 列
		int w = 5;
		// 行
		int h = 5;

		// 标记数组
		mark = new boolean[5][5];

		// 城堡
		int[][] castle = new int[][] { { 1, 1, 1, 0, 1 }, { 0, 0, 1, 0, 1 }, { 1, 0, 0, 1, 0 }, { 0, 1, 0, 1, 0 },
				{ 0, 0, 0, 1, 0 } };

		// 遍历标记数组
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				// 判断是否走过
				if (!mark[i][j]) {
					// 判断是否为墙
					if (castle[i][j] == 0) {
						// 深度搜索
						dfs(castle, i, j);
					}
				}
			}
		}

		// 遍历答案
		results.forEach((path, roomNum) -> System.out.println(path + " : " + roomNum));
	}

}
