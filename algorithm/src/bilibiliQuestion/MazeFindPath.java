package bilibiliQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * Ѱ·����
 * 
 * @author CavieLee
 *
 */
public class MazeFindPath {
	// ������������
	public static final int[][] DirectionArray = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	// ȡ�㹻�����
	public static int minStep;
	// �������飬��������Ƿ��߹�
	public static int[][] markMap;

	// �������·��
	public static void search(int[][] map, Index current, Index end, int currentStep) {
		// ��ǰ·���Ƿ����С·����
		if (currentStep > minStep) {
			return;
		}
		// ��ǰ�ڵ�Ϊ�յ㣬�жϸ���·���Ƿ�����·����
		if (current.equals(end)) {
			minStep = minStep > currentStep ? currentStep : minStep;
			return;
		}

		// ��Ч�㣬�ж��ĸ�����
		for (int i = 0; i < DirectionArray.length; i++) {

			// ��һ��λ��
			Index newIndex = new Index(current.x + DirectionArray[i][0], current.y + DirectionArray[i][1]);

			// �ж���һ��λ���Ƿ���Ч��Ҫ������ڸ����� && ( û�п�Ƭ&&û���߹� || ��һ��Ϊ�յ� &&�п�Ƭ )
			if (((newIndex.x > -1) && (newIndex.y > -1) && (newIndex.x < map[0].length) && (newIndex.y < map.length))
					&& (map[newIndex.y][newIndex.x] == 0 && markMap[newIndex.y][newIndex.x] == 0)
					|| (newIndex.equals(end) && map[newIndex.y][newIndex.x] == 1)) {
				// ����µ�λ�����߹�
				markMap[newIndex.y][newIndex.x] = 1;
				// ������
				search(map, newIndex, end, currentStep + 1);
				// ����
				markMap[newIndex.y][newIndex.x] = 0;
			}

		}

	}

	// �������·�����ģ���������ı���step��+1
	public static void search_1(int[][] map, Index current, Index end, int currentStep, int direction) {
		// ��ǰ·���Ƿ����С·����
		if (currentStep > minStep) {
			return;
		}
		// ��ǰ�ڵ�Ϊ�յ㣬�жϸ���·���Ƿ�����·����
		if (current.equals(end)) {
			minStep = minStep > currentStep ? currentStep : minStep;
			return;
		}

		// ��Ч�㣬�ж��ĸ�����
		for (int i = 0; i < DirectionArray.length; i++) {

			// ��һ��λ��
			Index newIndex = new Index(current.x + DirectionArray[i][0], current.y + DirectionArray[i][1]);

			// �ж���һ��λ���Ƿ���Ч��Ҫ������ڸ����� && ( û�п�Ƭ&&û���߹� || ��һ��Ϊ�յ� &&�п�Ƭ )
			if (((newIndex.x > -1) && (newIndex.y > -1) && (newIndex.x < map[0].length) && (newIndex.y < map.length))
					&& (map[newIndex.y][newIndex.x] == 0 && markMap[newIndex.y][newIndex.x] == 0)
					|| (newIndex.equals(end) && map[newIndex.y][newIndex.x] == 1)) {
				// ����µ�λ�����߹�
				markMap[newIndex.y][newIndex.x] = 1;
				// ������
				if (i == direction) {
					// ������ͬ
					search_1(map, newIndex, end, currentStep, i);
				} else {
					// ����ͬ
					search_1(map, newIndex, end, currentStep + 1, i);
				}
				// ����
				markMap[newIndex.y][newIndex.x] = 0;
			}

		}

	}

	public static void main(String[] args) {

		// �У�x��
		int w = 5;
		// �У�y��
		int h = 4;
		int[][] map = new int[][] { { 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 1, 1, 0 }, { 0, 1, 0, 0, 0, 1, 0 },
				{ 0, 1, 1, 1, 0, 1, 0 }, { 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };

		// ���
		List<String> results = new ArrayList<>();
		// ����
		List<Sample> samples = new ArrayList<>();

		// ����������������п�Ƭ
		samples.add(new Sample(new Index(2, 3), new Index(5, 3)));
		samples.add(new Sample(new Index(1, 3), new Index(4, 4)));
		samples.add(new Sample(new Index(2, 3), new Index(3, 4)));

		// ��������
		for (int i = 0; i < samples.size(); i++) {
			minStep = 10000;
			markMap = new int[h + 2][w + 2];
			search_1(map, samples.get(i).indexA, samples.get(i).IndexB, 0, -1);

			if (minStep < 10000) {
				results.add("Pair " + i + ":" + minStep + " Step");
			} else {
				results.add("Pair " + i + ":" + " impossible");
			}
		}

		// �������
		results.forEach(result -> System.out.println(result));

	}

}

/**
 * ������
 * 
 * @author CavieLee
 *
 */
class Index {
	int x, y;

	public Index(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		return (x + "" + y).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Index) {
			Index IndexA = (Index) obj;
			return this.x == IndexA.x && this.y == IndexA.y;
		}
		return super.equals(obj);
	}

}

/**
 * ����������
 * 
 * @author CavieLee
 *
 */
class Sample {
	Index indexA, IndexB;

	public Sample(Index indexA, Index indexB) {
		super();
		this.indexA = indexA;
		IndexB = indexB;
	}

}