package JPL.ch06.ex06_04;

class Color {
	String colorName;
	
	public Color() {
		colorName = "BLUE";
	}
	
	public Color(String colorName){
		this.colorName = colorName;
	}
	
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	
	public String getColorName() {
		return colorName;
	}
}