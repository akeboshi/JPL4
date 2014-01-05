package JPL4.prac64;

enum TraficSignal {
	BLUE(new Color("BLUE")),
	YELLOW(new Color("YELLOW")),
	RED(new Color("RED"));
	
	Color color;
	private TraficSignal(Color color) {
		this.color = color;
	}
}