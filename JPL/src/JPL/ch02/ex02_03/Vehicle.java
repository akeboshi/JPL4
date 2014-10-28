package JPL.ch02.ex02_03;

class Vehicle {
	public double speed;
	public double angle;
	public String owner;
	public int myId;
	public static int nextId = 0;
}	

class testVehicle {
	public static void main ( String[] args ) {
		Vehicle A = new Vehicle();
		Vehicle B = new Vehicle();

		A.speed = 1; A.angle = 1 ; A.owner = "1"; A.myId = A.nextId++;
		B.speed = 2; B.angle = 2 ; B.owner = "2"; B.myId = B.nextId++;

		System.out.println("Owner :" + A.owner + " speed:" + A.speed + " angle:" + A.angle + " myId:" + A.myId);
		System.out.println("Owner :" + B.owner + " speed:" + B.speed + " angle:" + B.angle + " myId:" + B.myId);
	}
}
