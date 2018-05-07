package offer;

/**
 * 25.克隆链表（输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空,并要求原链表不能变动）
 * 思路：三步式
 * 第一步复制节点
 * 第二步复制random值
 * 第三步拆分链表
 * @author Cavielee
 *
 */
public class Clone {

	static class RandomListNode {
		int label;
		RandomListNode next = null;
		RandomListNode random = null;

		RandomListNode(int label) {
			this.label = label;
		}
	}

	public RandomListNode clone(RandomListNode pHead) {
		if (pHead == null) {
			return null;
		}
		// 第一个节点
		RandomListNode p = pHead;
		RandomListNode r = pHead;
		// 复制新节点
		while (p != null) {
			RandomListNode newNode = new RandomListNode(p.label);
			newNode.next = p.next;
			// 添加新节点到原节点后
			p.next = newNode;
			// 往后移
			p = newNode.next;
		}
		// 初始化random值
		while (r != null) {
			// 如果原节点有随机值，则该克隆节点指向随机值的下一个值（随机值的克隆节点）
			if (r.random != null)
				r.next.random = r.random.next;
			// 玩后移
			r = r.next.next;
		}
		// 拆分链表
		// 第一个复制的节点
		RandomListNode pClone = pHead.next;
		while (pHead != null) {
			RandomListNode pHeadClone = pHead.next;
			pHead.next = pHeadClone.next;
			// 如果不为最后一个节点
			if (pHead.next != null)
				pHeadClone.next = pHeadClone.next.next;
			pHead = pHead.next;

		}
		return pClone;
	}

	public static void main(String[] args) {
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		RandomListNode node4 = new RandomListNode(4);
		RandomListNode node5 = new RandomListNode(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		node1.random = node3;
		node2.random = node1;
		node3.random = node4;
		node4.random = node2;

		new Clone().clone(node1);
	}

}
