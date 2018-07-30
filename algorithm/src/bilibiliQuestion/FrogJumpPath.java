package bilibiliQuestion;

import java.util.ArrayList;
import java.util.Collections;

/**
 * ��������
 * ����������һ�����꣨x��y����ʾ���ܲ�̤�ĵ���
 * ���̤�ĵ���·�ߵ���������������������ϲ���һ��·����
 * 
 * ����������ͨ��ö�ٵķ�ʽ��ͨ��һ�����ж��������е��Ƿ�Ϊ��·�ߵ�����һ��ֵ����ʱ��
 * ʵ�ʷ�����ͨ��ö�������е������㣬����������Ĳ���ȥ�ж��Ƿ����������������У������·������
 * 
 * �Ż���
 * �� �ȶ������������ʹ��ÿһ�λ�õ�һ���㶼�ǵ�һ���㡣
 * �� �ж��Ըò���ȡ�ĵ�һ�����Ƿ�Ϊ�������ĵ�һ����
 * �� �ж��õ�ǰ�������-1 * �����Ƿ�������������򲻿��ܻ�ø�������
 * @author Cavielee
 *
 */
public class FrogJumpPath {

	public static int solution(ArrayList<Plant> list, int row, int col) {
		int maxSteps = 0;
		// �ж�map�Ƿ�Ϊ�ջ�map��Ԫ���Ƿ�С������
		if (list == null || list.size() < 3) {
			return maxSteps;
		}
		// ��list��������
		Collections.sort(list, (Plant point1, Plant point2) -> (point1.x - point2.x) == 0 ? (point1.y - point2.y)
				: (point1.x - point2.x));
		// ö�������߹��ĵ���Ϊ����
		for (int i = 0; i < list.size() - 1; i++) {
			Plant point1 = list.get(i);
			for (int j = i + 1; j < list.size(); j++) {
				Plant point2 = list.get(j);
				// ��ȡ������ľ���
				int dx = point2.x - point1.x;
				int dy = point2.y - point1.y;
				// �ж�point1�Ƿ�Ϊ��һ���㣬�����򲻼����ж�
				if (point1.x - dx > 0 && point1.y - dy > 0) {
					continue;
				} else if ((point1.x + (maxSteps - 1) * dx) > col || (point1.y + (maxSteps - 1) * dy) > row) {
					// �жϾ���(maxStep - 1)�� * �����Ƿ�����������򲻼���
					continue;
				} else { // �ж��Ƿ��иò����ĵ�
					int steps = 1;
					Plant temp;
					try {
						temp = (Plant) point1.clone();
						while ((temp.x + dx) <= col && (temp.y + dy) <= row && (temp.x + dx) > 0 && (temp.y + dy) > 0) {
							temp.x = temp.x + dx;
							temp.y = temp.y + dy;
							// ����ò�������һ��û�вȵ�ˮ������һ������·��
							if (!list.contains(temp)) {
								steps = 0;
								break;
							}
							steps++;
						}
						if (steps > 2 && steps > maxSteps) {
							maxSteps = steps;
						}
					} catch (CloneNotSupportedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return maxSteps;
	}

	public static void main(String[] args) {
		// List
		ArrayList<Plant> list = new ArrayList<Plant>();
		list.add(new Plant(2, 1));
		list.add(new Plant(6, 6));
		list.add(new Plant(4, 2));
		list.add(new Plant(2, 5));
		list.add(new Plant(2, 6));
		list.add(new Plant(2, 7));
		list.add(new Plant(3, 4));
		list.add(new Plant(6, 2));
		list.add(new Plant(2, 3));
		list.add(new Plant(6, 3));
		list.add(new Plant(6, 4));
		list.add(new Plant(6, 5));
		list.add(new Plant(6, 7));
		list.add(new Plant(6, 1));

		System.out.println(FrogJumpPath.solution(list, 6, 7));
	}

}

class Plant implements Cloneable {
	int x, y;

	public Plant(int y, int x) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Plant) {
			Plant p = (Plant) obj;
			return x == p.x ? y == p.y : false;
		}
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return (x + "" + y).hashCode();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
