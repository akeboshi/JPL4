package JPL4.prac41;

class GasTank implements EnergySource{
	public int gasEnergy = 100;
	final static int gasMax = 100;
	
	@Override
	public boolean empty() {
		if(gasEnergy <= 0) { 
			return true;
		} else {
			return false;
		}
	}
	
	public void chargeEnergy(int energy){
		if(this.gasEnergy + energy > gasMax) this.gasEnergy = gasMax;
		else this.gasEnergy += energy;
	}
}