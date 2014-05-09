package JPL.ch22.ex22_13;

public interface Attributed<E> {
	void add(Attr<E> newAttr);
	Attr<E> find(String attrName);
	Attr<E> remove(String attrName);
	java.util.Iterator<Attr<E>> attrs();
}