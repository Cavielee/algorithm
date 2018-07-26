package bilibiliQuestion;

/**
 * 熄灯问题，通过一组对按钮的操作，使所有灯都关闭(必定有一种按钮操作使得所有灯熄灭) 
 * 输入：一个数组（描述灯的状态） 
 * 输出：一个数组（描述各开关状态)
 * 
 * 思路： 可以枚举每个开关的状态，即2^30（会超时） 
 * 优化： 把枚举各开关状态控制在第一行，然后依次判断下一行开关的状态（要使得上一行的灯全熄灭）
 * 可以选择行和列较小者作为枚举的方案，此时次数为2^n（行和列中较小者） 
 * 最后判断最后一行的状态是否为全熄灭，如果全熄灭则该种开关操作可行，并返回
 * 
 * 枚举第一行开关状态可以通过嵌套for循环或使用二进制模拟
 * 
 * @author Cavielee
 *
 */
public class LightsOutProblem {

	public int[][] solution(int[][] puzzle) {
		// 数组非空判断
		if (puzzle == null || puzzle.length == 0) {
			return null;
		}
		// 行
		int press_row = puzzle.length + 1;
		// 列
		int press_col = puzzle[0].length + 2;
		// 辅助数组，记录按钮情况
		int[][] press = new int[press_row][press_col];
		int c;
		while (guess(puzzle, press, press_row, press_col) == false) {
			// 二进制控制第一列按钮状态
			press[1][1]++;
			c = 1;
			while (press[1][c] > 1) {
				press[1][c] = 0;
				c++;
				press[1][c]++;
			}

		}
		return press;
	}

	public boolean guess(int[][] puzzle, int[][] press, int press_row, int press_col) {
		// 判断最后一行前面的所有行开关操作
		for (int r = 1; r < press_row - 1; r++) {
			for (int c = 1; c < press_col - 1; c++) {
				// 判断下一行的该列的开关状态
				press[r + 1][c] = puzzle[r - 1][c - 1] ^ press[r][c] ^ press[r - 1][c] ^ press[r][c - 1]
						^ press[r][c + 1];
			}
		}
		// 判断最后一行灯的状态是否全为熄灭
		for (int c = 1; c < press_col - 1; c++) {
			if ((puzzle[press_row - 2][c - 1] != (press[press_row - 1][c] ^ press[press_row - 2][c] ^ press[press_row - 1][c - 1] ^ press[press_row - 1][c + 1])))
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		int[][] puzzle = new int[][] { { 0, 1, 1, 0, 1, 0 }, { 1, 0, 0, 1, 1, 1 }, { 0, 0, 1, 0, 0, 1 },
				{ 1, 0, 0, 1, 0, 1 }, { 0, 1, 1, 1, 0, 0 } };
		int[][] puzzle_2 = new int[][] { { 0, 0, 1, 0, 1, 0 }, { 1, 0, 1, 0, 1, 1 }, { 0, 0, 1, 0, 1, 1 },
			{ 1, 0, 1, 1, 0, 0 }, { 0, 1, 0, 1, 0, 0 } };
		int[][] press = new LightsOutProblem().solution(puzzle_2);
		System.out.println(press);
	}

}
