package JPL.ch24.ex24_02;

import java.util.Currency;
import java.util.Locale;

public class ShowCurrency {

	static Locale[] locales = new Locale[] { Locale.JAPAN, new Locale("de_CH"),
			Locale.CHINA, Locale.FRANCE, Locale.GERMANY, Locale.US, Locale.UK, };

	static String[] ISO_4217 = new String[] { "JPY", "CHF", "EUR", "CNY",
			"USD", "ZWD", };

	public static void main(String[] args) {
		for (Locale locale : locales) {
			System.out.printf(locale.toString());
			for (String code : ISO_4217) {
				System.out.printf(" %3s ", Currency.getInstance(code)
						.getSymbol(locale));
			}
			System.out.printf("%n");
		}
	}
}