package onlineTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Today1 {
	// 存放关系
	private static List<List<Integer>> relations;
	// 标记
	private static boolean[] flag;
	// 多少组
	private static int m = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// n个人
		int n = Integer.parseInt(in.nextLine());

		relations = new ArrayList<>();;

		// 标记
		flag = new boolean[n];

		// 接下来n组关系
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
			// 找到没有组队的
			if (!flag[i]) {
				// 遍历关系
				int j = 0;
				while (true) {
					int know = relations.get(i).get(j);
					if (know != 0) {
						// 如果认识的人没有组过队
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
				// 判断是否自己一个
				if (j != 0) {
					m++;
				}
				if (relations.get(i).get(0) != 0) {
					flag[i] = true;
				}
			}
		}
		// 在遍历一次把没有组队的各自为一队
		for (int i = 0; i < n; i++) {
			if (!flag[i]) {
				m++;
			}
		}
		System.out.println(m);
	}

	public static void find(int people) {
		// 遍历关系
		int j = 0;
		while (true) {
			int know = relations.get(people).get(j);
			if (know != 0) {
				// 如果认识的人没有组过队
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
