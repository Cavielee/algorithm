package algorithm;

/**
 * ���鼯
 * @author Cavielee
 *
 */
public class UF {
	// ʹ�� id ��������������ͨ��Ϣ
	private int[] id;

	public UF(int N) {
		id = new int[N];
		// ��ʼ�����ÿ��Ԫ��Ĭ�����Ϊ���±�ֵ
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

//	/**
//	 * find(p)����p������ union(p,q)����p��q���Ȳ���p��q����� ��������ͬ���ʾ������
//	 * �������ͬ���������Ϊp��q������Ԫ��ȫ����Ϊ��һ�������� 
//	 * �ŵ������ײ����������Ƿ������ӣ�ͬһ���
//	 * ȱ���������ͬһ�������Ҫ�����������������һ��������ĵ�ȫ����Ϊ��һ��������
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
	 * ͨ��������ʽ�����Ҹõ�ĸ��ڵ㣨���ֵ�����±�ֵ��
	 * @param p
	 * @return
	 */
	 public int find(int p) {
	 while (p != id[p])
	 p = id[p];
	 return p;
	 }
	
	 /**
	 * ͨ���Ƚ�������ĸ��ڵ��Ƿ���ͬ
	 * ��ͬ���ʾ������
	 * ����ͬ������һ��������ָ����һ������±꣨��ʱ��������ͬһ������·���ϣ�
	 * �ŵ㲻��Ҫֱ�Ӱ����ֵ��ͬ�������Ƿ����ӣ�����ͨ���жϵ�ĸ�·�����ж�
	 * ȱ����Ҹ�·��ʱ�������ĸ߳�����
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
