package onlineTest;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 给出N份工作难度和对应工资
 * 给出M个人的个人能力
 * 匹配出该人能力所能拿到的最高工资是多少
 * 
 * @author Cavielee
 *
 */
public class NetEasy_1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// N工作数量
		int N = in.nextInt();
		// 小伙伴数量
		int M = in.nextInt();
		// 当前难度
		int nowLevel = 0;
		// 目前难度范围的最高工资
		int nowMaxWage = 0;
		// 插入工作进treemap
		TreeMap<Integer, Integer> tree = new TreeMap<Integer, Integer>();
		for (int i = 0; i < N; i++) {
			tree.put(in.nextInt(), in.nextInt());
		}
		// 因为是treemap，所以工作难度是有序的，把工作难度的薪酬取该难度范围的最高值
		// 第一个工作，因为难度最低，所以该难度范围最高薪资就是本身
		nowLevel = tree.firstKey();
		nowMaxWage = tree.get(nowLevel);
		while (tree.higherKey(nowLevel) != null) {
			Entry<Integer, Integer> e = tree.higherEntry(nowLevel);
			nowMaxWage = Math.max(nowMaxWage, e.getValue());
			nowLevel = e.getKey();
			// 重设该难度范围的工资最高值
			tree.put(nowLevel, nowMaxWage);
		}
		// 打印小伙伴的难度范围能获得最高的薪资
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
