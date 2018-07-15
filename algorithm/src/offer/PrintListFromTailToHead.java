package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * ����һ��������β��ͷ��ӡ����ÿ���ڵ��ֵ��
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
	 * ͨ���ݹ�ķ�ʽʵ�ִ��������һ��Ԫ����ǰ��ӵ�ArrayList�� ����
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
	 * ��������ջ�����ԣ��Ƚ����
	 * ����
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
	 * ͨ��LinkedList��addFirst()��ʵ�ַ�ת��ӽڵ㣬������ʹ��ArrayList������
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
