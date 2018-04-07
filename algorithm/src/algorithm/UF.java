package algorithm;

/**
 * 并查集
 * @author Cavielee
 *
 */
public class UF {
	// 使用 id 数组来保存点的连通信息
	private int[] id;

	public UF(int N) {
		id = new int[N];
		// 初始化组别，每个元素默认组别为其下标值
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

//	/**
//	 * find(p)查找p点的组别 union(p,q)联合p和q，先查找p和q的组别 如果组别相同则表示已连接
//	 * 如果不相同则把数组中为p或q的组别的元素全都改为另一个点的组别 
//	 * 优点是容易查找两个点是否已连接（同一组别）
//	 * 缺点如果不是同一个组别，则要遍历整个数组把其中一个点的组别的点全都改为另一个点的组别。
//	 */
//	public int find(int p) {
//		return id[p];
//	}
//
//	public void union(int p, int q) {
//		int pID = find(p);
//		int qID = find(q);
//
//		if (pID == qID)
//			return;
//		for (int i = 0; i < id.length; i++) {
//			if (id[i] == pID)
//				id[i] = qID;
//		}
//	}

	 /**
	 * 通过树的形式，查找该点的根节点（组别值等于下标值）
	 * @param p
	 * @return
	 */
	 public int find(int p) {
	 while (p != id[p])
	 p = id[p];
	 return p;
	 }
	
	 /**
	 * 通过比较两个点的根节点是否相同
	 * 相同则表示相连接
	 * 不相同则其中一个点的组别指向另一个点的下标（此时两点则在同一树的条路径上）
	 * 优点不需要直接把组别值相同来区分是否连接，而是通过判断点的根路径来判断
	 * 缺点查找根路径时，与树的高成正比
	 * @param p
	 * @param q
	 */
	 public void union(int p, int q) {
	 int pRoot = find(p);
	 int qRoot = find(q);
	 if (pRoot == qRoot) return;
	 id[pRoot] = qRoot;
	 }
}
