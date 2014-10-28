package JPL.ch02.ex02_13;

class Vehicle {
	/*
	myIdはセッターを持つべきではない。何故ならば、コンストラクタで値を決定されるものであり、不変の値を持つためである。
	また、nextidもセッターを持つべきではない。何故ならば、myIdが唯一であるために使用されるものであるため、容易に変更されるべきものではないため。
	myIdが唯一だと保証される構造をもつのならば、セッターを持ってもかまわない。
	*/
	private double speed;
	private double angle;
	private String owner;
	private int myId;
	private static int nextId = 0;
	
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
	
	public int getNextId(){
		return nextId;
	}
	
	public int getMyId(){
		return myId;
	}

	public String getOwner(){
		return owner;
	}

	public void setOwner(String owner){
		this.owner = owner;
	}

	public double getAngle(){
		return angle;
	}

	public void setAngle(double angle){
		this.angle = angle;
	}

	public double getSpeed(){
		return speed;
	}

	public void setSpeed(double speed){
		this.speed = speed;
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
