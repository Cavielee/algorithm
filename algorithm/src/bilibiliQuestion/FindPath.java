package bilibiliQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ���������·�����е����У����г��ȣ��������Ƶ����·������
 * 
 * @author CavieLee
 *
 */
public class FindPath {
	// ���е�·��Ϣ
	private static Map<Integer, List<Road>> listRoad;
	// �������
	private static boolean[] mark;
	// �������·������(��ǰ��֧���ó����������·��)
	private static int[][] minLenMark;

	// ���·��
	private static int minLen = Integer.MAX_VALUE;

	// �������
	public static void dfs(int start, int end, int hasMoney, int totalCost, int totalLen) {

		// �ж��Ƿ񵽴��յ�
		if (start == end) {
			minLen = minLen < totalLen ? minLen : totalLen;
			return;
		}
		// ������ǰ��֧������·��
		for (int i = 0; i < listRoad.get(start).size(); i++) {
			// ��ǰ��·��Ϣ
			Road currentRoad = listRoad.get(start).get(i);
			// �жϵ�ǰ·���Ƿ��߹�
			if (!mark[currentRoad.end]) {
				// ��ǰ����
				totalCost += currentRoad.cost;
				// ��ǰ·��
				totalLen += currentRoad.len;
				// �жϵ�ǰ�����Ƿ񳬹�ӵ�е�Ǯ
				if (totalCost <= hasMoney) {
					// �жϸõ�·�����Ƿ񳬹���С����
					if (totalLen < minLen) {
						// �Ƿ񳬹���ǰ��֧���ó����������·��
						if (minLenMark[currentRoad.end][hasMoney] == 0
								|| totalLen <= minLenMark[currentRoad.end][hasMoney]) {
							minLenMark[currentRoad.end][hasMoney] = totalLen;
							mark[currentRoad.end] = true;
							dfs(currentRoad.end, end, hasMoney, totalCost, totalLen);
						}
					}
				}
				// ����״̬
				mark[currentRoad.end] = false;
				totalCost -= currentRoad.cost;
				totalLen -= currentRoad.len;
			}

		}

	}

	static class Point {
		// �յ�
		int start;
		// ����
		int totalCost;
		// ·��
		int totalLen;

		public Point(int start, int totalCost, int totalLen) {
			super();
			this.start = start;
			this.totalCost = totalCost;
			this.totalLen = totalLen;
		}
	}

	static class Road {
		// �յ�
		int end;
		// ����
		int cost;
		// ·��
		int len;

		public Road(int end, int cost, int len) {
			super();
			this.end = end;
			this.cost = cost;
			this.len = len;
		}

	}

	public static void main(String[] args) {
		// ӵ�еĽ�Ǯ
		int hasMoney = 1000;
		// ����������
		int cityNum = 4;
		// ��ʼ�ĳ���
		int start = 0;
		// �յ�ĳ���
		int end = 3;

		// ·���ֲ����飬list�洢�±�ĳ��е����е�·��Ϣ
		listRoad = new HashMap<Integer, List<Road>>();
		// ����0�����е�·
		List<Road> listTo0 = new ArrayList<>();
		listTo0.add(new Road(1, 100, 100));
		listTo0.add(new Road(2, 100, 100));
		listTo0.add(new Road(3, 1100, 100));

		// ����1�����е�·
		List<Road> listTo1 = new ArrayList<>();
		listTo1.add(new Road(2, 100, 100));

		// ����2�����е�·
		List<Road> listTo2 = new ArrayList<>();
		listTo2.add(new Road(3, 100, 100));

		listRoad.put(0,listTo0);
		listRoad.put(1,listTo1);
		listRoad.put(2,listTo2);

		// ��ʼ��mark����
		mark = new boolean[cityNum];

		// ��ʼ���������·������(��ǰ��֧���ó����������·��)
		minLenMark = new int[mark.length][10000];

		// �������
		dfs(start, end, hasMoney, 0, 0);

		// �ж��Ƿ���·����ͨstart-end
		if (minLen == Integer.MAX_VALUE) {
			// û�����-1
			System.out.println(-1);
		} else {
			// ����������·��
			System.out.println(minLen);
		}
	}
}
