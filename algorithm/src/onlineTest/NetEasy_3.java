package onlineTest;

/**
 * СQ���ڸ�һ������Ϊn�ĵ�·���·�ư��÷�����
 * Ϊ�����������,СQ�ѵ�·��Ϊn������,��Ҫ�����ĵط���'.'��ʾ, ����Ҫ�������ϰ��������'X'��ʾ��
 * СQ����Ҫ�ڵ�·������һЩ·��, ���ڰ�����posλ�õ�·��, ��յ·�ƿ�������pos - 1, pos, pos + 1������λ�á�
 * СQϣ���ܰ��þ����ٵ�·����������'.'����, ϣ�����ܰ�������һ��������Ҫ����յ·�ơ�
 * 
 * ˼·��
 * �жϵ�ǰλ���Ƿ���Ҫ����
 * ��Ϊ.ʱ������Ҫ�ڸ��ڷ���һյ�ƣ��õ���ȷ������������������Ų3������ж�
 * ��ΪXʱ��������ǰλ�ò���Ҫ������������Ų1������ж�
 * ֱ���жϵ�λ���Ѿ�����·�������·����
 */
import java.util.Scanner;

public class NetEasy_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testNum = sc.nextInt();
		int routeLength;
		String route;
		int num;
		for (int i = 0; i < testNum; i++) {
			num = 0;
			routeLength = sc.nextInt();
			route = sc.next();
			for (int j = 0; j < routeLength; j++) {
				if (route.charAt(j) == '.') {
					num++;
					j += 2;
				}
			}
			System.out.println(num);
		}
	}

}
