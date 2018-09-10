package onlineTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 范围合并问题，给出多个范围区间，输出最终的合并后的区间。
 * @author CavieLee
 *
 */
public class MergeRange {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// 编辑数量m
		long m = Long.parseLong(in.nextLine());

		// 二叉树快速搜索,用于存放start值
		TreeSet<Long> tree = new TreeSet<>();
		// 用map存储结果
		HashMap<Long, Long> map = new HashMap<Long, Long>();

		// 每个编辑的错误
		for (int i = 0; i < m; i++) {
			String line = in.nextLine();
			// 分割成每个区间
			String[] range = line.split(";");
			// 范围的每个数
			for (int j = 0; j < range.length; j++) {
				String[] number = range[j].split(",");
				long start = Long.parseLong(number[0]);
				long end = Long.parseLong(number[1]);
				// 判断是否有变动
				boolean flag = false;

				// 找到存在范围小的，并进行判断是否需要修改
				Long lowerStart_start = tree.lower(start);
				if (lowerStart_start != null) {
					// 获得point的end
					Long lowerEnd = map.get(lowerStart_start);
					// 如果当前起点小于等于lowerEnd
					if (start <= lowerEnd) {
						// 两个范围是交集关系
						if (end > lowerEnd) {
							// 把lowerEnd更新为当前end
							map.replace(lowerStart_start, end);

							flag = true;
						} else { // 两个范围是包含关系
							// 因为在已有区间内，不需要改动
							flag = true;
						}
					}
				}

				// 如果有修改，则判断修改后的是否出现右边界是否已经在map中作为左边界
				if (flag) {
					if (tree.contains(end)) {
						// 合并两个范围区间
						map.replace(lowerStart_start, map.get(end));
						tree.remove(end);
						map.remove(end);
					}
				}
				// 判断map中是否有比当前范围右边界小的区间，且要大于lowerStart_start
				while (tree.lower(end) != lowerStart_start) {
					// 找到一个起点比end小的
					Long lowerStart_end = tree.lower(end);

					// map中存在区间是当前区间的子集，去掉子集
					if (map.get(lowerStart_end) <= end) {
						tree.remove(lowerStart_end);
						map.remove(lowerStart_end);
					} else {
						// map中存在区间与当前区间的交集，更新范围
						Long lowerEnd_end = map.get(lowerStart_end);
						// 替换掉higherStart
						tree.remove(lowerStart_end);
						tree.add(start);
						map.remove(lowerStart_end);
						map.putIfAbsent(start, lowerEnd_end);

						flag = true;
						break;
					}
				}
				
				// 对原来没有任何修改，是新的范围
				if (!flag) {
					tree.add(start);
					map.putIfAbsent(start, end);
				}
			}
		}

		// 输出结果
		Set set = map.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Entry entry = (Entry) iterator.next();
			if (iterator.hasNext()) {
				System.out.print(entry.getKey() + "," + entry.getValue() + ";");
			} else {
				System.out.print(entry.getKey() + "," + entry.getValue());
			}
		}
	}

}
