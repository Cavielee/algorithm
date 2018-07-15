package onlineTest;

import java.util.ArrayList;
import java.util.Scanner;

public class JD {

	// public static void main(String[] args) {
	// Scanner sc = new Scanner(System.in);
	// String test = sc.nextLine();
	// int count = 0;
	// int length = test.length();
	//
	//
	// if ((length % 2) == 0) {
	// String fu = test.substring(0, length >> 1);
	// String son = new StringBuffer(test.substring(length >>
	// 1)).reverse().toString();
	// if (fu.equals(son)) {
	// count += 1;
	// }
	// }
	// // 移除的个数
	// for (int i = 0;i<length;i++) {
	// // for (int j = 0; j<length; j++) {
	// // test.
	// // }
	// }
	//
	// }

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.nextLine().trim();
		ArrayList<String> results = new ArrayList();
		int leftN = 0, rightN = 0;

		for (int i = 0; i < Integer.parseInt(a); i++) {
			String b = in.nextLine().trim();

			// 判断是否（）数量是否相等
			String[] left = b.split("\\)");
			String[] right = b.split("\\(");
			if (left.length == (right.length-1)) {
				for (int j = 0; j<b.length(); j++) {
					if (b.charAt(j) == '(' )
						leftN++;
					else
						rightN++;
					if (rightN-leftN>2) {
						results.add("No");
						break;
					}
				}
				results.add("Yes");
			}
			else
				results.add("No");
		}
		for (String result : results) {
			System.out.println(result);
		}

	}
}
