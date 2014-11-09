package JPL.ch03.ex03_06;

class Vehicle {
	public double speed;
	public double angle;
	public String owner;
	final public int myId;
	public static int nextId = 0;
	public GasTank gasTank = new GasTank();
	public Battery battery = new Battery();

	 public static void main ( String[] args ) {
		Vehicle vehicle = new Vehicle();
		System.out.println("gas & battery energy is 100 ");
		/*  gas & battery energy is 100 */
		if(vehicle.start()) System.out.println("start method");
		else System.out.println("stop method");
		/* gas & battery energy is 100  */
		System.out.println("gas & battery energy is 0 ");
		vehicle.gasTank.gasEnergy = 0;
		if(vehicle.start()) System.out.println("start method");
		else System.out.println("stop method");
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
	
	public boolean start(){
		if(gasTank.empty() || battery.empty()){
			return false;
		} else {
			return true;
		}
	}

}	