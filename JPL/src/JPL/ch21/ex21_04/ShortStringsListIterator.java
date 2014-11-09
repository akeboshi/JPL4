package JPL.ch21.ex21_04;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ShortStringsListIterator implements ListIterator<String>{
	private ListIterator<String> strings;
	private String nextShort;
	private String prevShort;
	private final int maxLen;

	public ShortStringsListIterator(ListIterator<String> strings,int maxLen){
		this.strings = strings;
		this.maxLen = maxLen;
		this.nextShort = null;
		this.prevShort = null;
	}

	@Override
	public boolean hasNext() {
		if (nextShort != null)
			return true;
		while (strings.hasNext()) {
			nextShort = strings.next();
			if(nextShort.length() <= maxLen)
				return true;
		}
		nextShort = null;
		return false;
	}

	@Override
	public String next() {
		if (nextShort == null && !hasNext())
			throw new NoSuchElementException();
		String n = nextShort;
		nextShort = null;
		return n;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasPrevious() {
		if (prevShort != null)
			return true;
		while (strings.hasPrevious()) {
			prevShort = strings.previous();
			if (prevShort.length() <= maxLen)
				return true;
		}
		prevShort = null;
		return false;
	}

	@Override
	public String previous() {
		if (prevShort == null && !hasPrevious())
			throw new NoSuchElementException();
		String n = prevShort;
		prevShort = null;
		return n;
	}

	@Override
	public int nextIndex() {
		return strings.nextIndex();
	}

	@Override
	public int previousIndex() {
		return strings.previousIndex();
	}

	@Override
	public void set(String e) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void add(String e) {
		throw new UnsupportedOperationException();
	}
}