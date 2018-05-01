package offer;

import java.util.ArrayList;

/**
 * 14.寻找链表倒数第n个节点
 * 
 * @author Cavielee
 *
 */
public class FindKthToTail {

	class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
	
	/**
	 * 正解
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode findKthToTail(ListNode head, int k) {

		if (head == null || k == 0) {
			return null;
		}
		ArrayList<ListNode> list = new ArrayList<ListNode>();
		do {
			list.add(head);
			head = head.next;
		} while (head != null);

		if (k > list.size()) {
			return null;
		}
		return list.get(list.size() - k);
	}

	/**
	 * 最优解
	 * 通过两个指针
	 * 第一个指针先移动k-1个节点
	 * 然后两个节点同时往后移动，直到第一个节点指到尾节点
	 * 第一和第二个指针相距k（即实现了倒数第k个节点的要求）
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode findKthToTail_2(ListNode head, int k) {
		// 头指针为空和k小于等于0
		if (head == null || k <= 0) {
			return null;
		}
		ListNode first = head;
		ListNode second = head;
		// 先让第一个指针移动k-1个位置，若移动后first.next为null则证明k超出了链表长度
		for (int i = 1; i < k; i++) {
			if (first.next != null) {
				first = first.next;
			} else {
				return null;
			}
		}
		// 两个指针同时移动，直到第一个指针指到尾节点
		while (first.next != null) {
			first = first.next;
			second = second.next;
		}
		return second;
	}

}

