package algorithm;

import org.junit.Test;

public class TestQueue {

	@Test
	public void testQueue() {
		Queue<String> q = new Queue<String>();

		System.out.println(q.isEmpty());

		q.push("test1");
		q.push("test2");
		System.out.println(q.pop());
		q.push("test3");

		System.out.println(q.isEmpty());

		System.out.println(q.size());
	}

}
