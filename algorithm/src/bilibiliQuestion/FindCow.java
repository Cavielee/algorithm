package bilibiliQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 农夫抓牛问题（广搜） 农夫初始点为x，牛在y，且牛不会走。给出节点与节点连接之间的关系，问能不能抓到牛。
 * 
 * @author CavieLee
 *
 */
public class FindCow {

	// 所有道路信息
	private static Map<Integer, List<Integer>> listRoad;
	// 标记数组
	private static boolean[] mark;

	public static void bfs(int start, int end, int pointNum) {
		// 辅助队列
		Queue<Integer> que = new LinkedList<>();

		// 把初始节点压入队列
		que.offer(start);
		// 标记初始
		mark[start] = true;
		// 遍历每一层
		while (!que.isEmpty()) {
			int size = que.size();

			for (int i = 0; i < size; i++) {
				int currentPoint = que.poll();

				// 判断是否到终点
				if (currentPoint == end) {
					System.out.println("可到达");
					return;
				}

				// 当前节点可到达的路
				List<Integer> list = listRoad.get(currentPoint);

				// 判断是否有路可走
				if (list != null) {
					for (int j = 0; j < list.size(); j++) {
						int nextPoint = list.get(j);
						// 判断是否访问过
						if (!mark[nextPoint]) {
							// 加入队列
							que.offer(nextPoint);
							// 标记已走过
							mark[nextPoint] = true;
						}
					}
				}

			}
		}
		System.out.println(-1);
	}

	public static void main(String[] args) {
		// 节点数
		int pointNum = 7;
		// 开始的节点
		int start = 3;
		// 牛的节点
		int end = 5;

		// 路径分布数组，list存储下标的节点的所有道路信息
		listRoad = new HashMap<>();
		// 节点0的所有道路
		List<Integer> listTo0 = new ArrayList<>();
		listTo0.add(1);

		// 节点1的所有道路
		List<Integer> listTo1 = new ArrayList<>();
		listTo1.add(0);
		listTo1.add(1);

		// 节点2的所有道路
		List<Integer> listTo2 = new ArrayList<>();
		listTo2.add(1);
		listTo2.add(3);
		listTo2.add(4);

		// 节点3的所有道路
		List<Integer> listTo3 = new ArrayList<>();
		listTo3.add(2);
		listTo3.add(4);
		listTo3.add(6);

		// 节点4的所有道路
		List<Integer> listTo4 = new ArrayList<>();
		listTo4.add(3);
		listTo4.add(5);

		// 节点5的所有道路
		List<Integer> listTo5 = new ArrayList<>();
		listTo5.add(4);
		listTo5.add(6);

		// 节点6的所有道路
		List<Integer> listTo6 = new ArrayList<>();
		listTo6.add(5);

		listRoad.put(0, listTo0);
		listRoad.put(1, listTo1);
		listRoad.put(2, listTo2);
		listRoad.put(3, listTo3);
		listRoad.put(4, listTo4);
		listRoad.put(5, listTo5);
		listRoad.put(6, listTo6);

		// 初始化mark数组
		mark = new boolean[pointNum];

		// 深度搜索
		bfs(start, end, pointNum);

	}
}
