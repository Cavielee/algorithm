package algorithm;

/**
 * 队列
 * @author Cavielee
 *
 * @param <Item>
 */
public class Queue<Item> {

	// 当前存储数量
	private int N = 0;

	// 头节点
	private Node top;

	// 尾节点
	private Node last;

	// 节点对象
	private class Node {
		Item item;
		Node next;
	}

	// 压栈
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

	// 弹栈
	public Item pop() {
		Item i = top.item;
		top = top.next;
		N--;
		return i;
	}

	// 判断是否为空
	public boolean isEmpty() {
		return N == 0;
	}

	// 存储数量
	public int size() {
		return N;
	}
}
