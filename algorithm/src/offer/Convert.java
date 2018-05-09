package offer;

/**
 * 26.将二叉搜索树转换成双向链表
 * 思路：
 * 通过中序遍历
 * 先遍历左子树，后根节点，再右子树一直递归下去
 * left代表上一个节点，right代表下一个节点
 * 最终返回leftNode（有左子树的情况下），否则返回根节点（无左子树，根节点即为链表第一个）
 * @author Cavielee
 *
 */
public class Convert {
	static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}
	}

	public TreeNode convert(TreeNode pRootOfTree) {

		// right=next,left=pre
		if (pRootOfTree == null) {
			return null;
		}
		// 当为叶子节点时，结束递归
		if (pRootOfTree.left == null && pRootOfTree.right == null) {
			// 返回叶子节点
			return pRootOfTree;
		}
		// 遍历左子树
		TreeNode leftNode = convert(pRootOfTree.left);
		// 通过对temp的操作而不会影响leftNode（双向链表的第一个节点）
		TreeNode temp = leftNode;

		while (temp != null && temp.right != null) {
			temp = temp.right;
		}
		// 此时pRootOfTree为根节点，应当接在链表最后一个后面
		if (leftNode != null) {
			temp.right = pRootOfTree;
			pRootOfTree.left = temp;
		}

		// 遍历右子树
		TreeNode rightNode = convert(pRootOfTree.right);

		// 将右子树接在根节点后
		if (rightNode != null) {
			pRootOfTree.right = rightNode;
			rightNode.left = pRootOfTree;
		}
		// 判断是否有左子树，如果没有则链表第一个节点为根节点
		return leftNode != null ? leftNode : pRootOfTree;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(8);
		TreeNode n2 = new TreeNode(6);
		TreeNode n3 = new TreeNode(5);
		TreeNode n4 = new TreeNode(7);
		TreeNode n5 = new TreeNode(1);
		TreeNode n6 = new TreeNode(10);
		TreeNode n7 = new TreeNode(9);

		n1.left = n2;
		n1.right = n6;
		n2.left = n3;
		n2.right = n4;
		n3.left = n5;
		n6.left = n7;

		new Convert().convert(n1);

	}

}
