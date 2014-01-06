package JPL.ch10.ex10_03;

class WeekDay{
	public static void main(String[] args) {
		try {
			if(getWorkDay(EnumWeek.SUNDAY) == true){
				System.out.println("はたらいてください");
			} else {
				System.out.println("やすみです");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean getWorkDay(EnumWeek enumWeek) throws Exception{
		switch (enumWeek) {
		case MONDAY: case TUESDAY: case WEDNESDAY:
		case THURSDAY: case FRIDAY:
			return true;
		case SUNDAY: case SUTURDAY:
			return false;
		default:
			throw new Exception();
		}
	}
}