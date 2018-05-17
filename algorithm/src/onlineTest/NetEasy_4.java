package onlineTest;

import java.util.Scanner;

/**
 * 找方向问题
 * 初始为北，然后经过turnTime次转向（每次可以选择左转或右转）
 * 输出最终方向
 * 思路：
 * 初始角度为0
 * 左转-90度，右转+90度
 * 通过判断最终角度确定方向。
 * @author Cavielee
 *
 */
public class NetEasy_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int turnTime = sc.nextInt();
		int angle = 0;
		String direction = sc.next();
		for (int i = 0; i < turnTime; i++) {
			if (direction.charAt(i) == 'L') {
				angle -= 90;
			} else {
				angle += 90;
			}
		}
		angle = angle % 360;
		if (angle < 0) {
			angle += 360;
		}
		if (angle == 90) {
			System.out.println("E");
		} else if (angle == 180) {
			System.out.println("S");
		} else if (angle == 270) {
			System.out.println("W");
		} else {
			System.out.println("N");
		}
	}

}
