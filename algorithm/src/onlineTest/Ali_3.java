package onlineTest;

import java.util.Scanner;

/**
 * ����ͰͿͷ�����Ա������n���ͷ�С�飬����ҪΪÿһ�鰲�ſͷ�24Сʱֵ�ࡣΪ�����������ÿ��ֻ��2���ͷ���һ��ֻ��Ҫ1���ͷ��ϰ࣬����һЩ�ͷ�����ĳЩԭ������ͬһ���ϰࡣ
 * 
 * �����Ѿ��Կͷ������˱�ţ���i��i>=1&&i<=n������Ŀͷ����Ϊ2*i-1��2*i������֪����m������Լ����ϵ���ͷ����a�Ϳͷ����b����һ���ϰࡣ
 * 
 * ����Ա��Ҫ���������æ�жϽ����Ƿ���ڿ��еķ�����������m��Լ����ϵ��������ÿ���鶼��1���ͷ��ϰࡣ
 * 
 * ���룺n(������n���飩
 * 
 * m(m��Լ����ϵ��������������m�� a,b(����a��b��λ�ͷ���Ų���ͬʱ�ϰ�)
 * 
 * ������ж���û�п��з�����������������no������������yes
 * 
 * @author Cavielee
 *
 */
public class Ali_3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int group = Integer.parseInt(in.nextLine().trim());
		int m = Integer.parseInt(in.nextLine().trim());

		int[][] array = new int[2 * group + 1][2 * group + 1];
		for (int i = 0; i < m; i++) {
			String line = in.nextLine().trim();
			String[] s = line.split(",");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);

			array[a][b] = 1;
			array[b][a] = 1;
		}
		for (int i = 1; i < 2 * group; i++) {
			for (int j = i + 2; j < 2 * group; j += 2) {
				if (array[i][j] == 1 && array[i][j + 1] == 1) {
					System.out.println("no");
					System.exit(1);
				}
				
			}
		}
		System.out.println("yes");
	}

}
