package algorithm;

import org.junit.Test;

public class TestQuickSort {

	@Test
	public void testQuickSort() {
		int[] a = new int[]{9,5,1,3,7,5,4,0,8,3};
		QuickSort.sort(a);
	}

}
