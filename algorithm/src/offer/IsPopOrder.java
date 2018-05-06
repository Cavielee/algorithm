package offer;

import java.util.Stack;

/**
 * 21������һ��ѹջ���кͳ�ջ���У��жϳ�ջ�����Ƿ��ܳɹ�����ע�⣺���������еĳ�������ȵģ�
 * @author Cavielee
 *
 */
public class IsPopOrder {
	/*
	 * ����
	 */
	public boolean isPopOrder(int[] pushA, int[] popA) {
		int maxIndex = popA[0];
		boolean isMax = false;
		for (int i = 0; i < popA.length; i++) {
			boolean isExist = false;
			// �ж��Ƿ����
			for (int k = 0; k < pushA.length; k++) {
				if (popA[i] == pushA[k])
					isExist = true;
			}
			if (!isExist)
				return false;
			// �ж��Ƿ������
			if (isMax) {
				for (int j = i + 1; j < popA.length; j++) {
					if (popA[i] < popA[j])
						return false;
				}
			} else {
				// �ж��Ƿ�Ϊ���ֵ
				if (popA[i] != pushA.length) {
					// С�ڵ�ǰ���ֵmaxIndex��ֻ��ΪmaxIndex-1������Ϊfalse
					if (popA[i] < maxIndex) {
						if (popA[i] != popA[i] - 1)
							return false;
					} else if (popA[i] > maxIndex) {
						// ����maxIndex��Ѹ�ֵ���Ϊ��ǰ���ֵ
						maxIndex = popA[i];
					}
				} else {
					// �޸ı��isMaxΪtrue
					isMax = true;
				}
			}

		}
		return true;
	}
	
	/*
	 * ���Ž�
	 * ͨ������ջʵ��
	 * 
	 */
	public boolean isPopOrder_1(int [] pushA,int [] popA) {
		if(pushA.length == 0 || popA.length == 0)
            return false;
		// ����ջ
		Stack<Integer> s = new Stack<Integer>();
		// ��¼��ǰpopAִ�е���һ���±�
		int popIndex = 0;
		for (int i = 0; i < pushA.length; i++) {
			s.push(pushA[i]);
			/*
			 *  �����ǰջ�ﻹ��Ԫ��
			 *  ���жϸ���ջջ��Ԫ���Ƿ�͵�ǰpopAִ�е����±��Ӧ��Ԫ�����
			 *  ���������ʾҪ��ջ����������popIndex������һ��
			 */
			while(!s.empty() && s.peek() == popA[popIndex]) {
				s.pop();
				popIndex++;
			}
		}
		// �жϸ���ջ�Ƿ�Ϊ�գ�Ϊ����ѹջ�ͳ�ջ˳����ϣ�
		return s.empty();
	}

	public static void main(String[] args) {
		int[] pushA = new int[] { 1, 2, 3, 4, 5 };
		int[] popA = new int[] { 3, 5, 4, 2, 1 };
		new IsPopOrder().isPopOrder_1(pushA, popA);
	}

}
