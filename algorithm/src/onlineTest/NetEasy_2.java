package onlineTest;

import java.util.Scanner;

/**
 * �ж�һ������[start,end]�ڵ����������ܱ�3�����ĸ���
 * ������[2,5]����������Ϊ12,123,1234,12345��
 * ���ɣ�
 * �� ���������ģ��3����Ϊ0�������һ���ܱ�3����
 * �� ��������Ϊ0���������ģ��2������Ϊ0��������Ǳ��ܱ�3����
 * ͨ����ѧ���ɷ�����֤��������
 * 
 * @author Cavielee
 *
 */
public class NetEasy_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		int num = 0;
		for (int i = start; i < end + 1; i++) {
			if (i % 3 % 2 == 0) {
				num++;
			}
		}

		System.out.println(num);
	}

}
