package JPL4.prac32;

class Y extends X{
	{
		mask("Y initialize before");
	}
	protected int yMask = 0xff00;

	{
		mask("Y initialize after");
	}
	
	public static void main(String[] args) {
		Y y = new Y();
		System.out.printf("main method is end xMask:%#06x yMask:%#6x fullmask:%#06x %n",y.xMask,y.yMask,y.fullMask);
	}
	
	@Override
	public void mask(String name) {
		System.out.printf("%s	xMask:%#06x yMask:%#06x fullmask:%#06x %n",name,xMask,yMask,fullMask);
};
	
	public Y(){
		mask("Y constructor start");
		fullMask |= yMask;
		mask("Y constructor end"); 
	}
}