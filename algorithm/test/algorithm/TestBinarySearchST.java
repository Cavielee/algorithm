package algorithm;

import org.junit.Test;

public class TestBinarySearchST {

	@Test
	public void testBinarySearchST() {
		BinarySearchST<Integer, Integer> bst = new BinarySearchST<>(10);
		bst.put(7, 10);
		bst.put(7, 9);
		bst.put(12, 4);
		bst.put(10, 10);
		bst.put(1, 9);
		bst.put(5, 20);
		System.out.println(bst.get(7));
		System.out.println(bst.ceiling(2));
	}

}
