package JPL.ch06.ex06_02;
/* enumを用いることにより、定数値で指定しなくなるため、間違った値を代入することを予防できる
 * switch文をみやすく書くこともできる。
 */
class Vehicle {
	private double speed;
	private double angle;
	private String owner;
	private int myId;
	private static int nextId = 0;

	public enum eAngle{
		TURN_LEFT, TURN_RIGHT
	}
	
	 public static void main ( String[] args ) {
                Vehicle A = new Vehicle();
                Vehicle B = new Vehicle("2");
		Vehicle C = new Vehicle("4");

                A.speed = 1; A.angle = 1 ; A.owner = "1"; 
                B.speed = 2; B.angle = 2 ;
                C.speed = 4; C.angle = 4 ;

		A.turn(30);
		B.turn(eAngle.TURN_LEFT);
		C.turn(eAngle.TURN_RIGHT);
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

	public void turn(double angle) {
		this.angle += angle;
	}

	public void turn(eAngle angle){
		switch (angle) {
		case TURN_LEFT:
			turn(90);
			break;
		case TURN_RIGHT:
			turn( -90);
			break;
		default:
			System.out.println("No changed");
			break;
		}
	}
		
	
	public void stop(){
		this.setSpeed(0.0);
	}

	public void changeSpeed(double speed){
		this.setSpeed(speed);
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