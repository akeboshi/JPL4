package JPL.ch01.ex01_08;

class Point{
	public double x,y;
	
	public void clear() {
		x = 0.0;	
		y = 0.0;
	}

	public void move (double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void setPoint (Point param) {
		this.x = param.x;
		this.y = param.y;
	}
}
