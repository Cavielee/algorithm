package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Dijkstra {

	// ɢ�б��洢������Ϣ��
	private static Map<Integer, List<Road>> listRoad;
	// ������ڵ�
	private static int[] waitingSort;

	// �ж�Դ�ڵ㵽Ŀ��ڵ��Ƿ��ҵ���̾��루0Ϊû�У�1Ϊ�У�
	private static int[] hasPath;

	// ����Դ�㵽Ŀ��ڵ�Ŀǰ��̾���
	private static int[] distance;

	// ������㵽Ŀ�궥�����·�������Ѿ����㣨���Ϊ0��û���ܵ���ģ�
	private static int[] path;

	// Dijkstra���������·��
	public static void dijkstra(int start, int end, int cityNum) {

		// ���start == end
		if (start == end) {
			System.out.println(0);
			System.out.println("·����" + start);
			return;
		}
		// ������û�����ڵĵ�ֱ�ӷ���
		if (listRoad.get(start) == null) {
			System.out.println(-1);
			return;
		}

		// ��̾���
		int minDistance;
		// �м�ڵ�
		int midCity = 0;
		// ��ʼ��
		for (int i = 0; i < listRoad.get(start).size(); i++) {
			// ��ʼ�������
			Road road = listRoad.get(start).get(i);
			distance[road.end] = road.len;

			// ��ʼ�� path
			path[road.end] = start;
		}
		// ��hasPath[start]Ҳ��Ϊ1
		hasPath[start] = 1;

		// ��waitingSort��������нڵ�������Ϊ��������¾���
		for (int i = 0; i < waitingSort.length; i++) {
			minDistance = Integer.MAX_VALUE;

			// ѡȡ����hasPath ���Ҿ�����С����Ķ���
			for (int j = 1; j < distance.length; j++) {
				if (hasPath[j] == 0 && distance[j] != 0 && distance[j] < minDistance) {
					midCity = j;
					minDistance = distance[j];
				}
			}
			// �Ѿ�ΪԴ�㵽Ŀ��ڵ�midCity����̾���
			hasPath[midCity] = 1;
			// �ж�midCity �Ƿ������ڵ�
			if (listRoad.get(midCity) != null) {
				// midCity �ڵ���Ϊ�м�㣬�޸�Դ�㵽waitingSort �и����ڵ�ľ���
				for (int j = 0; j < listRoad.get(midCity).size(); j++) {
					Road road = listRoad.get(midCity).get(j);
					// �ж�֮ǰ�Ƿ���·�� road.end �ڵ�
					if (hasPath[road.end] == 0) {
						// �� waitingSort[i] ��Ϊ�м�㵽 waitingSort[i]���ڵĵ�ľ���
						int newDistance = distance[midCity] + road.len;

						// ����µ�������ڵ�
						if (distance[road.end] == 0) {
							distance[road.end] = newDistance;
							path[road.end] = midCity;
						} else if (newDistance < distance[road.end]) {
							// newDistance �����ֱ�ӵ� road.end �����,�����
							distance[road.end] = newDistance;
							path[road.end] = midCity;
						}
					}
				}
			}
		}

		// ���Դ�㵽�յ�����̾���ʱ����������룬���򷵻�-1
		if (hasPath[end] == 0) {
			System.out.println(-1);
			return;
		} else {
			System.out.println(distance[end]);
			// ���·��
			disPath(start, end);
			return;
		}

	}

	// չʾstart �� end �����·�������ĵ�
	public static void disPath(int start, int end) {
		// ͨ��path �� end �����ҵ� start

		// ջ�洢�������Ϊ�ǵ�Ѱ
		Stack<Integer> stack = new Stack<>();
		stack.push(end);
		// ��һ���ڵ�
		int prePoint = path[end];
		while (prePoint != start) {
			stack.push(prePoint);
			prePoint = path[prePoint];
		}
		// ��������
		System.out.print(start);
		while (!stack.isEmpty()) {
			System.out.print("," + stack.pop());
		}
	}

	static class Road {
		// �յ�
		int end;
		// ·��
		int len;

		public Road(int end, int len) {
			super();
			this.end = end;
			this.len = len;
		}

	}

	public static void main(String[] args) {
		// ����������
		int cityNum = 7;
		// ��ʼ�ĳ���
		int start = 1;
		// �յ�ĳ���
		int end = 7;

		// ��ʼ����������
		waitingSort = new int[] { 7, 6, 5, 3, 4, 2 };
		distance = new int[cityNum + 1];
		hasPath = new int[cityNum + 1];
		listRoad = new HashMap<Integer, List<Road>>();
		path = new int[cityNum + 1];

		// ����1�����е�·
		ArrayList<Road> listTo1 = new ArrayList<>();
		listTo1.add(new Road(2, 4));
		listTo1.add(new Road(3, 6));
		listTo1.add(new Road(4, 6));

		// ����2�����е�·
		ArrayList<Road> listTo2 = new ArrayList<>();
		listTo2.add(new Road(3, 1));
		listTo2.add(new Road(5, 7));

		// ����3�����е�·
		ArrayList<Road> listTo3 = new ArrayList<>();
		listTo3.add(new Road(5, 6));
		listTo3.add(new Road(6, 4));

		// ����4�����е�·
		ArrayList<Road> listTo4 = new ArrayList<>();
		listTo4.add(new Road(3, 2));
		listTo4.add(new Road(6, 5));

		// ����5�����е�·
		ArrayList<Road> listTo5 = new ArrayList<>();
		listTo5.add(new Road(7, 6));

		// ����6�����е�·
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
