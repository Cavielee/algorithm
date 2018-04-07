package algorithm;

/**
 * 加权快速并查集
 * @author Cavielee
 *
 */
public class WeightedQuickUnionUF {
	private int[] id;
	// 保存节点的数量信息
	private int[] sz;

	/**
	 * 初始化组别和权（以其为根节点的树含有多少个节点），默认组别为下标值，权都为1
	 * @param N
	 */
	public WeightedQuickUnionUF(int N) {
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public int find(int p) {
		while (p != id[p])
			p = id[p];
		return p;
	}

	/**
	 * 如果权比较小，则把权小的树直接连接到权大的树的根节点，这样节减少高度，方便查找根节点
	 * @param p
	 * @param q
	 */
	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j)
			return;
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
	}
}
