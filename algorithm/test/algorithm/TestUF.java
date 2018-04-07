package algorithm;

import org.junit.Test;

public class TestUF {

	@Test
	public void testUF() {
		long start = System.currentTimeMillis();
		UF uf = new UF(100000000);
		uf.union(4, 3);
		uf.union(3, 8);
		uf.union(9, 4);
		uf.union(9, 7);
		uf.union(4, 2);
		uf.union(2, 1);
		uf.union(2, 1);
		uf.union(5, 0);
		uf.union(1, 0);
		uf.union(6, 7);
		uf.union(200, 3);
		uf.union(150, 7);
		uf.union(420, 7);
		uf.union(7, 12);
		uf.union(8, 45);
		uf.union(10, 1);
		System.out.println(uf.connected(3, 9));
		System.out.println(System.currentTimeMillis()-start);
	}
	
	@Test
	public void testWeightedQuickUnionUF() {
		long start = System.currentTimeMillis();
		WeightedQuickUnionUF wuf = new WeightedQuickUnionUF(10);
		wuf.union(4, 3);
		wuf.union(3, 8);
		wuf.union(9, 4);
		wuf.union(9, 7);
		wuf.union(4, 2);
		wuf.union(2, 1);
		wuf.union(2, 1);
		wuf.union(5, 0);
		wuf.union(1, 0);
		
		System.out.println(wuf.connected(3, 9));
		System.out.println(System.currentTimeMillis()-start);
	}
}
