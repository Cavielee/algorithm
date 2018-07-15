package offer;

import java.util.Stack;

/**
 * 20.拥有求最小值函数的栈 
 * 思路：
 * 通过维护两个栈
 * 一个数据栈，用来添加和弹出数据
 * 一个辅助栈，用来记录当前最小值
 * push时，添加到数据栈，并判断添加元素和辅助栈栈顶元素大小，把较小者添加到辅助栈中
 * pop时，则同时把两个栈栈顶元素弹出
 * top返回数据栈栈顶元素
 * min返回辅助栈栈顶元素
 * 
 * @author Cavielee
 *
 */
public class StackWithMinMethod {

	// 辅助栈，用来记录最小值
	final Stack<Integer> s_min = new Stack<Integer>();
	// 数据栈，用来添加或弹出数据
	final Stack<Integer> s_data = new Stack<Integer>();

	public void push(int node) {
		s_data.push(node);
		if (s_min.empty()) {
			s_min.push(node);
		} else {
			// 辅助栈栈顶元素，即当前数据栈最小值。
			int min = s_min.peek();
			if (min > node) {
				s_min.push(node);
			} else {
				s_min.push(min);
			}
		}
	}

	public void pop() {
		s_data.pop();
		s_min.pop();
	}

	public int top() {
		return s_data.peek();
	}

	public int min() {
		return s_min.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
