package onlineTest;

import java.util.Scanner;

/**
 * �ַ���ȥ��
 * û��AC
 * ���룺����Ͱ���Ҫ�˿���Ҫ�˿���������˿�����˿�
 * ���������Ͱ���Ҫ�˿���������˿�
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
