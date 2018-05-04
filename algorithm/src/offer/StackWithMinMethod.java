package offer;

import java.util.ArrayList;

/**
 * 20.拥有求最小值函数的栈
 * 思路：通过ArrayList去实现数组
 * min来记录栈的最小值，num记录栈所含有元素
 * push: 判断是否为第一个数，如果是则最小为该node,不是则比较该数和最小值
 * pop： 如果弹出的是最小值元素，判断此时有多少个元素，如果为0个，则最小值为0
 * 如果不为0个，则需要在剩下的元素中重新选一个最小值（先默认第一个元素为最小值），否则不需要改变最小值
 * top: 直接返回第一个元素
 * min: 返回min变量
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
