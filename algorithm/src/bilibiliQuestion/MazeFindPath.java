package bilibiliQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * 寻路问题
 * 
 * @author CavieLee
 *
 */
public class MazeFindPath {
	// 方向下右上左
	public static final int[][] DirectionArray = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	// 取足够大的数
	public static int minStep;
	// 辅助数组，用来标记是否走过
	public static int[][] markMap;

	// 查找最短路径
	public static void search(int[][] map, Index current, Index end, int currentStep) {
		// 当前路径是否比最小路径大
		if (currentStep > minStep) {
			return;
		}
		// 当前节点为终点，判断该条路径是否比最短路径短
		if (current.equals(end)) {
			minStep = minStep > currentStep ? currentStep : minStep;
			return;
		}

		// 有效点，判断四个方向
		for (int i = 0; i < DirectionArray.length; i++) {

			// 下一步位置
			Index newIndex = new Index(current.x + DirectionArray[i][0], current.y + DirectionArray[i][1]);

			// 判断下一步位置是否有效，要求必须在格子内 && ( 没有卡片&&没有走过 || 下一步为终点 &&有卡片 )
			if (((newIndex.x > -1) && (newIndex.y > -1) && (newIndex.x < map[0].length) && (newIndex.y < map.length))
					&& (map[newIndex.y][newIndex.x] == 0 && markMap[newIndex.y][newIndex.x] == 0)
					|| (newIndex.equals(end) && map[newIndex.y][newIndex.x] == 1)) {
				// 标记新的位置已走过
				markMap[newIndex.y][newIndex.x] = 1;
				// 往下走
				search(map, newIndex, end, currentStep + 1);
				// 回溯
				markMap[newIndex.y][newIndex.x] = 0;
			}

		}

	}

	// 查找最短路径（改），当方向改变了step才+1
	public static void search_1(int[][] map, Index current, Index end, int currentStep, int direction) {
		// 当前路径是否比最小路径大
		if (currentStep > minStep) {
			return;
		}
		// 当前节点为终点，判断该条路径是否比最短路径短
		if (current.equals(end)) {
			minStep = minStep > currentStep ? currentStep : minStep;
			return;
		}

		// 有效点，判断四个方向
		for (int i = 0; i < DirectionArray.length; i++) {

			// 下一步位置
			Index newIndex = new Index(current.x + DirectionArray[i][0], current.y + DirectionArray[i][1]);

			// 判断下一步位置是否有效，要求必须在格子内 && ( 没有卡片&&没有走过 || 下一步为终点 &&有卡片 )
			if (((newIndex.x > -1) && (newIndex.y > -1) && (newIndex.x < map[0].length) && (newIndex.y < map.length))
					&& (map[newIndex.y][newIndex.x] == 0 && markMap[newIndex.y][newIndex.x] == 0)
					|| (newIndex.equals(end) && map[newIndex.y][newIndex.x] == 1)) {
				// 标记新的位置已走过
				markMap[newIndex.y][newIndex.x] = 1;
				// 往下走
				if (i == direction) {
					// 方向相同
					search_1(map, newIndex, end, currentStep, i);
				} else {
					// 方向不同
					search_1(map, newIndex, end, currentStep + 1, i);
				}
				// 回溯
				markMap[newIndex.y][newIndex.x] = 0;
			}

		}

	}

	public static void main(String[] args) {

		// 列（x）
		int w = 5;
		// 行（y）
		int h = 4;
		int[][] map = new int[][] { { 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 1, 1, 0 }, { 0, 1, 0, 0, 0, 1, 0 },
				{ 0, 1, 1, 1, 0, 1, 0 }, { 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };

		// 结果
		List<String> results = new ArrayList<>();
		// 样例
		List<Sample> samples = new ArrayList<>();

		// 输入参数样例必须有卡片
		samples.add(new Sample(new Index(2, 3), new Index(5, 3)));
		samples.add(new Sample(new Index(1, 3), new Index(4, 4)));
		samples.add(new Sample(new Index(2, 3), new Index(3, 4)));

		// 样例尝试
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

		// 遍历结果
		results.forEach(result -> System.out.println(result));

	}

}

/**
 * 坐标类
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
 * 测试样例类
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