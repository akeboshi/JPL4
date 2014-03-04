package JPL.ch06.ex06_05;

enum TraficSignal {
	BLUE {
		@Override
		Color getColor() {
			Color color = new Color("BLUE");
			return color;
		}
	},
	YELLOW {
		@Override
		Color getColor() {
			Color color = new Color("YELLOW");
			return color;
		}
	},
	RED {
		@Override
		Color getColor() {
			Color color = new Color("RED");
			return color;
		}
	};
	
	
	abstract Color getColor();
}