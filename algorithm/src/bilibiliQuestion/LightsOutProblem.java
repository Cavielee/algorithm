package bilibiliQuestion;

/**
 * Ϩ�����⣬ͨ��һ��԰�ť�Ĳ�����ʹ���еƶ��ر�(�ض���һ�ְ�ť����ʹ�����е�Ϩ��) 
 * ���룺һ�����飨�����Ƶ�״̬�� 
 * �����һ�����飨����������״̬)
 * 
 * ˼·�� ����ö��ÿ�����ص�״̬����2^30���ᳬʱ�� 
 * �Ż��� ��ö�ٸ�����״̬�����ڵ�һ�У�Ȼ�������ж���һ�п��ص�״̬��Ҫʹ����һ�еĵ�ȫϨ��
 * ����ѡ���к��н�С����Ϊö�ٵķ�������ʱ����Ϊ2^n���к����н�С�ߣ� 
 * ����ж����һ�е�״̬�Ƿ�ΪȫϨ�����ȫϨ������ֿ��ز������У�������
 * 
 * ö�ٵ�һ�п���״̬����ͨ��Ƕ��forѭ����ʹ�ö�����ģ��
 * 
 * @author Cavielee
 *
 */
public class LightsOutProblem {

	public int[][] solution(int[][] puzzle) {
		// ����ǿ��ж�
		if (puzzle == null || puzzle.length == 0) {
			return null;
		}
		// ��
		int press_row = puzzle.length + 1;
		// ��
		int press_col = puzzle[0].length + 2;
		// �������飬��¼��ť���
		int[][] press = new int[press_row][press_col];
		int c;
		while (guess(puzzle, press, press_row, press_col) == false) {
			// �����ƿ��Ƶ�һ�а�ť״̬
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
		// �ж����һ��ǰ��������п��ز���
		for (int r = 1; r < press_row - 1; r++) {
			for (int c = 1; c < press_col - 1; c++) {
				// �ж���һ�еĸ��еĿ���״̬
				press[r + 1][c] = puzzle[r - 1][c - 1] ^ press[r][c] ^ press[r - 1][c] ^ press[r][c - 1]
						^ press[r][c + 1];
			}
		}
		// �ж����һ�еƵ�״̬�Ƿ�ȫΪϨ��
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
