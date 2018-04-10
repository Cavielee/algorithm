package onlineTest;

import java.util.Scanner;
/**
 * 题目：给出两个字符串a和b
 * 求b插入到a中不同位置形成的新的字符串是不是回文串
 * 
 * 思路：暴力法
 * 把b插入到a字符串的每个位置（通过该位置的a左子串+b串+该位置a的右子串）形成新串
 * 然后把新串与该新串反转比较，相同则是回文串
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
