package JPL.ch22.ex22_12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class AttributedImpl<E> implements Attributed<E>{
	private Map<String, Attr<E>> attr = new HashMap<String, Attr<E>>();

	@Override
	public void add(Attr<E> newAttr) {
		attr.put(newAttr.getName(), newAttr);
	}

	@Override
	public Attr<E> find(String attrName) {		
		return attr.get(attrName);
	}

	@Override
	public Attr<E> remove(String attrName) {
		return attr.remove(attrName);
	}

	@Override
	public Iterator<Attr<E>> attrs() {
		return attr.values().iterator();
	}
	
	

}