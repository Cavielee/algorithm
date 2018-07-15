package offer;

import java.util.Stack;

/**
 * 20.ӵ������Сֵ������ջ 
 * ˼·��
 * ͨ��ά������ջ
 * һ������ջ��������Ӻ͵�������
 * һ������ջ��������¼��ǰ��Сֵ
 * pushʱ����ӵ�����ջ�����ж����Ԫ�غ͸���ջջ��Ԫ�ش�С���ѽ�С����ӵ�����ջ��
 * popʱ����ͬʱ������ջջ��Ԫ�ص���
 * top��������ջջ��Ԫ��
 * min���ظ���ջջ��Ԫ��
 * 
 * @author Cavielee
 *
 */
public class StackWithMinMethod {

	// ����ջ��������¼��Сֵ
	final Stack<Integer> s_min = new Stack<Integer>();
	// ����ջ��������ӻ򵯳�����
	final Stack<Integer> s_data = new Stack<Integer>();

	public void push(int node) {
		s_data.push(node);
		if (s_min.empty()) {
			s_min.push(node);
		} else {
			// ����ջջ��Ԫ�أ�����ǰ����ջ��Сֵ��
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
