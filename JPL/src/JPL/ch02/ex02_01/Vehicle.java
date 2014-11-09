package JPL.ch02.ex02_01;

class Vehicle {
	public double speed;
	public double angle;
	public String owner;
}

class accessVehicle{
	public static void main (String[] args) {
		Vehicle myVe = new Vehicle();
		myVe.speed = 32.0; myVe.angle = 60.0 ; myVe.owner = "Aruga";
		System.out.println ("owner :" + myVe.owner + " speed :" + myVe.speed + " angle :" + myVe.angle);
	}
}
