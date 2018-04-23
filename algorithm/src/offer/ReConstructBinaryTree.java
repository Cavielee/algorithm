package offer;

import algorithm.TreeNode;

/**
 * 4.
 * ����ǰ��������ؽ���������
 * �ݹ�˼�룬ÿ�ν������������������µ��������д��� 
 * ������������������ܺ��� 
 * ǰ��Ŀ�ʼ��������ͨ���������������������Ĵ�С������
 * Ȼ��ݹ���⣬ֱ��startPre>endPre||startIn>endIn
 * startPre>endPre������ǰ�����������Ѿ������꣬startIn>endIn����������������������
 * ֻҪ����һ�������������������˾���������������
 * ˵�����������굽 
 * ����ÿ�η������������������ĸ��ڵ�
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
