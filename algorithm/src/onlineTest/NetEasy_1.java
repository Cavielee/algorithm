package onlineTest;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * ����N�ݹ����ѶȺͶ�Ӧ����
 * ����M���˵ĸ�������
 * ƥ����������������õ�����߹����Ƕ���
 * 
 * @author Cavielee
 *
 */
public class NetEasy_1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// N��������
		int N = in.nextInt();
		// С�������
		int M = in.nextInt();
		// ��ǰ�Ѷ�
		int nowLevel = 0;
		// Ŀǰ�Ѷȷ�Χ����߹���
		int nowMaxWage = 0;
		// ���빤����treemap
		TreeMap<Integer, Integer> tree = new TreeMap<Integer, Integer>();
		for (int i = 0; i < N; i++) {
			tree.put(in.nextInt(), in.nextInt());
		}
		// ��Ϊ��treemap�����Թ����Ѷ�������ģ��ѹ����Ѷȵ�н��ȡ���Ѷȷ�Χ�����ֵ
		// ��һ����������Ϊ�Ѷ���ͣ����Ը��Ѷȷ�Χ���н�ʾ��Ǳ���
		nowLevel = tree.firstKey();
		nowMaxWage = tree.get(nowLevel);
		while (tree.higherKey(nowLevel) != null) {
			Entry<Integer, Integer> e = tree.higherEntry(nowLevel);
			nowMaxWage = Math.max(nowMaxWage, e.getValue());
			nowLevel = e.getKey();
			// ������Ѷȷ�Χ�Ĺ������ֵ
			tree.put(nowLevel, nowMaxWage);
		}
		// ��ӡС�����Ѷȷ�Χ�ܻ����ߵ�н��
		for (int k = 0; k < M; k++) {
			int people = in.nextInt();
			Entry<Integer, Integer> e = tree.floorEntry(people);
			if (e == null) {
				System.out.println(0);
			} else {
				System.out.println(e.getValue());
			}
		}
	}
}
