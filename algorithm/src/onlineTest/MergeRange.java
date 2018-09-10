package onlineTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * ��Χ�ϲ����⣬���������Χ���䣬������յĺϲ�������䡣
 * @author CavieLee
 *
 */
public class MergeRange {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// �༭����m
		long m = Long.parseLong(in.nextLine());

		// ��������������,���ڴ��startֵ
		TreeSet<Long> tree = new TreeSet<>();
		// ��map�洢���
		HashMap<Long, Long> map = new HashMap<Long, Long>();

		// ÿ���༭�Ĵ���
		for (int i = 0; i < m; i++) {
			String line = in.nextLine();
			// �ָ��ÿ������
			String[] range = line.split(";");
			// ��Χ��ÿ����
			for (int j = 0; j < range.length; j++) {
				String[] number = range[j].split(",");
				long start = Long.parseLong(number[0]);
				long end = Long.parseLong(number[1]);
				// �ж��Ƿ��б䶯
				boolean flag = false;

				// �ҵ����ڷ�ΧС�ģ��������ж��Ƿ���Ҫ�޸�
				Long lowerStart_start = tree.lower(start);
				if (lowerStart_start != null) {
					// ���point��end
					Long lowerEnd = map.get(lowerStart_start);
					// �����ǰ���С�ڵ���lowerEnd
					if (start <= lowerEnd) {
						// ������Χ�ǽ�����ϵ
						if (end > lowerEnd) {
							// ��lowerEnd����Ϊ��ǰend
							map.replace(lowerStart_start, end);

							flag = true;
						} else { // ������Χ�ǰ�����ϵ
							// ��Ϊ�����������ڣ�����Ҫ�Ķ�
							flag = true;
						}
					}
				}

				// ������޸ģ����ж��޸ĺ���Ƿ�����ұ߽��Ƿ��Ѿ���map����Ϊ��߽�
				if (flag) {
					if (tree.contains(end)) {
						// �ϲ�������Χ����
						map.replace(lowerStart_start, map.get(end));
						tree.remove(end);
						map.remove(end);
					}
				}
				// �ж�map���Ƿ��бȵ�ǰ��Χ�ұ߽�С�����䣬��Ҫ����lowerStart_start
				while (tree.lower(end) != lowerStart_start) {
					// �ҵ�һ������endС��
					Long lowerStart_end = tree.lower(end);

					// map�д��������ǵ�ǰ������Ӽ���ȥ���Ӽ�
					if (map.get(lowerStart_end) <= end) {
						tree.remove(lowerStart_end);
						map.remove(lowerStart_end);
					} else {
						// map�д��������뵱ǰ����Ľ��������·�Χ
						Long lowerEnd_end = map.get(lowerStart_end);
						// �滻��higherStart
						tree.remove(lowerStart_end);
						tree.add(start);
						map.remove(lowerStart_end);
						map.putIfAbsent(start, lowerEnd_end);

						flag = true;
						break;
					}
				}
				
				// ��ԭ��û���κ��޸ģ����µķ�Χ
				if (!flag) {
					tree.add(start);
					map.putIfAbsent(start, end);
				}
			}
		}

		// ������
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
