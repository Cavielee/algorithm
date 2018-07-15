package algorithm;

public class MyLinkedList<T> {
	class Node<T> {
		Node<T> next = null;
		Node<T> pre = null;
		T val;

		public Node(T t) {
			this.val = t;
		}
	}

	Node<T> headNode = null;
	Node<T> tailNode = null;
	int N = 0;

	public void addFirst(T t) {
		if (N == 0) {
			headNode = new Node(t);
			tailNode = headNode;
		} else {
			Node newNode = new Node(t);
			newNode.pre = null;
			newNode.next = headNode;
			headNode.pre = newNode;
			headNode = newNode;
		}
		N++;
	}

	public void addLast(T t) {
		if (N == 0) {
			tailNode = new Node(t);
			headNode = headNode;
		} else {
			Node newNode = new Node(t);
			newNode.next = null;
			newNode.pre = tailNode;
			tailNode.next = newNode;
			tailNode = newNode;
		}
		N++;
	}
	public static void main(String[] args) {
		MyLinkedList<Integer> ml = new MyLinkedList<Integer>();
		ml.addFirst(9);
		ml.addFirst(8);
		ml.addFirst(7);
		ml.addFirst(6);
	}
}
