package onlineTest;

import java.util.Scanner;

/**
 * 判断一个区间[start,end]内的神奇数列能被3整除的个数
 * （例如[2,5]的神奇数列为12,123,1234,12345）
 * 规律：
 * ① 若插入的数模与3余数为0则该数列一定能被3整除
 * ② 若余数不为0，则把余数模与2，余数为0则该数还是被能被3整除
 * 通过数学归纳法可验证上述规律
 * 
 * @author Cavielee
 *
 */
public class NetEasy_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		int num = 0;
		for (int i = start; i < end + 1; i++) {
			if (i % 3 % 2 == 0) {
				num++;
			}
		}

		System.out.println(num);
	}

}
