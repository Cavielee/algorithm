package onlineTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 上课问题：每分钟都有醒和没醒状态，且每分钟都有相应数值分数。
 * 问：如何叫醒一次，让获得数值分数最大化
 * @author CavieLee
 *
 */
public class NetEasy8_11 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// 最大成绩
		long maxScore = 0;
		// 基础分数
		long minScore = 0;
		// 课的时间
		long n = in.nextLong();
		// 保持清醒时间
		int k = in.nextInt();
		
		// 每分钟的分值
		long[] score = new long[(int) (n + 1)];

		for (int i = 1; i <= n; i++) {
			score[i] = in.nextInt();
		}

		// 每分钟是否清醒，1为清醒
		long[] statuArray = new long[(int) (n + 1)];
		// 记录那几分钟是睡着
		List<Integer> isSleep = new ArrayList<>();

		// 如果k >= n,直接返回所有score相加
		if (k >= n) {
			for (int i = 1; i <= n; i++) {
				maxScore += score[i];
			}
			// 输出结果
			System.out.println(maxScore);
			return;
		} else {
			for (int i = 1; i <= n; i++) {
				int statu = in.nextInt();
				// 判断是否醒着
				if (statu == 1) {
					minScore += score[i];
					statuArray[i] = 1;
				} else {
					isSleep.add(i);
				}
			}
		}

		// 初始化最大值
		maxScore = minScore;

		// 尝试所有所有睡着的可能叫醒
		for (int i = 0; i < isSleep.size(); i++) {
			int time = isSleep.get(i);
			// 该方案初始分数
			long currentScore = minScore + score[time];
			// 判断后面两个分数是否要加
			for (int j = 1; j < k; j++) {
				int nextTime = time + j;
				if (nextTime < (n + 1)) {
					if (statuArray[nextTime] == 0) {
						currentScore += score[nextTime];
					}
				}

			}
			// 判断是否比当前最大值大
			maxScore = maxScore > currentScore ? maxScore : currentScore;
		}

		// 可以通过对每个0进行尝试叫醒
		System.out.println(maxScore);
	}

}
