package offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * ����һ��������β��ͷ��ӡ����ÿ���ڵ��ֵ��
 * @author Cavielee
 *
 */
public class PrintListFromTailToHead {

	private class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	/**
	 * ͨ��LinkedList��addFirst()��ʵ�ַ�ת��ӽڵ㣬������ʹ��ArrayList������
	 * @param listNode
	 * @return
	 */
	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		if (listNode != null) {
			do {
				ll.addFirst(listNode.val);
				listNode = listNode.next;
			} while (listNode != null);

		}
		ArrayList<Integer> list = new ArrayList<Integer>(ll);
		return list;

	}
	/**
	 * ͨ���ݹ�ķ�ʽʵ�ִ��������һ��Ԫ����ǰ��ӵ�ArrayList��
	 */
//	ArrayList<Integer> arrayList = new ArrayList<Integer>();
//
//	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//		if(listNode!=null){
//			this.printListFromTailToHead(listNode.next);
//			arrayList.add(listNode.val);
//		}
//		return arrayList;
//	}
}
