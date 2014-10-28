package JPL.ch01.ex01_08;

class TestPoint {
	public static void main(String[] args) {
		Point point_a = new Point();
		Point point_b = new Point();

		point_a.clear();
		point_b.clear();

		point_a.move( 3.0, 4.0);

		point_b.setPoint(point_a);
		
		System.out.println("point_a.x: " + point_a.x);
		System.out.println("point_a.y: " + point_a.y);

		System.out.println("point_b.x: " + point_b.x);    
                System.out.println("point_b.y: " + point_b.y);	
	}
}
