package JPL.ch24.ex24_01;

import static org.junit.Assert.*;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

public class GlobalHelloTest {

	@Test
	public void test() {
		Locale.setDefault(Locale.ENGLISH);
		ResourceBundle rb = ResourceBundle.getBundle("JPL.ch24.ex24_01.GlobalRes");

		assertEquals("Hello", rb.getString(GlobalRes.HELLO));

		Locale locale = new Locale("en","AU");
		Locale.setDefault(locale);
		rb = ResourceBundle.getBundle("JPL.ch24.ex24_01.GlobalRes");
		assertEquals("G'day", rb.getString(GlobalRes.HELLO));

		 locale = new Locale("ja");
		Locale.setDefault(locale);
		rb = ResourceBundle.getBundle("JPL.ch24.ex24_01.GlobalRes");
		assertEquals("おはよう", rb.getString(GlobalRes.HELLO));
	}

}
