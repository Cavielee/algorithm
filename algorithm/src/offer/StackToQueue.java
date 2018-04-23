package offer;

import java.util.Stack;

/**
 * 5、使用两个栈实现队列
 * 思路：
 * stack1用来push，stack2用来pop
 * 因为push到stack1时是倒序
 * 通过pop stack1再push到stack2，使得Stack2变为倒序的倒序（即正序）
 * 当stack2为空时，即把当前stack1的元素放到stack2中，使得每次pop的时候stack2当前元素都是正序
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
