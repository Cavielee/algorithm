package offer;

/**
 * 13.O(1)时间内删除链表节点
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
		// 链表为空或者删除的节点为空
		if (headNode == null || deleteNode == null) {
			return null;
		}
		// 链表只有一个节点,且删除的是该唯一节点
		else if (headNode.next == null && headNode == deleteNode) {
			return null;
		}
		// 如果链表不止一个节点，且删除的不是尾节点，把删除节点复制成下一节点
		else if (headNode.next != null && deleteNode.next != null) {
			deleteNode.val = deleteNode.next.val;
			deleteNode.next = deleteNode.next.next;
			return headNode;
		}

		// 如果链表不止一个节点，且删除的是尾节点，顺序查找删除节点的前一节点，并把该节点next设为null
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
