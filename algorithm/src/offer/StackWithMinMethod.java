package offer;

import java.util.ArrayList;

/**
 * 20.ӵ������Сֵ������ջ
 * ˼·��ͨ��ArrayListȥʵ������
 * min����¼ջ����Сֵ��num��¼ջ������Ԫ��
 * push: �ж��Ƿ�Ϊ��һ���������������СΪ��node,������Ƚϸ�������Сֵ
 * pop�� �������������СֵԪ�أ��жϴ�ʱ�ж��ٸ�Ԫ�أ����Ϊ0��������СֵΪ0
 * �����Ϊ0��������Ҫ��ʣ�µ�Ԫ��������ѡһ����Сֵ����Ĭ�ϵ�һ��Ԫ��Ϊ��Сֵ����������Ҫ�ı���Сֵ
 * top: ֱ�ӷ��ص�һ��Ԫ��
 * min: ����min����
 * @author Cavielee
 *
 */
public class StackWithMinMethod {

	ArrayList<Integer> list = new ArrayList<Integer>();
	int num = 0;
	int min = 0;
	
	public void push(int node) {
		list.add(node);
		if (num == 0) {
			min = node;
		} else {
			min = (node < min ? node : min);
		}
		num++;
	}

	public void pop() {
		int node = list.remove(num - 1);
		num--;
		if (node == min) {
			if (num == 0) {
				min = 0;
			} else {
				min = list.get(0);
				for (int i : list) {
					if (i < min) {
						min = i;
					}
				}
			}
			
		}
	}

	public int top() {
		return list.get(num);
	}

	public int min() {
		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
