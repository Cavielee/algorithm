package algorithm;

/**
 * 基于链表的栈
 * @author Cavielee
 *
 * @param <Item>
 */
public class LinkedStack<Item> {

	// 当前存储数量
	private int N = 0;

	// 头结点
	private Node top;

	// 节点对象
	private class Node {
		Item item;
		Node next;
	}

	// 压栈
	public void push(Item i) {
		Node newTop = new Node();
		newTop.item = i;
		newTop.next = top;
		top = newTop;
		N++;
	}

	// 弹栈
	public Item pop() {
		Item i = top.item;
		top = top.next;
		N--;
		return i;
	}

	// 是否为空
	public boolean isEmpty() {
		return N == 0;
	}

	// 数量
	public int size() {
		return N;
	}

}
