package algorithm;

/**
 * 二分查找实现有序符号表
 * 不能存在相同的key
 * 
 * @author Cavielee
 *
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
	private Key[] keys;
	private Value[] values;
	private int N;

	/**
	 * 内部维护key和value的两个数组
	 * capacity是容量
	 * @param capacity
	 */
	public BinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		values = (Value[]) new Object[capacity];
	}

	/**
	 * 当前数组有多少个元素
	 * @return
	 */
	public int size() {
		return N;
	}

	/**
	 * 同过rank（）查找该key所在的位置
	 * 如果i<N且keys[i]等于key则返回该键的value
	 * 否则则key不存在，返回null
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
	 * 通过二分查找当前key应当存放的位置
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
	 * 插入key/value
	 * 1、查找key应当存放的位置
	 * 2、判断key的位置i小于当前存放数量N，且该key值与keys[i]的值是否相同
	 * 如果符合则证明当前表已存在该key，替换该key的值
	 * 3、如果key是不存在，则将从N到i的下标的元素往右移
	 * 然后把key/value复制到i下标处
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
	 * 返回一个比该key等于或者大于(当key不存在时)的key
	 * @param key
	 * @return
	 */
	public Key ceiling(Key key) {
		int i = rank(key);
		return keys[i];
	}
}
