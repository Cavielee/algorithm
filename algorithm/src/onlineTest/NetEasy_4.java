package onlineTest;

import java.util.Scanner;

/**
 * �ҷ�������
 * ��ʼΪ����Ȼ�󾭹�turnTime��ת��ÿ�ο���ѡ����ת����ת��
 * ������շ���
 * ˼·��
 * ��ʼ�Ƕ�Ϊ0
 * ��ת-90�ȣ���ת+90��
 * ͨ���ж����սǶ�ȷ������
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
