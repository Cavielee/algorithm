package lintCode;

/**
 * LintCode.92:背包问题
 * 在n个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A[i]。
 * 思路： dp[i][j]:意思为装载第i个物品，背包容量为j时的当前最大装载量 
 * 分两种情况： 
 * 1.当A[i] > j时，意味着无论怎么腾空间都无法满足，因此直接等于dp[i-1][j] 
 * 2.为A[i]腾出空间，此时情况为dp[i-1][j-A[i]]的状态下+A[i]
 * dp[i-1][j-A[i]]代表装在第i-1个，背包容量为j-A[i]（确保腾出A[i]的容量）时的当前最大装载量
 * 放入新物品后背包最大可装满空间可能更大，也可能变小，因此取与dp[i-1][j]中较大者
 * 
 * @author Cavielee
 *
 */
public class BackPack {

	public int backPack(int m, int[] A) {
		// 动态规划矩阵
		int[][] dp = new int[A.length][m + 1];
		// 背包空间为0时，不管要放第几个物品，可装满的背包空间为0.
		for (int i = 0; i < A.length; i++) {
			dp[i][0] = 0;
		}
		for (int j = 1; j < m + 1; j++) {
			// 当第0个物品的空间小于等于当前背包空间j时
			if (A[0] <= j) {
				// 背包可装满的最大空间是第0个物品的体积
				dp[0][j] = A[0];
			} else {// 当第0个物品的空间大于当前背包空间j时
				// 背包可装满的最大空间是0
				dp[0][j] = 0;
			}
			// 当放第1个到第A.length-1个物品时
			for (int i = 1; i < A.length; i++) {
				// 若该物品所占空间大于背包总空间（无论怎样腾背包空间，该物品无法放入背包
				if (A[i] > j) {
					// 背包可装满的最大空间不变
					dp[i][j] = dp[i - 1][j];
				} else {
					/*
					 *  若该物品所占空间小于等于背包总空间,则需将背包空间腾出至少A[i]后，将该物品放入。
					 *  放入新物品后背包最大可装满空间可能更大，也可能变小大，取大值作为背包空间为j且放第i个物品时可以有的最大可装满空间。
					 */
					dp[i][j] = Math.max(dp[i - 1][j - A[i]] + A[i], dp[i - 1][j]);
				}
			}
		}
		return dp[A.length - 1][m];
	}

	public static void main(String[] args) {
		int[] array = new int[] { 3, 4, 8, 5 };
		System.out.println(new BackPack().backPack(10, array));
	}

}
