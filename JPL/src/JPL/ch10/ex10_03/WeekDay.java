package JPL.ch10.ex10_03;

class WeekDay {
	public static void main(String[] args) {
		if (getWorkDay(EnumWeek.SUNDAY) == true) {
			System.out.println("はたらいてください");
		} else {
			System.out.println("やすみです");
		}
	}

	public static boolean getWorkDay(EnumWeek enumWeek) {
		switch (enumWeek) {
		case MONDAY:
		case TUESDAY:
		case WEDNESDAY:
		case THURSDAY:
		case FRIDAY:
			return true;
		case SUNDAY:
		case SUTURDAY:
			return false;
		default:
			throw new AssertionError();
		}
	}
}