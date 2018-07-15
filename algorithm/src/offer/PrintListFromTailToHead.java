package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * 
 * @author Cavielee
 *
 */
public class PrintListFromTailToHead {

	private class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	/**
	 * 通过递归的方式实现从链表最后一个元素往前添加到ArrayList中 正解
	 */
	private static ArrayList<Integer> list;

	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		if (listNode == null) {
			list = new ArrayList<Integer>();
		} else {
			printListFromTailToHead(listNode.next);
			list.add(listNode.val);
		}
		return list;
	}

	/**
	 * 可以利用栈的特性，先进后出
	 * 正解
	 */
	public static ArrayList<Integer> printListFromTailToHead_1(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		while (listNode != null) {
			s.push(listNode.val);
			listNode = listNode.next;
		}
		while (!s.empty()) {
			list.add(s.pop());
		}
		return list;
	}

	/**
	 * 通过LinkedList的addFirst()来实现反转添加节点，并最终使用ArrayList来返回
	 * 
	 */
	public static ArrayList<Integer> printListFromTailToHead_2(ListNode listNode) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		if (listNode != null) {
			do {
				ll.addFirst(listNode.val);
				listNode = listNode.next;
			} while (listNode != null);

		}
		ArrayList<Integer> list = new ArrayList<Integer>(ll);
		return list;

	}
}
