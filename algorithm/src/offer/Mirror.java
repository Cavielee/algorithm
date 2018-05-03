package offer;

/**
 * 18. 求一二叉树的镜像
 * 思路：从根节点开始对左右子节点交换
 * 并依次递归根节点的左节点和右节点
 * @author Cavielee
 *
 */
public class Mirror {

	static class TreeNode {
		int val;
		TreeNode left = null;
		TreeNode right = null;
		
		TreeNode(int val) {
			this.val = val;
		}
	}
	
	public void mirror(TreeNode root) {
		if (root == null) {
            return;
        }
        TreeNode temp = null;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror (root.left);
        mirror (root.right);
	}
	public static void main(String[] args) {

	}

}
