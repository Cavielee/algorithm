package algorithm;

import org.junit.Test;

public class TestHeap {

	@Test
	public void testHeap() {
		Heap<Integer> h = new Heap<>(10);
		h.insert(15);
		h.insert(4);
		h.insert(7);
		h.insert(20);
		h.insert(16);
		h.delMax();
	}
	
	@Test
	public void testHeapSort() {
		Heap<Integer> h = new Heap<>(10);
		h.insert(15);
		h.insert(4);
		h.insert(7);
		h.insert(20);
		h.insert(16);
		h.sort();
	}

}
