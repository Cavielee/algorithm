package offer;

/**
 * 15.反转链表
 * 思路：需要记录三个节点
 * 当前操作节点(current)、上一个节点(pre)、下一个节点(temp)
 * 返回reverseHead（反转后链表的头结点）
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
		
		// 当操作的节点不为空时
		while (current != null) {
			// 记录下一个节点
			temp = current.next;
			// 把当前节点反转
			current.next = pre;
			// 当下一节点为null时，则此节点为尾节点，此时整个链表已经翻转完成，当前节点即为翻转链表头结点
			if (temp == null) {
				reverseHead = current;
			}
			// 修改前一个节点
			pre = current;
			// 当前节点移到下一节点
			current = temp;
		}
		return reverseHead;
	}
}

