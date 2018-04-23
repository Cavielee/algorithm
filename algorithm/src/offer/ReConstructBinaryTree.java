package offer;

import algorithm.TreeNode;

/**
 * 4.
 * 给出前序和中序，重建出二叉树
 * 递归思想，每次将左右两颗子树当成新的子树进行处理 
 * 中序的左右子树索引很好找 
 * 前序的开始结束索引通过计算中序中左右子树的大小来计算
 * 然后递归求解，直到startPre>endPre||startIn>endIn
 * startPre>endPre代表在前序中左子树已经遍历完，startIn>endIn代表中序中左子树遍历完
 * 只要其中一个序中左子树遍历完了就跳出遍历右子树
 * 说明子树整理完到 
 * 方法每次返回左子树或右子树的根节点
 * 
 * @author Cavielee
 *
 */
public class ReConstructBinaryTree {

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
		return root;
	}

	private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

		if (startPre > endPre || startIn > endIn)
			return null;
		TreeNode root = new TreeNode(pre[startPre]);

		for (int i = startIn; i <= endIn; i++)
			if (in[i] == pre[startPre]) {
				root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
				root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
				break;
			}
		return root;
	}

	public static void main(String[] args) {
		ReConstructBinaryTree reTree = new ReConstructBinaryTree();
		int[] pre = new int[] { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] in = new int[] { 7, 4, 2, 1, 5, 3, 8, 6 };
		TreeNode root = reTree.reConstructBinaryTree(pre, in);

	}

}
