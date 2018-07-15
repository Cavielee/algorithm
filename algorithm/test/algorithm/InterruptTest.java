package algorithm;

public class InterruptTest {

	public static void main(String[] args) {
		System.out.println("主线程");
		Thread t1 = new Thread(new Task());
		t1.start();
		
//		System.out.println(t1.interrupted());
//		System.out.println(t1.interrupted());
		t1.interrupt();
//		System.out.println(t1.isInterrupted());
//		System.out.println(t1.isInterrupted());
	}

}

class Task implements Runnable {

	@Override
	public void run() {
		System.out.println("t1在运行");
		try {
			synchronized (this) {
				wait();
			}
		} catch (InterruptedException e) {
			System.out.println("正在wait");
			Thread.currentThread().interrupt();
//			System.out.println(Thread.currentThread().isInterrupted());
			System.out.println(Thread.currentThread().interrupted());
			System.out.println(Thread.currentThread().interrupted());
//			Thread.currentThread().interrupted();
		}
		System.out.println("继续执行");
//		Thread.currentThread().
	}

}