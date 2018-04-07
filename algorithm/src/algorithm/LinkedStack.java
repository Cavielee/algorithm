package algorithm;

/**
 * ���������ջ
 * @author Cavielee
 *
 * @param <Item>
 */
public class LinkedStack<Item> {

	// ��ǰ�洢����
	private int N = 0;

	// ͷ���
	private Node top;

	// �ڵ����
	private class Node {
		Item item;
		Node next;
	}

	// ѹջ
	public void push(Item i) {
		Node newTop = new Node();
		newTop.item = i;
		newTop.next = top;
		top = newTop;
		N++;
	}

	// ��ջ
	public Item pop() {
		Item i = top.item;
		top = top.next;
		N--;
		return i;
	}

	// �Ƿ�Ϊ��
	public boolean isEmpty() {
		return N == 0;
	}

	// ����
	public int size() {
		return N;
	}

}
