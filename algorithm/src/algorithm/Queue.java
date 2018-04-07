package algorithm;

/**
 * ����
 * @author Cavielee
 *
 * @param <Item>
 */
public class Queue<Item> {

	// ��ǰ�洢����
	private int N = 0;

	// ͷ�ڵ�
	private Node top;

	// β�ڵ�
	private Node last;

	// �ڵ����
	private class Node {
		Item item;
		Node next;
	}

	// ѹջ
	public void push(Item i) {
		Node newNode = new Node();
		newNode.item = i;
		newNode.next = null;
		if (this.isEmpty()) {
			top = newNode;
			last = newNode;
		} else {
			last.next = newNode;
			last = newNode;
		}
		N++;
	}

	// ��ջ
	public Item pop() {
		Item i = top.item;
		top = top.next;
		N--;
		return i;
	}

	// �ж��Ƿ�Ϊ��
	public boolean isEmpty() {
		return N == 0;
	}

	// �洢����
	public int size() {
		return N;
	}
}
