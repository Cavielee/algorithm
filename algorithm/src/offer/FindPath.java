package offer;

import java.util.ArrayList;

/**
 * 24.�ж϶�������һ��·���ڵ�ֵ���Ƿ����target��·�������ڵ㵽Ҷ�ӽڵ㣩
 * @author Cavielee
 *
 */
public class FindPath {

	static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return arr;
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		int sum = 0;
		pa(root, target, arr, a1, sum);
		return arr;
	}

	// �ж�ÿһ��·���Ľڵ�ֵ���Ƿ����target
	public void pa(TreeNode root, int target, ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> a1, int sum) {
		if (root == null)
			return;
		// ���ڵ㵽��ǰ�ڵ�ĺ�
		sum += root.val;

		// �ж��Ƿ�Ҷ�ӽڵ�
		if (root.left == null && root.right == null) {
			// �жϸ�·���Ľڵ�ֵ���Ƿ����target
			if (sum == target) {
				// �������Ѹýڵ����a1�У���ʱa1Ϊһ��������·��������arr��
				a1.add(root.val);
				arr.add(new ArrayList<Integer>(a1));
				// ɾ��a1���һ���ڵ㣬���Ϸ����ж���һ��·��
				a1.remove(a1.size() - 1);

			}
			return;
		}

		// ��ӵ�ǰֵ��a1��
		a1.add(root.val);
		// ������·��
		pa(root.left, target, arr, a1, sum);
		// ������·��
		pa(root.right, target, arr, a1, sum);
		// ������һ��
		a1.remove(a1.size() - 1);
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(10);
		TreeNode t2 = new TreeNode(5);
		TreeNode t3 = new TreeNode(12);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(7);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		ArrayList<ArrayList<Integer>> list = new FindPath().findPath(t1, 22);
		System.out.println(list);
	}

}
