package algorithm;

/**
 * ���ֲ���ʵ��������ű�
 * ���ܴ�����ͬ��key
 * 
 * @author Cavielee
 *
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
	private Key[] keys;
	private Value[] values;
	private int N;

	/**
	 * �ڲ�ά��key��value����������
	 * capacity������
	 * @param capacity
	 */
	public BinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		values = (Value[]) new Object[capacity];
	}

	/**
	 * ��ǰ�����ж��ٸ�Ԫ��
	 * @return
	 */
	public int size() {
		return N;
	}

	/**
	 * ͬ��rank�������Ҹ�key���ڵ�λ��
	 * ���i<N��keys[i]����key�򷵻ظü���value
	 * ������key�����ڣ�����null
	 * @param key
	 * @return
	 */
	public Value get(Key key) {
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) {
			return values[i];
		}
		return null;
	}

	/**
	 * ͨ�����ֲ��ҵ�ǰkeyӦ����ŵ�λ��
	 * @param key
	 * @return
	 */
	public int rank(Key key) {
		int lo = 0, hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			if (cmp == 0)
				return mid;
			else if (cmp < 0)
				hi = mid - 1;
			else
				lo = mid + 1;
		}
		return lo;
	}

	/**
	 * ����key/value
	 * 1������keyӦ����ŵ�λ��
	 * 2���ж�key��λ��iС�ڵ�ǰ�������N���Ҹ�keyֵ��keys[i]��ֵ�Ƿ���ͬ
	 * ���������֤����ǰ���Ѵ��ڸ�key���滻��key��ֵ
	 * 3�����key�ǲ����ڣ��򽫴�N��i���±��Ԫ��������
	 * Ȼ���key/value���Ƶ�i�±괦
	 * @param key
	 * @param value
	 */
	public void put(Key key, Value value) {
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) {
			values[i] = value;
			return;
		}
		for (int j = N; j > i; j--) {
			keys[j] = keys[j - 1];
			values[j] = values[j - 1];
		}
		keys[i] = key;
		values[i] = value;
		N++;
	}

	/**
	 * ����һ���ȸ�key���ڻ��ߴ���(��key������ʱ)��key
	 * @param key
	 * @return
	 */
	public Key ceiling(Key key) {
		int i = rank(key);
		return keys[i];
	}
}
