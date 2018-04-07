package algorithm;

import org.junit.Test;

public class TestMergeSort {

	@Test
	public void test() {
		int[] a = new int[]{9,5,1,3,7,5,4,0,8,3,11,12,13,14,15};
		MergeSort.sort(a);
	}

}
