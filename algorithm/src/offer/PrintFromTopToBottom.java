package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 22.将二叉树按层从左往右一次输出
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
        // 添加根节点
        queue.offer(root);
        // 确保队列是按照左孩子右孩子一次操作
        while(!queue.isEmpty()){
        	// 弹出队列第一个
            TreeNode treeNode=queue.poll();
            // 如果有左孩子，则添加左孩子进队列
            if(treeNode.left!=null){
                queue.offer(treeNode.left);
            }
            // 如果有右孩子，则添加右孩子进队列
            if(treeNode.right!=null){
                queue.offer(treeNode.right);
            }
            // 把第一个元素放入list中
            list.add(treeNode.val);
        }
        return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
