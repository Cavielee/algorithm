package onlineTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class NetEasy_6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// �ж��ٸ�����
		int n = sc.nextInt();
		// ���½�x1
		int[] x1 = new int[n];
		for (int i = 0; i < n; i++) {
			x1[i] = sc.nextInt();
		}

		// ���½�y1
		int[] y1 = new int[n];
		for (int i = 0; i < n; i++) {
			y1[i] = sc.nextInt();
		}

		// ���Ͻ�x1
		int[] x2 = new int[n];
		for (int i = 0; i < n; i++) {
			x2[i] = sc.nextInt();
		}

		// ���Ͻ�y1
		int[] y2 = new int[n];
		for (int i = 0; i < n; i++) {
			y2[i] = sc.nextInt();
		}
		// ��Ӿ���
		ArrayList<Rectangle> list = new ArrayList<Rectangle>();
		for (int i = 0; i < n; i++) {
			list.add(new Rectangle(x1[i], x2[i], y1[i], y2[i]));
		}
		Collections.sort(list, (o1,o2) -> Integer.compare(o1.x1, o2.x1));
		new ConcurrentLinkedQueue();
	}

	private static class Rectangle {
		int x1;
		int x2;
		int y1;
		int y2;

		public Rectangle(int x1, int x2, int y1, int y2) {
			super();
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
		}

		public boolean intersect(Rectangle r) {
			return x1 < r.x2 && x2 > r.x1 && y1 < r.y2 && y2 > r.y1;
		}
	}
}
