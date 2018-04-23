package offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
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
	 * 通过LinkedList的addFirst()来实现反转添加节点，并最终使用ArrayList来返回
	 * @param listNode
	 * @return
	 */
	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
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
	/**
	 * 通过递归的方式实现从链表最后一个元素往前添加到ArrayList中
	 */
//	ArrayList<Integer> arrayList = new ArrayList<Integer>();
//
//	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//		if(listNode!=null){
//			this.printListFromTailToHead(listNode.next);
//			arrayList.add(listNode.val);
//		}
//		return arrayList;
//	}
}
