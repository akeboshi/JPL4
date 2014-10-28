package JPL.ch02.ex02_10;

class Vehicle {
	public double speed;
	public double angle;
	public String owner;
	public int myId;
	public static int nextId = 0;

	 public static void main ( String[] args ) {
                Vehicle A = new Vehicle();
                Vehicle B = new Vehicle("2");
		Vehicle C = new Vehicle("4");

                A.speed = 1; A.angle = 1 ; A.owner = "1"; 
                B.speed = 2; B.angle = 2 ;
                C.speed = 4; C.angle = 4 ;
		/*
                System.out.println("Owner :" + A.owner + " speed:" + A.speed + " angle:" + A.angle + " myId:" + A.myId);
                System.out.println("Owner :" + B.owner + " speed:" + B.speed + " angle:" + B.angle + " myId:" + B.myId);
                System.out.println("Owner :" + C.owner + " speed:" + C.speed + " angle:" + C.angle + " myId:" + C.myId);
		*/
		System.out.println(A.toString());
		System.out.println(B.toString());
		System.out.println(C.toString());

		System.out.println("MaxId : " + maxId());
        }
	public static int maxId(){
		return nextId - 1;	
	}

	public String toString() {
		String desc = "Owner :" + owner + " speed:" + speed + " angle:" + angle + " myId:" + myId;
		return desc;
	}

	public Vehicle(){
		myId = nextId++;
	}

	public Vehicle(String owner){
		this();
		this.owner = owner;
	}

}	
