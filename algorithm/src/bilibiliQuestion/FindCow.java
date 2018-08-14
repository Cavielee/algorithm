package bilibiliQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * ũ��ץţ���⣨���ѣ� ũ���ʼ��Ϊx��ţ��y����ţ�����ߡ������ڵ���ڵ�����֮��Ĺ�ϵ�����ܲ���ץ��ţ��
 * 
 * @author CavieLee
 *
 */
public class FindCow {

	// ���е�·��Ϣ
	private static Map<Integer, List<Integer>> listRoad;
	// �������
	private static boolean[] mark;

	public static void bfs(int start, int end, int pointNum) {
		// ��������
		Queue<Integer> que = new LinkedList<>();

		// �ѳ�ʼ�ڵ�ѹ�����
		que.offer(start);
		// ��ǳ�ʼ
		mark[start] = true;
		// ����ÿһ��
		while (!que.isEmpty()) {
			int size = que.size();

			for (int i = 0; i < size; i++) {
				int currentPoint = que.poll();

				// �ж��Ƿ��յ�
				if (currentPoint == end) {
					System.out.println("�ɵ���");
					return;
				}

				// ��ǰ�ڵ�ɵ����·
				List<Integer> list = listRoad.get(currentPoint);

				// �ж��Ƿ���·����
				if (list != null) {
					for (int j = 0; j < list.size(); j++) {
						int nextPoint = list.get(j);
						// �ж��Ƿ���ʹ�
						if (!mark[nextPoint]) {
							// �������
							que.offer(nextPoint);
							// ������߹�
							mark[nextPoint] = true;
						}
					}
				}

			}
		}
		System.out.println(-1);
	}

	public static void main(String[] args) {
		// �ڵ���
		int pointNum = 7;
		// ��ʼ�Ľڵ�
		int start = 3;
		// ţ�Ľڵ�
		int end = 5;

		// ·���ֲ����飬list�洢�±�Ľڵ�����е�·��Ϣ
		listRoad = new HashMap<>();
		// �ڵ�0�����е�·
		List<Integer> listTo0 = new ArrayList<>();
		listTo0.add(1);

		// �ڵ�1�����е�·
		List<Integer> listTo1 = new ArrayList<>();
		listTo1.add(0);
		listTo1.add(1);

		// �ڵ�2�����е�·
		List<Integer> listTo2 = new ArrayList<>();
		listTo2.add(1);
		listTo2.add(3);
		listTo2.add(4);

		// �ڵ�3�����е�·
		List<Integer> listTo3 = new ArrayList<>();
		listTo3.add(2);
		listTo3.add(4);
		listTo3.add(6);

		// �ڵ�4�����е�·
		List<Integer> listTo4 = new ArrayList<>();
		listTo4.add(3);
		listTo4.add(5);

		// �ڵ�5�����е�·
		List<Integer> listTo5 = new ArrayList<>();
		listTo5.add(4);
		listTo5.add(6);

		// �ڵ�6�����е�·
		List<Integer> listTo6 = new ArrayList<>();
		listTo6.add(5);

		listRoad.put(0, listTo0);
		listRoad.put(1, listTo1);
		listRoad.put(2, listTo2);
		listRoad.put(3, listTo3);
		listRoad.put(4, listTo4);
		listRoad.put(5, listTo5);
		listRoad.put(6, listTo6);

		// ��ʼ��mark����
		mark = new boolean[pointNum];

		// �������
		bfs(start, end, pointNum);

	}
}
