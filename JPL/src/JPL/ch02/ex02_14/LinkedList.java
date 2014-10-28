package JPL.ch02.ex02_14;

import java.util.*;

class LinkedList {
	/*
		nextListもリストの削除や追加のため変更可能にするべきだと思われる。
		valueは、LinkedListの一つのオブジェクトごとに不変にしたほうが、リスト構造を作りやすいと感じたため、セッターは用意しなかった。
		
	*/
	private Object value = null;
	private LinkedList nextList = null;

        public static void main(String[] args) {
                Vehicle A = new Vehicle();
                Vehicle B = new Vehicle();
		Vehicle C = new Vehicle();
		LinkedList LC = new LinkedList(C);
		LinkedList LB = new LinkedList(B);
		LinkedList LA = new LinkedList(A);
		
                A.setOwner("testA");
                B.setOwner("testB");
		C.setOwner("testC");
		
		

		LA.setLinkedList(LB,LC);

                System.out.println(LA.toString());
        }
	
	public Object getValue(){
		return value;
	}
/*
	public void setValue(Object value){
		this.value = value;
	}
*/
	public LinkedList getNextList() {
		return nextList;
	}
	
	public void setLinkedList(LinkedList... obj){
		LinkedList desc = this;
		for(int i = 0 ; i < obj.length ; i++){
			desc.setNextList(obj[i]);
			desc = obj[i];
		}
	}

	public String toString(){
		String desc = "";
		if( this.value != null){
			desc += this.value.toString();
		} else {
			/* String desc に何も追加しない*/
		}

		if( this.nextList != null ) {
			desc += "\n";
			desc += " nextLink :" + this.nextList.toString();
		} else {
			/* String desc に何も追加しない。次のリストが存在しないため。 */
		}
		return desc;
	}

	public LinkedList(){
	}

	public LinkedList(Object value) {
		this.value =value;
	}

	public void setNextList(LinkedList nextList){
		this.nextList = nextList;
	}

	public LinkedList(Object value, LinkedList nextList) {
		this(value);
		this.nextList = nextList;
	}
} 
