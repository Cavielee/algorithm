package offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 27、输入一个字符串,按字典序打印出该字符串中字符的所有排列可能。
 * @author Cavielee
 *
 */
public class Permutation {

	public ArrayList<String> permutation(String str) {
		ArrayList<String> res = new ArrayList<>();
		// 判断是否有字符
		if (str != null && str.length() > 0) {
			// 调用PermutationHelper方法对字符串排序，把可能性序列插入到res中
			PermutationHelper(str.toCharArray(), 0, res);
			// 对res集合进行排序
			Collections.sort(res);
		}
		return res;
	}

	/**
	 * cs 表示字符数组
	 * i表示当前排序到第几个字符
	 * @param cs
	 * @param i
	 * @param list
	 */
	public void PermutationHelper(char[] cs, int i, ArrayList<String> list) {
		// 当i为最后一个字符下标时，无法形成分支（即最终结果）
		if (i == cs.length - 1) {
			// val为分支结果（字符串），判断list中是否有该字符串，没有则把该字符串加入
			String val = String.valueOf(cs);
			if (!list.contains(val))
				list.add(val);
		} else {
			// 通过把i和j下标的字符交换，形成一个新的分支递归下去
			for (int j = i; j < cs.length; j++) {
				swap(cs, i, j);
				PermutationHelper(cs, i + 1, list);
				// 递归返回表示该分支已经到尽头，重新把i和j的字符交换，返回上一个分叉口走另一条路径
				swap(cs, i, j);
			}
		}
	}

	public void swap(char[] cs, int i, int j) {
		char temp = cs[i];
		cs[i] = cs[j];
		cs[j] = temp;
	}

	public static void main(String[] args) {
		new Permutation().permutation("ABC");
	}

}
