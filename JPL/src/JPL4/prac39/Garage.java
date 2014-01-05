package JPL4.prac39;

class Garage implements Cloneable{
	 Vehicle[] vehicles ;
	
	public static void main(String[] args) {
		Garage garage = new Garage();
		garage.vehicles = new Vehicle[3];
		for (int i = 0; i < garage.vehicles.length; i++) garage.vehicles[i] = new Vehicle();	
		
		garage.vehicles[0].speed = 1; garage.vehicles[0].angle = 1 ; garage.vehicles[0].owner = "1";
        garage.vehicles[1].speed = 2; garage.vehicles[1].angle = 2 ; garage.vehicles[1].owner = "2";
        garage.vehicles[2].speed = 4; garage.vehicles[2].angle = 4 ; garage.vehicles[2].owner = "3";
		
        Garage cpGarage = garage.clone();
        
        System.out.println("default object");
        garage.vehicles[0].printVehicle();
        garage.vehicles[1].printVehicle();
        garage.vehicles[2].printVehicle();
        System.out.println("copy object");
        cpGarage.vehicles[0].printVehicle();
        cpGarage.vehicles[1].printVehicle();
        cpGarage.vehicles[2].printVehicle();
	}
	
	@Override
	protected Garage clone() {
		try{
			Garage nObj = (Garage)super.clone();
			nObj.vehicles = vehicles.clone();
			for (int i = 0; i < vehicles.length; i++) {
				nObj.vehicles[i] = vehicles[i].clone();
			}
			return nObj;
		} catch (CloneNotSupportedException e){
			throw new InternalError(e.toString());
		}
	}
}