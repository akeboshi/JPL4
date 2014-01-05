/*
 * cloneをサポートする。例外はthrowsしない。
 * cloneでは親クラスに全て任せているため、親クラスで例外を発生させればよいため。
 */

package JPL4.prac38;

public class PassengerVehicle extends Vehicle implements Cloneable{
		public Integer passenger;
		public Integer seat;

		 public static void main ( String[] args ) {
	                PassengerVehicle A = new PassengerVehicle();
	                PassengerVehicle B = new PassengerVehicle("2");
	                PassengerVehicle C = new PassengerVehicle("4");

	                A.speed = 1; A.angle = 1 ; A.owner = "1"; A.passenger = 3; A.seat = 4;
	                B.speed = 2; B.angle = 2 ; B.passenger = 2; B.seat = 2; 
	                C.speed = 4; C.angle = 4 ; C.passenger = 4; C.seat = 4;
	                
	                PassengerVehicle D = A.clone();
	                PassengerVehicle E = B.clone();
	                PassengerVehicle F = C.clone();
	                
	                A.printVehicle();
	                B.printVehicle();
	                C.printVehicle();
	                D.printVehicle();
	                E.printVehicle();
	                F.printVehicle();
	                System.out.println("MaxId : " + maxId());
	        }
		 
		@Override
		protected void printVehicle(){
			System.out.println("Owner :" + owner + " speed:" + speed +
					" angle:" + angle + " myId:" + myId +
					" passenger:" + passenger + " seats:" + seat);
		}
		 

		public PassengerVehicle() {
			super();
		}

		public PassengerVehicle(String owner){
			this();
			this.owner = owner;
		}
		
		@Override
		protected PassengerVehicle clone() {
				return (PassengerVehicle)super.clone();
			
		}

}