package onlineTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Today1 {
	// ��Ź�ϵ
	private static List<List<Integer>> relations;
	// ���
	private static boolean[] flag;
	// ������
	private static int m = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// n����
		int n = Integer.parseInt(in.nextLine());

		relations = new ArrayList<>();;

		// ���
		flag = new boolean[n];

		// ������n���ϵ
		for (int i = 1; i <= n; i++) {
			String line = in.nextLine();
			String[] relation = line.split(" ");

			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < relation.length; j++) {
				int temp = Integer.parseInt(relation[j]);
				if (temp <= n)
//					relations[i][j] = temp;
					list.add(temp);
			}
			relations.add(list);
		}

		for (int i = 0; i < relations.size(); i++) {
			// �ҵ�û����ӵ�
			if (!flag[i]) {
				// ������ϵ
				int j = 0;
				while (true) {
					int know = relations.get(i).get(j);
					if (know != 0) {
						// �����ʶ����û�������
						if (!flag[know - 1]) {
							flag[know - 1] = true;
							find(know - 1);
							j++;
						} else {
							break;
						}
					} else {
						break;
					}
				}
				// �ж��Ƿ��Լ�һ��
				if (j != 0) {
					m++;
				}
				if (relations.get(i).get(0) != 0) {
					flag[i] = true;
				}
			}
		}
		// �ڱ���һ�ΰ�û����ӵĸ���Ϊһ��
		for (int i = 0; i < n; i++) {
			if (!flag[i]) {
				m++;
			}
		}
		System.out.println(m);
	}

	public static void find(int people) {
		// ������ϵ
		int j = 0;
		while (true) {
			int know = relations.get(people).get(j);
			if (know != 0) {
				// �����ʶ����û�������
				if (!flag[know - 1]) {
					flag[know - 1] = true;
					find(know - 1);
					j++;
				} else {
					break;
				}
			} else {
				break;
			}
		}
	}

}
