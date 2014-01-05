package JPL4.prac65;

enum TraficSignal {
	BLUE(new Color("BLUE")) {
		@Override
		Color getColor() {
			return color;
		}
	},
	YELLOW(new Color("YELLOW")) {
		@Override
		Color getColor() {
			return color;
		}
	},
	RED(new Color("RED")) {
		@Override
		Color getColor() {
			return color;
		}
	};
	
	Color color;
	private TraficSignal(Color color) {
		this.color = color;
	}
	
	abstract Color getColor();
}