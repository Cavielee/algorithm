package bilibiliQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 多条单向道路（城市到城市），有长度，花费限制的最短路径问题
 * 
 * @author CavieLee
 *
 */
public class FindPath {
	// 所有道路信息
	private static Map<Integer, List<Road>> listRoad;
	// 标记数组
	private static boolean[] mark;
	// 辅助最短路径数组(当前分支到该城市所需最短路径)
	private static int[][] minLenMark;

	// 最短路径
	private static int minLen = Integer.MAX_VALUE;

	// 深度搜索
	public static void dfs(int start, int end, int hasMoney, int totalCost, int totalLen) {

		// 判断是否到达终点
		if (start == end) {
			minLen = minLen < totalLen ? minLen : totalLen;
			return;
		}
		// 遍历当前分支的所有路径
		for (int i = 0; i < listRoad.get(start).size(); i++) {
			// 当前道路信息
			Road currentRoad = listRoad.get(start).get(i);
			// 判断当前路径是否走过
			if (!mark[currentRoad.end]) {
				// 当前花费
				totalCost += currentRoad.cost;
				// 当前路长
				totalLen += currentRoad.len;
				// 判断当前花费是否超过拥有的钱
				if (totalCost <= hasMoney) {
					// 判断该道路长度是否超过最小长度
					if (totalLen < minLen) {
						// 是否超过当前分支到该城市所需最短路径
						if (minLenMark[currentRoad.end][hasMoney] == 0
								|| totalLen <= minLenMark[currentRoad.end][hasMoney]) {
							minLenMark[currentRoad.end][hasMoney] = totalLen;
							mark[currentRoad.end] = true;
							dfs(currentRoad.end, end, hasMoney, totalCost, totalLen);
						}
					}
				}
				// 回溯状态
				mark[currentRoad.end] = false;
				totalCost -= currentRoad.cost;
				totalLen -= currentRoad.len;
			}

		}

	}

	static class Point {
		// 终点
		int start;
		// 花费
		int totalCost;
		// 路长
		int totalLen;

		public Point(int start, int totalCost, int totalLen) {
			super();
			this.start = start;
			this.totalCost = totalCost;
			this.totalLen = totalLen;
		}
	}

	static class Road {
		// 终点
		int end;
		// 花费
		int cost;
		// 路长
		int len;

		public Road(int end, int cost, int len) {
			super();
			this.end = end;
			this.cost = cost;
			this.len = len;
		}

	}

	public static void main(String[] args) {
		// 拥有的金钱
		int hasMoney = 1000;
		// 城市所有数
		int cityNum = 4;
		// 开始的城市
		int start = 0;
		// 终点的城市
		int end = 3;

		// 路径分布数组，list存储下标的城市的所有道路信息
		listRoad = new HashMap<Integer, List<Road>>();
		// 城市0的所有道路
		List<Road> listTo0 = new ArrayList<>();
		listTo0.add(new Road(1, 100, 100));
		listTo0.add(new Road(2, 100, 100));
		listTo0.add(new Road(3, 1100, 100));

		// 城市1的所有道路
		List<Road> listTo1 = new ArrayList<>();
		listTo1.add(new Road(2, 100, 100));

		// 城市2的所有道路
		List<Road> listTo2 = new ArrayList<>();
		listTo2.add(new Road(3, 100, 100));

		listRoad.put(0,listTo0);
		listRoad.put(1,listTo1);
		listRoad.put(2,listTo2);

		// 初始化mark数组
		mark = new boolean[cityNum];

		// 初始化辅助最短路径数组(当前分支到该城市所需最短路径)
		minLenMark = new int[mark.length][10000];

		// 深度搜索
		dfs(start, end, hasMoney, 0, 0);

		// 判断是否有路径连通start-end
		if (minLen == Integer.MAX_VALUE) {
			// 没有输出-1
			System.out.println(-1);
		} else {
			// 有则输出最短路径
			System.out.println(minLen);
		}
	}
}
