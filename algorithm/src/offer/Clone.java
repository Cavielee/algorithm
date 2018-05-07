package offer;

/**
 * 25.��¡�������������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿ�,��Ҫ��ԭ�����ܱ䶯��
 * ˼·������ʽ
 * ��һ�����ƽڵ�
 * �ڶ�������randomֵ
 * �������������
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
		// ��һ���ڵ�
		RandomListNode p = pHead;
		RandomListNode r = pHead;
		// �����½ڵ�
		while (p != null) {
			RandomListNode newNode = new RandomListNode(p.label);
			newNode.next = p.next;
			// ����½ڵ㵽ԭ�ڵ��
			p.next = newNode;
			// ������
			p = newNode.next;
		}
		// ��ʼ��randomֵ
		while (r != null) {
			// ���ԭ�ڵ������ֵ����ÿ�¡�ڵ�ָ�����ֵ����һ��ֵ�����ֵ�Ŀ�¡�ڵ㣩
			if (r.random != null)
				r.next.random = r.random.next;
			// �����
			r = r.next.next;
		}
		// �������
		// ��һ�����ƵĽڵ�
		RandomListNode pClone = pHead.next;
		while (pHead != null) {
			RandomListNode pHeadClone = pHead.next;
			pHead.next = pHeadClone.next;
			// �����Ϊ���һ���ڵ�
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
