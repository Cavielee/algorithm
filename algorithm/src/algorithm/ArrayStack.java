package algorithm;

import java.util.Iterator;
/**
 * ���������ջ
 * @author Cavielee
 *
 * @param <Item>
 */
public class ArrayStack<Item> implements Iterable<Item> {

	// �ڲ�ά������һ�����飬��Ϊ���鲻���÷��ͣ�����ֻ��ͨ��ǿת����ʼ��СΪ1
	private Item[] a = (Item[]) new Object[1];

	// Nָ��ǰ����Ԫ������
	private int N = 0;

	// ����Ԫ��
	public void push(Item i) {
		// ��������Ҫ����ʱ���򰴵�ǰ��������������
		if (N >= a.length) {
			resize(2 * a.length);
		}
		a[N++] = i;
	}

	// ����Ԫ��
	public Item pop() {
		return a[--N];
	}

	// ��չ����
	private void resize(int size) {
		Item[] newArray = (Item[]) new Object[size];

		for (int i = 0; i < N; i++) {
			newArray[i] = a[i];
		}
		a = newArray;
	}

	// �ж��Ƿ�Ϊ��
	public boolean isEmpty() {
		return N == 0;
	}

	// ջ��Ԫ������
	public int size() {
		return N;
	}

	@Override
	public Iterator<Item> iterator() {
		// ��Ϊ��ջ�������Ƚ���������Է����������
		return new ReverseArrayIterator();
	}
	
	// �����������ĵ�����
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
