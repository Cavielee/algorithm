package offer;

/**
 * 15.��ת����
 * ˼·����Ҫ��¼�����ڵ�
 * ��ǰ�����ڵ�(current)����һ���ڵ�(pre)����һ���ڵ�(temp)
 * ����reverseHead����ת�������ͷ��㣩
 * @author Cavielee
 *
 */
public class ReverseList {

	class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
	public ListNode reverseList(ListNode head) {
		ListNode current = head;
		ListNode pre = null;
		ListNode temp;
		ListNode reverseHead = null;
		
		// �������Ľڵ㲻Ϊ��ʱ
		while (current != null) {
			// ��¼��һ���ڵ�
			temp = current.next;
			// �ѵ�ǰ�ڵ㷴ת
			current.next = pre;
			// ����һ�ڵ�Ϊnullʱ����˽ڵ�Ϊβ�ڵ㣬��ʱ���������Ѿ���ת��ɣ���ǰ�ڵ㼴Ϊ��ת����ͷ���
			if (temp == null) {
				reverseHead = current;
			}
			// �޸�ǰһ���ڵ�
			pre = current;
			// ��ǰ�ڵ��Ƶ���һ�ڵ�
			current = temp;
		}
		return reverseHead;
	}
}

