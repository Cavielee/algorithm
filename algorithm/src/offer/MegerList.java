package offer;

/**
 * 16.合并两个单调递增的链表，使新的链表为单调不递减的
 * @author Cavielee
 *
 */
public class MegerList {
	static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	/*
	 * 非递归法
	 * 思路：
	 * list1和list2指向当前线程操作的节点
	 * megerHead为合并的新的链表头结点
	 * current为合并新的链表当前合并到的节点
	 * 
	 */
	public ListNode meger(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}

		ListNode megerHead = null;
		ListNode current = null;

		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				// 判断是否为一开始
				if (megerHead == null) {
					megerHead = current = list1;

				} else { // 不是一开始，则修改合并新的链表当前合并到的节点
					current.next = list1;
					current = list1;
				}
				// 链表1往下移
				list1 = list1.next;
			} else {
				// 判断是否为一开始
				if (megerHead == null) {
					megerHead = current = list2;
				} else { // 不是一开始，则修改合并新的链表当前合并到的节点
					current.next = list2;
					current = list2;
				}
				// 链表2往下移
				list2 = list2.next;
			}
		}
		// 判断哪一个链表有剩下的，直接合并到新的链表后面
		if (list1 == null) {
			current.next = list2;
		}
		if (list2 == null) {
			current.next = list1;
		}

		return megerHead;
	}
	/*
	 * 递归法
	 * 每一次选出两个链表中当前最小的节点，并把剩下的递归再求次小接到前一个
	 * 
	 */
	public ListNode meger_1(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		
		if (list1.val <= list2.val) {
			list1.next = meger_1(list1.next, list2);
			return list1;
		} else {
			list2.next = meger_1(list1, list2.next);
			return list2;
		}
		
	}

	public static void main(String[] args) {
		ListNode l1_1 = new ListNode(1);
		ListNode l1_2 = new ListNode(3);
		ListNode l1_3 = new ListNode(7);
		l1_1.next = l1_2;
		l1_2.next = l1_3;

		ListNode l2_1 = new ListNode(4);
		ListNode l2_2 = new ListNode(6);
		ListNode l2_3 = new ListNode(8);
		l2_1.next = l2_2;
		l2_2.next = l2_3;

		new MegerList().meger(l1_1, l2_1);
	}
}
