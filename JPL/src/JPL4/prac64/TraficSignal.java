package JPL4.prac64;

enum TraficSignal {
	BLUE(new Color("BLUE")),
	YELLOW(new Color("YELLOW")),
	RED(new Color("RED"));
	
	private final Color color;
	private TraficSignal(Color color) {
		this.color = color;
	}
	
	public Color getColor(){
		return color;
	}
}