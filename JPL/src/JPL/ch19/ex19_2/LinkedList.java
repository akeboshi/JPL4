package JPL.ch19.ex19_2;
/**
 * 連結リストを作るクラスです。<br>
 * リストをつなげていくには、setNextLinkを使います<br>
 */
public class LinkedList {
	/**
	 * リストが持っている要素
	 */
	private Object value = null;
	/**
	 * 次のリスト
	 */
	private LinkedList nextList = null;

	/**
	 * 指定した要素をもつLinkedListを作成します。
	 * @param value リンクの要素
	 */
	public LinkedList(Object value) {
		this.value = value;
	}

	/**
	 * 指定された要素と、次にくるリストを設定して、リストを作成します。
	 * @param value 要素
	 * @param nextList
	 */
	public LinkedList(Object value, LinkedList nextList) {
		this(value);
		this.nextList = nextList;
	}

	/**
	 * 現在のリストからリンクの終端までのリストの数を返します。
	 * @return リストの数
	 */
	public int countList() {
		LinkedList obj = this;
		int numList = 1;
		while (obj.nextList != null) {
			numList++;
			obj = obj.nextList;
		}
		return numList;
	}

	/**
	 * リストの要素を返します。
	 * @return 要素
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * 設定されている次のLinkedListを返します。<br>
	 * LinkedListの最後ならば、nullを返します
	 * @return 次のリスト
	 */
	public LinkedList getNextList() {
		return nextList;
	}
	/**
	 * LinkedListの配列から、リストを生成します
	 * @param obj
	 */
	public void setLinkedList(LinkedList... obj) {
		LinkedList desc = this;
		for (int i = 0; i < obj.length; i++) {
			desc.setNextList(obj[i]);
			desc = obj[i];
		}
	}
	/**
	 * このリストを文字列表現で返します
	 * @return リストの文字列
	 */
	public String toString() {
		String desc = "";
		if (this.value != null) {
			desc += this.value.toString();
		} else {
			/* String desc に何も追加しない */
		}

		if (this.nextList != null) {
			desc += "\n";
			desc += " nextLink :" + this.nextList.toString();
		} else {
			/* String desc に何も追加しない。次のリストが存在しないため。 */
		}
		return desc;
	}


	/**
	 * 次のLinkedListのリンクを設定します
	 * @param nextList
	 */
	public void setNextList(LinkedList nextList) {
		this.nextList = nextList;
	}

}
