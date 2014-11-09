package JPL.ch04.ex04_03;

class LinkedList implements Cloneable , LinkInterface{
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
		
       LB.nextList = LC;

		LC.value = C;
		LC.nextList = null;
		
		LinkedList LD = LA.clone();
		LA = new LinkedList(B,LB);
		System.out.println("change list");
        System.out.println(((Vehicle)LD.value).owner + ((Vehicle)LD.nextList.value).owner + ((Vehicle)LD.nextList.nextList.value).owner);
        System.out.println(((Vehicle)LA.value).owner + ((Vehicle)LA.nextList.value).owner + ((Vehicle)LA.nextList.nextList.value).owner);
        C.owner = "changedOwner";
        System.out.println("change object");
        System.out.println(((Vehicle)LD.value).owner + ((Vehicle)LD.nextList.value).owner + ((Vehicle)LD.nextList.nextList.value).owner);
        System.out.println(((Vehicle)LA.value).owner + ((Vehicle)LA.nextList.value).owner + ((Vehicle)LA.nextList.nextList.value).owner);
        
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
	
	 @Override
     public LinkedList clone() {
             LinkedList linkObj;
			try {
				linkObj = (LinkedList)super.clone();
				return linkObj;
			} catch (CloneNotSupportedException e) {
				throw new InternalError(e.toString());
			}
	 }
} 