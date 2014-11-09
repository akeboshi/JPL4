package JPL.ch02.ex02_11;

import java.util.*;

class LinkedList {
	Object value = null;
	LinkedList nextList = null;

        public static void main(String[] args) {
                Vehicle A = new Vehicle();
                Vehicle B = new Vehicle();
		Vehicle C = new Vehicle();
		LinkedList LC = new LinkedList();
		LinkedList LB = new LinkedList(B);
		LinkedList LA = new LinkedList(A,LB);

                A.owner = "testA";
                B.owner = "testB";
		C.owner = "testC";
		
		// LA.value = A;
                // LA.nextList = LB;
		
		// LB.value = B;
                LB.nextList = LC;

		LC.value = C;
		LC.nextList = null;

                System.out.println(LA.toString());
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

	public LinkedList(Object value, LinkedList nextList) {
		this(value);
		this.nextList = nextList;
	}
} 
