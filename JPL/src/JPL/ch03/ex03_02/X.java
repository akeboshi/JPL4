package JPL.ch03.ex03_02;

class X{
	{
		mask("X initialize before");
	}
	protected int xMask = 0x00ff;
	protected int fullMask;
	{
		mask("X initialize after");
	}
	
	public void mask(String name){
	}
	
	public X() {
		mask("X constructor start");
		fullMask |= xMask;
		mask("X constructor end");
	}

	
}