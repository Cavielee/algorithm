package algorithm;

import java.util.Iterator;

import org.junit.Test;

public class TestStack {

	@Test
	public void testArrayStack() {
		ArrayStack<String> a = new ArrayStack<>();

		System.out.println(a.isEmpty());

		a.push("test1");
		a.push("test2");
		System.out.println(a.pop());
		a.push("test3");

		System.out.println(a.isEmpty());

		System.out.println(a.size());

		for (Iterator<String> it = a.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
	}

	@Test
	public void testLinkedStack() {
		LinkedStack<String> ls = new LinkedStack<String>();
		
		System.out.println(ls.isEmpty());

		ls.push("test1");
		ls.push("test2");
		System.out.println(ls.pop());
		ls.push("test3");

		System.out.println(ls.isEmpty());

		System.out.println(ls.size());

	}
}
