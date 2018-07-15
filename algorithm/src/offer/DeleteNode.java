package offer;

/**
 * 13.O(1)ʱ����ɾ������ڵ�
 * @author Cavielee
 *
 */
public class DeleteNode {

	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int n) {
			this.val = n;
		}
	}

	public static ListNode deleteNode(ListNode headNode, ListNode deleteNode) {
		// ����Ϊ�ջ���ɾ���Ľڵ�Ϊ��
		if (headNode == null || deleteNode == null) {
			return null;
		}
		// ����ֻ��һ���ڵ�,��ɾ�����Ǹ�Ψһ�ڵ�
		else if (headNode.next == null && headNode == deleteNode) {
			return null;
		}
		// �������ֹһ���ڵ㣬��ɾ���Ĳ���β�ڵ㣬��ɾ���ڵ㸴�Ƴ���һ�ڵ�
		else if (headNode.next != null && deleteNode.next != null) {
			deleteNode.val = deleteNode.next.val;
			deleteNode.next = deleteNode.next.next;
			return headNode;
		}

		// �������ֹһ���ڵ㣬��ɾ������β�ڵ㣬˳�����ɾ���ڵ��ǰһ�ڵ㣬���Ѹýڵ�next��Ϊnull
		else {
			ListNode preDeleteNode = headNode;
			while (preDeleteNode.next != deleteNode) {
				preDeleteNode = preDeleteNode.next;
			}
			preDeleteNode.next = null;
			return headNode;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode tail = new ListNode(3);
		head.next = second;
		second.next = tail;
		
		head = deleteNode(head, second);
		System.out.println(head);
	}

}
