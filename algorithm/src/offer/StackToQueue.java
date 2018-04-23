package offer;

import java.util.Stack;

/**
 * 5��ʹ������ջʵ�ֶ���
 * ˼·��
 * stack1����push��stack2����pop
 * ��Ϊpush��stack1ʱ�ǵ���
 * ͨ��pop stack1��push��stack2��ʹ��Stack2��Ϊ����ĵ��򣨼�����
 * ��stack2Ϊ��ʱ�����ѵ�ǰstack1��Ԫ�طŵ�stack2�У�ʹ��ÿ��pop��ʱ��stack2��ǰԪ�ض�������
 * 
 * @author Cavielee
 *
 */
public class StackToQueue {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	int temp;
	
	public void push(int node) {
		stack1.add(node);
	}

	public int pop() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				temp = stack1.pop();
				stack2.push(temp);
			}
		}
		return stack2.pop();
	}
	public static void main(String[] args) {
		StackToQueue stq = new StackToQueue();
		stq.push(1);
		stq.push(2);
		stq.push(3);
		stq.push(4);
		System.out.println(stq.pop());
		System.out.println(stq.pop());
		System.out.println(stq.pop());
		System.out.println(stq.pop());
	}
}
