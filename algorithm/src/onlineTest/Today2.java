package onlineTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Today2 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Future<String> f = executorService.submit(() -> {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "²âÊÔ");
		}, new String("hehe"));
		System.out.println("main");
		executorService.submit(() -> {
			try {
				System.out.println(Thread.currentThread().getName() + f.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		});
		System.out.println("main2");
		executorService.shutdown();
	}

}
