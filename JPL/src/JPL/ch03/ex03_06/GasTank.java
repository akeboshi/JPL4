package JPL.ch03.ex03_06;

class GasTank extends EnergySource{
	public int gasEnergy = 100;
	final static int gasMax = 100;
	
	@Override
	protected boolean empty() {
		if(gasEnergy <= 0) { 
			return true;
		} else {
			return false;
		}
	}
	
	public void chargeGasEnergy(int gasEnergy){
		if(this.gasEnergy + gasEnergy > gasMax) this.gasEnergy = gasMax;
		else this.gasEnergy += gasEnergy;
	}
}