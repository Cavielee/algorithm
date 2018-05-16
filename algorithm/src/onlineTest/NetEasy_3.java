package onlineTest;

/**
 * 小Q正在给一条长度为n的道路设计路灯安置方案。
 * 为了让问题更简单,小Q把道路视为n个方格,需要照亮的地方用'.'表示, 不需要照亮的障碍物格子用'X'表示。
 * 小Q现在要在道路上设置一些路灯, 对于安置在pos位置的路灯, 这盏路灯可以照亮pos - 1, pos, pos + 1这三个位置。
 * 小Q希望能安置尽量少的路灯照亮所有'.'区域, 希望你能帮他计算一下最少需要多少盏路灯。
 * 
 * 思路：
 * 判断当前位置是否需要照明
 * 当为.时，则需要在隔壁放置一盏灯，该灯能确保三个格子所以往后挪3格继续判断
 * 当为X时，表明当前位置不需要照明，则往后挪1格继续判断
 * 直到判断的位置已经超过路长则输出路灯数
 */
import java.util.Scanner;

public class NetEasy_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testNum = sc.nextInt();
		int routeLength;
		String route;
		int num;
		for (int i = 0; i < testNum; i++) {
			num = 0;
			routeLength = sc.nextInt();
			route = sc.next();
			for (int j = 0; j < routeLength; j++) {
				if (route.charAt(j) == '.') {
					num++;
					j += 2;
				}
			}
			System.out.println(num);
		}
	}

}
