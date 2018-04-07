package algorithm;

/**
 * 由于是完全二叉树，父节点序号是左孩子节点（k）的2k，是右孩子的2k+1
 * 为了方便演示，采取数组从1下标开始存储。
 * @author Cavielee
 *
 * @param <Item>
 */
public class Heap<Item extends Comparable<Item>> {

	private Item[] a;
	private int N = 0;

	/**
	 * 因为从数组1下标开始存储，所以数组容量应该为maxN+1
	 * @param maxN
	 */
	public Heap(int maxN) {
		a = (Item[]) new Comparable[maxN + 1];
	}

	/**
	 * 判断是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return N == 0;
	}

	/**
	 * 判断存储元素的个数
	 * @return
	 */
	public int size() {
		return N;
	}

	/**
	 * 比较i和j下标的元素值大小
	 * @param i
	 * @param j
	 * @return
	 */
	private boolean less(int i, int j) {
		return a[i].compareTo(a[j]) < 0;
	}

	/**
	 * 交换i和j下标的元素
	 * @param i
	 * @param j
	 */
	private void exch(int i, int j) {
		Item t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	/**
	 * 上浮
	 * 把k下标的元素与父节点比较（k/2）如果大于父节点则上浮
	 * @param k
	 */
	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k / 2, k);
			k = k / 2;
		}
	}

	/**
	 * 下沉
	 * 先判断k节点是否有子节点(2k<=N)
	 * 有子节点则先比较左右子节点大小，j指向较大的子节点
	 * 然后把较大的子节点与父节点比较，如果子节点较大，则父节点与该节点交换
	 * @param k
	 */
	private void sink(int k) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && less(j, j + 1))
				j++;
			if (!less(k, j))
				break;
			exch(k, j);
			k = j;
		}
	}
	private void sink(int k , int N) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && less(j, j + 1))
				j++;
			if (!less(k, j))
				break;
			exch(k, j);
			k = j;
		}
	}

	/**
	 * 插入元素，插入在当前元素的下一个空位
	 * 然后将该元素进行上浮
	 * @param v
	 */
	public void insert(Item v) {
		a[++N] = v;
		swim(N);
	}

	/**
	 * 删除最大元素，把第一个（最大）与最后一个元素交换
	 * 然后把最后一个元素置为null
	 * 再把第一个元素进行下沉
	 * @return
	 */
	public Item delMax() {
		Item max = a[1];
		exch(1, N--);
		a[N + 1] = null;
		sink(1);
		return max;
	}
	
	/**
	 * 堆排序
	 * 1、先从最后一个节点的父节点开始下沉（通过下沉可以减少了对叶子节点的比较，相对于上浮更高效）
	 * 然后从右往左进行下沉，直至根节点，使得根节点为最大节点
	 * 2、把最大元素（第一个）与最后一个元素调换，N--
	 * 把第一个元素下沉，确保第一个元素是最大的
	 * 每一次循环都确保最后一个是当前的最大元素，循环N-1次是整个数组递增排序
	 * @param a
	 */
	public void sort(){
		int N = this.N;
	    for(int k = N/2; k >= 1; k--){
	        sink(k, N);
	    }
	    while(N > 1){
	        exch(1, N--);
	        sink(1, N);
	    }
	}

}
