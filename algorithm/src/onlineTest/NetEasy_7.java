package onlineTest;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * 牛牛总是睡过头，所以他定了很多闹钟，只有在闹钟响的时候他才会醒过来并且决定起不起床。
 * 从他起床算起他需要X分钟到达教室，上课时间为当天的A时B分，请问他最晚可以什么时间起床
 * 
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含一个正整数，表示闹钟的数量N(N<=100)。
 * 接下来的N行每行包含两个整数，表示这个闹钟响起的时间为Hi(0<=A<24)时Mi(0<=B<60)分。
 * 接下来的一行包含一个整数，表示从起床算起他需要X(0<=X<=100)分钟到达教室。
 * 接下来的一行包含两个整数，表示上课时间为A(0<=A<24)时B(0<=B<60)分。 
 * 数据保证至少有一个闹钟可以让牛牛及时到达教室。
 * 
 * @author Cavielee
 *
 */
public class NetEasy_7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 测试用例个数
		int n = sc.nextInt();
		// 闹钟,用treeset去重和排序
		TreeSet<Integer> tree = new TreeSet<Integer>();

		for (int i = 0; i < n; i++) {
			// 时
			int hour = sc.nextInt();
			// 分，把时转为分并和分结合,并存入到数组
			tree.add(sc.nextInt() + hour * 60);
		}
		// 去教室所需时间
		int need = sc.nextInt();
		// 上课时间
		int start = sc.nextInt() * 60 + sc.nextInt();

		// 寻找小于等于start-end时间的闹钟
		int right = tree.floor(start - need);
		int min = right % 60;
		int hour = (right - min) / 60;
		System.out.println(hour + " " + min);

	}

}
