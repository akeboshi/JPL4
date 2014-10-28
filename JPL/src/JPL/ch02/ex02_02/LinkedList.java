package JPL.ch02.ex02_02;

import java.util.*;

class LinkedList {
	Object value;
	LinkedList nextList;
}

class testLink {
	public static void main(String[] args) {
		LinkedList testListA = new LinkedList();
		LinkedList testListB = new LinkedList();
		testListA.value = "testA1";
		testListB.value = "testB";
		testListA.nextList = testListB;
		testListB.nextList = null;

		System.out.println("" + testListA.value + testListA.nextList.value);
	}
} 
