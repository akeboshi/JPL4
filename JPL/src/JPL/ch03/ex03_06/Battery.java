package JPL.ch03.ex03_06;

class Battery extends EnergySource{
	public int batteryEnergy = 100;
	final static int batteryMax = 100;
	
	@Override
	protected boolean empty() {
		if(batteryEnergy <= 0){
			return true;
		} else {
			return false;
		}
	}
	
	public void chargeBattery (int batteryEnergy){
		if(this.batteryEnergy + batteryEnergy > batteryMax) this.batteryEnergy = batteryMax;
		else this.batteryEnergy += batteryEnergy;
	}
}