package offer;

import java.util.ArrayList;

/**
 * 24.判断二叉树的一条路径节点值和是否符合target（路径：根节点到叶子节点）
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

	// 判断每一个路径的节点值和是否符合target
	public void pa(TreeNode root, int target, ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> a1, int sum) {
		if (root == null)
			return;
		// 根节点到当前节点的和
		sum += root.val;

		// 判断是否到叶子节点
		if (root.left == null && root.right == null) {
			// 判断该路径的节点值和是否符合target
			if (sum == target) {
				// 如果是则把该节点加入a1中，此时a1为一条成立的路径并放入arr中
				a1.add(root.val);
				arr.add(new ArrayList<Integer>(a1));
				// 删除a1最后一个节点，向上返回判断另一条路径
				a1.remove(a1.size() - 1);

			}
			return;
		}

		// 添加当前值到a1中
		a1.add(root.val);
		// 左子树路径
		pa(root.left, target, arr, a1, sum);
		// 右子树路径
		pa(root.right, target, arr, a1, sum);
		// 返回上一层
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
