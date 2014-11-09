package JPL.ch22.ex22_04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;

class AttributedImpl<E> extends Observable implements Attributed<E>{
	private Map<String, Attr<E>> attr = new HashMap<String, Attr<E>>();

	@Override
	public void add(Attr<E> newAttr) {
		attr.put(newAttr.getName(), newAttr);
		setChanged();
		notifyObservers("add :" + newAttr.toString());
	}

	@Override
	public Attr<E> find(String attrName) {
		return attr.get(attrName);
	}

	@Override
	public Attr<E> remove(String attrName) {
		Attr<E> removed = attr.remove(attrName);
		setChanged();
		notifyObservers("remove :" + attrName);
		return removed;
	}

	@Override
	public Iterator<Attr<E>> attrs() {
		return attr.values().iterator();
	}

}