package offer;

/**
 * 18. ��һ�������ľ���
 * ˼·���Ӹ��ڵ㿪ʼ�������ӽڵ㽻��
 * �����εݹ���ڵ����ڵ���ҽڵ�
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
