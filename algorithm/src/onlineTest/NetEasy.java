package onlineTest;

import java.util.Scanner;
/**
 * ��Ŀ�����������ַ���a��b
 * ��b���뵽a�в�ͬλ���γɵ��µ��ַ����ǲ��ǻ��Ĵ�
 * 
 * ˼·��������
 * ��b���뵽a�ַ�����ÿ��λ�ã�ͨ����λ�õ�a���Ӵ�+b��+��λ��a�����Ӵ����γ��´�
 * Ȼ����´�����´���ת�Ƚϣ���ͬ���ǻ��Ĵ�
 * @author Cavielee
 *
 */
public class NetEasy {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		int count = 0;
		int length = a.length();
		StringBuilder sb;

		for (int i = 0; i <= length; i++) {
			String sona = a.substring(0, i);
			sb = new StringBuilder(sona);
			sb.append(b).append(a.substring(i));
			if (sb.toString().equals(sb.reverse().toString()))
				count++;
		}

		System.out.println(count);
	}

}
