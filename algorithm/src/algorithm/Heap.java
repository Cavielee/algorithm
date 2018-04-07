package algorithm;

/**
 * ��������ȫ�����������ڵ���������ӽڵ㣨k����2k�����Һ��ӵ�2k+1
 * Ϊ�˷�����ʾ����ȡ�����1�±꿪ʼ�洢��
 * @author Cavielee
 *
 * @param <Item>
 */
public class Heap<Item extends Comparable<Item>> {

	private Item[] a;
	private int N = 0;

	/**
	 * ��Ϊ������1�±꿪ʼ�洢��������������Ӧ��ΪmaxN+1
	 * @param maxN
	 */
	public Heap(int maxN) {
		a = (Item[]) new Comparable[maxN + 1];
	}

	/**
	 * �ж��Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty() {
		return N == 0;
	}

	/**
	 * �жϴ洢Ԫ�صĸ���
	 * @return
	 */
	public int size() {
		return N;
	}

	/**
	 * �Ƚ�i��j�±��Ԫ��ֵ��С
	 * @param i
	 * @param j
	 * @return
	 */
	private boolean less(int i, int j) {
		return a[i].compareTo(a[j]) < 0;
	}

	/**
	 * ����i��j�±��Ԫ��
	 * @param i
	 * @param j
	 */
	private void exch(int i, int j) {
		Item t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	/**
	 * �ϸ�
	 * ��k�±��Ԫ���븸�ڵ�Ƚϣ�k/2��������ڸ��ڵ����ϸ�
	 * @param k
	 */
	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k / 2, k);
			k = k / 2;
		}
	}

	/**
	 * �³�
	 * ���ж�k�ڵ��Ƿ����ӽڵ�(2k<=N)
	 * ���ӽڵ����ȱȽ������ӽڵ��С��jָ��ϴ���ӽڵ�
	 * Ȼ��ѽϴ���ӽڵ��븸�ڵ�Ƚϣ�����ӽڵ�ϴ��򸸽ڵ���ýڵ㽻��
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
	 * ����Ԫ�أ������ڵ�ǰԪ�ص���һ����λ
	 * Ȼ�󽫸�Ԫ�ؽ����ϸ�
	 * @param v
	 */
	public void insert(Item v) {
		a[++N] = v;
		swim(N);
	}

	/**
	 * ɾ�����Ԫ�أ��ѵ�һ������������һ��Ԫ�ؽ���
	 * Ȼ������һ��Ԫ����Ϊnull
	 * �ٰѵ�һ��Ԫ�ؽ����³�
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
	 * ������
	 * 1���ȴ����һ���ڵ�ĸ��ڵ㿪ʼ�³���ͨ���³����Լ����˶�Ҷ�ӽڵ�ıȽϣ�������ϸ�����Ч��
	 * Ȼ�������������³���ֱ�����ڵ㣬ʹ�ø��ڵ�Ϊ���ڵ�
	 * 2�������Ԫ�أ���һ���������һ��Ԫ�ص�����N--
	 * �ѵ�һ��Ԫ���³���ȷ����һ��Ԫ��������
	 * ÿһ��ѭ����ȷ�����һ���ǵ�ǰ�����Ԫ�أ�ѭ��N-1�������������������
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
