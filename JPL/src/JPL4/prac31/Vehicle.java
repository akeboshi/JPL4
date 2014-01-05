/*
 *  cloneクラスをサポートする。cloneメソッドは例外をスローしない。
 *  同等のVehicleを作る際にコピーを用いると便利なため、cloneをサポート。
 *  cloneをサポートしており、親クラスなので、cloneメソッドは例外をスローしない。
 *  myIdのみインスタンス独自で持つべきであると考えられるため、その部分のみ、独自実装。
 */

package JPL4.prac31;

class Vehicle implements Cloneable{
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
                
                A.printVehicle();
                B.printVehicle();
                C.printVehicle();
                System.out.println("maxId: " + maxId());
        }
	 
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