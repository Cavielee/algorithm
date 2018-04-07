package algorithm;

import java.util.Iterator;
/**
 * 基于数组的栈
 * @author Cavielee
 *
 * @param <Item>
 */
public class ArrayStack<Item> implements Iterable<Item> {

	// 内部维护的是一个数组，因为数组不能用泛型，所以只能通过强转，初始大小为1
	private Item[] a = (Item[]) new Object[1];

	// N指向当前数组元素数量
	private int N = 0;

	// 插入元素
	public void push(Item i) {
		// 当容量需要扩大时，则按当前容量的两倍扩大
		if (N >= a.length) {
			resize(2 * a.length);
		}
		a[N++] = i;
	}

	// 弹出元素
	public Item pop() {
		return a[--N];
	}

	// 扩展容量
	private void resize(int size) {
		Item[] newArray = (Item[]) new Object[size];

		for (int i = 0; i < N; i++) {
			newArray[i] = a[i];
		}
		a = newArray;
	}

	// 判断是否为空
	public boolean isEmpty() {
		return N == 0;
	}

	// 栈的元素数量
	public int size() {
		return N;
	}

	@Override
	public Iterator<Item> iterator() {
		// 因为是栈，所以先进后出，所以反向遍历数组
		return new ReverseArrayIterator();
	}
	
	// 反向遍历数组的迭代器
	private class ReverseArrayIterator implements Iterator<Item> {

		private int i = N;
		
		@Override
		public boolean hasNext() {
			return i>0;
		}

		@Override
		public Item next() {
			return a[--i];
		}
		
	}

}
