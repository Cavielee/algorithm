package onlineTest;

import java.util.Scanner;

/**
 * 背包问题 牛牛准备参加学校组织的春游, 出发前牛牛准备往背包里装入一些零食, 牛牛的背包容量为w。
 * 牛牛家里一共有n袋零食, 第i袋零食体积为v[i]。
 * 牛牛想知道在总体积不超过背包容量的情况下,他一共有多少种零食放法(总体积为0也算一种放法)。
 * 
 * 输入包括两行
 * 第一行为两个正整数n和w(1 <= n <= 30, 1 <= w <= 2 * 10^9),表示零食的数量和背包的容量。
 * 第二行n个正整数v[i](0 <= v[i] <= 10^9),表示每袋零食的体积。
 * 
 * 思路：由于背包容量过大，不能用动态规划
 * 使用深度优化搜索方法（树）
 * ①从第一个物品开始，可以选择添加或不添加
 * ②如果添加，则需要判断添加后是否超过背包容量，不超过则可以放入并且方法+1，超过则该节点没有分支。
 * 依次判断剩下的物品，并重复上述两个操作
 * @author Cavielee
 *
 */
public class NetEasy_8 {
	public static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 零食数量
		int n = sc.nextInt();
		// 背包容量
		int w = sc.nextInt();

		int[] v = new int[n];
		long sum = 0;
		for (int i = 0; i < n; i++) {
			v[i] = sc.nextInt();
			sum += v[0];
		}

		// 如果所有物品总体积小于背包容量，则一共有2^n种
		if (sum <= w) {
			System.out.println((int) Math.pow(2, n));
		} else {
			dfs(0, 0, n, w, v);
			System.out.println(count + 1);
		}

	}

	// 深度优化搜索
	/**
	 * 
	 * @param sum
	 *            当前使用容量
	 * @param cur
	 *            当前操作物品下标
	 * @param n
	 *            总件数
	 * @param w
	 *            背包容量
	 * @param v
	 *            物品体积数组
	 */
	private static void dfs(long sum, int cur, int n, int w, int[] v) {
		// 判断是否还有物品
		if (cur < n) {
			// 判断当前容量是否超出背包容量
			if (sum > w) {
				return;
			}
			// 选择不加入物品
			dfs(sum, cur + 1, n, w, v);
			// 选择加入物品
			// 如果加入第cur件物品时大于背包容量则终止递归
			if ((sum + v[cur]) <= w) {
				count++;
				dfs(sum + v[cur], cur + 1, n, w, v);
			}
		}

	}

}
