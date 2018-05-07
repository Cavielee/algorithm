package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 22.�������������������һ�����
 * @author Cavielee
 *
 */
public class PrintFromTopToBottom {
	static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}

	public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
		ArrayList<Integer>list=new ArrayList<Integer>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        // ��Ӹ��ڵ�
        queue.offer(root);
        // ȷ�������ǰ��������Һ���һ�β���
        while(!queue.isEmpty()){
        	// �������е�һ��
            TreeNode treeNode=queue.poll();
            // ��������ӣ���������ӽ�����
            if(treeNode.left!=null){
                queue.offer(treeNode.left);
            }
            // ������Һ��ӣ�������Һ��ӽ�����
            if(treeNode.right!=null){
                queue.offer(treeNode.right);
            }
            // �ѵ�һ��Ԫ�ط���list��
            list.add(treeNode.val);
        }
        return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
