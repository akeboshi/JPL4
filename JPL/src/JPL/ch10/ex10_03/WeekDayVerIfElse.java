package JPL.ch10.ex10_03;

class WeekDayVerIfElse{
	public static void main(String[] args) {
		try {
			if(getWorkDay(EnumWeek.FRIDAY) == true){
				System.out.println("はたらいてください");
			} else {
				System.out.println("やすみです");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean getWorkDay(EnumWeek enumWeek) throws Exception{
		if(enumWeek == EnumWeek.MONDAY ||
				enumWeek == EnumWeek.TUESDAY ||
				enumWeek == EnumWeek.WEDNESDAY ||
				enumWeek == EnumWeek.THURSDAY ||
				enumWeek == EnumWeek.FRIDAY){
			return true;
		}else if (enumWeek == EnumWeek.SUNDAY ||
				enumWeek == EnumWeek.SUTURDAY){
			return false;
		}else{
			throw new Exception();
		}
	}
}