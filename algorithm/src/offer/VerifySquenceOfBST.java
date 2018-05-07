package offer;

/**
 * 23.给出一个数组序列，判断是否可以建立一个二叉搜索树（BST，左子树左右节点比根节点小，右子树所有节点比根节点大）
 * @author Cavielee
 *
 */
public class VerifySquenceOfBST {

	public boolean verifySquenceOfBST(int[] sequence) {
		if (sequence.length == 0) {
			return false;
		} else {
			return isBST(sequence, 0, sequence.length - 1);
		}
	}

	// 判断是否为BST（二叉搜索树）
	public boolean isBST(int[] sequence, int start, int end) {
		if (end <= start) {
			return true;
		} else {
			int i = start;
			// 找出右子树第一个节点（比根节点大的）
			while (sequence[i] < sequence[end]) {
				i++;
			}
			// 判断右树是否都大于根节点
			for (int j = i; j < end; j++) {
				if (sequence[j] < sequence[end])
					return false;
			}
			
			// 继续判断左子树和右子树是否为BST
			return isBST(sequence, start, i - 1) && isBST(sequence, i, end - 1);
		}
	}

	public static void main(String[] args) {
		int[] sequence = new int[] { 4,8,6,12,16,14,10 };
		new VerifySquenceOfBST().verifySquenceOfBST(sequence);
	}

}
