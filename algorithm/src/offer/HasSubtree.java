package offer;

/**
 * 17.输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
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
		 *  当root1为null时，这证明遍历完A都不存在子树B
		 *  当root2为null时， 因为规定空树不属于子结构
		 */
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean result = false;
        if (root1.val == root2.val) {
        	// 此时找到相同的根节点，判断以这个为根节点是否包含tree2
            result = isSubtree(root1,root2);
            // 如果为true则表明含有A含有B
            if (result)
                return result;
            
        }
        // 如果找不到，则先从左子树开始找
        result = hasSubtree(root1.left, root2);
        // 如果还是找不到，则从右子树开始找
        if (!result)
        	result = hasSubtree(root1.right, root2);
        return result;
        
    }
    public boolean isSubtree(TreeNode root1,TreeNode root2){
    	// 如果root2为null，则表明已经以上皆符合
        if (root2 == null) {
            return true;
        }
        // 此时表明root2不为null，如果root1为null，则证明不包含
        if (root1 == null) {
            return false;
        }
        // 如果值不相同，则表明不包含
        if (root1.val != root2.val) {
            return false;
        } else {
        	// 相同，继续判断该节点的子节点是否相同
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
