package JPL.ch01.ex01_15;

interface Lookup {
	/** nameと関連づけされた値を返す
	 *  そのような値がなければnullを返す */
	Object find(String name);
	void add(String name, Object value);
	void remove(String name);
}
