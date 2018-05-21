package onlineTest;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * ţţ����˯��ͷ�����������˺ܶ����ӣ�ֻ�����������ʱ�����Ż��ѹ������Ҿ������𴲡�
 * ��������������ҪX���ӵ�����ң��Ͽ�ʱ��Ϊ�����AʱB�֣��������������ʲôʱ����
 * 
 * ÿ���������һ������������
 * ÿ�����������ĵ�һ�а���һ������������ʾ���ӵ�����N(N<=100)��
 * ��������N��ÿ�а���������������ʾ������������ʱ��ΪHi(0<=A<24)ʱMi(0<=B<60)�֡�
 * ��������һ�а���һ����������ʾ������������ҪX(0<=X<=100)���ӵ�����ҡ�
 * ��������һ�а���������������ʾ�Ͽ�ʱ��ΪA(0<=A<24)ʱB(0<=B<60)�֡� 
 * ���ݱ�֤������һ�����ӿ�����ţţ��ʱ������ҡ�
 * 
 * @author Cavielee
 *
 */
public class NetEasy_7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// ������������
		int n = sc.nextInt();
		// ����,��treesetȥ�غ�����
		TreeSet<Integer> tree = new TreeSet<Integer>();

		for (int i = 0; i < n; i++) {
			// ʱ
			int hour = sc.nextInt();
			// �֣���ʱתΪ�ֲ��ͷֽ��,�����뵽����
			tree.add(sc.nextInt() + hour * 60);
		}
		// ȥ��������ʱ��
		int need = sc.nextInt();
		// �Ͽ�ʱ��
		int start = sc.nextInt() * 60 + sc.nextInt();

		// Ѱ��С�ڵ���start-endʱ�������
		int right = tree.floor(start - need);
		int min = right % 60;
		int hour = (right - min) / 60;
		System.out.println(hour + " " + min);

	}

}
