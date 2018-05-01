package offer;

/**
 * 17.�������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
 * @author Cavielee
 *
 */
public class HasSubtree {

	static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public boolean hasSubtree(TreeNode root1,TreeNode root2) {
		/*
		 *  ��root1Ϊnullʱ����֤��������A������������B
		 *  ��root2Ϊnullʱ�� ��Ϊ�涨�����������ӽṹ
		 */
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean result = false;
        if (root1.val == root2.val) {
        	// ��ʱ�ҵ���ͬ�ĸ��ڵ㣬�ж������Ϊ���ڵ��Ƿ����tree2
            result = isSubtree(root1,root2);
            // ���Ϊtrue���������A����B
            if (result)
                return result;
            
        }
        // ����Ҳ��������ȴ���������ʼ��
        result = hasSubtree(root1.left, root2);
        // ��������Ҳ����������������ʼ��
        if (!result)
        	result = hasSubtree(root1.right, root2);
        return result;
        
    }
    public boolean isSubtree(TreeNode root1,TreeNode root2){
    	// ���root2Ϊnull��������Ѿ����ϽԷ���
        if (root2 == null) {
            return true;
        }
        // ��ʱ����root2��Ϊnull�����root1Ϊnull����֤��������
        if (root1 == null) {
            return false;
        }
        // ���ֵ����ͬ�������������
        if (root1.val != root2.val) {
            return false;
        } else {
        	// ��ͬ�������жϸýڵ���ӽڵ��Ƿ���ͬ
           return isSubtree(root1.left,root2.left) && isSubtree(root1.right,root2.right);
        }
        
    }
	public static void main(String[] args) {
		TreeNode t1_1 = new TreeNode(8);
		TreeNode t1_2 = new TreeNode(8);
		TreeNode t1_3 = new TreeNode(7);
		TreeNode t1_4 = new TreeNode(9);
		TreeNode t1_5 = new TreeNode(2);
		TreeNode t1_6 = new TreeNode(4);
		t1_1.left = t1_2;
		t1_1.right = t1_3;
		t1_2.left = t1_4;
		t1_2.right = t1_5;
		t1_5.left = t1_6;
		
		
		TreeNode t2_1 = new TreeNode(8);
		TreeNode t2_2 = new TreeNode(9);
		TreeNode t2_3 = new TreeNode(2);
		
		t2_1.left = t2_2;
		t2_1.right = t2_3;
		
		new HasSubtree().hasSubtree(t1_1, t2_1);

	}

}
