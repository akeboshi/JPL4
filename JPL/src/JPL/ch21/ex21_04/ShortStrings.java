package JPL.ch21.ex21_04;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ShortStrings implements Iterator<String> {
	protected Iterator<String> strings;
	protected String nextShort;
	protected final int maxLen;

	public ShortStrings(Iterator<String> strings,int maxLen){
		this.strings = strings;
		this.nextShort=null;
		this.maxLen= maxLen;
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
}