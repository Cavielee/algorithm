package offer;

/**
 * 23.����һ���������У��ж��Ƿ���Խ���һ��������������BST�����������ҽڵ�ȸ��ڵ�С�����������нڵ�ȸ��ڵ��
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

	// �ж��Ƿ�ΪBST��������������
	public boolean isBST(int[] sequence, int start, int end) {
		if (end <= start) {
			return true;
		} else {
			int i = start;
			// �ҳ���������һ���ڵ㣨�ȸ��ڵ��ģ�
			while (sequence[i] < sequence[end]) {
				i++;
			}
			// �ж������Ƿ񶼴��ڸ��ڵ�
			for (int j = i; j < end; j++) {
				if (sequence[j] < sequence[end])
					return false;
			}
			
			// �����ж����������������Ƿ�ΪBST
			return isBST(sequence, start, i - 1) && isBST(sequence, i, end - 1);
		}
	}

	public static void main(String[] args) {
		int[] sequence = new int[] { 4,8,6,12,16,14,10 };
		new VerifySquenceOfBST().verifySquenceOfBST(sequence);
	}

}
