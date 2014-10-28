package JPL.ch02.ex02_06;

import java.util.*;

class LinkedList {
	Object value;
	LinkedList nextList;

        public static void main(String[] args) {
                Vehicle A = new Vehicle();
                Vehicle B = new Vehicle();
		Vehicle C = new Vehicle();
		LinkedList LA = new LinkedList();
		LinkedList LB = new LinkedList();
		LinkedList LC = new LinkedList();

                A.owner = "testA";
                B.owner = "testB";
		C.owner = "testC";
		
		LA.value = A;
                LA.nextList = LB;
		
		LB.value = B;
                LB.nextList = LC;

		LC.value = C;
		LC.nextList = null;

                System.out.println(((Vehicle)LA.value).owner + ((Vehicle)LA.nextList.value).owner + ((Vehicle)LA.nextList.nextList.value).owner);
        }
} 
