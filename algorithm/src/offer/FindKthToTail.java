package offer;

import java.util.ArrayList;

/**
 * 14.Ѱ����������n���ڵ�
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
	 * ����
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
	 * ���Ž�
	 * ͨ������ָ��
	 * ��һ��ָ�����ƶ�k-1���ڵ�
	 * Ȼ�������ڵ�ͬʱ�����ƶ���ֱ����һ���ڵ�ָ��β�ڵ�
	 * ��һ�͵ڶ���ָ�����k����ʵ���˵�����k���ڵ��Ҫ��
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode findKthToTail_2(ListNode head, int k) {
		// ͷָ��Ϊ�պ�kС�ڵ���0
		if (head == null || k <= 0) {
			return null;
		}
		ListNode first = head;
		ListNode second = head;
		// ���õ�һ��ָ���ƶ�k-1��λ�ã����ƶ���first.nextΪnull��֤��k������������
		for (int i = 1; i < k; i++) {
			if (first.next != null) {
				first = first.next;
			} else {
				return null;
			}
		}
		// ����ָ��ͬʱ�ƶ���ֱ����һ��ָ��ָ��β�ڵ�
		while (first.next != null) {
			first = first.next;
			second = second.next;
		}
		return second;
	}

}

