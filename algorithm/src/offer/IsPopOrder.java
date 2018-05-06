package offer;

import java.util.Stack;

/**
 * 21、给出一个压栈序列和出栈序列，判断出栈序列是否能成功。（注意：这两个序列的长度是相等的）
 * @author Cavielee
 *
 */
public class IsPopOrder {
	/*
	 * 正解
	 */
	public boolean isPopOrder(int[] pushA, int[] popA) {
		int maxIndex = popA[0];
		boolean isMax = false;
		for (int i = 0; i < popA.length; i++) {
			boolean isExist = false;
			// 判断是否存在
			for (int k = 0; k < pushA.length; k++) {
				if (popA[i] == pushA[k])
					isExist = true;
			}
			if (!isExist)
				return false;
			// 判断是否到最大序
			if (isMax) {
				for (int j = i + 1; j < popA.length; j++) {
					if (popA[i] < popA[j])
						return false;
				}
			} else {
				// 判断是否为最大值
				if (popA[i] != pushA.length) {
					// 小于当前最大值maxIndex则只能为maxIndex-1，否则为false
					if (popA[i] < maxIndex) {
						if (popA[i] != popA[i] - 1)
							return false;
					} else if (popA[i] > maxIndex) {
						// 大于maxIndex则把该值标记为当前最大值
						maxIndex = popA[i];
					}
				} else {
					// 修改标记isMax为true
					isMax = true;
				}
			}

		}
		return true;
	}
	
	/*
	 * 最优解
	 * 通过辅助栈实现
	 * 
	 */
	public boolean isPopOrder_1(int [] pushA,int [] popA) {
		if(pushA.length == 0 || popA.length == 0)
            return false;
		// 辅助栈
		Stack<Integer> s = new Stack<Integer>();
		// 记录当前popA执行到哪一个下标
		int popIndex = 0;
		for (int i = 0; i < pushA.length; i++) {
			s.push(pushA[i]);
			/*
			 *  如果当前栈里还有元素
			 *  则判断辅助栈栈顶元素是否和当前popA执行到的下标对应的元素相等
			 *  如果相等则表示要弹栈操作，并把popIndex往后移一个
			 */
			while(!s.empty() && s.peek() == popA[popIndex]) {
				s.pop();
				popIndex++;
			}
		}
		// 判断辅助栈是否为空，为空则压栈和出栈顺序符合，
		return s.empty();
	}

	public static void main(String[] args) {
		int[] pushA = new int[] { 1, 2, 3, 4, 5 };
		int[] popA = new int[] { 3, 5, 4, 2, 1 };
		new IsPopOrder().isPopOrder_1(pushA, popA);
	}

}
