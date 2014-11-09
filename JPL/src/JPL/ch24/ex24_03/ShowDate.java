package JPL.ch24.ex24_03;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class ShowDate{
	static Integer[] dfmts = {DateFormat.FULL,DateFormat.LONG,DateFormat.MEDIUM,DateFormat.SHORT};
	static String[] dfmtString = {"FULL","LONG","MEDIUM","SHORT"};
	static Locale locale = Locale.US;
	
	public static void main(String[] args) {
		show("8/29/86 5:00 PM");
		show("Aug 29, 1986 5:00:00 PM");
		show("August 29, 1986 5:00:00 PM EDT");
		show("Friday, August 29, 1986 5:00:00 PM EDT");
		show("Monday, August 29, 1986 5:00:00 PM EDT");
	}
	
	public static void show (String source) {
		for (Integer dfmt : dfmts){
			DateFormat fmt = DateFormat.getDateTimeInstance(dfmt,dfmt,locale);
			Date dt = null;
			try {
				dt = fmt.parse(source);
			} catch (ParseException e) {
				System.out.println("unparseable" + " DateFormat: " + dfmtString[dfmt] + " source: " + source);
			}
			if (dt != null){
			for (Integer dfmt2 : dfmts){
				System.out.print("format by " + dfmtString[dfmt]  + ": parse by " + dfmtString[dfmt2] + "  ");
				DateFormat fmt2 = DateFormat.getDateTimeInstance(dfmt2,dfmt2,locale);
				System.out.println(fmt2.format(dt));
			}
			}
		}
		
	}
}