package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Dijkstra {

	// 散列表（存储连接信息）
	private static Map<Integer, List<Road>> listRoad;
	// 待排序节点
	private static int[] waitingSort;

	// 判断源节点到目标节点是否找到最短距离（0为没有，1为有）
	private static int[] hasPath;

	// 保存源点到目标节点目前最短距离
	private static int[] distance;

	// 保存起点到目标顶点最短路径的上已经过点（如果为0则没有能到达的）
	private static int[] path;

	// Dijkstra，返回最短路径
	public static void dijkstra(int start, int end, int cityNum) {

		// 如果start == end
		if (start == end) {
			System.out.println(0);
			System.out.println("路径：" + start);
			return;
		}
		// 如果起点没有相邻的点直接返回
		if (listRoad.get(start) == null) {
			System.out.println(-1);
			return;
		}

		// 最短距离
		int minDistance;
		// 中间节点
		int midCity = 0;
		// 初始化
		for (int i = 0; i < listRoad.get(start).size(); i++) {
			// 初始化距离表
			Road road = listRoad.get(start).get(i);
			distance[road.end] = road.len;

			// 初始化 path
			path[road.end] = start;
		}
		// 把hasPath[start]也置为1
		hasPath[start] = 1;

		// 把waitingSort数组的所有节点依次作为经过点更新距离
		for (int i = 0; i < waitingSort.length; i++) {
			minDistance = Integer.MAX_VALUE;

			// 选取不在hasPath 中且具有最小距离的顶点
			for (int j = 1; j < distance.length; j++) {
				if (hasPath[j] == 0 && distance[j] != 0 && distance[j] < minDistance) {
					midCity = j;
					minDistance = distance[j];
				}
			}
			// 已经为源点到目标节点midCity的最短距离
			hasPath[midCity] = 1;
			// 判断midCity 是否有相邻点
			if (listRoad.get(midCity) != null) {
				// midCity 节点作为中间点，修改源点到waitingSort 中各个节点的距离
				for (int j = 0; j < listRoad.get(midCity).size(); j++) {
					Road road = listRoad.get(midCity).get(j);
					// 判断之前是否有路到 road.end 节点
					if (hasPath[road.end] == 0) {
						// 以 waitingSort[i] 作为中间点到 waitingSort[i]相邻的点的距离
						int newDistance = distance[midCity] + road.len;

						// 如果新到达这个节点
						if (distance[road.end] == 0) {
							distance[road.end] = newDistance;
							path[road.end] = midCity;
						} else if (newDistance < distance[road.end]) {
							// newDistance 比起点直接到 road.end 距离短,则更新
							distance[road.end] = newDistance;
							path[road.end] = midCity;
						}
					}
				}
			}
		}

		// 如果源点到终点有最短距离时，则输出距离，否则返回-1
		if (hasPath[end] == 0) {
			System.out.println(-1);
			return;
		} else {
			System.out.println(distance[end]);
			// 输出路径
			disPath(start, end);
			return;
		}

	}

	// 展示start 到 end 的最短路径经过的点
	public static void disPath(int start, int end) {
		// 通过path 从 end 倒着找到 start

		// 栈存储结果，因为是倒寻
		Stack<Integer> stack = new Stack<>();
		stack.push(end);
		// 上一个节点
		int prePoint = path[end];
		while (prePoint != start) {
			stack.push(prePoint);
			prePoint = path[prePoint];
		}
		// 先输出起点
		System.out.print(start);
		while (!stack.isEmpty()) {
			System.out.print("," + stack.pop());
		}
	}

	static class Road {
		// 终点
		int end;
		// 路长
		int len;

		public Road(int end, int len) {
			super();
			this.end = end;
			this.len = len;
		}

	}

	public static void main(String[] args) {
		// 城市所有数
		int cityNum = 7;
		// 开始的城市
		int start = 1;
		// 终点的城市
		int end = 7;

		// 初始化辅助数组
		waitingSort = new int[] { 7, 6, 5, 3, 4, 2 };
		distance = new int[cityNum + 1];
		hasPath = new int[cityNum + 1];
		listRoad = new HashMap<Integer, List<Road>>();
		path = new int[cityNum + 1];

		// 城市1的所有道路
		ArrayList<Road> listTo1 = new ArrayList<>();
		listTo1.add(new Road(2, 4));
		listTo1.add(new Road(3, 6));
		listTo1.add(new Road(4, 6));

		// 城市2的所有道路
		ArrayList<Road> listTo2 = new ArrayList<>();
		listTo2.add(new Road(3, 1));
		listTo2.add(new Road(5, 7));

		// 城市3的所有道路
		ArrayList<Road> listTo3 = new ArrayList<>();
		listTo3.add(new Road(5, 6));
		listTo3.add(new Road(6, 4));

		// 城市4的所有道路
		ArrayList<Road> listTo4 = new ArrayList<>();
		listTo4.add(new Road(3, 2));
		listTo4.add(new Road(6, 5));

		// 城市5的所有道路
		ArrayList<Road> listTo5 = new ArrayList<>();
		listTo5.add(new Road(7, 6));

		// 城市6的所有道路
		ArrayList<Road> listTo6 = new ArrayList<>();
		listTo6.add(new Road(5, 1));
		listTo6.add(new Road(7, 8));

		listRoad.put(1, listTo1);
		listRoad.put(2, listTo2);
		listRoad.put(3, listTo3);
		listRoad.put(4, listTo4);
		listRoad.put(5, listTo5);
		listRoad.put(6, listTo6);

		dijkstra(start, end, cityNum);
	}
}
