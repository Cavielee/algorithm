package onlineTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
/**
 * 输入一个M×N个位置的球场，每个位置可能存在球迷。
 * 相邻（八个方位）都是同一队的球迷，不同队球迷起码要隔着一个空位。
 * 问一共有多少队球迷 和 最多球迷的那一队有多少人？
 * 思路：其实是求有多少连通图（八个方向版本）
 * 
 * AC
 * @author CavieLee
 *
 */
public class SoccerTeam {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String line = in.nextLine();
		String[] lineNum = line.split(",");
		// M行
		int M = Integer.parseInt(lineNum[0]);
		// N列
		int N = Integer.parseInt(lineNum[1]);

		// P球队群体个数
		long P = 0;
		// 最大球队群体的人数
		long Q = 0;

		// 球场Map
		int[][] teamMap = new int[M][N];

		// 辅助mark数组
		boolean[][] markMap = new boolean[M][N];

		// 八个个方向
		int[] deltaX = { -1, 1, 0, 0, -1, 1, 1, -1 };
		int[] deltaY = { 0, 0, -1, 1, -1, 1, -1, 1 };

		// 创建辅助栈
		Stack<int[]> stack = new Stack<int[]>();

		// 标记那些位置有人
		List<int[]> hasPeople = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			line = in.nextLine();
			lineNum = line.split(",");
			for (int j = 0; j < N; j++) {
				teamMap[i][j] = Integer.parseInt(lineNum[j]);
				// 判断是否有人
				if (teamMap[i][j] == 1) {
					hasPeople.add(new int[] { i, j });
				}
			}
		}

		// dfs
		for (int n = 0; n < hasPeople.size(); n++) {
			int teamNum = 1;
			// 第一个有人的位置
			int[] index = hasPeople.get(n);

			// 判断是否已经走过
			if (markMap[index[0]][index[1]] == true) {
				continue;
			}
			// 添加初始点
			stack.push(index);

			// 标记当前位置
			markMap[index[0]][index[1]] = true;

			// 搜索
			while (!stack.isEmpty()) {
				int size = stack.size();
				// 遍历所有分支
				for (int i = 0; i < size; i++) {
					// 弹出分支
					int[] current = stack.pop();

					// 判断相邻八个方向位置
					for (int j = 0; j < 8; j++) {
						// 下一个点
						int[] temp = new int[] { current[0] + deltaX[j], current[1] + deltaY[j] };

						// 是否在圈内
						if (inBound(temp, M, N)) {
							// 判断该点是否能走（没标记&&有人）
							if (markMap[temp[0]][temp[1]] == false && teamMap[temp[0]][temp[1]] == 1) {
								// 标记当前位置
								markMap[temp[0]][temp[1]] = true;
								teamNum++;
								// 添加到下一分支
								stack.push(temp);
							}
						}
					}
				}
			}
			P++;
			Q = Q > teamNum ? Q : teamNum;
		}

		System.out.println(P + "," + Q);

	}

	// 是否在圈内
	private static boolean inBound(int[] temp, int row, int col) {
		if (temp[0] >= 0 && temp[0] < row && temp[1] >= 0 && temp[1] < col) {
			return true;
		}
		return false;
	}

}
