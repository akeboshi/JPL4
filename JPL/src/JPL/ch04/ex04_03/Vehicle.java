package JPL.ch04.ex04_03;

class Vehicle implements Cloneable{
	public double speed;
	public double angle;
	public String owner;
	public int myId;
	public static int nextId = 0;
/*
	 public static void main ( String[] args ) {
                Vehicle A = new Vehicle();
                Vehicle B = new Vehicle("2");
                Vehicle C = new Vehicle("4");
                
                A.speed = 1; A.angle = 1 ; A.owner = "1";
                B.speed = 2; B.angle = 2 ; 
                C.speed = 4; C.angle = 4 ; 
                
                Vehicle D = A.clone();
                Vehicle E = B.clone();
                Vehicle F = C.clone();
                
                A.printVehicle();
                B.printVehicle();
                C.printVehicle();
                D.printVehicle();
                E.printVehicle();
                F.printVehicle();
                
                System.out.println("maxId: " + maxId());
        }
	 */
	 protected void printVehicle(){
			System.out.println("Owner :" + owner + " speed:" + speed +
					" angle:" + angle + " myId:" + myId );
	}
	 
	public static int maxId(){
		return nextId - 1;	
	}

	public Vehicle(){
		myId = nextId++;
	}

	public Vehicle(String owner){
		this();
		this.owner = owner;
	}
	
	@Override
	protected Vehicle clone() {
		try{
			Vehicle nObj = (Vehicle)super.clone();
			nObj.myId = nextId++;
			return nObj;
		} catch (CloneNotSupportedException e){
			throw new InternalError(e.toString());
		}
	}
}	