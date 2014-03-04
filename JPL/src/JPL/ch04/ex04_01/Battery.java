package JPL.ch04.ex04_01;

class Battery implements EnergySource{
	public int batteryEnergy = 100;
	final static int batteryMax = 100;
	
	@Override
	public boolean empty() {
		if(batteryEnergy <= 0){
			return true;
		} else {
			return false;
		}
	}
	@Override
	public void chargeEnergy (int energy){
		if(this.batteryEnergy + energy > batteryMax) this.batteryEnergy = batteryMax;
		else this.batteryEnergy += energy;
	}
}