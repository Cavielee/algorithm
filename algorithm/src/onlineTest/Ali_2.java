package onlineTest;

import java.util.Scanner;

/**
 * 字符串去重
 * 没有AC
 * 输入：阿里巴巴我要退款我要退款，还不给我退款给我退款
 * 输出：阿里巴巴我要退款，还不给我退款
 * @author Cavielee
 *
 */
public class Ali_2 {

	public static String replace(String a){
		int maxLength = 0;
		int maxIndex = 0;
		for (int start = 0; start < a.length() - 3; start++) {
			for (int end = start + 2; (end - start) <= ((a.length() - start) / 2) ; end++) {
				int length = end - start;
				String b = a.substring(start, end);
				String c = a.substring(end, (end + length));
				if (b.equals(c)) {
					if (length > maxLength) {
						maxLength = length;
						maxIndex = end;
					}
					
				}
			}
			
		}
		a = a.replaceFirst(a.substring(maxIndex, maxIndex + maxLength), "");
		return a;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.nextLine().trim();
		String newString = Ali_2.replace(a);
		while(!a.equals(newString)) {
			a = newString;
			newString = Ali_2.replace(a);
		}
		System.out.println(a);
	}

}
