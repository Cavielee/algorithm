package algorithm;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer_Consumer {

	public static class Producer implements Runnable {
		private BlockingQueue<String> queue;
		private AtomicInteger size;

		public Producer(BlockingQueue<String> queue, AtomicInteger size) {
			this.queue = queue;
			this.size = size;
		}

		public void run() {
			while (true) {
//				System.out.println(Thread.currentThread().getName() + " Making product");
				String product = new String(
						"product " + queue.size() + " maked by " + Thread.currentThread().getName());
				try {
					queue.put(product);
					System.out.println(product);
				} catch (InterruptedException e) {
					e.printStackTrace();
					break;
				}
			}
		}
	}

	public static class Consumer implements Runnable {
		private BlockingQueue<String> queue;
		private AtomicInteger size;

		public Consumer(BlockingQueue<String> queue, AtomicInteger size) {
			this.queue = queue;
			this.size = size;
		}

		public void run() {
			while (true) {
				try {
					String product = queue.take();
					size.decrementAndGet();
					System.out.println(Thread.currentThread().getName() + " taking " + product);
				} catch (InterruptedException e) {
					e.printStackTrace();
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(5);
		AtomicInteger size = new AtomicInteger(0);

		for (int i = 0; i < 5; i++) {
			new Thread(new Producer(queue, size)).start();
		}
		for (int j = 0; j < 3; j++) {
			new Thread(new Consumer(queue, size)).start();
		}
//		for (int i = 2; i < 5; i++) {
//			new Thread(new Producer(queue, size)).start();
//		}
	}

}
