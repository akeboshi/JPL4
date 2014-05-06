package JPL.ch21.ex21_07;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Stack<E> {
	private List<E> list = new ArrayList<>();

	public boolean empty() {
		return list.isEmpty();
	}

	public E peek() {
		if (empty())
			throw new EmptyStackException();
		return list.get(list.size() - 1);
	}

	public E pop() {
		if (empty())
			throw new EmptyStackException();
		return list.remove(list.size() - 1);
	}

	public E push(E e) {
		list.add(e);
		return e;
	}

	public int search(E e) {
		if(list.indexOf(e) == -1) return -1;
		return list.size() - list.indexOf(e);
	}
}