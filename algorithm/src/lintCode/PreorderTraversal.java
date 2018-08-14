package lintCode;

import java.util.ArrayList;
import java.util.List;

/**
 * ��������ǰ�����
 * 
 * @author Cavielee
 *
 */
public class PreorderTraversal {

	private static List<Integer> list;

	// �ݹ鷨
	public List<Integer> preorderTraversal(TreeNode root) {
		list = new ArrayList<Integer>();
		// �ж�root�Ƿ�Ϊ��
		if (root == null) {
			return list;
		}
		Recursive(root);
		return list;

	}

	public static void Recursive(TreeNode root) {
		// ��ӵ�ǰ�ڵ㵽list��
		list.add(root.val);

		// �ж��Ƿ�ΪҶ�ӽڵ�
		if (root.left == null && root.right == null) {
			return;
		}

		// �ж��Ƿ�����ڵ�
		if (root.left != null) {
			Recursive(root.left);
		}
		// �ж��Ƿ����ҽڵ�
		if (root.right != null) {
			Recursive(root.right);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// �ڵ�
class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}