package offer;

/**
 * 16.�ϲ�������������������ʹ�µ�����Ϊ�������ݼ���
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
	 * �ǵݹ鷨
	 * ˼·��
	 * list1��list2ָ��ǰ�̲߳����Ľڵ�
	 * megerHeadΪ�ϲ����µ�����ͷ���
	 * currentΪ�ϲ��µ�����ǰ�ϲ����Ľڵ�
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
				// �ж��Ƿ�Ϊһ��ʼ
				if (megerHead == null) {
					megerHead = current = list1;

				} else { // ����һ��ʼ�����޸ĺϲ��µ�����ǰ�ϲ����Ľڵ�
					current.next = list1;
					current = list1;
				}
				// ����1������
				list1 = list1.next;
			} else {
				// �ж��Ƿ�Ϊһ��ʼ
				if (megerHead == null) {
					megerHead = current = list2;
				} else { // ����һ��ʼ�����޸ĺϲ��µ�����ǰ�ϲ����Ľڵ�
					current.next = list2;
					current = list2;
				}
				// ����2������
				list2 = list2.next;
			}
		}
		// �ж���һ��������ʣ�µģ�ֱ�Ӻϲ����µ��������
		if (list1 == null) {
			current.next = list2;
		}
		if (list2 == null) {
			current.next = list1;
		}

		return megerHead;
	}
	/*
	 * �ݹ鷨
	 * ÿһ��ѡ�����������е�ǰ��С�Ľڵ㣬����ʣ�µĵݹ������С�ӵ�ǰһ��
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
