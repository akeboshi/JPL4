package JPL.ch02.ex02_06;

class Vehicle {
	public double speed;
	public double angle;
	public String owner;
	public int myId;
	public static int nextId = 0;

	 public static void main ( String[] args ) {
                Vehicle A = new Vehicle();
                Vehicle B = new Vehicle();
		Vehicle C = new Vehicle();

                A.speed = 1; A.angle = 1 ; A.owner = "1"; A.myId = A.nextId++;
                B.speed = 2; B.angle = 2 ; B.owner = "2"; B.myId = B.nextId++;
                C.speed = 4; C.angle = 4 ; C.owner = "4"; C.myId = B.nextId++;

                System.out.println("Owner :" + A.owner + " speed:" + A.speed + " angle:" + A.angle + " myId:" + A.myId);
                System.out.println("Owner :" + B.owner + " speed:" + B.speed + " angle:" + B.angle + " myId:" + B.myId);
                System.out.println("Owner :" + C.owner + " speed:" + C.speed + " angle:" + C.angle + " myId:" + C.myId);
        }
}	
