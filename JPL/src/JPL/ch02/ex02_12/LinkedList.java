package JPL.ch02.ex02_12;

import java.util.*;

class LinkedList {
	Object value = null;
	LinkedList nextList = null;

        public static void main(String[] args) {
                Vehicle A = new Vehicle();
                Vehicle B = new Vehicle();
		Vehicle C = new Vehicle();
		LinkedList LC = new LinkedList(C);
		LinkedList LB = new LinkedList(B);
		LinkedList LA = new LinkedList(A);

                A.owner = "testA";
                B.owner = "testB";
		C.owner = "testC";
		
		// LA.value = A;
                // LA.nextList = LB;
		
		// LB.value = B;
                // LB.nextList = LC;

		LC.value = C;
		//LC.nextList = null;

		LA.setLinkedList(LB,LC);

                System.out.println(LA.toString());
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
