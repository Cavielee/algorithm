package offer;

/**
 * 26.������������ת����˫������
 * ˼·��
 * ͨ���������
 * �ȱ���������������ڵ㣬��������һֱ�ݹ���ȥ
 * left������һ���ڵ㣬right������һ���ڵ�
 * ���շ���leftNode����������������£������򷵻ظ��ڵ㣨�������������ڵ㼴Ϊ�����һ����
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
		// ��ΪҶ�ӽڵ�ʱ�������ݹ�
		if (pRootOfTree.left == null && pRootOfTree.right == null) {
			// ����Ҷ�ӽڵ�
			return pRootOfTree;
		}
		// ����������
		TreeNode leftNode = convert(pRootOfTree.left);
		// ͨ����temp�Ĳ���������Ӱ��leftNode��˫������ĵ�һ���ڵ㣩
		TreeNode temp = leftNode;

		while (temp != null && temp.right != null) {
			temp = temp.right;
		}
		// ��ʱpRootOfTreeΪ���ڵ㣬Ӧ�������������һ������
		if (leftNode != null) {
			temp.right = pRootOfTree;
			pRootOfTree.left = temp;
		}

		// ����������
		TreeNode rightNode = convert(pRootOfTree.right);

		// �����������ڸ��ڵ��
		if (rightNode != null) {
			pRootOfTree.right = rightNode;
			rightNode.left = pRootOfTree;
		}
		// �ж��Ƿ��������������û���������һ���ڵ�Ϊ���ڵ�
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
