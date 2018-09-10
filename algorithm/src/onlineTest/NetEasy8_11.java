package onlineTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * �Ͽ����⣺ÿ���Ӷ����Ѻ�û��״̬����ÿ���Ӷ�����Ӧ��ֵ������
 * �ʣ���ν���һ�Σ��û����ֵ�������
 * @author CavieLee
 *
 */
public class NetEasy8_11 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// ���ɼ�
		long maxScore = 0;
		// ��������
		long minScore = 0;
		// �ε�ʱ��
		long n = in.nextLong();
		// ��������ʱ��
		int k = in.nextInt();
		
		// ÿ���ӵķ�ֵ
		long[] score = new long[(int) (n + 1)];

		for (int i = 1; i <= n; i++) {
			score[i] = in.nextInt();
		}

		// ÿ�����Ƿ����ѣ�1Ϊ����
		long[] statuArray = new long[(int) (n + 1)];
		// ��¼�Ǽ�������˯��
		List<Integer> isSleep = new ArrayList<>();

		// ���k >= n,ֱ�ӷ�������score���
		if (k >= n) {
			for (int i = 1; i <= n; i++) {
				maxScore += score[i];
			}
			// ������
			System.out.println(maxScore);
			return;
		} else {
			for (int i = 1; i <= n; i++) {
				int statu = in.nextInt();
				// �ж��Ƿ�����
				if (statu == 1) {
					minScore += score[i];
					statuArray[i] = 1;
				} else {
					isSleep.add(i);
				}
			}
		}

		// ��ʼ�����ֵ
		maxScore = minScore;

		// ������������˯�ŵĿ��ܽ���
		for (int i = 0; i < isSleep.size(); i++) {
			int time = isSleep.get(i);
			// �÷�����ʼ����
			long currentScore = minScore + score[time];
			// �жϺ������������Ƿ�Ҫ��
			for (int j = 1; j < k; j++) {
				int nextTime = time + j;
				if (nextTime < (n + 1)) {
					if (statuArray[nextTime] == 0) {
						currentScore += score[nextTime];
					}
				}

			}
			// �ж��Ƿ�ȵ�ǰ���ֵ��
			maxScore = maxScore > currentScore ? maxScore : currentScore;
		}

		// ����ͨ����ÿ��0���г��Խ���
		System.out.println(maxScore);
	}

}
