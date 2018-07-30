package bilibiliQuestion;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 青蛙问题
 * 叙述：给定一组坐标（x和y）表示青蛙踩踏的稻田
 * 求踩踏的稻田路线的最大跳数（至少三棵以上才算一条路径）
 * 
 * 方案：可以通过枚举的方式，通过一个点判断其余所有点是否为该路线的其中一个值（超时）
 * 实际方法：通过枚举坐标中的两两点，以这两个点的步径去判断是否有其他点在坐标中，并获得路径跳数
 * 
 * 优化：
 * ① 先对坐标进行排序，使得每一次获得第一个点都是第一个点。
 * ② 判断以该步径取的第一个点是否为青蛙跳的第一个点
 * ③ 判断用当前最大跳数-1 * 步径是否跳出稻田，跳出则不可能获得更大跳数
 * @author Cavielee
 *
 */
public class FrogJumpPath {

	public static int solution(ArrayList<Plant> list, int row, int col) {
		int maxSteps = 0;
		// 判断map是否为空或map的元素是否小于两个
		if (list == null || list.size() < 3) {
			return maxSteps;
		}
		// 对list进行排序
		Collections.sort(list, (Plant point1, Plant point2) -> (point1.x - point2.x) == 0 ? (point1.y - point2.y)
				: (point1.x - point2.x));
		// 枚举两个走过的点作为步长
		for (int i = 0; i < list.size() - 1; i++) {
			Plant point1 = list.get(i);
			for (int j = i + 1; j < list.size(); j++) {
				Plant point2 = list.get(j);
				// 获取两个点的距离
				int dx = point2.x - point1.x;
				int dy = point2.y - point1.y;
				// 判断point1是否为第一个点，不是则不继续判断
				if (point1.x - dx > 0 && point1.y - dy > 0) {
					continue;
				} else if ((point1.x + (maxSteps - 1) * dx) > col || (point1.y + (maxSteps - 1) * dy) > row) {
					// 判断经过(maxStep - 1)跳 * 步径是否跳出稻田，是则不继续
					continue;
				} else { // 判断是否有该步长的点
					int steps = 1;
					Plant temp;
					try {
						temp = (Plant) point1.clone();
						while ((temp.x + dx) <= col && (temp.y + dy) <= row && (temp.x + dx) > 0 && (temp.y + dy) > 0) {
							temp.x = temp.x + dx;
							temp.y = temp.y + dy;
							// 如果该步径下有一步没有踩到水稻则不是一条行走路径
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
