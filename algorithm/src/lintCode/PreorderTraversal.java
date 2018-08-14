package lintCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历
 * 
 * @author Cavielee
 *
 */
public class PreorderTraversal {

	private static List<Integer> list;

	// 递归法
	public List<Integer> preorderTraversal(TreeNode root) {
		list = new ArrayList<Integer>();
		// 判断root是否为空
		if (root == null) {
			return list;
		}
		Recursive(root);
		return list;

	}

	public static void Recursive(TreeNode root) {
		// 添加当前节点到list中
		list.add(root.val);

		// 判断是否为叶子节点
		if (root.left == null && root.right == null) {
			return;
		}

		// 判断是否有左节点
		if (root.left != null) {
			Recursive(root.left);
		}
		// 判断是否有右节点
		if (root.right != null) {
			Recursive(root.right);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// 节点
class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}