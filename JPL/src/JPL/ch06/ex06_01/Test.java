package JPL.ch06.ex06_01;


class Test{
	public static void main(String[] args) {
		EnumWeek enumweek = EnumWeek.MONDAY;
		
		switch (enumweek) {
		case SUNDAY:
			System.out.println("sunday");
			break;
		case MONDAY:
			System.out.println("monday");
			break;
		case TUESDAY:
			System.out.println("tuesday");
			break;
		case WEDNESDAY:
			System.out.println("wednesday");
			break;
		case THURSDAY:
			System.out.println("thursday");
			break;
		case FRIDAY:
			System.out.println("friday");
			break;
		case SUTURDAY:
			System.out.println("suturday");
			break;
		default:
			throw new InternalError();
		}
		
		TraficSignal traficSignal = TraficSignal.RED;
		
		switch (traficSignal) {
		case BLUE:
		case YELLOW:
			System.out.println("GOGOGO");
			break;
		case RED:
			System.out.println("STOP");
		default:
			throw new InternalError();
		}
		
	}
}