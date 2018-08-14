package onlineTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
/**
 * ����һ��M��N��λ�õ��򳡣�ÿ��λ�ÿ��ܴ������ԡ�
 * ���ڣ��˸���λ������ͬһ�ӵ����ԣ���ͬ����������Ҫ����һ����λ��
 * ��һ���ж��ٶ����� �� ������Ե���һ���ж����ˣ�
 * ˼·����ʵ�����ж�����ͨͼ���˸�����汾��
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
		// M��
		int M = Integer.parseInt(lineNum[0]);
		// N��
		int N = Integer.parseInt(lineNum[1]);

		// P���Ⱥ�����
		long P = 0;
		// ������Ⱥ�������
		long Q = 0;

		// ��Map
		int[][] teamMap = new int[M][N];

		// ����mark����
		boolean[][] markMap = new boolean[M][N];

		// �˸�������
		int[] deltaX = { -1, 1, 0, 0, -1, 1, 1, -1 };
		int[] deltaY = { 0, 0, -1, 1, -1, 1, -1, 1 };

		// ��������ջ
		Stack<int[]> stack = new Stack<int[]>();

		// �����Щλ������
		List<int[]> hasPeople = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			line = in.nextLine();
			lineNum = line.split(",");
			for (int j = 0; j < N; j++) {
				teamMap[i][j] = Integer.parseInt(lineNum[j]);
				// �ж��Ƿ�����
				if (teamMap[i][j] == 1) {
					hasPeople.add(new int[] { i, j });
				}
			}
		}

		// dfs
		for (int n = 0; n < hasPeople.size(); n++) {
			int teamNum = 1;
			// ��һ�����˵�λ��
			int[] index = hasPeople.get(n);

			// �ж��Ƿ��Ѿ��߹�
			if (markMap[index[0]][index[1]] == true) {
				continue;
			}
			// ��ӳ�ʼ��
			stack.push(index);

			// ��ǵ�ǰλ��
			markMap[index[0]][index[1]] = true;

			// ����
			while (!stack.isEmpty()) {
				int size = stack.size();
				// �������з�֧
				for (int i = 0; i < size; i++) {
					// ������֧
					int[] current = stack.pop();

					// �ж����ڰ˸�����λ��
					for (int j = 0; j < 8; j++) {
						// ��һ����
						int[] temp = new int[] { current[0] + deltaX[j], current[1] + deltaY[j] };

						// �Ƿ���Ȧ��
						if (inBound(temp, M, N)) {
							// �жϸõ��Ƿ����ߣ�û���&&���ˣ�
							if (markMap[temp[0]][temp[1]] == false && teamMap[temp[0]][temp[1]] == 1) {
								// ��ǵ�ǰλ��
								markMap[temp[0]][temp[1]] = true;
								teamNum++;
								// ��ӵ���һ��֧
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

	// �Ƿ���Ȧ��
	private static boolean inBound(int[] temp, int row, int col) {
		if (temp[0] >= 0 && temp[0] < row && temp[1] >= 0 && temp[1] < col) {
			return true;
		}
		return false;
	}

}
